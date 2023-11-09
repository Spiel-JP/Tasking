package model.IF;

import java.time.LocalDateTime;

import model.entity.Status;
import model.entity.Task;

public interface Taskable {

	default boolean isNULL() {
		return this == NullTask.NULL;
	}

	static Taskable of(long task_id, String title, String description, Status status, LocalDateTime due_date) {
		if (task_id <= 0 || due_date == null || status == null) {
			return NullTask.NULL;
		}

		return Task.create(task_id, title, description, status, due_date);
	}

	final class NullTask implements Taskable {
		static Taskable NULL = new NullTask();

		private NullTask() {
		}

		@Override
		public String toString() {
			return "This is NULL";
		}
	}
}
