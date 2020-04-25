package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Service.ParticipantDao;
import jpaModel.Participant;

public class JpaTest {

	private static EntityManagerFactory Entity_Manager_Factory = Persistence.createEntityManagerFactory("mysql");
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
				
		
		ParticipantDao pdao = new ParticipantDao();
		
		Participant p = new Participant("cantin", "damien", "damien.cantin@gmail.com");
		
		pdao.addParticipant(p);
		
		p = new Participant("dulac", "damien", "damien.dulac@gmail.com");
		
		pdao.addParticipant(p);
		

		List<Participant> truc = pdao.findAll();
		
		for (Participant part : truc) {
			System.out.println(part.toString());
		}
		
		
		System.out.println(pdao.findNumberParticipant());
		

	}

}

