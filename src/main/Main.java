package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

//Aulas 137 - 138 - 139 Exceptions (Solu��o Ruim) {Github}  
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

			String erro = reserva.atualizacaoData(dataEntrada, dataSaida);
			if(erro != null) {
				System.out.println(erro);
			}else {
			System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}
}
