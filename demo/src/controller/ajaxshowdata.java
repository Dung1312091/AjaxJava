package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.database;

/**
 * Servlet implementation class ajaxshowdata
 */
@WebServlet("/ajaxshowdata")
public class ajaxshowdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxshowdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		database db = new database();
		String x = request.getParameter("tintuc");
		ResultSet rs =null;
		try {
			rs = db.getlisttintuc("Select * from tintuc where idloaitin = "+x);
			while(rs.next()){
				String note ="";
				if(Integer.parseInt(rs.getString("flags"))==1){
				note = "Yes";
				}
				else{
					 note = "<a href="+ rs.getString("id")+ ">No</a>";
				}
				out.write("<tr>"
						+ "<td>"+ rs.getString("id") +"</td>"
						+ "<td>"+ rs.getString("ten") +"</td>"
						+ "<td>"+ rs.getString("ngaythang") +"</td>"
						+ "<td>"+ rs.getString("giobatdau") +"</td>"
						+ "<td>"+ rs.getString("gioketthuc") +"</td>"
						+ "<td>"+ note +"</td>"
						+ "</tr>");
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
