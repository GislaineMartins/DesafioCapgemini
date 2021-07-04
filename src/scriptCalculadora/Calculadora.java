package scriptCalculadora;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		

		System.out.println("Informe valor investido:");
		double valorInvestido = sc.nextDouble();
		
		double visualizacoes = valorInvestido * 30;
		double nvis = visualizacoes;
		double totalvis = visualizacoes;
		
		for(int i=1; i<=4 ;i++) {
			double clique = nvis * 0.12; //a cada 100 pessoas que visualizam o anúncio 12 clicam nele.(12/100 = 0.12)
			double compartilha = clique * 0.15; //a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.(3/20 = 0.15)
			nvis = compartilha * 40; //cada compartilhamento nas redes sociais gera 40 novas visualizações.
			totalvis += nvis;
		}
		
		double arredonda = Math.round(totalvis);// Math.round usado para arrendondar valor do total de visualizacoes
		System.out.println("total de "+ arredonda + " visualizações aproximadamente. ");
		
		

	}

}
