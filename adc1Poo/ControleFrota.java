package adc1Poo;
/**
 *Atividade desenvolvida para ADC1 da matéria Programação Orientada a Objetos.
 * autor: Gabriela Stringasci
 * Data: 21/03/2024
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControleFrota extends JFrame implements ActionListener {
	// Declaração de Atributos
	JButton btnCadastrar, btnAlterar, btnExcluir, btnPesquisar, btnLimpar, btnSair;
	JTextField txtPlaca, txtModelo, txtDataCompra, txtFabricante, txtAno, txtValor;
	JLabel lbPlaca, lbModelo, lbDataCompra, lbFabricante, lbAno, lbValor;
	JPanel pnCampos, pnBotoes;

	Veiculo[] veiculos;
	int contadorVeiculos = 0;

	ComboBox comboBoxFabricante;

	public ControleFrota() {
		super("Controle de Frota - Cadastro de Veículos");
		setSize(700, 250);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);

		veiculos = new Veiculo[100];

		inicializarComponentes();
		adicionarGUI();

		setVisible(true);
	}

	private void inicializarComponentes() {
		// Construção de componentes
		lbPlaca = new JLabel("Placa");
		lbModelo = new JLabel("Modelo");
		lbDataCompra = new JLabel("Data da Compra");
		lbAno = new JLabel("    Ano");
		lbValor = new JLabel("    Valor (R$): ");

		txtPlaca = new JTextField(40);
		txtModelo = new JTextField(40);
		txtDataCompra = new JTextField(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
		txtAno = new JTextField(40);
		txtValor = new JTextField(40);

		comboBoxFabricante = new ComboBox();

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadastrar()) {
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
				}
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(this);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(this);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(this);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // Fecha o JFrame
			}
		});
	}

	private void adicionarGUI() {
		// Adicionar os componentes a GUI
		pnCampos = new JPanel(new GridLayout(3, 2));
		pnBotoes = new JPanel(new FlowLayout());

		pnCampos.add(lbPlaca);
		pnCampos.add(txtPlaca);
		pnCampos.add(new JLabel("    Fabricante"));
		pnCampos.add(comboBoxFabricante.getComboBox());
		pnCampos.add(lbModelo);
		pnCampos.add(txtModelo);
		pnCampos.add(lbAno);
		pnCampos.add(txtAno);
		pnCampos.add(lbDataCompra);
		pnCampos.add(txtDataCompra);
		pnCampos.add(lbValor);
		pnCampos.add(txtValor);

		pnBotoes.add(btnCadastrar);
		pnBotoes.add(btnAlterar);
		pnBotoes.add(btnExcluir);
		pnBotoes.add(btnPesquisar);
		pnBotoes.add(btnLimpar);
		pnBotoes.add(btnSair);

		add(pnCampos, new BorderLayout().NORTH);
		add(pnBotoes, new BorderLayout().SOUTH);
	}

	public static void main(String[] args) {
		ControleFrota frm = new ControleFrota();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btnCadastrar) {
            cadastrar();
        }
        if (evento.getSource() == btnAlterar) {
            alterar();
        }
        if (evento.getSource() == btnExcluir) {
            excluir();
        }
        if (evento.getSource() == btnPesquisar) {
            pesquisar();
        }
        if (evento.getSource() == btnLimpar) {
            limpar();
        }
        if (evento.getSource() == btnSair) {
            dispose();
        }
	}
	private boolean cadastrar() {
		// Cadastra Veiculos
		String modelo = txtModelo.getText();
		String fabricante = (String) comboBoxFabricante.getComboBox().getSelectedItem();
		String placa = txtPlaca.getText();
		int ano = Integer.parseInt(txtAno.getText());
		float valor = Float.parseFloat(txtValor.getText());

		java.sql.Date dataCompra = java.sql.Date.valueOf(java.time.LocalDate.now());

		Veiculo novoVeiculo = new Veiculo(modelo, fabricante, placa, ano, valor, dataCompra);

		veiculos[contadorVeiculos] = novoVeiculo;
		contadorVeiculos++;
		limpar();
		return true;
	}

	private void alterar() {
		// Altera as Informações dos Veiculos
		String modelo = txtModelo.getText();
		String fabricante = (String) comboBoxFabricante.getComboBox().getSelectedItem();
		String placa = txtPlaca.getText();
		int ano = Integer.parseInt(txtAno.getText());
		float valor = Float.parseFloat(txtValor.getText());

		java.sql.Date dataCompra = java.sql.Date.valueOf(java.time.LocalDate.now());

		Veiculo novoVeiculo = new Veiculo(modelo, fabricante, placa, ano, valor, dataCompra);

		boolean alterado = AlterarVeiculo.alterarVeiculoPorPlaca(veiculos, placa, novoVeiculo);
		JOptionPane.showMessageDialog(null, alterado ? "Informações alteradas." : "Erro");
	}

	private void excluir() {
		// Exclui um Veiculo
		String placaExcluir = txtPlaca.getText();
		boolean excluiu = ExcluirVeiculo.excluirVeiculoPorPlaca(veiculos, placaExcluir);
		JOptionPane.showMessageDialog(null, excluiu ? "Veículo excluido" : "Erro");
	}

	private void pesquisar() {
		// Pesquisa os Veiculos
		String placaPesquisada = txtPlaca.getText();
		Veiculo veiculoEncontrado = PesquisaVeiculo.pesquisarVeiculoPorPlaca(veiculos, placaPesquisada);
		if (veiculoEncontrado != null) {
			String mensagem = "Veículo encontrado: \n\n" + veiculoEncontrado.toString();
			JOptionPane.showMessageDialog(null, mensagem);
		} else {
			JOptionPane.showMessageDialog(null, "Veículo não encontrado.");
		}
	}

	private void limpar() {
		// Limpa os Campos
		txtPlaca.setText("");
		txtModelo.setText("");
		txtAno.setText("");
		txtValor.setText("");
	}
}