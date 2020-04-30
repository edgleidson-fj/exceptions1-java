package model.excecoes;
//Excerção personalizada

public class DominioExcecoes extends Exception{
	private static final long serialVersionUID = 1L; //Necessário definir uma versão. /(Versão Padrão) 
	
	public DominioExcecoes(String msg) {
		super(msg);
	}

}
