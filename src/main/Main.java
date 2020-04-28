package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

//Aula 137 e 138 Exceptions (Solu��o Muito Ruim) {Github}  
public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe o n�mero do quarto? ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Informe a data de entrada (dd/MM/aaaa)? ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Informe a data de sa�da (dd/MM/aaaa)? ");
		Date dataSaida = sdf.parse(sc.next());

		if (!dataSaida.after(dataEntrada)) { // Diferente SA�DA.depois(ENTRADA)
			System.out.println("Erro na reserva - Data de ENTRADA depois da data de SA�DA!");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
			System.out.println("_______________________________________");
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Informe a data de entrada (dd/MM/aaaa)? ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Informe a data de sa�da (dd/MM/aaaa)? ");
			dataSaida = sdf.parse(sc.next());

			Date hoje = new Date();
			if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {// ENTRADA.Antes(hoje) ou SA�DA.Antes(hoje)
				System.out.println("Erro na reserva - Data de atualiza��o de reserva dever ser datas futuras!");
			} else if (!dataSaida.after(dataEntrada)) {
				System.out.println("Erro na reserva - Data de ENTRADA depois da data de SA�DA!");
			} else {
				reserva.atualizacaoData(dataEntrada, dataSaida);
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}
}
