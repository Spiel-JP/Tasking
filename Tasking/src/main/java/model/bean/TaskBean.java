package model.bean;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import model.entity.Status;
import model.entity.Task;

@Getter
public final class TaskBean {
	private final long task_id;
	private final String title;
	private final String description;
	private final Status status;
	private final LocalDateTime due_date;

	TaskBean(long task_id, String title, String description, Status status, LocalDateTime due_date) {
		this.task_id = task_id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.due_date = due_date;
	}

	public List<Task> getList() {
		return null;
	}

}
