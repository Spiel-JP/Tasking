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

	String getTitle();

	String getDescription();

	Status getStatus();

	LocalDateTime getLocalDateTime();

	final class NullTask implements Taskable {
		static Taskable NULL = new NullTask();

		private NullTask() {
		}

		@Override
		public String toString() {
			return "This is NULL";
		}

		@Override
		public String getTitle() {
			return "";
		}

		@Override
		public String getDescription() {
			// TODO 自動生成されたメソッド・スタブ
			return "";
		}

		@Override
		public Status getStatus() {
			// TODO 自動生成されたメソッド・スタブ
			return Status.NOTING;
		}

		@Override
		public LocalDateTime getLocalDateTime() {
			// TODO 自動生成されたメソッド・スタブ
			return LocalDateTime.now();
		}
	}
}
