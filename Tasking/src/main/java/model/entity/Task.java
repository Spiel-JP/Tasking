package model.entity;

import java.time.LocalDateTime;

import model.IF.Taskable;

public final class Task implements Taskable {
	private final String name;
	private final String title;
	private final String description;
	private final Status status;
	private final LocalDateTime due_date;

	public static Taskable create(String name, String title, String description, Status status,
			LocalDateTime due_date) {
		//creat条件クリア
		if (name != null && title != null && description != null && status != null && due_date != null) {
			return new Task(name, title, description, status, due_date);
		}
		return Taskable.of(name, title, description, status, due_date);
	}

	private Task(String name, String title, String description, Status status, LocalDateTime due_date) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.status = status;
		this.due_date = due_date;
	}

	@Override
	public String toString() {
		return name + ":" + title + ":<" + description + ">:" + status + ":" + due_date;
	}

	@Override
	public String getName() {
		return this.name;
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
