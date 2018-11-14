package chapter2.item1;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriver implements Driver {
	// 1) 서비스 인터페이스
	private static Driver defaultDriver = new MyDriver();

	static {
		try {
			// 2) 제공자 등록 API
			DriverManager.registerDriver(defaultDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override public Connection connect(String url, Properties info) throws SQLException {
		System.out.println(String.format("%s 등록되었어요.", url));
		return null;
	}

	@Override public boolean acceptsURL(String url) throws SQLException {
		return false;
	}

	@Override public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return new DriverPropertyInfo[0];
	}

	@Override public int getMajorVersion() {
		return 0;
	}

	@Override public int getMinorVersion() {
		return 0;
	}

	@Override public boolean jdbcCompliant() {
		return false;
	}

	@Override public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
}
