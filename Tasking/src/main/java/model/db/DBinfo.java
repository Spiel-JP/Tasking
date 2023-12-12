package model.db;

public enum DBinfo {
	URL("jdbc:mysql://localhost:3306/mysql"), //
	SCHEMA("ff"), //
	USER("root"), //
	PASS("password"), //
	JDBC_DRIVER_NAME("com.mysql.cj.jdbc.Driver");

	private final String info;

	DBinfo(final String info) {
		this.info = info;
	}

	public String get() {
		return this.info;
	}
}
