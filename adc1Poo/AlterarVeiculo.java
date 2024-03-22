package adc1Poo;
/**
 *Atividade desenvolvida para ADC1 da matéria Programação Orientada a Objetos.
 * autor: Gabriela Stringasci
 * Data: 21/03/2024
 */
public class AlterarVeiculo {
		public static boolean alterarVeiculoPorPlaca(Veiculo[] veiculos, String placa, Veiculo novoVeiculo) {
			   for (int i = 0; i < veiculos.length; i++) {
		            if (veiculos[i] != null && veiculos[i].getPlaca().equalsIgnoreCase(placa)) {
		                veiculos[i] = novoVeiculo; // Substitui o veículo existente pelo novo veículo
		                return true; // Indica que o veículo foi alterado com sucesso
		            }
		        } 
			return false;
		}
	}

