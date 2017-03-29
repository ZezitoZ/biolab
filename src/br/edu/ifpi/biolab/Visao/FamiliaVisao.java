package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.FamiliaControle;
import br.edu.ifpi.biolab.Entidade.Familia;

public class FamiliaVisao {
	private FamiliaControle familiaControle;

	public FamiliaVisao() {
		familiaControle = new FamiliaControle();
	}

	public void adiciona(Familia familia) throws SQLException {
		familiaControle.adiciona(familia);
	}
	public List<Familia> buscaTodos() throws SQLException {
		List<Familia> familias = familiaControle.buscaTodos();
		return familias;
	}

	public void altera(Familia familia) throws SQLException {
		familiaControle.altera(familia);
	}
	public void remove(Familia familia) throws SQLException {
		familiaControle.remove(familia);
	}

	
	public static void main(String[] args) throws SQLException {

		FamiliaVisao visao = new FamiliaVisao();
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {

			String menu = "1- Consultar \n 2- Adicionar \n \n 3 - Alterar \n 4 - Remover \n 0-Sair";
			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			Familia f;

			switch (opcaoEscolhida) {

			case 1:
				List<Familia> familias = visao.buscaTodos();
				String familiasTela = "";
				JOptionPane.showMessageDialog(null, familias);
				for (Familia i : familias) {
					familiasTela = familiasTela + i.getId() + " - " + i.getNome() + "\n";
				}

				JOptionPane.showMessageDialog(null, familiasTela);

				break;
			case 2:
				String nomeFamilia = JOptionPane.showInputDialog("Digite o nome do familia");
				f = new Familia(nomeFamilia);
				visao.adiciona(f);
				break;
				
			case 3:
				f = new Familia("familia ");
				visao.altera(f);
				break;
				
			case 4:
				f = new Familia("familia ");
				visao.remove(f);
				break;
			}

		}

	}



}
