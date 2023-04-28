# Implementação de árvore AVL

## Estruturas Avançadas de Dados I - Grau A
```
Integrantes:

Arthur Palma,
Caua Festa,
Otto Schmitz,
Thomaz Justo.
```

## Recursos

### 0 - Árvore de Demonstração:

Uma árvore pré-definida será criada. Caso já exista uma árvore, a anterior será <b>EXCLUÍDA</b>.

```
	Árvore pré-definida:

	[RAIZ]---[40]
		[ESQ]---[30]
			[ESQ]---[25]
		[DIR]---[50]
			[ESQ]---[45]
			[DIR]---[60]
```

### 1 - Inserir:

Insira números na árvore AVL. Após informar algum número <b>VÁLIDO</b> na árvore, o número será adicionado e a árvore se balanceará automaticamente caso seja necessário. Caso seja a primeira inserção e não exista raíz, o número inserido será a raíz.

### 2 - Remover:

Revmova números da árvore AVL. Após informar algum número <b>VÁLIDO</b>, caso seja encontrado, ele será removido da árvore e a mesma se balanceará automaticamente caso seja necessário.

### 3 - Percurso Pré-Ordem:

Ao selecionar a opção de percurso pré-ordem, os números da árvore serão retornados na sequência desejada.

```
	Percurso Pré-Ordem da Árvore de Demonstração:

	[40, 30, 25, 50, 45, 60]
```

### 4 - Percurso Pós-Ordem:

Ao selecionar a opção de percurso pós-ordem, os números da árvore serão retornados na sequência desejada.

```
	Percurso Pós-Ordem da Árvore de Demonstração:

	[25, 30, 45, 60, 50, 40]
```

### 5 - Percurso Em Ordem:

Ao selecionar a opção de percurso em ordem, os números da árvore serão retornados na sequência desejada.

```
	Percurso Em Ordem da Árvore de Demonstração:

	[25, 30, 40, 45, 50, 60]
```

### 6 - Percurso Por Nível:

Ao selecionar a opção de percurso por nível, os números da árvore serão retornados na sequência desejada.

```
	Percurso Por Nível da Árvore de Demonstração:

	[40, 30, 50, 25, 45, 60]
```

### 7 - Excluir Árvore:

Ao excluír a árvore AVL, a raiz atual será <b>APAGADA</b> e todas as informações serão <b>EXCLUÍDAS</b> e <b>NÃO</b> poderão ser recuperadas posteriormente.

### 8 - Mostrar Árvore:

A árvore AVL atual será exibida de forma gráfica na tela. Caso não exista raíz, uma mensagem de aviso será exibida.

```
	Árvore AVL:

	[RAIZ]---[40]
		[ESQ]---[30]
			[ESQ]---[25]
		[DIR]---[50]
			[ESQ]---[45]
			[DIR]---[60]
```

### 9 - Verificar Número:

Retorna <b>TRUE</b> caso o número esteja presente na árvore AVL e <b>FALSE</b> caso não esteja presente.
