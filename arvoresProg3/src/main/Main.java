package main;

import arvore.ConstrutorArvore;

public class Main {

	public static void main(String[] args) {
		ConstrutorArvore arvore = new ConstrutorArvore();

		arvore.inserirNo(30);
		arvore.inserirNo(20);
		arvore.inserirNo(15);
		arvore.inserirNo(11);
		arvore.inserirNo(1);
		arvore.inserirNo(0);
		
		System.out.println(arvore.getRaiz().getAltura());
		
	}

}
