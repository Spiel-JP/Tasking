package model.entity;

import java.util.Arrays;

public enum Status {
	TODO(3, "TODO"), //
	DOING(2, "DOING"), //
	DONE(1, "DONE"), //
	NOTING(0, "NULL");

	int weight;
	String status;

	private Status(int weight, String status) {
		this.weight = weight;
		this.status = status;
	}

	public int getWeight() {
		return weight;
	}

	public static Status StringToStatus(String str) {
		if (str == null || str.equals(NOTING.status)) {
			return NOTING;
		}
		if(!TODO.status.equals(str)&&!DOING.status.equals(str)&&!DONE.status.equals(str)) {
			return NOTING;
		}
		return Arrays.asList(Status.values()).stream().filter(status -> str.equals(status.status)).findFirst().get();
	}

	public String getStatus() {
		return status;
	}
}
