package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import model.IF.DaoIF;
import model.IF.Taskable;
import model.IF.TasksIF;
import model.entity.Status;
import model.entity.Tasks;

public final class TasksDAO implements DaoIF {

	@Override
	public TasksIF fetchAll() {

		DaoIF.readJDBCDriver();

		TasksIF tasks = new Tasks();
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String aql = "SELECT * FROM projitsu3.task;";

			//SELECTを実行
			PreparedStatement pStmt = conn.prepareStatement(aql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				//タスクID
				long pkeyTaskId = rs.getLong("PKEYTASK_ID");
				//タイトル
				String titke = rs.getString("TITLE");
				//説明
				String description = rs.getString("DESCRIPTION");
				//ステータス
				Status status = Status.StringToStatus(rs.getString("STATUS"));
				//期限日
				LocalDateTime duedate = rs.getTimestamp("DUE_DATE").toLocalDateTime();

				tasks.add(Taskable.of(pkeyTaskId, titke, description, status, duedate));
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

}
