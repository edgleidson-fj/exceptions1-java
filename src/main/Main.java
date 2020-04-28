package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

//Aula 137 e 138 Exceptions (Solução Muito Ruim) {Github}  
public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe o número do quarto? ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Informe a data de entrada (dd/MM/aaaa)? ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Informe a data de saída (dd/MM/aaaa)? ");
		Date dataSaida = sdf.parse(sc.next());

		if (!dataSaida.after(dataEntrada)) { // Diferente SAÍDA.depois(ENTRADA)
			System.out.println("Erro na reserva - Data de ENTRADA depois da data de SAÍDA!");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
			System.out.println("_______________________________________");
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Informe a data de entrada (dd/MM/aaaa)? ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Informe a data de saída (dd/MM/aaaa)? ");
			dataSaida = sdf.parse(sc.next());

			Date hoje = new Date();
			if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {// ENTRADA.Antes(hoje) ou SAÍDA.Antes(hoje)
				System.out.println("Erro na reserva - Data de atualização de reserva dever ser datas futuras!");
			} else if (!dataSaida.after(dataEntrada)) {
				System.out.println("Erro na reserva - Data de ENTRADA depois da data de SAÍDA!");
			} else {
				reserva.atualizacaoData(dataEntrada, dataSaida);
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}
}
