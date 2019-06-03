package iodware.pcbuild;

public class Ram {
	
	

	public Ram(String nome, String gen, int clock, int size) {
		this.nome = nome;
		this.gen = gen;
		this.clock = clock;
		this.size = size;
	}
	
	public String nome;
	public String gen;
	public int clock;
	public int size;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	public int getClock() {
		return clock;
	}
	public void setClock(int clock) {
		this.clock = clock;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
