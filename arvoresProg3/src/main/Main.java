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
//
		arvore.inserir(50);
		arvore.inserir(60);
		arvore.inserir(40);
		arvore.inserir(30);
		arvore.inserir(45);
		arvore.inserir(65);
		arvore.inserir(25);
		arvore.inserir(12);
		arvore.inserir(22);
		arvore.inserir(63);
		arvore.inserir(21);
		arvore.inserir(69);
		
//		System.out.println(arvore.raiz.getNumero());
//		System.out.println(arvore.raiz.getNoDireito());
//		System.out.println(arvore.raiz.getNoEsquerdo());
//		System.out.println(arvore.raiz.getNoEsquerdo().getNoEsquerdo());
//		System.out.println(arvore.raiz.getNoDireito().getNoDireito());
//		System.out.println(arvore.raiz.getNoDireito().getNoEsquerdo());
//		
//		System.out.println(arvore.buscarNumero(65));
//		
//		arvore.inserir(50);
//		arvore.inserir(25);
//		arvore.inserir(30);
//		arvore.inserir(10);
//		arvore.inserir(5);
		
//		arvore.inserir(1);
//		arvore.inserir(2);
//		arvore.inserir(3);
//		arvore.inserir(4);
//		arvore.inserir(6);
//		arvore.inserir(7);
//		arvore.inserir(5);
		
//		System.out.println(arvore.preOrdem());
//		System.out.println(arvore.posOrdem());
//		System.out.println(arvore.emOrdem());
//		System.out.println(arvore.porNivel());
		
		arvore.mostrarArvore();

	}

}
