package model.excecoes;
//Excer��o personalizada

public class DominioExcecoes extends Exception{
	private static final long serialVersionUID = 1L; //Necess�rio definir uma vers�o. /(Vers�o Padr�o) 
	
	public DominioExcecoes(String msg) {
		super(msg);
	}

}
