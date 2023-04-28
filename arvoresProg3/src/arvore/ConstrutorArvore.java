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

        noAtual.setNoEsquerdo(noNovo.getNoDireito());
        noNovo.setNoDireito(noAtual);

        noAtual.setAltura(Math.max(getAltura(noAtual.getNoEsquerdo()), getAltura(noAtual.getNoDireito())) + 1);
        noNovo.setAltura(Math.max(getAltura(noNovo.getNoEsquerdo()), getAltura(noNovo.getNoDireito())) + 1);

        return noNovo;
    }
	
	private No rotacionarEsquerda(No noAtual) {
        No noNovo = noAtual.getNoDireito();

		noAtual.setNoDireito(noNovo.getNoEsquerdo());
		noNovo.setNoEsquerdo(noAtual);

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
		
        no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

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
	        return no;
	    }

	    if (valor < no.getNumero()) {
	        no.setNoEsquerdo(removerAux(no.getNoEsquerdo(), valor));
	    } else if (valor > no.getNumero()) {
	        no.setNoDireito(removerAux(no.getNoDireito(), valor));;
	    } else {
	        if (no.getNoEsquerdo() == null || no.getNoDireito() == null) {
	            No filho = (no.getNoEsquerdo() != null) ? no.getNoEsquerdo() : no.getNoDireito();

	            if (filho == null) {
	                no = null;
	            } else {
	                no = filho;
	            }
	        } else {
	            no.setNumero(encontrarMinimo(no.getNoDireito()));

	            no.setNoDireito(removerAux(no.getNoDireito(), no.getNumero()));
	        }
	    }

	    if (no == null) {
	        return no;
	    }

	    no.setAltura(1 + Math.max(getAltura(no.getNoEsquerdo()), getAltura(no.getNoDireito())));

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
	    if(no.getNoEsquerdo() != null) {
	    	return encontrarMinimo(no.getNoEsquerdo());
	    }
	    return no.getNumero();
	}
	
	public boolean verificarNumero(int numero) {
		return verificarNumeroAux(numero, this.raiz) != null;
	}
	
	private No verificarNumeroAux(int numero, No no) {
		if(no == null) {
			return no;
		}
		
		if(numero < no.getNumero()) {
			no = verificarNumeroAux(numero, no.getNoEsquerdo());
		}
		else if(numero > no.getNumero()) {
			no = verificarNumeroAux(numero, no.getNoDireito());
		}
		else if(numero != no.getNumero()) {
			no = this.raiz;
		}
		return no;
	}
	
	public ArrayList<Integer> preOrdem() {
		return preOrdemAux(this.raiz, new ArrayList<>());
	}
	
	private ArrayList<Integer> preOrdemAux(No no, ArrayList<Integer> ordem) {
		if(no != null) {
			ordem.add(no.getNumero());
			ordem = preOrdemAux(no.getNoEsquerdo(), ordem);
			ordem = preOrdemAux(no.getNoDireito(), ordem);
		}
		return ordem;
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
	
	public ArrayList<Integer> emOrdem() {
		return emOrdemAux(this.raiz, new ArrayList<>());
	}
	
	private ArrayList<Integer> emOrdemAux(No no, ArrayList<Integer> ordem) {
		if(no != null) {
			ordem = emOrdemAux(no.getNoEsquerdo(), ordem);
			ordem.add(no.getNumero());
			ordem = emOrdemAux(no.getNoDireito(), ordem);
		}
		return ordem;
	} 
	
	public ArrayList<Integer> porNivel() {
		ArrayList<Integer> ordem = new ArrayList<>();
		for(int i = 0; i <= getAltura(this.raiz); i++) {
			ordem = porNivelAux(this.raiz, ordem, i);
		}
		return ordem;
	}
	
	private ArrayList<Integer> porNivelAux(No no, ArrayList<Integer> ordem, int nivel) {
		if(no != null) {
			if(nivel == 1) {
				ordem.add(no.getNumero());
			}
			else if(nivel > 1) {
				ordem = porNivelAux(no.getNoEsquerdo(), ordem, nivel - 1);
				ordem = porNivelAux(no.getNoDireito(), ordem, nivel - 1);
			}
		}
		return ordem;
	}
	
	public void mostrarArvore() {
		if(raiz == null) {
			System.out.println("Raiz nula");
			return;
		}
		int tab = 1;
		System.out.println("[RAIZ]---"+raiz.toString());
		mostrarSubArvore(raiz.getNoEsquerdo(), tab, "ESQ");
		mostrarSubArvore(raiz.getNoDireito(), tab, "DIR");
	}
	
	private void mostrarSubArvore(No no, int tab, String lado) {
		if (no != null) {
			
			String txt = "";
			for(int i = 0; i < tab; i++) 
				txt += "\t";
			
			System.out.println(txt + "[" + lado + "]" + "---" + no.toString());
			mostrarSubArvore(no.getNoEsquerdo(),tab + 1,"ESQ");
			mostrarSubArvore(no.getNoDireito(),tab + 1,"DIR");
		}
	}

	
	public void excluirArvore() {
		this.raiz = null;
	}
	
	public No getRaiz() {
		return raiz;
	}
	
}