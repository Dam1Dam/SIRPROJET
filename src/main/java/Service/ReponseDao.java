package Service;

import java.util.List;

import jpaModel.Reponse;;

public class ReponseDao {
	
	public Reponse findById(int id) {
		return EntityManagerHelper.getEntityManager().find(Reponse.class, id);
	}
	
	public List<Reponse> findByParticipant(String id){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select rep FROM Participant e JOIN e.Reponse rep where e.Reponse = :part", Reponse.class)
				.setParameter("part", id).getResultList();
		
	}
	public List<Reponse> findAll(){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Reponse as p", Reponse.class)
				.getResultList();
		
	}
	
	public void addResponse(Reponse p) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(p);
		EntityManagerHelper.commit();
	}
	
	public void delete(int id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();        
    }
	
	

	
	
	
	

}

