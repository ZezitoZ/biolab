package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Familia;

public class FamiliaDao extends Dao {
	
	public void adicionar(Familia familia) throws SQLException {
		String sql = "insert into familia " + "(nome) values (?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		stmt.setString(1, familia.getNome());

		stmt.execute();
		stmt.close();
		System.out.println("Familia Adicionado!");
	}

	public List<Familia> buscaTodos() throws SQLException {
		List<Familia> familias = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from familia");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Familia familia = new Familia();
			familia.setId(rs.getInt("id"));
			familia.setNome(rs.getString("nome"));

			familias.add(familia);
		}
		return familias;
	}
	
	public void remove(Familia familia) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete from familia where id=?");
			stmt.setLong(1, familia.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Familia familia) {
		String sql = "update familia set id=? nome=?" + "where id=?";

		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, familia.getNome());
			stmt.setInt(2, familia.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
