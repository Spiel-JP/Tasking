package model.IF;

import java.util.List;

public interface TasksIF extends Iterable<Taskable> {

	void add(Taskable element);

	void add(int index, Taskable element);

	Taskable get(int index);

	Taskable get(Taskable object);

	boolean isEmpty();

	int size();

	List<Taskable> toList();

}
