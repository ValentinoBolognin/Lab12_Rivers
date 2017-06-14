package it.polito.tdp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.model.Flow;
import it.polito.tdp.model.River;
import it.polito.tdp.model.Statistiche;

public class RiverDAO {
	
	public List<River> getAllRivers() {
		
		String sql = "SELECT id, name FROM river ORDER BY name ASC";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			List<River> rivers = new ArrayList<River>();
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				River r = new River(rs.getInt("id"), rs.getString("name"));
				rivers.add(r);
			}
			st.close();
			conn.close();
			
			return rivers;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public List<Flow> getFlows(River river) {
		
		final String sql = "SELECT id, day, flow FROM flow WHERE river=? ORDER BY day ASC";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
		
			List<Flow> flows = new ArrayList<Flow>();
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				flows.add(new Flow(rs.getInt("id"), rs.getDate("day").toLocalDate(), rs.getDouble("flow"), river));
			}
			st.close();
			conn.close();

			return flows;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
	}

	public Statistiche getStatistiche(River river) {
		String sql = "SELECT min(day) as primaData, max(day) as ultimaData, count(*) as nMisure, AVG (flow) as fmed FROM flow WHERE river = ?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
			
			Statistiche statistiche = null;
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				statistiche = new Statistiche(rs.getDate("primaData").toLocalDate(), rs.getDate("ultimaData").toLocalDate(), rs.getInt("nMisure"), rs.getFloat("fmed"));
			}
			st.close();
			conn.close();
			
			return statistiche;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}