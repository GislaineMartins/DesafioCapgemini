package model.bean;


public class Calculadora {
	
	 private static final int NUMEROPESSOAS = 30;
	 
	 public int calculaVisualizacao(double valor) {
		 int pessoasVisualizacao = (int) Math.floor(valor * NUMEROPESSOAS);
		 return pessoasVisualizacao;
	 }
	 
	 public int calculaCliques(int pessoasVisualizacao) {
		 int quantidadeCliques = (int) Math.floor((pessoasVisualizacao * 12)/ 100);
	     return quantidadeCliques;
	 }
	 
	 public int calculaCompartilhado(int quantidadeCliques) {
		 int quantidadeCompartilhado = (int) Math.floor((quantidadeCliques * 3) / 20);
		 return quantidadeCompartilhado;
	 }
	 
	 public int calculaVisualizacao(int quantidadeCompartilhado, int pessoasVisualizacao) {
		 pessoasVisualizacao += Math.floor(quantidadeCompartilhado * 40);
		 return pessoasVisualizacao;		 
	 }
	 
	 public int calculoTotalVizualizacao(int pessoasVisualizacao) {
		 int totalVisualizacao = (int) Math.pow(pessoasVisualizacao, 4);
		 return totalVisualizacao;
	 }
	 
	 

}
