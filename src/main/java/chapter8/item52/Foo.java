package chapter8.item52;

public class Foo {
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

		//action(() -> Print.println()); //Task? Work? Ambiguous !

		action((Task) () -> System.out.println("Hi"));

	}
}

