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
			System.out.println(raiz.getNumero());
		} else {
			if (valor < no.getNumero()) {
				if (no.getNoEsquerdo() == null) {
					no.setNoEsquerdo(new No(valor));
					System.out.println(no.getNoEsquerdo().getNumero());
				} else {
					inserirNo(valor, no.getNoEsquerdo());
				}
			} else {
				if (no.getNoDireito() == null) {
					no.setNoDireito(new No(valor));
				} else {
					inserirNo(valor, no.getNoDireito());
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
