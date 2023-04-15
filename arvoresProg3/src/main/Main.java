package main;

import arvore.ConstrutorArvore;

public class Main {

	public static void main(String[] args) {
		ConstrutorArvore arvore = new ConstrutorArvore();

		arvore.inserirNo(10);
		arvore.inserirNo(8);
		arvore.inserirNo(9);
		arvore.inserirNo(20);
		arvore.inserirNo(14);
		arvore.inserirNo(3);
		
		
		System.out.println(arvore.getRaiz().getNoEsquerdo());
		
	}

}
