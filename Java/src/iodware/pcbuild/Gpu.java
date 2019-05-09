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
	
}
