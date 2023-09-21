package controller;

import java.util.concurrent.Semaphore;

public class CruzamentoControle extends Thread{
	
	public int carroId;
	public String sentido;
	public Semaphore semaforo;

	public CruzamentoControle(int carroId, String sentido, Semaphore semaforo) {
		this.carroId = carroId;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void cruzamento() {
		String novoSentido;
		switch(sentido) {
		case "Norte":
			novoSentido = "Sul";
			System.out.println("Carro #"+carroId+" vindo do sentido "+sentido+" passou para "+novoSentido);
			break;
		case "Sul":
			novoSentido = "Norte";
			System.out.println("Carro #"+carroId+" vindo do sentido "+sentido+" passou para "+novoSentido);
			break;
		case "Leste":
			novoSentido = "Oeste";
			System.out.println("Carro #"+carroId+" vindo do sentido "+sentido+" passou para "+novoSentido);
			break;
		case "Oeste":
			novoSentido = "Leste";
			System.out.println("Carro #"+carroId+" vindo do sentido "+sentido+" passou para "+novoSentido);
			break;
		}
	}

}
