package arvore;

public class No {
	
	private int numero;
	private int altura;
	private No noEsquerdo;
	private No noDireito;
	
	public No() {}
	
	public No(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public No getNoEsquerdo() {
		return noEsquerdo;
	}

	public void setNoEsquerdo(No noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}

	public No getNoDireito() {
		return noDireito;
	}

	public void setNoDireito(No noDireito) {
		this.noDireito = noDireito;
	}
	
	
}
