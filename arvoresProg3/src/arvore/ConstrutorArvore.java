package arvore;

public class ConstrutorArvore {

	private No raiz;

	public ConstrutorArvore() {
		raiz = null;
	}

	public boolean verificaRaizExiste() {
		return !(raiz == null);
	}

	public void limpaArvore() {
		raiz = null;
	}

	private int getAltura(No no) {
		return no == null ? -1 : no.getAltura();
	}

	private int getAlturaMaxima(int alturaEsquerda, int alturaDireita) {
		return alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;
	}
	
	private No rotacionarDireita(No noAtual) {
		No noNovo = noAtual.getNoEsquerdo();
		noAtual.setNoEsquerdo(noNovo.getNoDireito());
		noNovo.setNoDireito(noAtual);
		
		noAtual.setAltura(getAlturaMaxima(getAltura(noAtual.getNoEsquerdo()), getAltura(noAtual.getNoDireito())) + 1);
		noNovo.setAltura(getAlturaMaxima(getAltura(noNovo.getNoEsquerdo()), noAtual.getAltura()) + 1);
		
		return noNovo;
	}
	
	private No rotacionarDuasVezesDireita(No noAtual) {

		
		
		
		return null;
	}

	public No inserirNo(int valor, No no) {
		if (no == null) {
			no = new No(valor);
		} else if (valor < no.getNumero()) {
			no.setNoEsquerdo(inserirNo(valor, no.getNoEsquerdo()));
			if (getAltura(no.getNoEsquerdo()) - getAltura(no.getNoDireito()) == 2) {				
				if (valor < no.getNoEsquerdo().getNumero())
					no = rotacionarDireita(no);
				else 
					no = rotacionarDuasVezesDireita(no);
					
			}
		} else if (valor > no.getNumero()) {
			no.setNoDireito(inserirNo(valor, no.getNoDireito()));;
		}

		no.setAltura(getAlturaMaxima(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())) + 1);

		return no;
	}
	
	public void inserirNo(int valor) {
		raiz = inserirNo(valor, raiz);
	}

	public No getRaiz() {
		
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

}
