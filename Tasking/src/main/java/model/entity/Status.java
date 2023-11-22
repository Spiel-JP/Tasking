package model.entity;

import java.util.List;

import lombok.Getter;

@Getter
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

	public static Status numberToStatus(int num) {
		return List.of(Status.values()).stream().filter(t -> t.weight == num).findFirst().orElse(NOTING);
	}

	public static Status stringToStatus(String str) {
		if (str == null) {
			return NOTING;
		}
		return List.of(Status.values()).stream().filter(t -> t.status == str).findFirst().orElse(NOTING);
	}
}
