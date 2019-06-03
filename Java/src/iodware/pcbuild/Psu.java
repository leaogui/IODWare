package iodware.pcbuild;

public class Psu {
	
	
	
	public Psu(String nome, int watts, int seisPinos, String eightyP, boolean pfc) {

		this.nome = nome;
		this.watts = watts;
		this.seisPinos = seisPinos;
		this.eightyP = eightyP;
		this.pfc = pfc;
	}
	
	public String nome;
	public int watts;
	public int seisPinos;
	public String eightyP;
	public boolean pfc;
	
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
	
	public boolean isPfc() {
		return pfc;
	}
	public void setPfc(boolean pfc) {
		this.pfc = pfc;
	}
	
	
}
