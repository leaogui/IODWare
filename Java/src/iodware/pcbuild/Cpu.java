package iodware.pcbuild;

public class Cpu {
	
	
	public Cpu(int clock, String nome, String cores, String modelo, String socket, String gen, boolean mthread) {

		this.clock = clock;
		this.nome = nome;
		this.cores = cores;
		this.modelo = modelo;
		this.socket = socket;
		this.gen = gen;
		this.mthread = mthread;
	}
	
	public int clock;
	public String nome;
	public String cores;
	public String modelo;
	public String socket;
	public String gen;
	public boolean mthread; 
	
}
