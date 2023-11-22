package model.IF;

import java.time.LocalDateTime;

import model.entity.Status;
import model.entity.Task;
import model.entity.User;

public interface Taskable extends EntityIF {

	default boolean isNULL() {
		return this == NullTask.NULL;
	}

	static Taskable of(long id, User user, String title, String description, Status status, LocalDateTime due_date) {
		if (id < 0 || user == null || title == null || description == null || status == null || due_date == null) {
			return NullTask.NULL;
		}

		return Task.create(id, user, title, description, status, due_date);
	}

	long getId();

	User getUser();

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
		public long getId() {
			// TODO 自動生成されたメソッド・スタブ
			return -1;
		}

		@Override
		public User getUser() {
			// TODO 自動生成されたメソッド・スタブ
			return User.DUMMY;
		}

		@Override
		public String getTitle() {
			// TODO 自動生成されたメソッド・スタブ
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

		@Override
		public boolean isNull(EntityIF e) {
			return this == e;
		}
	}
}
