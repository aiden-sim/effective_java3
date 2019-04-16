package chapter11.item79.step5;

import chapter11.item79.ForwardingSet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
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

	// CopyOnWriteArrayList는 앞에서 동기화 블록 바깥으로 옮긴 역할을 해준다.
	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

	public void addObserver(SetObserver<E> observer) {
		observers.add(observer);
	}

	public boolean removeObserver(SetObserver<E> observer) {
		return observers.remove(observer);
	}

	private void notifyElementAdded(E element) {
		for (SetObserver<E> observer : observers) {
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
