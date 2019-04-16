package chapter11.item79.step4;

import chapter11.item79.ForwardingSet;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 외계인 메소드
 */
public class ObservableSet<E> extends ForwardingSet<E> {
	public ObservableSet(Set<E> s) {
		super(s);
	}

	private final List<SetObserver<E>> observers = new ArrayList<>();

	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public boolean removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.removeAll(observers);
		}
	}

	// 외계인 메서드를 동기화 블록 바깥으로 옮겼다.
	// 관찰자 리스트를 복사해 쓰면 락 없이도 안전하게 순회할 수 있다.
	// 예외와 교착이 사라진다. (open call)
	private void notifyElementAdded(E element) {
		List<SetObserver<E>> snapshot = null;
		synchronized (observers) {
			snapshot = new ArrayList<>(observers);
		}
		for (SetObserver<E> observer : snapshot) {
			observer.added(this, element);
		}
	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added) {
			notifyElementAdded(element);
		}
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c) {
			result |= add(element); // result = result | add(element);
		}
		return result;
	}

	public static void main(String[] args) {
		ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
		set.addObserver(new SetObserver<>() {
			public void added(ObservableSet<Integer> s, Integer e) {
				System.out.println(e);
				if (e == 23) {
					ExecutorService exec =
							Executors.newSingleThreadExecutor();
					try {
						exec.submit(() -> s.removeObserver(this)).get();
					} catch (ExecutionException | InterruptedException ex) {
						throw new AssertionError(ex);
					} finally {
						exec.shutdown();
					}
				}
			}
		});

		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}
}
