package iodware.pcbuild;

public class Gpu {

	
	public Gpu(int clock, String nome, String memory, String modelo, String slot, int ventoinhas, String saidas, int tdp) {

		this.clock = clock;
		this.nome = nome;
		this.memory = memory;
		this.modelo = modelo;
		this.slot = slot;
		this.ventoinhas = ventoinhas;
		this.Saidas = saidas;
		this.tdp = tdp;
	}
	
	private int clock;
	private String nome;
	private String memory;
	private String modelo;
	private String slot;
	private int ventoinhas;
	private String Saidas;
	private int tdp;
	
	
	public int getClock() {
		return clock;
	}
	public void setClock(int clock) {
		this.clock = clock;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	public int getVentoinhas() {
		return ventoinhas;
	}
	public void setVentoinhas(int ventoinhas) {
		this.ventoinhas = ventoinhas;
	}
	
	public String getSaidas() {
		return Saidas;
	}
	public void setSaidas(String saidas) {
		Saidas = saidas;
	}
	
	public void setTdp(int tdp) {
		this.tdp = tdp;
	}
	
	public int getTdp() {
		return this.tdp;
	}
	
	
}
