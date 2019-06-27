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
	
	private String nome;
	private String modelo;
	private String socket;
	private int slotmemo;
	private int slotpci;
	private String saidas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	
	public int getSlotmemo() {
		return slotmemo;
	}
	public void setSlotmemo(int slotmemo) {
		this.slotmemo = slotmemo;
	}
	
	public int getSlotpci() {
		return slotpci;
	}
	public void setSlotpci(int slotpci) {
		this.slotpci = slotpci;
	}
	
	public String getSaidas() {
		return saidas;
	}
	public void setSaidas(String saidas) {
		this.saidas = saidas;
	}
	
	

}
