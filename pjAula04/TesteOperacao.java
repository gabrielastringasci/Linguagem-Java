package pjAula04;

public class TesteOperacao {
	public void calcular (OperacaoMatematica op, double a, double b) {
		System.out.println(op.calcular(a, b));
		op.getTipo();
	
	if(op instanceof Soma) {
		System.out.println("Escolheu uma soma");
	}	else if(op instanceof Subtracao) {
		System.out.println("Escolheu uma subtração");
		}
	}
	
	public static void  main (String[] args) {
		TesteOperacao teste = new TesteOperacao ();
	
		teste.calcular(new Soma(), 123, 456);
		teste.calcular(new Subtracao(), 123, 456);
		
		OperacaoMatematica mult = new Multiplicacao();
		teste.calcular(mult, 3, 6);
	}
} 
