package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TasksDAO;
import model.dao.UsersDAO;
import model.entity.Status;
import model.entity.Tasks;
import model.entity.User;

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

		request.setCharacterEncoding("UTF-8");

		//別サーブレットから情報渡し
		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			user = User.DUMMY;
		}

		if (user.isNull()) {
			String userName = request.getParameter("userName");
			String pass = request.getParameter("pass");

			user = new UsersDAO().fitchByName(userName);

			if (!user.isPass(pass)) {
				response.sendRedirect("/Tasking/index.html");
				return;
			}
		}

		//SELECT一覧
		Tasks tasks = new TasksDAO().fetchAll(user.getName());

		//ステータスごとにフィルタリング→Listへ変更
		request.setAttribute("todoTasks", tasks.fillter(Status.TODO).toList());
		request.setAttribute("doingTasks", tasks.fillter(Status.DOING).toList());
		request.setAttribute("doneTasks", tasks.fillter(Status.DONE).toList());
		request.getSession().setAttribute("user", user);

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
