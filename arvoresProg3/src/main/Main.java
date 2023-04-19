package main;

import arvore.ConstrutorArvore;

public class Main {

	public static void main(String[] args) {
		ConstrutorArvore arvore = new ConstrutorArvore();
		
//		arvore.inserir(50);
//		arvore.inserir(60);
//		arvore.inserir(40);
//		arvore.inserir(30);
//		arvore.inserir(45);
//		arvore.inserir(65);
//		arvore.inserir(25);
//		arvore.remover(65);
		
//		System.out.println(arvore.raiz.getNumero());
//		System.out.println(arvore.raiz.getNoDireito());
//		System.out.println(arvore.raiz.getNoEsquerdo());
//		System.out.println(arvore.raiz.getNoEsquerdo().getNoEsquerdo());
//		System.out.println(arvore.raiz.getNoDireito().getNoDireito());
//		System.out.println(arvore.raiz.getNoDireito().getNoEsquerdo());
		
//		System.out.println(arvore.buscarNumero(30));
		
		arvore.inserir(50);
		arvore.inserir(25);
		arvore.inserir(30);
		arvore.inserir(10);
		arvore.inserir(5);
		
		System.out.println(arvore.getRaiz().getNoEsquerdo());

	}

}
