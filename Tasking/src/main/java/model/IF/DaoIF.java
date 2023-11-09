package model.IF;

import model.db.DBinfo;

public interface DaoIF {
	//DB接続情報
	public static final String URL = DBinfo.URL.get();
	public static final String USER = DBinfo.USER.get();
	public static final String PASS = DBinfo.PASS.get();
	public static final String SCHEMA = DBinfo.SCHEMA.get();

	//JDBCドライバの読み込み
	public static void readJDBCDriver() {
		try {
			Class.forName(DBinfo.JDBC_DRIVER_NAME.get());
		} catch (ClassNotFoundException e) {
			throw new IllegalAccessError("JDBC読み込み不可能");
		}
	}

	TasksIF fetchAll();
	
	TasksIF fetchById(long id);

}
