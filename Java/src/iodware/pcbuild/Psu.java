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
	
	
}
