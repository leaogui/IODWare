package iodware.pcbuild;

public class Gpu {

	
	public Gpu(int clock, String nome, String memory, String modelo, String slot, int ventoinhas, String saidas) {

		this.clock = clock;
		this.nome = nome;
		this.memory = memory;
		this.modelo = modelo;
		this.slot = slot;
		this.ventoinhas = ventoinhas;
		Saidas = saidas;
	}
	
	public int clock;
	public String nome;
	public String memory;
	public String modelo;
	public String slot;
	public int ventoinhas;
	public String Saidas;
	
	
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
	
	
	
}
