package ui;

import java.util.Scanner;

import arvore.ConstrutorArvore;

public class Ui {
	private Scanner sc = new Scanner(System.in);
	private ConstrutorArvore arvore = new ConstrutorArvore();

	public void menu() {
		System.out.println("1 - Inserir");
		System.out.println("2 - Remover");
		System.out.println("3 - Pré-ordem");
		System.out.println("4 - Pós-ordem");
		System.out.println("5 - Em ordem");
		System.out.println("6 - Por nível");
		System.out.println("7 - Excluir árvore");
		System.out.println("8 - Sair");
		menuAux(trataIntMenu());

	}

	public void menuAux(int escolha) {
		System.out.println();
		switch (escolha) {
		case 1 -> arvore.inserir(trataInt());
		case 2 -> arvore.remover(trataInt());
		case 3 -> System.out.println(arvore.preOrdem());
		case 4 -> System.out.println(arvore.posOrdem());
		case 5 -> System.out.println(arvore.emOrdem());
		case 6 -> System.out.println(arvore.porNivel());
		case 7 -> arvore.excluirArvore();
		case 8 -> System.out.println("Adeus");

		}
		System.out.println();
		if (escolha != 9)
			menu();
	}

	public int trataIntMenu() {
		while (true) {
			try {
				System.out.print("Escolha um item da lista: ");
				String escolhaAux = sc.nextLine();
				int escolha = Integer.parseInt(escolhaAux);
				if (escolha >= 1 && escolha <= 9) {
					return escolha;
				}
			} catch (Exception e) {
				System.out.print("");
			}
		}
	}

	public int trataInt() {
		while (true) {
			try {
				System.out.print("Digite um valor: ");
				String escolhaAux = sc.nextLine();
				int escolha = Integer.parseInt(escolhaAux);
				return escolha;

			} catch (Exception e) {
				System.out.print("");
			}
		}
	}
}
