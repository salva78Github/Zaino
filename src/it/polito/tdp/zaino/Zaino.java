package it.polito.tdp.zaino;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zaino {

	private int capienza; // peso max sopportato dallo zaino
	private List<Pezzo> pezzi; // pezzi da provare e inserire

	/**
	 * Inizializza un nuovo problema dello zaino
	 * 
	 * @param capienza:
	 *            massimo peso che lo zaino può sopportare
	 */
	public Zaino(int capienza) {
		this.capienza = capienza;
		this.pezzi = new ArrayList<Pezzo>();
	}

	
	
	/**
	 * Aggiunge un nuovo pezzo al problema dello zaino che si vuole risolvere.
	 * Il nuovo pezzo deve essere diverso da quelli già presenti
	 * 
	 * @param p il {@link Pezzo} da aggiungere 
	 */
	public void addPezzo(Pezzo p) {
		// se usavo un Set non serviva questo controllo
		if (!this.pezzi.contains(p)) {
			this.pezzi.add(p);
		} else {
			throw new IllegalArgumentException("Pezzo duplicato " + p);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zaino z = new Zaino (15);
		z.addPezzo(new Pezzo(12,4,"verde"));
		z.addPezzo(new Pezzo(2,2,"azzurro"));
		z.addPezzo(new Pezzo(1,1,"salmone"));
		z.addPezzo(new Pezzo(4,10,"giallo"));
		z.addPezzo(new Pezzo(1,2,"grigio"));
		
		Set<Pezzo> soluzione = z.risolvi();
		
		System.out.println(soluzione);
		
		
	}

	/**
	 * calcola il costo della soluzione parziale
	 * 
	 * @param parziale
	 * @return
	 */
	private int costo(Set<Pezzo> parziale){
		int r = 0;
		for(Pezzo p: parziale){
			r += p.getCosto();
		}
		
		return r;
	}
	
	private void scegli(Set<Pezzo> parziale, int livello, Set<Pezzo> best){
		
		if(costo(parziale) > costo(best)){
			//trovato soluzione migliore
			//devo salvarla in best
			System.out.println("parziale: " + parziale);
		}
		
		for(Pezzo p: pezzi){
			if(!parziale.contains(p)){
				//pezzo 'p' non c'è ancora, provo a metterlo
				//se non supera la capacità dello zaino
				if(peso(parziale)+p.getPeso()<=capienza){
					//prova a mettere 'p' nello zaino
					parziale.add(p);
					//e delegare la ricerca al livello successivo
					scegli(parziale, livello+1, best);
					//poi rimetti le cose a posto (togli 'p')
					parziale.remove(p);
				}
			}
		}
		
		
	}
	
	/**
	 * calcola il peso della soluzione parziale
	 * 
	 * @param parziale
	 * @return
	 */
	
	private int peso(Set<Pezzo> parziale) {
		int r = 0;
		for(Pezzo p: parziale){
			r += p.getPeso();
		}
		
		return r;
	}



	private Set<Pezzo> risolvi() {
		// TODO Auto-generated method stub


		//soluzione madre di livello 0
		Set<Pezzo> parziale = new HashSet<Pezzo>();
		Set<Pezzo> best = new HashSet<Pezzo>();
		scegli(parziale, 0, best);
		
		return best;
	}

}
