package iodware.pcbuild;

public class Cpu {
	
	
	public Cpu(int clock, String nome, int cores, String modelo, String socket, String gen, boolean mthread, int tdp) {

		this.clock = clock;
		this.nome = nome;
		this.cores = cores;
		this.modelo = modelo;
		this.socket = socket;
		this.gen = gen;
		this.mthread = mthread;
		this.tdp = tdp;
	}
	
	public int clock;
	public String nome;
	public int cores;
	public String modelo;
	public String socket;
	public String gen;
	public boolean mthread;
	public int tdp;
	
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
	
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
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
	
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	public boolean isMthread() {
		return mthread;
	}
	public void setMthread(boolean mthread) {
		this.mthread = mthread;
	} 
	
	public void setTdp(int tdp) {
		this.tdp = tdp;
	}
	
	public int getTdp() {
		return this.tdp;
	}
	
	
}
