package iodware.actions;

import iodware.pcbuild.Cpu;
import iodware.pcbuild.Gpu;
import iodware.pcbuild.Mobo;
import iodware.pcbuild.Psu;
import iodware.pcbuild.Ram;

public class Creator {

	
	
	public Ram criarRam(String nomebox) {
		
		String nome;
		String gen;
		int clock;
		int size;
			
		
		Ram ram = new Ram(nome, gen, clock, size);
		
		return ram;
	}
	
	public Gpu criarGpu(String nomebox) {
		
		int clock;
		String nome;
		String memory;
		String modelo;
		String slot;
		int ventoinhas;
		String Saidas;
		int pdu;
		
		Gpu gpu = new Gpu(clock, nome, memory, modelo, slot, ventoinhas, Saidas, pdu);
		
		return gpu;
	}
	
	
	public Cpu criarCpu(String nomebox) {
		

		int clock;
		String nome;
		String cores;
		String modelo;
		String socket;
		String gen;
		boolean mthread;
		int pdu;
		
		
		Cpu cpu = new Cpu(clock, nome, cores, modelo, socket, gen, mthread, pdu);
		
		return cpu;
	}
	
	public Psu criarPsu(String nomebox) {
	
		String nome;
		int watts;
		int seisPinos;
		String eightyP;
		boolean pfc;
		
		
		Psu psu = new Psu(nome, watts, seisPinos, eightyP, pfc);
		
		return psu;
	}
	
	public Mobo criarMobo(String nomebox) {
		
		String nome;
		String modelo;
		String socket;
		int slotmemo;
		int slotpci;
		String saidas;
		
		Mobo mobo = new Mobo(nome, modelo, socket, slotmemo, slotpci, saidas);
		
		return mobo;
	}
	
	
	
	
	
	
	
}
