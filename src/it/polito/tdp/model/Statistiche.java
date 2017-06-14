package it.polito.tdp.model;

import java.time.LocalDate;

public class Statistiche {
	
	private LocalDate primaData;
	private LocalDate ultimaData;
	private int nMisure;
	private double fmed;
	
	public Statistiche(LocalDate primaData, LocalDate ultimaData, int nMisure, double fmed) {
		super();
		this.primaData = primaData;
		this.ultimaData = ultimaData;
		this.nMisure = nMisure;
		this.fmed = fmed;
	}

	public LocalDate getPrimaData() {
		return primaData;
	}

	public void setPrimaData(LocalDate primaData) {
		this.primaData = primaData;
	}

	public LocalDate getUltimaData() {
		return ultimaData;
	}

	public void setUltimaData(LocalDate ultimaData) {
		this.ultimaData = ultimaData;
	}

	public int getNMisure() {
		return nMisure;
	}

	public void setNumeroMisurazioni(int nMisure) {
		this.nMisure = nMisure;
	}

	public double getFmed() {
		return fmed;
	}

	public void setFmed(double fmed) {
		this.fmed = fmed;
	}

}
