package ui;

import java.util.Scanner;

import arvore.ConstrutorArvore;

public class Ui {
	private Scanner sc = new Scanner(System.in);
	private ConstrutorArvore arvore = new ConstrutorArvore();

	public void menu() {
		System.out.println("ARVORE AVL - ESTRUTURAS AVANCADAS DE DADOS I\n");
		System.out.println("0 - Arvore de Demonstracao");
		System.out.println("1 - Inserir");
		System.out.println("2 - Remover");
		System.out.println("3 - Pre-ordem");
		System.out.println("4 - Pos-ordem");
		System.out.println("5 - Em ordem");
		System.out.println("6 - Por nivel");
		System.out.println("7 - Excluir Arvore");
		System.out.println("8 - Mostrar Arvore");
		System.out.println("9 - Verificar Número");
		System.out.println("10 - Sair\n");
		menuAux(trataIntMenu());

	}

	private void menuAux(int escolha) {
		System.out.println();
		switch (escolha) { 
		case 0 -> arvoreDemonstracao();
		case 1 -> arvore.inserir(trataInt());
		case 2 -> arvore.remover(trataInt());
		case 3 -> System.out.println(arvore.preOrdem());
		case 4 -> System.out.println(arvore.posOrdem());
		case 5 -> System.out.println(arvore.emOrdem());
		case 6 -> System.out.println(arvore.porNivel());
		case 7 -> arvore.excluirArvore();
		case 8 -> arvore.mostrarArvore();
		case 9 -> {
			int inteiro = trataInt();
			System.out.println(arvore.verificarNumero(inteiro) ? inteiro + " existe na arvore" : inteiro + " nao existe na arvore");
		}
		case 10 -> System.out.println("Adeus");

		}
		System.out.println();
		if (escolha != 10)
			menu();
	}

	private int trataIntMenu() {
		while (true) {
			try {
				System.out.print("Escolha um item da lista: ");
				String escolhaAux = sc.nextLine();
				int escolha = Integer.parseInt(escolhaAux);
				if (escolha >= 0 && escolha <= 10) {
					return escolha;
				}
			} catch (Exception e) {
				System.out.print("Tente novamente");
			}
		}
	}

	private int trataInt() {
		while (true) {
			try {
				System.out.print("Digite um valor: ");
				String escolhaAux = sc.nextLine();
				int escolha = Integer.parseInt(escolhaAux);
				return escolha;

			} catch (Exception e) {
				System.out.print("Tente novamente");
			}
		}
	}
	
	private void arvoreDemonstracao() {
		arvore.inserir(50);
		arvore.inserir(60);
		arvore.inserir(40);
		arvore.inserir(30);
		arvore.inserir(45);
		arvore.inserir(65);
		arvore.inserir(25);
		arvore.remover(65);
	}
}
