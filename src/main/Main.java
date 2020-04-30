package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.excecoes.DominioExcecoes;

//Aulas 137 - 138 - 139 - 140 Exceptions (Solução Boa) {Github}  
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Informe o número do quarto? ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Informe a data de entrada (dd/MM/aaaa)? ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Informe a data de saída (dd/MM/aaaa)? ");
			Date dataSaida = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
			System.out.println("_______________________________________");
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Informe a data de entrada (dd/MM/aaaa)? ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Informe a data de saída (dd/MM/aaaa)? ");
			dataSaida = sdf.parse(sc.next());

			reserva.atualizacaoData(dataEntrada, dataSaida);
			System.out.println("Reserva: " + reserva);
		} 
		catch (ParseException ex) {
			System.out.println("Formato da data inválido!");
		} 
		catch (DominioExcecoes ex) { // Exceção personalizada
			System.out.println(ex.getMessage());
		} 
		catch (RuntimeException ex) {// Qual outro tipo de execeção.
			System.out.println("Erro desconhecido: " + ex);
		}
		sc.close();
	}
}
