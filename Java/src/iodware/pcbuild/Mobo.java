package iodware.pcbuild;

public class Mobo {
	
	
	public Mobo(String nome, String modelo, String socket, int slotmemo, int slotpci, String saidas) {
		this.nome = nome;
		this.modelo = modelo;
		this.socket = socket;
		this.slotmemo = slotmemo;
		this.slotpci = slotpci;
		this.saidas = saidas;
	}
	
	public String nome;
	public String modelo;
	public String socket;
	public int slotmemo;
	public int slotpci;
	public String saidas;

}
