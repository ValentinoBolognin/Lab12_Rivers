package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.dao.RiverDAO;

public class Model {
	
	private RiverDAO riverDAO;  
	private List<River> rivers;
	
	public Model() {
		this.riverDAO = new RiverDAO();
	}

	public List<River> getAllRivers() {
		if(rivers == null) {
			rivers = riverDAO.getAllRivers();
			for(River river : rivers)
				river.setFlows(riverDAO.getFlows(river));
		}
		return rivers ;
	}
	
	public Statistiche getStatistiche(River river) {
		return riverDAO.getStatistiche(river);
	}

	public Risultato run(River river, double k) {
		int nGiorni = 0;
		double occupazioneMedia = 0;	
		
		List<Double> occupazione = new ArrayList<Double>();
	
		double fmed = riverDAO.getStatistiche(river).getFmed() * 60 * 60 * 24;
		
		double Q = k * fmed * 30;
		double C = Q / 2;
		double fout_min = 0.8 * fmed;
		
		for (Flow flow : river.getFlows()) {
			double fout = fout_min;
			if (Math.random() < 0.05) 
				fout = 10 * fout_min;
			
			C += flow.getFlow() * 60 * 60 * 24;
			
			if (C > Q)
				C = Q;
	
			if (C < fout){
				nGiorni++;
				C = 0;
			} else {
				C -= fout;
			}
			occupazione.add(C);
		}
		
		double occupazioneTotale = 0;
		for (Double d : occupazione) {
			occupazioneTotale += d;
		}
		occupazioneMedia = occupazioneTotale / occupazione.size();
		
		Risultato risultato = new Risultato(nGiorni, occupazioneMedia);
		return risultato;
	}
}
