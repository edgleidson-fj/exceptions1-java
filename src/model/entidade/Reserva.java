package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DominioExcecoes;

public class Reserva {

	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		}

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) throws DominioExcecoes {
		if (!dataSaida.after(dataEntrada)) {
			throw new DominioExcecoes("Erro na reserva - Data de ENTRADA n�o pode ser inferior a data de SA�DA!");
		}//Definindo uma exce��o no Construtor (Para execu��o assim que a Classe for acionada).
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime(); // Diferen�a entre a data de SA�DA e ENTRADA em (Millisegundos)
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);// Converte Millisegundos em Dias.
	}
	
	public void atualizacaoData(Date dataEntrada, Date dataSaida) throws DominioExcecoes { //Propagando a exce��o		
		Date hoje = new Date();
		if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {
			throw new DominioExcecoes("Erro na reserva - Data de atualiza��o de reserva dever ser datas futuras!");
			//Lan�ando excer��o no sistema.
			//Exce��o personalizada (diret�rio: model.excecoes)
		} 
		if (!dataSaida.after(dataEntrada)) {
			throw new DominioExcecoes("Erro na reserva - Data de ENTRADA n�o pode ser inferior a data de SA�DA!");
		}
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		return "Quarto: "
				+ numeroQuarto
				+ ", Entrada: "
				+ sdf.format(dataEntrada)
				+ ", Sa�da: "
				+ sdf.format(dataSaida)
				+ ", Total: "
				+ duracao()
				+ " noites.";
	}
	}
