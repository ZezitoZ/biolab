package br.edu.ifpi.biolab.Visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.Controle.ClasseControle;
import br.edu.ifpi.biolab.Entidade.Classe;

	public class ClasseVisao {
		private ClasseControle classeControle;

		public ClasseVisao() {
			classeControle = new ClasseControle();
		}

		public void adiciona(Classe classe) throws SQLException {
			classeControle.adiciona(classe);
		}
		public List<Classe> buscaTodos() throws SQLException {
			List<Classe> classes = classeControle.buscaTodos();
			return classes;
		}

		public void altera(Classe classe) throws SQLException {
			classeControle.altera(classe);
		}
		public void remove(Classe classe) throws SQLException {
			classeControle.remove(classe);
		}

		
		public static void main(String[] args) throws SQLException {

			ClasseVisao visao = new ClasseVisao();
			int opcaoEscolhida = 1;
			while (opcaoEscolhida != 0) {

				String menu = "1- Consultar \n 2- Adicionar \n \n 3 - Alterar \n 4 - Remover \n 0-Sair";
				String valorDigitado = JOptionPane.showInputDialog(menu);
				opcaoEscolhida = Integer.parseInt(valorDigitado);
				Classe r;

				switch (opcaoEscolhida) {

				case 1:
					List<Classe> classes = visao.buscaTodos();
					String classesTela = "";
					JOptionPane.showMessageDialog(null, classes);
					for (Classe i : classes) {
						classesTela = classesTela + i.getId() + " - " + i.getNome() + "\n";
					}

					JOptionPane.showMessageDialog(null, classesTela);

					break;
				case 2:
					String nomeClasse = JOptionPane.showInputDialog("Digite o nome do classe");
					r = new Classe(nomeClasse);
					visao.adiciona(r);
					break;
					
				case 3:
					r = new Classe("Classe ");
					visao.altera(r);
					break;
					
				case 4:
					r = new Classe("Classe ");
					visao.remove(r);
					break;
				}

			}

		}
	}
