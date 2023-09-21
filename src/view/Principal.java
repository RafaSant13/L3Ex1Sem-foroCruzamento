package view;

import java.util.concurrent.Semaphore;

import controller.CruzamentoControle;


public class Principal {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo =  new Semaphore(permissao);
		
		Thread carro1 = new CruzamentoControle(1, "Norte", semaforo);
		Thread carro2 = new CruzamentoControle(2, "Sul", semaforo);
		Thread carro3 = new CruzamentoControle(3, "Leste", semaforo);
		Thread carro4 = new CruzamentoControle(4, "Oeste", semaforo);
		
		carro1.start();
		carro2.start();
		carro3.start();
		carro4.start();
	}

}
