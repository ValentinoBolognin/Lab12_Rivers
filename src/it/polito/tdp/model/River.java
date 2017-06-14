package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class River {

	private int id;
	private String name;
	private List<Flow> flows;

	public River(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.flows = new ArrayList<Flow>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

	@Override
	public String toString() {
		return name;
	}

}
