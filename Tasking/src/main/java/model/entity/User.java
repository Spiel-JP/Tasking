package model.entity;

import model.IF.EntityIF;

public final class User implements EntityIF {

	public static final User DUMMY = new User(0, "DUMMY", "DUMMY");
	private final long id;
	private final String name;
	private final String pass;

	public static User of(long id, String name, String pass) {

		if (id < 0 || name == null || pass == null) {
			return DUMMY;
		}

		return new User(id, name, pass);
	}

	private User(long id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean pass(String str) {
		return this.pass.equals(str);
	}

	@Override
	public boolean isNull() {
		return DUMMY == this;
	}

}
