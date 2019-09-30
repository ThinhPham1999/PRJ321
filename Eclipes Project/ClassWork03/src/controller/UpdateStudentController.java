package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Student;
import dao.StudentDB;

/**
 * Servlet implementation class UpdateStudentController
 */
@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Student update = StudentDB.getStudent(Integer.parseInt(id));
		request.setAttribute("update", update);
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idU = request.getParameter("idU");
		String nameU = request.getParameter("nameU");
		String genderU = request.getParameter("genderU");
		String dob = request.getParameter("dobU");
		int genderadd = 1;
		if (genderU.equals("Male")) {
			genderadd = 0;
		}
		Student upst = new Student(Integer.parseInt(idU), nameU, genderadd, dob);
		StudentDB.updateStudent(upst);
		RequestDispatcher rd = request.getRequestDispatcher("ListController");
		rd.forward(request, response);

	}

}
