package model.bean;

import lombok.Getter;

@Getter
public final class TaskBean {
	private final long id;
	private final long user_id;
	private final String title;
	private final String description;
	private final int status_id;
	private final String due_date;

	public static TaskBean create(long task_id, long user_id, String title, String description, int status_id,
			String due_date) {
		return new TaskBean(task_id, user_id, title, description, status_id, due_date);
	}

	private TaskBean(long task_id, long user_id, String title, String description, int status_id, String due_date) {
		this.id = task_id;
		this.user_id = user_id;
		this.title = title;
		this.description = description;
		this.status_id = status_id;
		this.due_date = due_date;
	}
}
