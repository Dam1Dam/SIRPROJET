package Service;

import java.util.List;

import jpaModel.Proposition;;

public class PropositionDao {

	public Proposition findById(int id) {
		return EntityManagerHelper.getEntityManager().find(Proposition.class, id);
	}
	
	public List<Proposition> findByPropAccept(boolean accpt){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Proposition as p where p.propositionAcceptee = :number", Proposition.class)
				.setParameter("number", accpt).getResultList();
		
	}
	
	public List<Proposition> findAll(){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Proposition as p", Proposition.class)
				.getResultList();
		
	}
	
	public void addProp(Proposition p) {
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
