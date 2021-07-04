package model.bean;

public class Anuncio {
	
	private String nomeAnuncio;
    private String dataInicioAnuncio;
    private String dataTerminoAnuncio;
    private String investimentoDiaAnuncio;
    
    
	public Anuncio() {
		//super();
	}
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}
	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}
	public String getDataInicioAnuncio() {
		return dataInicioAnuncio;
	}
	public void setDataInicioAnuncio(String dataInicioAnuncio) {
		this.dataInicioAnuncio = dataInicioAnuncio;
	}
	public String getDataTerminoAnuncio() {
		return dataTerminoAnuncio;
	}
	public void setDataTerminoAnuncio(String dataTerminoAnuncio) {
		this.dataTerminoAnuncio = dataTerminoAnuncio;
	}
	public String getInvestimentoDiaAnuncio() {
		return investimentoDiaAnuncio;
	}
	public void setInvestimentoDiaAnuncio(String investimentoDiaAnuncio) {
		this.investimentoDiaAnuncio = investimentoDiaAnuncio;
	}
    
    
	

}
