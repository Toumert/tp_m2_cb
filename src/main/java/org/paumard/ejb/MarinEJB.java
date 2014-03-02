package org.paumard.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.paumard.model.Marin;

@Stateless
public class MarinEJB {

	@PersistenceContext(unitName="cloudbees-project")
	private EntityManager em ;
	
	public Long createMarin(Marin marin) {
		
		em.persist(marin) ;
		return marin.getId() ;
 	}
 		@SuppressWarnings({ "unchecked", "rawtypes" })
	public List supression(Marin marin ){
		
		javax.persistence.Query q = em.createQuery("select Marin from Marin marin where marin.nom =" +"'" +marin.getNom()+"'" );
		List<Marin> marins = q.getResultList() ;
		for (Marin marin1 : marins) {
		   em.remove(marin1);
		}
		return marins;
	}


}
