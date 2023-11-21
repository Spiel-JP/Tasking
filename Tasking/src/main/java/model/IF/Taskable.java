package model.IF;

import java.time.LocalDateTime;

import model.entity.Status;
import model.entity.Task;

public interface Taskable {

	default boolean isNULL() {
		return this == NullTask.NULL;
	}

	static Taskable of(String name, String title, String description, Status status, LocalDateTime due_date) {
		if (name == null || title == null || description == null || status == null || due_date == null) {
			return NullTask.NULL;
		}

		return Task.create(name, title, description, status, due_date);
	}

	String getName();

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
		public String getName() {
			// TODO 自動生成されたメソッド・スタブ
			return "";
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
			return LocalDateTime.MAX;
		}
	}
}
