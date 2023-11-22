package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import model.IF.DaoIF;
import model.IF.Taskable;
import model.entity.Status;
import model.entity.Tasks;
import model.entity.User;
import model.entity.Users;

public final class TasksDAO implements DaoIF, Serializable {

	@Override
	public Tasks fetchAll() {

		DaoIF.readJDBCDriver();

		Tasks tasks = new Tasks();
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "select projitsu3.task.PKEYTASK_ID as ID,projitsu3.user.NAME as USER,projitsu3.task.TITLE,projitsu3.task.DESCRIPTION,projitsu3.task.STATUS_ID,task.DUE_DATE as DUE_DATE from projitsu3.task "
					+ "left join projitsu3.user on projitsu3.task.FKEYUSER_ID=projitsu3.user.PKEYUSER_ID "
					+ "left join projitsu3.status on projitsu3.task.STATUS_ID=projitsu3.status.PKEYSTATUS_ID;";

			//SELECTを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				//ID
				final long id = rs.getLong("ID");
				//userID
				final String name = rs.getString("USER");
				User user = new Users().get(name);
				//タイトル
				final String titke = rs.getString("TITLE");
				//説明
				final String description = rs.getString("DESCRIPTION");
				//ステータス
				final Status status = Status.numberToStatus(rs.getInt("STATUS_ID"));
				//期限日
				final LocalDateTime duedate = rs.getTimestamp("DUE_DATE").toLocalDateTime();

				tasks.add(Taskable.of(id, user, titke, description, status, duedate));
			}

		} catch (SQLException e) {
			System.out.println("接続に失敗:" + e.getMessage());
		}
		return tasks;
	}

	/*
	 * return 0 →エラー
	 * return 1 →正常
	 */

	public int append(Taskable entity) {
		if (entity.isNULL()) {
			return 0;
		}
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			//タイトル
			String title = entity.getTitle();
			//ユーザー名
			long userId = entity.getId();
			//ステータス
			String status = entity.getStatus().getStatus();
			//期限日
			LocalDateTime due_date = entity.getLocalDateTime();
			//説明
			String description = entity.getDescription();

			String sql = "INSERT INTO projitsu3.task VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, fetchAll().toList().stream().count());
			ps.setLong(2, userId);
			ps.setString(3, title);
			ps.setString(4, description);

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
