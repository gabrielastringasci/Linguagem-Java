package adc1Poo;
/**
 *Atividade desenvolvida para ADC1 da matéria Programação Orientada a Objetos.
 * autor: Gabriela Stringasci
 * Data: 20/03/2024
 */
public class Teste {
	
    public static void main(String[] args) {
    	 java.time.LocalDate currentDate = java.time.LocalDate.now();
         java.sql.Date dataCompra = java.sql.Date.valueOf(currentDate);

         //Construtor
        Veiculo veiculo = new Veiculo("AMG 1", "Mercedes-Benz", "A1D23C", 2023, 200.000f, dataCompra);

        System.out.println("Dados do veículo: ");
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Fabricante: " + veiculo.getFabricante());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Ano de Fabricação: " + veiculo.getAnoFabricacao());
        System.out.printf("Valor: %.3f\n", veiculo.getValor());
        System.out.println("Data da compra: " + veiculo.getDataCompra());
    }
}
