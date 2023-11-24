package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TasksDAO;
import model.entity.Status;
import model.entity.Tasks;

/**
 * Servlet implementation class HomeServlet
 */

@WebServlet("/home")
public final class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//SELECT一覧
		Tasks tasks = new TasksDAO().fetchAll();

		//ステータスごとにフィルタリング→Listへ変更
		request.setAttribute("todoTasks", tasks.fillter(Status.TODO).toList());
		request.setAttribute("doingTasks", tasks.fillter(Status.DOING).toList());
		request.setAttribute("doneTasks", tasks.fillter(Status.DONE).toList());

		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
