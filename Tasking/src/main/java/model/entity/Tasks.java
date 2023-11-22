package model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.IF.EntitiesIF;
import model.IF.Taskable;

public final class Tasks implements EntitiesIF, Iterable<Taskable> {

	private final List<Taskable> list;

	public Tasks() {
		list = new ArrayList<>();
	}

	private Tasks(Stream<Taskable> stream) {
		list = stream.collect(Collectors.toList());
	}

	public void add(Taskable element) {
		list.add(element);
	}

	public void add(int index, Taskable element) {
		list.add(index, element);
	}

	//IndexNumber
	public Taskable get(int index) {
		if (list.size() - 1 < index || index < 0) {
			return Taskable.of(-1, null, null, null, null, null);
		}
		return list.get(index);
	}

	//ObjectNumber
	public Taskable get(Taskable object) {
		if (!list.contains(object)) {
			//NullTask呼び出し
			return Taskable.of(-1, null, null, null, null, null);
		}
		return list.stream().filter(t -> t == object).findFirst().get();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

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
