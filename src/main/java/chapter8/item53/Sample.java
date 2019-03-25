package chapter8.item53;

public class Sample {
	public static void main(String[] args) {
		System.out.println(sum());
		System.out.println(sum(1, 2, 3));
	}

	// 간단한 가변인수
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}

	// 인수가 1개 이상이어야 하는 가변인수 - 잘못 구현한 예
	static int min(int... args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
		}

		int min = args[0];
		for (int i = 1; i < args.length; i++) {
			if (args[i] < min) {
				min = args[i];
			}
		}
		return min;
	}

	static int min(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs) {
			if (arg < min) {
				min = arg;
			}
		}
		return min;
	}
}
