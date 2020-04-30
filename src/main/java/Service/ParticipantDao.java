package Service;

import java.util.List;

import jpaModel.Participant;

public class ParticipantDao {
	
	public Participant findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Participant.class, id);
	}
	
	public List<Participant> findByFirstName(String firstName){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Participant as p where p.prenom = :prenom", Participant.class)
				.setParameter("prenom", firstName).getResultList();
		
	}
	public List<Participant> findAll(){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Participant p", Participant.class)
				.getResultList();
		
	}
	
	public int findNumberParticipant() {
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Participant p", Participant.class)
				.getResultList().size();
	}
	
	public void addParticipant(Participant p) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(p);
		EntityManagerHelper.commit();
	}
	
	public void delete(Long id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();        
    }
	
	

	
	
	
	

}
