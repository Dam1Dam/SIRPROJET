package jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import Service.EntityManagerHelper;
import Service.ParticipantDao;
import Service.PropositionDao;
import jpaModel.Participant;
import jpaModel.Proposition;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		//tx.begin();
		System.out.println("test");


		try {
			
			ParticipantDao dao = new ParticipantDao();
			Participant p = new Participant("cantin", "damien", "damien.cantin@gmail.com");
			dao.addParticipant(p);
			System.out.println(dao.findByFirstName("damien"));
			PropositionDao pdao = new PropositionDao();
			Proposition prop = new Proposition("20/03/2020", "20/03/2020", "bat7", true);
			pdao.addProp(prop);
			
			pdao.findByPropAccept(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
