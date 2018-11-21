package chapter2.item9;

import java.io.*;

public class Sample {

	private static final int BUFFER_SIZE = 100;

	// 1) 전통적 방식
	static String firstLineOfFile(String path) throws IOException {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(path));
			// 여기서 Exception이 발생하면 finally 에서 먹어 버린다.
			return br.readLine();
		} finally {
			br.close();
		}
	}

	// 2) 전통적 방식 (자원이 여러개)
	static void copy(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while ((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}

	// 3) try-with-resources
	static String firstLineOfFile2(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	// 4) 다중 try-with-resources
	static void copy2(String src, String dst) throws IOException {
		try (InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(src)) {
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		}
	}

	// 5) try-with-resources와 catch
	static String firstLineOfFile(String path, String defaultVal) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		} catch (IOException e) {
			return defaultVal;
		}
	}

	public static void main(String[] args) throws IOException {
		firstLineOfFile("connectFactory.txt");
		//firstLineOfFile2("connectFactory.txt");
		//copy("connectFactory.txt", "test.txt");
		//copy2("connectFactory.txt", "test.txt");
	}
}
