package br.edu.ifpi.biolab.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.Entidade.Classe;

	public class ClasseDao extends Dao{
		public void adicionar(Classe classe) throws SQLException {
			String sql = "insert into classe " + "(nome,id,id_filo) values (?,?,?)";

			PreparedStatement stmt = super.getConexao().prepareStatement(sql);

			stmt.setString(1, classe.getNome());
			stmt.setInt(2, classe.getId());
			stmt.setInt(3, classe.getFilo().getId());

			stmt.execute();
			stmt.close();
			System.out.println("Classe Adicionada!");
		}
		
		public List<Classe> buscaTodos() throws SQLException {
			List<Classe> classes = new ArrayList<>();
			Connection conexao = ConnectionFactory.getConexao();
			PreparedStatement stmt = conexao.prepareStatement("select * from classe");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Classe classe = new Classe();
				classe.setId(rs.getInt("id"));
				classe.setNome(rs.getString("nome"));
				

				classes.add(classe);
			}
			return classes;
		}
		

		public void remove(Classe classe) {
			try {
				PreparedStatement stmt = getConexao().prepareStatement("delete from classe where id=?");
				stmt.setLong(1, classe.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void altera(Classe classe) {
			String sql = "update classe set id=? nome=?" + "where id=?";

			try {
				PreparedStatement stmt = getConexao().prepareStatement(sql);
				stmt.setString(1, classe.getNome());
				stmt.setInt(2, classe.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}


