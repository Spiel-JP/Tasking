package model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.IF.EntitiesIF;

public class Users implements EntitiesIF, Iterable<User> {

	private final List<User> list;

	public Users() {
		list = new ArrayList<>();
	}

	private Users(Stream<User> stream) {
		this.list = stream.collect(Collectors.toList());
	}

	public void add(User user) {
		list.add(user);
	}

	public void add(int index, User user) {
		list.add(index, user);
	}

	public User get(int index) {
		if (list.size() - 1 < index || index < 0) {
			return User.DUMMY;
		}
		return list.get(index);
	}

	public User get(String name) {
		return list.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(User.DUMMY);
	}

	public Users filter(long user_Id) {
		return new Users(list.stream().filter(t -> t.getId() == user_Id));
	}
	
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<User> iterator() {
		return list.iterator();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

}
