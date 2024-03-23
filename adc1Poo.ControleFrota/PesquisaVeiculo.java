package adc1Poo;
/**
 *Atividade desenvolvida para ADC1 da matéria Programação Orientada a Objetos.
 * autor: Gabriela Stringasci
 * Data: 20/03/2024
 */
public class PesquisaVeiculo {

    public static Veiculo pesquisarVeiculoPorPlaca(Veiculo[] veiculos, String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null; // Retorna null se o veículo não for encontrado
    }
}
