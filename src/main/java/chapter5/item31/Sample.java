package chapter5.item31;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sample {
    public static <E> void swap(List<E> list, int i, int j) {

    }

    public static void swap2(List<?> list, int i, int j) {
        //list.set(i, list.set(j, list.get(i))); // ?에는 nul 외에 어떤 값도 넣을 수 없다.
    }

    public static void swap3(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        return list.stream().findAny().get();
    }

    public static void main(String[] args) {
        List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();
        scheduledFutures.add(new ScheduledFuture<String>() {
            @Override public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override public boolean isCancelled() {
                return false;
            }

            @Override public boolean isDone() {
                return false;
            }

            @Override public String get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override public int compareTo(Delayed o) {
                return 0;
            }

            @Override public long getDelay(TimeUnit unit) {
                return 10;
            }
        });

        ScheduledFuture<?> result = max(scheduledFutures);
    }
}
