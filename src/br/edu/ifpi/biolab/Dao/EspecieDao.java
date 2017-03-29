package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Especie;

public class EspecieDao extends Dao {

	public void adicionar(Especie especie) throws SQLException {
		String sql = "insert into especie " + "(nomeVulgar,nomeCientifico,id_genero) values (?,?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, especie.getNomeVulgar());
		stmt.setString(2, especie.getNomeCientifico());
		stmt.setInt(3, especie.getGenero().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Especie Adicionada!");
	}

	public List<Especie> buscaTodos() throws SQLException {
		List<Especie> especies = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		getTime();
		PreparedStatement stmt = conexao.prepareStatement("select * from especie");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Especie especie = new Especie();
			especie.setId(rs.getInt("id"));
			especie.setNomeVulgar(rs.getString("nomeVulgar"));
			especie.setNomeCientifico(rs.getString("nomeCientifico"));

			especies.add(especie);
		}
		return especies;
	}

	private void getTime() {

	}

	public Especie buscaPorID(int id) {
		return null;

	}

	public void remove(Especie especie) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from especie  where id=?");
			stmt.setLong(1, especie.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Especie especie) {
		String sql = "update especie set id=? nomeVulgar=?, nomeCientifico=?," + "datainclusao=?, where id=?";

		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, especie.getId());
			stmt.setString(2, especie.getNomeVulgar());
			stmt.setString(3, especie.getNomeCientifico());
			stmt.setDate(4, new Date(especie.getDatainclusao().getTime()));
			stmt.setLong(5, especie.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
