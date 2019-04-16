package chapter11.item79.step3;

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

	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers) {
				observer.added(this, element);
			}
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

		// removeObserver를 실행자 서비스를 사용해 다른 스레드로 수행했다.
		// 교착상태 빠짐
		// 메인 스레드가 이미 락을 쥐고 있고, 백그라운드 스레드가 관찰자를 제거하기만 기다리고 있다.
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
