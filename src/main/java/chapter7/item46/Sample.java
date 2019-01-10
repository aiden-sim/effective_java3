package chapter7.item46;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample {
	public static void main(String[] args) {
		// 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
		Map<String, Long> freq = Map.of("simjunbo", 33L, "aiden", 33L);
		List<String> topTen = freq.keySet().stream()
				.sorted(Comparator.comparing(freq::get).reversed())
				.limit(10)
				.collect(Collectors.toList());

	}
}
