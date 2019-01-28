package chapter10.item79.before;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	public boolean removeObsevrer(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.removeAll(observers);
		}
	}

	/*
	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers) {
				observer.added(this, element);
			}
		}
	}*/

	// 외계인 메서드를 동기화 블록 바끝으로 옮김
	private void notifyElementAdded(E element) {
		List<SetObserver<E>> snapshot = null;
		synchronized (observers) {
			snapshot = new ArrayList<>(observers);
		}
		for (SetObserver<E> observer : snapshot)
			observer.added(this, element);
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
		// 옵저버 등록
		// set.addObserver((s, e) -> System.out.println(e)); // 그냥 선언
		/*
		set.addObserver(new SetObserver<Integer>() {
			@Override public void added(ObservableSet<Integer> s, Integer e) {  // 람다는 this를 넘기지 못하기 때문에 익명 클래스를 사용했다.
				System.out.println(e);
				if (e == 23) {
					s.removeObsevrer(this); // ConcurrentModificationException 발생
				}
			}
		});
		*/

		set.addObserver(new SetObserver<Integer>() { // 교착상태 발생
			@Override public void added(ObservableSet<Integer> s, Integer e) {
				System.out.println(e);
				if (e == 23) {
					ExecutorService exec = Executors.newSingleThreadExecutor();

					try {
						exec.submit(() -> s.removeObsevrer(this)).get();
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
