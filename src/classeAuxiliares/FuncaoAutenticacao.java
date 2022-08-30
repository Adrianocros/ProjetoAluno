package classeAuxiliares;

import Interfaces.PermitirAcesso;

//Receber o acesso so quem tem o contrato da interface de access
public class FuncaoAutenticacao {

	private PermitirAcesso permitirAcesso;
	
	public boolean autenticar() {
		return permitirAcesso.autenticar();
	}
	
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}
}
