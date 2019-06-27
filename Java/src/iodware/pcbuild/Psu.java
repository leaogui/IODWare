package iodware.pcbuild;

public class Psu {
	
	
	
	public Psu(String nome, int watts, int seisPinos, String eightyP, boolean pfc) {

		this.nome = nome;
		this.watts = watts;
		this.seisPinos = seisPinos;
		this.eightyP = eightyP;
		this.pfc = pfc;
	}
	
	private String nome;
	private int watts;
	private int seisPinos;
	private String eightyP;
	private boolean pfc;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getWatts() {
		return watts;
	}
	public void setWatts(int watts) {
		this.watts = watts;
	}
	
	public int getSeisPinos() {
		return seisPinos;
	}
	public void setSeisPinos(int seisPinos) {
		this.seisPinos = seisPinos;
	}
	
	public String getEightyP() {
		return eightyP;
	}
	public void setEightyP(String eightyP) {
		this.eightyP = eightyP;
	}
	
	public boolean getPfc() {
		return pfc;
	}
	public void setPfc(boolean pfc) {
		this.pfc = pfc;
	}
	
	
}
