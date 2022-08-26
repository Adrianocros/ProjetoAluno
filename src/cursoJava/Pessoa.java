package cursoJava;

//Classe PAI ou MASTER ou SUPERCLASSE 
//abstract para nao poder instanciar diretamente a classe
public abstract class Pessoa {
  protected String nome;
    

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

@Override
public String toString() {
	return "Pessoa [nome=" + nome + "]";
}
  

  
 
}
