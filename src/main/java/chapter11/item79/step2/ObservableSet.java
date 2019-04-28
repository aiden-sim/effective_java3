package chapter11.item79.step2;

import chapter11.item79.ForwardingSet;

import java.util.*;

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
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return observers.remove(observer);
		}
	}

	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers) {
				/**
				 * 외계인 메소드
				 */
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

	public static void main(String[] args) throws InterruptedException {
		ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

		// 순회도중에 remove가 발생하면 ConcurrentModificationException 에러가 발생한다.
		// 콜백은 동시성을 깨뜨릴 수 있다.
		set.addObserver(new SetObserver<>() {
			public void added(ObservableSet<Integer> s, Integer e) {
				System.out.println(e);
				if (e == 23) {
					s.removeObserver(this);
				}
			}
		});

		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}
}
