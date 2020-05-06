package Service;

import java.util.List;

import jpaModel.SondageReunion;

public class SondageReunionDAO  {

	public SondageReunion findById(int id) {
		return EntityManagerHelper.getEntityManager().find(SondageReunion.class, id);
	}

	public SondageReunion findByUrl(String url){

		return EntityManagerHelper.getEntityManager()
				.createQuery("select s from SondageReunion as s where s.url = :lien", SondageReunion.class)
				.setParameter("lien", url).getSingleResult();

	}

	public List<SondageReunion> findByIntitule(String intit){

		return EntityManagerHelper.getEntityManager()
				.createQuery("select s from SondageReunion as s where s.intitule = :lien", SondageReunion.class)
				.setParameter("lien", intit).getResultList();

	}

	public List<SondageReunion> findAll(){

		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from sondagereunion as p", SondageReunion.class)
				.getResultList();

	}

	public void addSondageReunion(SondageReunion p) {
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


