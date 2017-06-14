package it.polito.tdp.model;

public class Risultato {

	private int nGiorni;
	private double occupazioneMedia;
	
	public Risultato(int nGiorni, double occupazioneMedia) {
		super();
		this.nGiorni = nGiorni;
		this.occupazioneMedia = occupazioneMedia;
	}

	public int getNGiorni() {
		return nGiorni;
	}

	public void setNGiorni(int nGiorni) {
		this.nGiorni = nGiorni;
	}

	public double getOccupazioneMedia() {
		return occupazioneMedia;
	}

	public void setOccupazioneMedia(double occupazioneMedia) {
		this.occupazioneMedia = occupazioneMedia;
	}
		
}
