package controller;

import java.io.IOException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.IF.Taskable;
import model.dao.TasksDAO;
import model.entity.Status;
import model.entity.User;

/**
 * Servlet implementation class RegistServlet
 */

@WebServlet("/regist")
public final class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//別サーブレットから情報渡し
		User user = (User) request.getSession().getAttribute("user");
		String title = (String) request.getParameter("title");

		//JSON日付形式 yyyy-mm-dd"T"hh:mm:ss
		String due_date = (String) request.getParameter("due_date");
		String date = due_date.substring(0, 10);
		String time = due_date.substring(11, 16);

		due_date = date + " " + time + ":00";

		String description = (String) request.getParameter("description");

		TasksDAO dao = new TasksDAO();
		Taskable task = Taskable.of(
				dao.allSize(),
				user,
				title,
				description,
				Status.TODO,
				Timestamp.valueOf(due_date).toLocalDateTime());

		//DB追加
		dao.append(task);

		response.sendRedirect("/Tasking/home");

	}

}
