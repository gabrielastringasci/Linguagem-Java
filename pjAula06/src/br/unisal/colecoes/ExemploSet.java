package br.unisal.colecoes;

import java.util.Collection;
import java.util.HashSet;

public class ExemploSet {
	public static void main (String[] args) {
		Collection c = new HashSet(); //Treeset = ordem alfabetica
		
		Produto produto = new Produto (1234, "Sab�o");
		Produto produtoA = new Produto (4561, "ProdutoA");
	
		c.add(produto);
		c.add(produtoA);
		
		System.out.println(c);
		
	}
}
