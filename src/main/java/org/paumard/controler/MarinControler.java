package org.paumard.controler;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.paumard.ejb.MarinEJB;
import org.paumard.model.Marin;

@SuppressWarnings("serial")
@Named("marinControler")
@SessionScoped
public class MarinControler implements Serializable {
	
	@Inject
	private transient MarinEJB marinEJB ;
	
	private Marin marin = new Marin() ;
	private List< Marin> marins;

	public void create() {
		Long id = marinEJB.createMarin(marin) ;
		System.out.println("Marin persisté : " + id) ;
	}
	
	public Marin getMarin() {
		return marin;
	}

	public void setMarin(Marin marin) {
		this.marin = marin;
	}
	
	
@SuppressWarnings("unchecked")
	public void delete() {
		
		marins= marinEJB.supression(marin);
		System.out.println("Marin persisté : " + marin.getNom()) ;
		
	}
	@SuppressWarnings("unchecked")

        public void deletePrenom() {

		

		marins= marinEJB.deleteMarinByPrenom(marin);

		System.out.println("Marin persisté : " + marin.getPrenom()) ;
	}
	
		public void delete() {

		
		marinEJB.deleteMarin(marin);

		System.out.println("Marin supprimé : " + marin.getNom()) ;

	}

	public void rechercherById() {

		marinEJB.rechercheMarin(marin.getId());

		System.out.println("Marin recherché : " + marin.getNom()) ;

	}
}

