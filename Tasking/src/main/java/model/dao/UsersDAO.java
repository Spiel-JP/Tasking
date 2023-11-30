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

public final class UsersDAO implements DaoIF, Serializable {

	private Users users;

	public UsersDAO() {
		users = null;
		DaoIF.readJDBCDriver();
	}

	@Override
	public Users fetchAll() {

		if (users == null) {
			users = new Users();
		}

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

	public User fitchByName(String name) {

		User user = User.DUMMY;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select projitsu3.user.PKEYUSER_ID as ID,projitsu3.user.NAME,projitsu3.user.PASS from projitsu3.user ");
			sb.append("where projitsu3.user.NAME in ('");
			sb.append(name);
			sb.append("');");
			PreparedStatement pStmt = conn.prepareStatement(sb.toString());
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				//ID
				final long id = rs.getLong("ID");
				//NAME
				final String n = rs.getString("NAME");
				//PASS
				final String pass = rs.getString("PASS");

				user = User.of(id, n, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return user;
		}

		return user;
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

	@Override
	public int allSize() {
		return fetchAll().size();
	}

}
