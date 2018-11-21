package chapter2.item8.aucocloseable;

public class Execute {
	public static void main(String[] args) {

		try (FileInputStream fi = new FileInputStream("sample.json")) {
			fi.read();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}