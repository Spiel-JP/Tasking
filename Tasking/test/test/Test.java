package test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.function.IntPredicate;

import model.IF.Taskable;
import model.dao.TasksDAO;
import model.entity.Status;
import model.entity.Task;
import model.entity.Tasks;

public class Test {
	public static void main(String[] args) {

		Taskable task = Taskable.of(-1, null, null, "this is testsample", Status.TODO,
				LocalDateTime.of(2021, Month.JULY, 3, 10, 30));

		Taskable task2 = Taskable.of(-1, null, "", null, Status.TODO, LocalDateTime.of(2021, Month.JULY, 3, 10, 30));

		TasksDAO dao = new TasksDAO();

		//dao.append(Taskable.of(2, User.of(2, "root","114514"), "よくわからない", "yokuwakaranai", Status.TODO, LocalDateTime.now()));
		Tasks ddd = dao.fetchAll();
		ddd.add(task);
		ddd.add(task2);
		ddd.add(Task.create(-1, null, null, null, null, null));
		for (Taskable t : ddd) {
			System.out.print(t);
			System.out.print(":" + t.getId() + "\n");
		}

		IntPredicate in;

		System.out.println(Status.stringToStatus("Null"));

	}
}
