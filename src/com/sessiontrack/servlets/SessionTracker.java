package com.sessiontrack.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionTracker")
public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionTracker() {
        super();
        // TODO Auto-generated constructor stub
    }

	
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Date createTime = new Date (session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		 String title = "Welcome Back to my website";
	      Integer visitCount = new Integer(0);
	      String visitCountKey = new String("visitCount");
	      String userIdKey = new String("userId");
	      String userId = new String("Avinash");
		
		if(session.isNew()){
			session.setAttribute(userIdKey, userId);
		}
		else{
			visitCount = (Integer)session.getAttribute(visitCountKey);
	         visitCount = visitCount + 1;
	         userId = (String)session.getAttribute(userIdKey);
		}
		session.setAttribute(visitCountKey,  visitCount);
		 response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      
	      out.print("<html>"+
"<head>"+
"<title>"+title +"</title>"+
"</head>"+
"<body>"+
"<h1 align=center>"+ title +"</h1>"
+"<h2 align=center>Session Infomation</h2>"
+"<table border=1 align=center>"
+"<tr bgcolor=#949494>"
+"<th>Session info</th><th>value</th></tr>"
+"<tr>"
+"<td>id</td>"
+"<td>"+ session.getId()+"</td></tr>"
+"<tr>"
+"<td>Creation Time</td>"
+"<td>"+createTime+"</td>"
+"</tr>"
+"<tr>"
+"<td>Time of Last Access</td>"
+"<td>"+lastAccessTime + "</td></tr>"
+"<tr>"
+"<td>User ID</td>"
+"<td>"+userId+" </td>"
+"</tr>"
+"<tr>"
+"<td>Number of visits</td>"
+"<td>"+ visitCount +"</td></tr>"
+"</table>"
+"</body>"
+"</html>");	
	}

}
