package arvoreConstrutor;

import static org.junit.jupiter.api.Assertions.*;

import arvore.ConstrutorArvore;
import arvore.No;

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
		arvore.inserir(50);
		arvore.inserir(25);
		arvore.inserir(30);
		
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
	@DisplayName("Deve buscar nó pelo número desejado que existe na árvore corretamente")
	void deveBuscarNo() {
		arvoreCompleta();
		
		int numeroExperado = 5;
		int noAtual = arvore.buscarNumero(numeroExperado).getNumero();
		
		assertEquals(noAtual, noAtual);
	}
	
	@Test
	@DisplayName("Deve retornar null ao buscar número não existente na árvore")
	void deveRetornarNullAoBuscarNo() {
		arvoreCompleta();
		int numeroNaoExistenteNaArvore = 38;
		
		assertNull(arvore.buscarNumero(numeroNaoExistenteNaArvore));
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
