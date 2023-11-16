package model.bean;

import lombok.Getter;

@Getter
public final class UserBeen {
	private final long id;
	private final String name;

	public static UserBeen create(long id, String name) {
		return new UserBeen(id, name);
	}

	private UserBeen(long id, String name) {
		this.id = id;
		this.name = name;
	}

}
