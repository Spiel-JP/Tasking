package model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import model.IF.DaoIF;
import model.IF.Taskable;
import model.IF.TasksIF;
import model.entity.Status;
import model.entity.Tasks;

public final class TasksDAO implements DaoIF, Serializable {

	@Override
	public Tasks fetchAll() {

		DaoIF.readJDBCDriver();

		Tasks tasks = new Tasks();
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String aql = "select projitsu3.task.PKEYTASK_ID as ID,projitsu3.user.NAME as USER,projitsu3.task.TITLE as TITLE,projitsu3.task.DESCRIPTION as DESCRIPTION,projitsu3.status.STATUS as STATUS,task.DUE_DATE as DUE_DATE from projitsu3.task "
					+ "left join projitsu3.user on projitsu3.task.FKEYUSER_ID=projitsu3.user.PKEYUSER_ID "
					+ "left join projitsu3.status on projitsu3.task.STATUS_ID=projitsu3.status.PKEYSTATUS_ID;";

			//SELECTを実行
			PreparedStatement pStmt = conn.prepareStatement(aql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				//userID
				String name = rs.getString("USER");
				//タイトル
				String titke = rs.getString("TITLE");
				//説明
				String description = rs.getString("DESCRIPTION");
				//ステータス
				Status status = Status.stringToStatus(rs.getString("STATUS"));
				//期限日
				LocalDateTime duedate = rs.getTimestamp("DUE_DATE").toLocalDateTime();

				tasks.add(Taskable.of(name, titke, description, status, duedate));
			}

		} catch (SQLException e) {
			System.out.println("接続に失敗:" + e.getMessage());
		}
		return tasks;
	}

	@Override
	public TasksIF fetchById(long id) {
		return null;
	}

	/*
	 * return 0 →エラー
	 * return 1 →正常
	 */

	@Override
	public int append(Taskable entity) {
		if (entity.isNULL()) {
			return 0;
		}
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			//タイトル
			String title = entity.getTitle();
			//ステータス
			String status = entity.getStatus().getStatus();
			//期限日
			LocalDateTime due_date = entity.getLocalDateTime();
			//説明
			String description = entity.getDescription();

			String sql = "INSERT INTO projitsu3.task VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, status);
			ps.setTimestamp(3, Timestamp.valueOf(due_date));
			ps.setNString(4, description);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
