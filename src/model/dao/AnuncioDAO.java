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
import model.bean.Anuncio;

public class AnuncioDAO {
	 public void create(Anuncio edc) {

	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement("INSERT INTO Anuncio (nomeAnuncio, dataInicioAnuncio, dataTerminoAnuncio, investimentoDiaAnuncio)VALUES(?, ?, ?, ?)");

	            stmt.setString(1, edc.getNomeAnuncio());
	            stmt.setString(2, edc.getDataInicioAnuncio());
	            stmt.setString(3, edc.getDataTerminoAnuncio());
	            stmt.setString(4, edc.getInvestimentoDiaAnuncio());

	            stmt.executeUpdate();

	            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt);
	        }
	    }

	    /**
	     * Chamando Anuncio do banco
	     *
	     * @return
	     */
	    public List<Anuncio> read() {

	        Connection con = null;

	        PreparedStatement stmt = null;

	        ResultSet rs = null;

	        List<Anuncio> mostrarAnuncio = new ArrayList<>();

	        try {
	            con = ConnectionFactory.getConnection();
	            stmt = con.prepareStatement("SELECT * FROM Anuncio");
	            rs = stmt.executeQuery();

	            while (rs.next()) {

	                Anuncio anuncioDoBanco = new Anuncio();

	                anuncioDoBanco.setNomeAnuncio(rs.getString("nomeAnuncio"));
	                anuncioDoBanco.setDataInicioAnuncio(rs.getString("dataInicioAnuncio"));
	                anuncioDoBanco.setDataTerminoAnuncio(rs.getString("dataTerminoAnuncio"));
	                anuncioDoBanco.setInvestimentoDiaAnuncio(rs.getString("investimentoDiaAnuncio"));
	                mostrarAnuncio.add(anuncioDoBanco);

	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }

	        return mostrarAnuncio;

	    }

}
