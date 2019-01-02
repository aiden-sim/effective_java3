package chapter4.item17;

public class Sample {
	public static void main(String[] args) throws CloneNotSupportedException {
		// 불변을 복사할 경우
		Immutable im1 = new Immutable(1, "simjunbo");
		Immutable im2 = im1.clone();
	}
}
