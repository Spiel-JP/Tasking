package model.entity;

public enum Status {
	TODO(1, "TODO"), //
	DOING(2, "DOING"), //
	DONE(3, "DONE"), //
	NOTING(4, "NULL");

	private final int weight;
	private final String status;

	private Status(int weight, String status) {
		this.weight = weight;
		this.status = status;
	}

	public int getWeight() {
		return weight;
	}

	public static Status stringToStatus(String str) {
		if (str == null || str.equals(NOTING.status)) {
			return NOTING;
		}
		if (!TODO.status.equals(str) && !DOING.status.equals(str) && !DONE.status.equals(str)) {
			return NOTING;
		}
		return Status.valueOf(str);
	}

	public String getStatus() {
		return status;
	}
}
