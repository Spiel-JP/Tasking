package model.bean;

import lombok.Getter;

@Getter
public final class StatusBean {
	private final int id;
	private final String todo;

	public static StatusBean create(int id, String todo) {
		return new StatusBean(id, todo);
	}

	private StatusBean(int id, String todo) {
		this.id = id;
		this.todo = todo;
	}
}
