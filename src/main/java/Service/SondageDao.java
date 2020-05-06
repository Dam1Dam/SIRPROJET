package Service;

import java.util.List;

import jpaModel.Sondage;;

public class SondageDao {
	
	public Sondage findById(int id) {
		return EntityManagerHelper.getEntityManager().find(Sondage.class, id);
	}
	
	public Sondage findByUrl(String url){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select s from Sondage as s where s.url = :lien", Sondage.class)
				.setParameter("lien", url).getSingleResult();
		
	}
	public List<Sondage> findAll(){
		
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Sondage as p", Sondage.class)
				.getResultList();
		
	}
	
	public void addResponse(Sondage p) {
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

