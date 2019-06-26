package iodware.actions;


import iodware.pcbuild.Cpu;
import iodware.pcbuild.Gpu;
import iodware.pcbuild.Mobo;
import iodware.pcbuild.Psu;
import iodware.pcbuild.Ram;

public class Creator {

	
	
	public Ram criarRam(String nomebox) {
		
		String nome = "";
		String gen = "";
		int clock = 0;
		int size = 0;
			
		
		Ram ram = new Ram(nome, gen, clock, size);
		
		return ram;
	}
	
	public Gpu criarGpu(String nomebox) {
		
		int clock = 0;
		String nome = "";
		String memory = "";
		String modelo = "";
		String slot = "";
		int ventoinhas = 0;
		String Saidas = "";
		int pdu = 0;
		
		Gpu gpu = new Gpu(clock, nome, memory, modelo, slot, ventoinhas, Saidas, pdu);
		
		return gpu;
	}
	
	
	public Cpu criarCpu(String nomebox) {
		

		int clock = 0;
		String nome = "";
		int cores = 0;
		String modelo= "";
		String socket= "";
		String gen= "";
		boolean mthread = false;
		int pdu = 0;
		
		
		Cpu cpu = new Cpu(clock, nome, cores, modelo, socket, gen, mthread, pdu);
		
		return cpu;
	}
	
	public Psu criarPsu(String nomebox) {
	
		String nome = "";
		int watts = 0;
		int seisPinos = 0;
		String eightyP = "";
		boolean pfc = false;
		
		
		Psu psu = new Psu(nome, watts, seisPinos, eightyP, pfc);
		
		return psu;
	}
	
	public Mobo criarMobo(String nomebox) {
		
		
		String nome = "";
		String modelo = "";
		String socket = "";
		int slotmemo = 0;
		int slotpci = 0;
		String saidas = "";
		
		Mobo mobo = new Mobo(nome, modelo, socket, slotmemo, slotpci, saidas);
		
		return mobo;
	}
	
	
	
	
}
