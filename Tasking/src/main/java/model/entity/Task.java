package model.entity;

import java.time.LocalDateTime;

import model.IF.Taskable;

public final class Task implements Taskable {
	private final User user_id;
	private final String title;
	private final String description;
	private final Status status;
	private final LocalDateTime due_date;

	public static Taskable create(User name, String title, String description, Status status,
			LocalDateTime due_date) {
		if (title == null) {
			title = "";
		}

		if (description == null) {
			description = "";
		}

		//creat条件クリア
		if (name > 0 && due_date != null && status != null) {
			return new Task(name, title, description, status, due_date);
		}
		return Taskable.of(name, title, description, status, due_date);
	}

	private Task(long user_id, String title, String description, Status status, LocalDateTime due_date) {
		this.user_id = user_id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.due_date = due_date;
	}

	@Override
	public String toString() {
		return user_id + ":" + title + ":<" + description + ">:" + status + ":" + due_date;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Status getStatus() {
		return this.status;
	}

	@Override
	public LocalDateTime getLocalDateTime() {
		return this.due_date;
	}

}
