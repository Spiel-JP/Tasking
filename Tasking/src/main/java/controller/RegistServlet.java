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

		String name = (String) request.getSession().getAttribute("user");
		String title = (String) request.getParameter("title");
		String due_date = (String) request.getParameter("due_date");
		String description = (String) request.getParameter("description");
		Taskable.of(new TasksDAO().fetchAll().toList().stream().count(), null, title, description, Status.TODO,
				Timestamp.valueOf(due_date).toLocalDateTime());

	}

}
