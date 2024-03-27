package pjAula07;

import java.util.ArrayList;
import java.util.List;

/**
 * Exemplo de Implementação de Estrutura de Dados List
 * @author Gabriela Stringasci
 * 26/03/2024
 */
public class TesteList {
	public static void main (String[] args) {
		//Implementacao de um elemento List
		List<Produto> lista = new ArrayList<Produto>();
		
		lista = Robo.gerarLista();
		
		/*System.out.println(lista.size());
		
		long limite = 24_116_400_000l;
		long inicio = System.currentTimeMillis();
		long acumula = 01;
		
		
		for(int i=0; i< lista.size(); i++) {
			acumula += i;
		}
		
		System.out.println("Tempo " + (System.currentTimeMillis() - inicio));*/
		
		/*for(Produto p : lista) {
			System.out.println("Codigo" + p.getCodigo()
			+"Descricao" + p.getDescricao()
			+"Quantidade" + p.getQuantidade()
			+(p.isStatus() ? "Aivo" : "Inativo"));
		}*/
		
		lista.stream().forEach(p -> System.out.println(p));
		lista.stream()
			.filter(p -> p.getDescricao().contains("6"))
			.forEach(p -> System.out.println(p));
			
	}
}
