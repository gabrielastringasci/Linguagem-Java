package adc1Poo;
/**
 *Atividade desenvolvida para ADC1 da matéria Programação Orientada a Objetos.
 * autor: Gabriela Stringasci
 * Data: 21/03/2024
 */
public class ExcluirVeiculo {

    public static boolean excluirVeiculoPorPlaca(Veiculo[] veiculos, String placaExcluir) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && veiculos[i].getPlaca().equalsIgnoreCase(placaExcluir)) {
                veiculos[i] = null; // Define o elemento como nulo para excluir o veículo
                return true; // Indica que o veículo foi excluído com sucesso
            }
        }
        return false; // Retorna falso se o veículo não for encontrado
    }
}