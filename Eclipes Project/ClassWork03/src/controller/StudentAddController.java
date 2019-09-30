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
 * Servlet implementation class StudentAdd
 */
@WebServlet("/StudentAdd")
public class StudentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender").toString();
		String dob = request.getParameter("dob").toString().trim();
		int setgender = 1;
		if (gender.equals("Male")) {
			setgender = 0;
		}
		Student newstu = new Student(0, name, setgender, dob);
		StudentDB.newStudent(newstu);
		RequestDispatcher rd = request.getRequestDispatcher("ListController");
		rd.forward(request, response);
	}

}
