package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ParticipantDao;
import jpaModel.Participant;

@WebServlet(name="adduser", urlPatterns={"/AddUser"})
public class AddUser extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		ParticipantDao pdao = new ParticipantDao();
		
		Participant p = new Participant(request.getParameter("name").toString(),request.getParameter("firstname").toString(), request.getParameter("email").toString());
		
		pdao.addParticipant(p);
		
		response.sendRedirect("/allUsers");
		
		
		

	}
	
	
}
