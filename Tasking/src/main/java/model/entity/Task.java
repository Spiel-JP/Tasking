package model.entity;

import java.time.LocalDateTime;

import model.IF.Taskable;

public final class Task implements Taskable {
	private final long id;
	private final User user;
	private final String title;
	private final String description;
	private final Status status;
	private final LocalDateTime due_date;

	public static Taskable create(long id, User user, String title, String description, Status status,
			LocalDateTime due_date) {
		//creat条件クリア
		if (id > 0 && user != null && title != null && description != null && status != null && due_date != null) {
			return new Task(id, user, title, description, status, due_date);
		}
		return Taskable.of(id, user, title, description, status, due_date);
	}

	private Task(long id, User user, String title, String description, Status status, LocalDateTime due_date) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.description = description;
		this.status = status;
		this.due_date = due_date;
	}

	@Override
	public String toString() {
		return user.getName() + "," + title + "," + description + "," + status + "," + due_date;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public User getUser() {
		return this.user;
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

	@Override
	public boolean isNull() {
		return false;
	}

}
