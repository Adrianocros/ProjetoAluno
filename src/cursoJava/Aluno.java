package cursoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cursoJava.constantes.StatusAluno;

/*Clase/Objeto que reperesenta o aluno*/
public class Aluno extends Pessoa {
	/*Estes são os atributos da Classe Aluno*/
	private int matricula;
	
	
	/*Criado a lista de disciplina no aluno*/
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Aluno() {}
	

	public Aluno(String nomePadrao,int matricula, List<Disciplina> disciplinas) {
		super();
		nome = nomePadrao;
		this.matricula = matricula;
		this.disciplinas = disciplinas;
	}


	/*Cria os dados na memoria*/
	

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
			
	
	/*Metodo que retorna a media do aluno de disciplina*/
	public double getMediaNota() {
		double somaNota = 0.0;
		for (Disciplina disciplina : disciplinas) {
			somaNota += disciplina.getNota();
		}
		return somaNota / disciplinas.size();//size() Retorna quantos objetos tem na lista.
	}
	
	

	@Override
	public String toString() {
		return "Aluno Nome:" + nome 
				+ ", matricula:" + matricula;
		
	}

	/*Metodo que retorna o aluno aprovado ou nao*/
	public boolean getAlunoAprovado() {
		double media = this.getMediaNota();
		if(media >= 70) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public String getAlunoAprovado2() {
		double media = this.getMediaNota();
		if(media >= 50) {	
			if(media >= 70) {
			return StatusAluno.APROVADO;
		}else {
			return StatusAluno.RECUPERACAO;
		}
		}else {
			return StatusAluno.REPROVADO;
		}
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
