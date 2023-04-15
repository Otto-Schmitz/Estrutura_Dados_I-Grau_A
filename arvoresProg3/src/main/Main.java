package main;

import arvore.ConstrutorArvore;

public class Main {

	public static void main(String[] args) {
		ConstrutorArvore arvore = new ConstrutorArvore();

		arvore.inserir(20);
		arvore.inserir(10);
		arvore.inserir(30);
		arvore.inserir(35);
		arvore.remover(10);
		
		System.out.println(arvore.raiz.getNumero());
		System.out.println(arvore.raiz.getNoEsquerdo());
	}

}
