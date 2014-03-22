package org.paumard.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.paumard.model.Marin;

@Stateless
public class MarinEJB {

	@PersistenceContext(unitName="cloudbees-project")
	@PersistenceContext(unitName="MySQL")
	
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
@SuppressWarnings("unused")

      public void retreaveMarin(Long Id ){

	 Marin marin=new Marin();

	marin= em.find(Marin.class, Id);

			

	}
+	public void deleteMarin(Marin marin ){

+		

+		Query q = em.createQuery("select Marin from Marin marin where marin.nom =" +"'" +marin.getNom()+"'" );

+		List<Marin> marins = q.getResultList() ;

+		for (Marin marin_sup : marins) {

+		   em.remove(marin_sup);

+		}}

+	public void rechercheMarin(Long Id ){

+		Marin marin=new Marin();

+		marin= em.find(Marin.class, Id);

+					

+	}

}
