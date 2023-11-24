package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.IF.DaoIF;
import model.entity.User;
import model.entity.Users;

public final class UserDAO implements DaoIF, Serializable {

	@Override
	public Users fetchAll() {
		DaoIF.readJDBCDriver();

		Users users = new Users();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "select user.PKEYUSER_ID as ID,user.NAME,user.PASS from projitsu3.user user;";

			//SELECT文を実行
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				//ID
				final long id = rs.getLong("ID");
				//NAME
				final String name = rs.getString("NAME");
				//PASS
				final String pass = rs.getString("PASS");

				users.add(User.of(id, name, pass));
			}

		} catch (SQLException e) {
			System.out.println("接続に失敗:" + e.getMessage());
		}

		return users;
	}

	public int append(User entity, String password) {

		if (entity.isNull()) {
			return 0;
		}

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			//ID
			long id = fetchAll().size();
			//NAME
			String name = entity.getName();
			String sql = "INSERT INTO projitsu3.user VALUES(?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ps.setString(2, name);
			ps.setString(3, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
