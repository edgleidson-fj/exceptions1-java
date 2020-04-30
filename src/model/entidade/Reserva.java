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
			throw new DominioExcecoes("Erro na reserva - Data de ENTRADA não pode ser inferior a data de SAÍDA!");
		}//Definindo uma exceção no Construtor (Para execução assim que a Classe for acionada).
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
		long diferenca = dataSaida.getTime() - dataEntrada.getTime(); // Diferença entre a data de SAÍDA e ENTRADA em (Millisegundos)
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);// Converte Millisegundos em Dias.
	}
	
	public void atualizacaoData(Date dataEntrada, Date dataSaida) throws DominioExcecoes { //Propagando a exceção		
		Date hoje = new Date();
		if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {
			throw new DominioExcecoes("Erro na reserva - Data de atualização de reserva dever ser datas futuras!");
			//Lançando excerção no sistema.
			//Exceção personalizada (diretório: model.excecoes)
		} 
		if (!dataSaida.after(dataEntrada)) {
			throw new DominioExcecoes("Erro na reserva - Data de ENTRADA não pode ser inferior a data de SAÍDA!");
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
				+ ", Saída: "
				+ sdf.format(dataSaida)
				+ ", Total: "
				+ duracao()
				+ " noites.";
	}
	}
