package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.database;

/**
 * Servlet implementation class getListUser
 */
@WebServlet("/getListUser")
public class getListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getListUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		database db = new database();
		try {
			rs =  db.getlisttheloai("Select * from theloai"); 
//			 RequestDispatcher dispatch = getServletContext().getRequestDispatcher("listuser.jsp");
//			 dispatch.forward(request, response);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("listuser.jsp");
			 request.setAttribute("listuser", rs);
			dispatcher.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("theloai");
		System.out.println(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("listuser.jsp");
//		//request.setAttribute("listuser", rs);
//		dispatcher.forward(request, response);
	}

}
