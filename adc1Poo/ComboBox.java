package adc1Poo;

/**
 *Atividade desenvolvida para ADC1 da matéria Programação Orientada a Objetos.
 * autor: Gabriela Stringasci
 * Data: 21/03/2024
 */
import javax.swing.JComboBox;

public class ComboBox {
	JComboBox<String> combo;

	public ComboBox() {
		combo = new JComboBox<String>();
		combo.addItem("CHEVROLET");
		combo.addItem("FORD");
		combo.addItem("VOLKSWAGEM");
		combo.addItem("RENAULT");
		combo.addItem("KIA");
		combo.addItem("MERCEDES-BENZ");
		combo.addItem("BMW");
		combo.setSelectedIndex(0);
	}

	public JComboBox<String> getComboBox() {
		return combo;
	}
}