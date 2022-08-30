package Executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Interfaces.PermitirAcesso;
import classeAuxiliares.FuncaoAutenticacao;
import cursoJava.Aluno;
import cursoJava.Diretor;
import cursoJava.Disciplina;
import cursoJava.Secretario;
import cursoJava.constantes.StatusAluno;

public class Application {
	public static void main(String[] args) {
		
		//Validando permissao
		String login = JOptionPane.showInputDialog("Digite o login ");
		String senha = JOptionPane.showInputDialog("Digite a senha ");
		

		if(new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {//Trava para autirizar somente quem pode acessar
			JOptionPane.showMessageDialog(null, "Seja bem vindo!");
		

		List<Aluno> alunos = new ArrayList<Aluno>();
		
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
			
		
//		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
//		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
//		List<Aluno> alunosReprovados = new ArrayList<Aluno>();
		
		String QtdAluno = JOptionPane.showInputDialog("Quantos alunos deseja incluir?");
		for (int qtd = 1; qtd <= Integer.valueOf(QtdAluno); qtd++) {
			String nome = JOptionPane.showInputDialog("Digite o nome do "+ qtd + "º aluno ");
			String matricula = JOptionPane.showInputDialog("Digite a matricula do "+ qtd + "º aluno ");

			/* New Aluno é uma instancia(Criação de Objeto) */
			Aluno aluno1 = new Aluno();

			/* Propriedade do aluno */
			aluno1.setNome(nome);
			aluno1.setMatricula(Integer.valueOf(matricula));
			String QtdDisciplina = JOptionPane.showInputDialog("Quantas disciplinas deseja incluir?");
			for (int pos = 1; pos <= Integer.valueOf(QtdDisciplina); pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Informe o nome da " + pos +"ª disciplina");
				String notaDisciplina = JOptionPane.showInputDialog("Informe a nota da " + pos +"ª disciplina");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);

			}

			/* Remove da lista */
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");
			if (escolha == 0) {/* Zero para sim */
				int continuaRemover = 0;
				int posicao = 1;
				while (continuaRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina, 1, 2, 3 ou 4 ? ");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuaRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar a remover ?");
				}
			}
			alunos.add(aluno1);
		}

		int buscarAluno = JOptionPane.showConfirmDialog(null, "Deseja buscar um aluno? ");
			if (buscarAluno == 0) {
				String nomeAluno = JOptionPane.showInputDialog("Digite o nome do Aluno");
				for (Aluno aluno : alunos) {
				if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
					System.out.println(aluno);
					System.out.println("Disciplinas: " + aluno.getDisciplinas());
					System.out.println("Media do aluno: " + aluno.getMediaNota());
					System.out.println("Resultado = " + (aluno.getAlunoAprovado2()));
					System.out.println("---------------------------------------------");
					break;
				}
			}
		}

		int removeAluno = JOptionPane.showConfirmDialog(null, "Deseja remover algum aluno? ");
		if (removeAluno == 0) {
				String QtdRemover = JOptionPane.showInputDialog("Quantas alunos deseja excluir?");
				for (int aQtd = 1; aQtd <= Integer.valueOf(QtdRemover); aQtd++) {
					String nomeAluno = JOptionPane.showInputDialog("Digite o nome do " + aQtd +"° aluno que sera removido" );
					for (Aluno aluno : alunos) {
					if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
						alunos.remove(aluno);
						System.out.println("---------------------------------------------");
						System.out.println("Aluno removido: " + nomeAluno);
						System.out.println("---------------------------------------------");
						System.out.println("-------------- Alunos da lista --------------");
						System.out.println("---------------------------------------------");
						break;
					}
				}
			}
		}
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
			System.out.println("Disciplinas: " + aluno.getDisciplinas());
			System.out.println("Media do aluno: " + aluno.getMediaNota());
			System.out.println("Resultado = " + (aluno.getAlunoAprovado2()));
			System.out.println("---------------------------------------------");
		}
		
		//Retorna a lista de alunos Aprovado / Recuperação / Reprovado
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		
		for (Aluno aluno : alunos) {
			if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				}else if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				}else if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}
			System.out.println("-------------Lista de status de alunos--------------");
			for(Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Nome: " + aluno.getNome()+ " - Resultado: " + aluno.getAlunoAprovado2() + " -Media: " + aluno.getMediaNota());
			}
			System.out.println("-----------------------------------------------------");
			for(Aluno aluno :  maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Nome: " + aluno.getNome()+ " - Resultado: " + aluno.getAlunoAprovado2() + " -Media: " + aluno.getMediaNota());
			}
			System.out.println("-----------------------------------------------------");
			for(Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Nome: " + aluno.getNome()+ " - Resultado: "  +aluno.getAlunoAprovado2() + " -Media: " + aluno.getMediaNota());
			}
		}else {
			System.out.println(login);
			System.out.println(senha);
			JOptionPane.showMessageDialog(null, "Acesso nao permitido");
			
		}
	}
}
