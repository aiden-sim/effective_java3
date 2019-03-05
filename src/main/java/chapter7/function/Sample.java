package chapter7.function;

public class Sample {
	interface Task {
		void execute();
	}

	interface Work {
		void process();
	}

	public static void action(Task task) {
		task.execute();
	}

	public static void action(Work work) {
		work.process();
	}

	public void foo() {
		action(new Task() {
			@Override
			public void execute() {
				System.out.println("Hi");
			}
		});

		action(new Work() {
			@Override public void process() {
				System.out.println("Hi");
			}
		});

		//action(() -> System.out.println("Hi")); //Task? Work? Ambiguous !

		action((Task) () -> System.out.println("Hi"));
	}
}
