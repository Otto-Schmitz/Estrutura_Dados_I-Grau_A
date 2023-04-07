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

//	public int tamanho() {
//		if(raiz.noEsquerdo == null && raiz.noDireito == null) {
//			return raiz.altura;
//		}
//		
//		
//		return tamanho(raiz).altura;
//	}
//	
//	private No tamanho(No no) {
//		if(no.noEsquerdo == null  && no.noDireito == null) {
//			return no;
//		}
//		
//		return null;
//	}

	public void inserirNo(int valor, No no) {
		if (!verificaRaizExiste()) {
			raiz = new No(valor);
			no = raiz;
			System.out.println(raiz.numero);
		} else {
			if (valor < no.numero) {
				if (no.noEsquerdo == null) {
					no.noEsquerdo = new No(valor);
					System.out.println(no.noEsquerdo.numero);
				} else {
					inserirNo(valor, no.noEsquerdo);
				}
			} else {
				if (no.noDireito == null) {
					no.noDireito = new No(valor);
				} else {
					inserirNo(valor, no.noDireito);
				}
			}
		}

	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

}
