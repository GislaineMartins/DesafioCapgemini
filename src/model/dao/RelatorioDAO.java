package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Relatorio;


public class RelatorioDAO {
	
	public void create(Relatorio relatorio) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO relatorio (maximoVisualizacaoRelatorio, maximoCliquesRelatorio, maximoCompartilhamentoRelatorio, valorTotoalInvestidoRelatorio)\r\n"
            		+ "VALUES(?,?,?,?);\r\n"
            		+ "");
            		

            stmt.setInt(1, relatorio.getMaximaVisualizacaoRelatorio());
            stmt.setInt(2, relatorio.getMaximaCliquesRelatorio());
            stmt.setInt(3, relatorio.getMaximaCompartilhamentoRelatorio());
            stmt.setInt(4, relatorio.getValorTotalInvestidoRelatorio());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo Relatorio com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar relatorio: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Chamando Relatorio do banco
     *
     * @return
     */
    public List<Relatorio> read() {

        Connection con = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Relatorio> mostrarRelatorio = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM Relatorio");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Relatorio relatorioDoBanco = new Relatorio();

                relatorioDoBanco.setMaximaVisualizacaoRelatorio(rs.getInt("maximaVisualizacaoRelatorio"));
                relatorioDoBanco.setMaximaCliquesRelatorio(rs.getInt("maximaCliquesRelatorio"));
                relatorioDoBanco.setMaximaCompartilhamentoRelatorio(rs.getInt("maximaCompartilhamentoRelatorio"));
                relatorioDoBanco.setValorTotalInvestidoRelatorio(rs.getInt("valorTotalInvestidoRelatorio"));
                relatorioDoBanco.setAnuncioIdAnuncio(rs.getInt("anuncioIdAnuncio"));
                mostrarRelatorio.add(relatorioDoBanco);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mostrarRelatorio;

    }
	
	
}
