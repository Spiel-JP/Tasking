package model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.IF.Taskable;
import model.IF.TasksIF;

public final class Tasks implements TasksIF {

	private final List<Taskable> list;

	public Tasks() {
		list = new ArrayList<>();
	}

	private Tasks(Stream<Taskable> stream) {
		list = stream.collect(Collectors.toList());
	}

	@Override
	public void add(Taskable element) {
		list.add(element);
	}

	@Override
	public void add(int index, Taskable element) {
		list.add(index, element);
	}

	//IndexNumber
	@Override
	public Taskable get(int index) {
		if (list.size() - 1 < index || index < 0) {
			return Taskable.of(0, null, null, null, null);
		}
		return list.get(index);
	}

	//ObjectNumber
	@Override
	public Taskable get(Taskable object) {
		if (list.contains(object)) {
			//NullTask呼び出し
			return Taskable.of(0, null, null, null, null);
		}
		return list.stream().filter(t -> t == object).findFirst().get();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<Taskable> iterator() {
		return list.iterator();
	}

	public Tasks fillter(Status status) {
		return new Tasks(list.stream().filter(t -> t.getStatus() == status));
	}

	public List<Taskable> toList() {
		return list;
	}

}
