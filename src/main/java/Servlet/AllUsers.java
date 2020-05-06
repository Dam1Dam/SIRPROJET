package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ParticipantDao;
import jpaModel.Participant;

@WebServlet(name="mytest", urlPatterns={"/allUsers"})
public class AllUsers extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		PrintWriter p = new PrintWriter(resp.getOutputStream());
		
		ParticipantDao pdao = new ParticipantDao();
		
		List<Participant> users= pdao.findAll();
		
		for(Participant user: users) {
			p.print(user.getPrenom() + " \t" + user.getNom() + "\n");
		}
		
		p.flush();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}	
}
