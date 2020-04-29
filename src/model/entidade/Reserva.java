package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		}

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
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
	
	public String atualizacaoData(Date dataEntrada, Date dataSaida) {
		
		Date hoje = new Date();
		if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {// ENTRADA.Antes(hoje) ou SA�DA.Antes(hoje)
			return "Erro na reserva - Data de atualiza��o de reserva dever ser datas futuras!";
		} 
		if (!dataSaida.after(dataEntrada)) {
			return "Erro na reserva - Data de ENTRADA depois da data de SA�DA!";
		}
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		
		return null;
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
