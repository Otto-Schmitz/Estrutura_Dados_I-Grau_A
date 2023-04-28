package arvoreConstrutor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import arvore.ConstrutorArvore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;	
import org.junit.jupiter.api.BeforeEach;

class ArvoreConstrutorTeste {
	
	private ConstrutorArvore arvore;
	
	@BeforeEach
	void inicial() {
		arvore = new ConstrutorArvore();
	}

	@Test
	@DisplayName("Deve criar uma árvore balanceada corretamente")
	void deveCriarUmaArvore() {
		arvorePequena();
		
		int raizExperada = 30;
		int noEsquerdoExperado = 25;
		int noDireitoExperado = 50;
		int raizAtual = arvore.getRaiz().getNumero();
		int noEsquerdoAtual = arvore.getRaiz().getNoEsquerdo().getNumero();
		int noDireitoAtual = arvore.getRaiz().getNoDireito().getNumero();
		
		assertEquals(raizExperada, raizAtual);
		assertEquals(noEsquerdoExperado, noEsquerdoAtual);
		assertEquals(noEsquerdoExperado, noEsquerdoAtual);
	}
	
	@Test
	@DisplayName("Deve verificar nó pelo número desejado que existe na árvore corretamente")
	void deveVerificarNo() {
		arvoreCompleta();
		
		int numeroExperado = 5;
		int numeroNaoExperado = 1000;
		boolean esperado = arvore.verificarNumero(numeroExperado);
		boolean naoEncontrado = arvore.verificarNumero(numeroNaoExperado);
		
		assertTrue(esperado);
		assertFalse(naoEncontrado);
	}
	
	@Test
	@DisplayName("Deve retornar null ao buscar número não existente na árvore")
	void deveRetornarNullAoBuscarNo() {
		arvoreCompleta();
		int numeroNaoExistenteNaArvore = 38;
		
		boolean esperado = arvore.verificarNumero(numeroNaoExistenteNaArvore);
		
		assertFalse(esperado);
	}
	
	@Test
	@DisplayName("Deve incluir número corretamente")
	void deveIncluirNumero() {
		int primeiroNumeroExperado = 10;
		int segundoNumeroExperado = 5;
		
		arvorePequena();
		arvore.inserir(primeiroNumeroExperado);
		arvore.inserir(segundoNumeroExperado);
		
		boolean primeiroNumeroAtual = arvore.verificarNumero(primeiroNumeroExperado);
		boolean segundoNumeroAtual = arvore.verificarNumero(segundoNumeroExperado);
		
		assertTrue(primeiroNumeroAtual);
		assertTrue(segundoNumeroAtual);
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList com os os números de acordo com o percurso pré-ordem corretamente")
	void deveOrdenarPreOrdem() {
		arvoreCompleta();
		
		ArrayList<Integer> listaExperada = new ArrayList<>();
		listaExperada.add(30);
		listaExperada.add(10);
		listaExperada.add(5);
		listaExperada.add(25);
		listaExperada.add(15);
		listaExperada.add(50);
		listaExperada.add(180);
		ArrayList<Integer> listaAtual = arvore.preOrdem();
		
		assertTrue(listaExperada.equals(listaAtual));
		
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList com os números de acordo com o percurso pré-ordem corretamente")
	void deveOrdenarPosOrdem() {
		arvoreCompleta();
	
		ArrayList<Integer> listaExperada = new ArrayList<>();
		listaExperada.add(5);
		listaExperada.add(15);
		listaExperada.add(25);
		listaExperada.add(10);
		listaExperada.add(180);
		listaExperada.add(50);
		listaExperada.add(30);
		ArrayList<Integer> listaAtual = arvore.posOrdem();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList com os números de acordo com o percurso em ordem corretamente")
	void deveOrdenarEmOrdem() {
		arvoreCompleta();
		
		ArrayList<Integer> listaExperada = new ArrayList<>();
		listaExperada.add(5);
		listaExperada.add(10);
		listaExperada.add(15);
		listaExperada.add(25);
		listaExperada.add(30);
		listaExperada.add(50);
		listaExperada.add(180);
		ArrayList<Integer> listaAtual = arvore.emOrdem();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList com os números de acordo com o percurso por nível corretamente")
	void deveOrdenarPorNivel() {
		arvoreCompleta();
		
		ArrayList<Integer> listaExperada = new ArrayList<>();
		listaExperada.add(30);
		listaExperada.add(10);
		listaExperada.add(50);
		listaExperada.add(5);
		listaExperada.add(25);
		listaExperada.add(180);
		listaExperada.add(15);
		ArrayList<Integer> listaAtual = arvore.porNivel();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList vazio caso a árvore esteja vazia com o percurso pré-ordem")
	void deveRetornarVazioPreOrdem() {
		ArrayList<Integer> listaExperada = new ArrayList<>();
		ArrayList<Integer> listaAtual = arvore.preOrdem();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList vazio caso a árvore esteja vazia com o percurso pós-ordem")
	void deveRetornarVazioPosOrdem() {
		ArrayList<Integer> listaExperada = new ArrayList<>();
		ArrayList<Integer> listaAtual = arvore.posOrdem();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList vazio caso a árvore esteja vazia com o percurso em  ordem")
	void deveRetornarVazioEmOrdem() {
		ArrayList<Integer> listaExperada = new ArrayList<>();
		ArrayList<Integer> listaAtual = arvore.emOrdem();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	@Test
	@DisplayName("Deve retornar um arrayList vazio caso a árvore esteja vazia com o percurso por nível")
	void deveRetornarVazioPorNivel() {
		ArrayList<Integer> listaExperada = new ArrayList<>();
		ArrayList<Integer> listaAtual = arvore.porNivel();
		
		assertTrue(listaExperada.equals(listaAtual));
	}
	
	private void arvorePequena() {
		arvore.inserir(50);
		arvore.inserir(25);
		arvore.inserir(30);
	}
	
	private void arvoreCompleta() {
		arvore.inserir(50);
		arvore.inserir(25);
		arvore.inserir(30);
		arvore.inserir(180);
		arvore.inserir(10);
		arvore.inserir(5);
		arvore.inserir(15);
	}

}
