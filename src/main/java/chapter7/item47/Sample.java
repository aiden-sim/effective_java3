package chapter7.item47;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 이러한 어댑터는 클라이언트 코드를 어수선하게 만들고 2.3배가 더 느리다고 한다(책에서...)
 */
public class Sample {
	public static void main(String[] args) {
		// 자바 타입 추론의 한계로 컴파일 되지 않음
		/*
		for(ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
			// 프로세스 처리
		}
		*/

		// 스트림을 반복하기 위한 '끔찍한' 우회 방법
		for (ProcessHandle ph : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {
			// 프로세스 처리
		}

		// 어댑터를 사용하면 어떤 스트림도 for-each 문으로 반복할 수 있다.
		for (ProcessHandle p : iterableOf(ProcessHandle.allProcesses())) {

		}
	}

	// Stream<E>를 Iterable<E>로 중개해주는 어댑터
	public static <E> Iterable<E> iterableOf(Stream<E> stream) {
		return stream::iterator;
	}

	// Iterable<E>를 Stram<E>로 중개해주는 어댑터
	public static <E> Stream<E> streamOf(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
