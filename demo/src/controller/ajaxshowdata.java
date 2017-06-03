package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public String FomatDate(String s){
    	if(s.length()>0){
    		String year = s.substring(0, 4);
    		String month = s.substring(4,6 );
    		String day = s.substring(6,8);
    		s = year +"/" + month + "/" + day;
    	}
    	else{
    		s = "";
    	}
    	return s;
    }
    public String FinDayofWeek(String s){
    	String dayOfWeek = "";
    	if(s.length()>0){
    		int year = Integer.parseInt(s.substring(0, 4));
        	int month = Integer.parseInt(s.substring(4, 6));
        	int day = Integer.parseInt(s.substring(6, 8));
        	String dateString = String.format("%d-%d-%d", year, month, day);
        	Date date;
        	
    		try {
    			date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
    			dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date); 
    		} catch (ParseException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    	}  	
    	return dayOfWeek;
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
				String date = FomatDate(rs.getString("ngaythang"));
				String dayofweek = FinDayofWeek(rs.getString("ngaythang"));
				System.out.println(dayofweek);
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
						+ "<td>"+dayofweek +"-"+"</br>" + date +"</td>"
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
