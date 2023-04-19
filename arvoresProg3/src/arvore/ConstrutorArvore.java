package arvore;

import java.util.ArrayList;

public class ConstrutorArvore {

	private No raiz;

	public ConstrutorArvore() {
		raiz = null;
	}
	
	private int getAltura(No no) {
		if (no == null) {
			return 0;
		}
		return no.getAltura();
	}
	
	private int calcularBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return getAltura(no.getNoEsquerdo()) - getAltura(no.getNoDireito());
    }
	
	private No rotacionarDireita(No noAtual) {
        No noNovo = noAtual.getNoEsquerdo();
        No subArvore = noNovo.getNoDireito();

        // Realiza a rotação
        noAtual.setNoEsquerdo(noNovo.getNoDireito());
        noNovo.setNoDireito(noAtual);

        // Atualiza as alturas
        noAtual.setAltura(Math.max(getAltura(noAtual.getNoEsquerdo()), getAltura(noAtual.getNoDireito())) + 1);
        noNovo.setAltura(Math.max(getAltura(noNovo.getNoEsquerdo()), getAltura(noNovo.getNoDireito())) + 1);

        return noNovo;
    }
	
	private No rotacionarEsquerda(No noAtual) {
        No noNovo = noAtual.getNoDireito();
        No subArvore = noNovo.getNoEsquerdo();

        // Realiza a rotação

		noAtual.setNoDireito(noNovo.getNoEsquerdo());
		noNovo.setNoEsquerdo(noAtual);
        // Atualiza as alturas
        noAtual.setAltura(Math.max(getAltura(noAtual.getNoEsquerdo()), getAltura(noAtual.getNoDireito())) + 1);
        noNovo.setAltura(Math.max(getAltura(noNovo.getNoEsquerdo()), getAltura(noNovo.getNoDireito())) + 1);

        return noNovo;
    }
	
	public void inserir(int valor) {
        this.raiz = inserirAux(this.raiz, valor);
    }
	
	private No inserirAux(No no, int valor) {
		if(no == null) {
			return new No(valor);
		}
		
		if (valor < no.getNumero()) {
			no.setNoEsquerdo(inserirAux(no.getNoEsquerdo(), valor));
		}
		else if (valor > no.getNumero()) {
			no.setNoDireito(inserirAux(no.getNoDireito(), valor));
		}
		else {
			return no;
		}
		
        // Atualiza a altura do nó atual
        no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

        // Verifica o balanceamento do nó atual e realiza rotações se necessário
        int balanceamento = calcularBalanceamento(no);
        if (balanceamento > 1) {
            if (valor < no.getNoEsquerdo().getNumero()) {
                return rotacionarDireita(no);
            } else {
                no.setNoEsquerdo(rotacionarEsquerda(no.getNoEsquerdo()));
                return rotacionarDireita(no);
            }
        }

        if (balanceamento < -1) {
            if (valor > no.getNoDireito().getNumero()) {
                return rotacionarEsquerda(no);
            } else {
                no.setNoDireito(rotacionarDireita(no.getNoDireito()));
                return rotacionarEsquerda(no);
            }
        }

        return no;
		
	}
	
	public void remover(int valor) {
        this.raiz = removerAux(this.raiz, valor);
    }
	
	private No removerAux(No no, int valor) {
	    if (no == null) {
	        return no; // Valor não encontrado na árvore
	    }

	    if (valor < no.getNumero()) {
	        no.setNoEsquerdo(removerAux(no.getNoEsquerdo(), valor));
	    } else if (valor > no.getNumero()) {
	        no.setNoDireito(removerAux(no.getNoDireito(), valor));;
	    } else {
	        // Valor encontrado, realiza a remoção
	        if (no.getNoEsquerdo() == null || no.getNoDireito() == null) {
	            No filho = (no.getNoEsquerdo() != null) ? no.getNoEsquerdo() : no.getNoDireito();

	            if (filho == null) {
	                // Nó folha, simplesmente remove
	                no = null;
	            } else {
	                // Nó com um único filho, substitui pelo filho
	                no = filho;
	            }
	        } else {
	            // Nó com dois filhos, encontra o sucessor in-order
	            no.setNumero(encontrarMinimo(no.getNoDireito()));

	            // Remove o sucessor in-order do subárvore direita
	            no.setNoDireito(removerAux(no.getNoDireito(), no.getNumero()));
	        }
	    }

	    if (no == null) {
	        return no;
	    }

	    // Atualiza a altura do nó atual
	    no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

	    // Verifica o balanceamento do nó atual e realiza rotações se necessário
	    int balanceamento = calcularBalanceamento(no);

	    if (balanceamento > 1) {
	        int balanceamentoEsquerdo = calcularBalanceamento(no.getNoEsquerdo());

	        if (balanceamentoEsquerdo >= 0) {
	            return rotacionarDireita(no);
	        } else {
	            no.setNoEsquerdo(rotacionarEsquerda(no.getNoEsquerdo()));
	            return rotacionarDireita(no);
	        }
	    }

	    if (balanceamento < -1) {
	        int balanceamentoDireito = calcularBalanceamento(no.getNoDireito());

	        if (balanceamentoDireito <= 0) {
	            return rotacionarEsquerda(no);
	        } else {
	            no.setNoDireito(rotacionarDireita(no.getNoDireito()));
	            return rotacionarEsquerda(no);
	        }
	    }

	    return no;
	}

	private int encontrarMinimo(No no) {
	    int minimo = no.getNumero();
	    while (no.getNoEsquerdo() != null) {
	        minimo = no.getNoEsquerdo().getNumero();
	        no = no.getNoEsquerdo();
	    }
	    return minimo;
	}
	
	public No buscarNumero(int numero) {
		return buscarNumeroAux(numero, this.raiz);
	}
	
	private No buscarNumeroAux(int numero, No no) {
		if(no == null) {
			return no;
		}
		
		if(numero < no.getNumero()) {
			no = buscarNumeroAux(numero, no.getNoEsquerdo());
		}
		else if(numero > no.getNumero()) {
			no = buscarNumeroAux(numero, no.getNoEsquerdo());
		}
		else if(numero != no.getNumero()) {
			no = this.raiz;
		}
		return no;
	}
	
	public ArrayList<Integer> posOrdem() {
		return posOrdemAux(this.raiz, new ArrayList<>());
	}
	
	private ArrayList<Integer> posOrdemAux(No no, ArrayList<Integer> ordem) {
		if(no != null) {
			ordem = posOrdemAux(no.getNoEsquerdo(), ordem);
			ordem = posOrdemAux(no.getNoDireito(), ordem);
			ordem.add(no.getNumero());
		}
		return ordem;
	}

	public No getRaiz() {
		return raiz;
	}
	
}