package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.OrdemControle;
import br.edu.ifpi.biolab.Entidade.Ordem;

public class OrdemVisao {
	private OrdemControle ordemControle;

	public OrdemVisao() {
		ordemControle = new OrdemControle();
	}

	public void adiciona(Ordem ordem) throws SQLException {
		ordemControle.adiciona(ordem);
	}
	public List<Ordem> buscaTodos() throws SQLException {
		List<Ordem> ordems = ordemControle.buscaTodos();
		return ordems;
	}

	public void altera(Ordem ordem) throws SQLException {
		ordemControle.altera(ordem);
	}
	public void remove(Ordem ordem) throws SQLException {
		ordemControle.remove(ordem);
	}

	
	public static void main(String[] args) throws SQLException {

		OrdemVisao visao = new OrdemVisao();
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {

			String menu = "1- Consultar \n 2- Adicionar \n \n 3 - Alterar \n 4 - Remover \n 0-Sair";
			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			Ordem o;

			switch (opcaoEscolhida) {

			case 1:
				List<Ordem> ordems = visao.buscaTodos();
				String ordemsTela = "";
				JOptionPane.showMessageDialog(null, ordems);
				for (Ordem i : ordems) {
					ordemsTela = ordemsTela + i.getId() + " - " + i.getNome() + "\n";
				}

				JOptionPane.showMessageDialog(null, ordemsTela);

				break;
			case 2:
				String nomeOrdem = JOptionPane.showInputDialog("Digite o nome do ordem");
				o = new Ordem(nomeOrdem);
				visao.adiciona(o);
				break;
				
			case 3:
				o = new Ordem("ordem ");
				visao.altera(o);
				break;
				
			case 4:
				o = new Ordem("ordem ");
				visao.remove(o);
				break;
			}

		}

	}
}
