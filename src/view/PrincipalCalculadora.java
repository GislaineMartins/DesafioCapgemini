package view;

import javax.swing.JOptionPane;
import model.bean.Calculadora;
import model.bean.Relatorio;
import model.dao.RelatorioDAO;


public class PrincipalCalculadora {
	
	public static void main(String[] args) {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser investido."));
		

        /**
         * Calcula os dados do relatorio. Os calculos são apresentados na classe calculadora
         *
         * @return
         */
        Calculadora calc = new Calculadora();
        int resultado = calc.calculaVisualizacao(valor);
        int resultado2 = calc.calculaCliques(resultado);
        int resultado3 = calc.calculaCompartilhado(resultado2);
        int resultado4 = calc.calculaVisualizacao(resultado3, resultado);
        int resultado5 = calc.calculoTotalVizualizacao(resultado4);

        /**
         * Cadastrando as informações do calculos dentro da tabela relatorio do banco de dados
         *
         * @return
         */
       
        Relatorio relatorio = new Relatorio();
        RelatorioDAO relatorioDao = new RelatorioDAO();
        relatorio.setMaximaVisualizacaoRelatorio(resultado4);
        relatorio.setMaximaCliquesRelatorio(resultado2);
        relatorio.setMaximaCompartilhamentoRelatorio(resultado3);
        relatorio.setValorTotalInvestidoRelatorio(resultado);
        relatorioDao.create(relatorio);
		
        
        
        
	    
		 
	}
	

}
