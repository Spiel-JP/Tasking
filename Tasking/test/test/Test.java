package test;

import java.time.LocalDateTime;
import java.time.Month;

import model.IF.Taskable;
import model.IF.TasksIF;
import model.dao.TasksDAO;
import model.entity.Status;
import model.entity.Task;

public class Test {
	public static void main(String[] args) {

		Taskable task = Taskable.of(1, null, "this is testsample", Status.TODO,
				LocalDateTime.of(2021, Month.JULY, 3, 10, 30));

		Taskable task2 = Taskable.of(-1, "", null, Status.TODO, LocalDateTime.of(2021, Month.JULY, 3, 10, 30));

		TasksDAO dao = new TasksDAO();

		TasksIF ddd=dao.fetchAll();
		ddd.add(task);
		ddd.add(task2);
		ddd.add(Task.create(0, null, null, null, null));
		for (Taskable t : ddd) {
			System.out.println(t);
		}
		
	}
}
