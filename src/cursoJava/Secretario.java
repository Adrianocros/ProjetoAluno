package cursoJava;

import Interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {
	private String registro;
	private String NivelCargo;
	private String Experiencia;
	
	private String login;
	private String senha;
	
	
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNivelCargo() {
		return NivelCargo;
	}
	public void setNivelCargo(String nivelCargo) {
		NivelCargo = nivelCargo;
	}
	public String getExperiencia() {
		return Experiencia;
	}
	public void setExperiencia(String experiencia) {
		Experiencia = experiencia;
	}
	
	
		
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Secretario [DataMatricula=" + registro + ", NivelCargo=" + NivelCargo + ", Experiencia="
				+ Experiencia + "]";
	}
	//Metodo do contrato de autenticação
	@Override
	public boolean autenticar() {
		
		return login.equals("sec") && senha.equals("123");
	}
	
	
	
	

}
