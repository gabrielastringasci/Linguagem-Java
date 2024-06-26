package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.modelagem.Produto;
import br.unisal.modelagem.Situacao;
import br.unisal.modelagem.UnidadeMedida;

public class frmProduto extends JFrame implements ActionListener {
	//1- Passo Declarar os Objetos
	
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, txtLocalizacao, txtSituacao;
	JComboBox cbxUnidadeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa;
	List<Produto> bdProduto = new ArrayList<Produto>();
	
	public frmProduto() {
		super ("Cadastro de Produto");
		setSize (400,250);
		setLayout (new BorderLayout());
		
		// 2-Passo Construir os Objetos
		lbCodigo = new JLabel ("C�digo");
		lbDescricao = new JLabel ("Descri��o");
		lbUnidadeMedida= new JLabel ("Un. Medida");
		lbLargura = new JLabel ("Largura");
		lbComprimento = new JLabel ("Comprimento");
		lbSituacao = new JLabel("Situa��o");
		lbLocalizacao = new JLabel ("Localiza��o");
		
		txtCodigo = new JTextField();
		txtDescricao = new JTextField();
		txtLargura =  new JTextField();
		txtComprimento =  new JTextField();
		txtLocalizacao = new JTextField();
		txtSituacao = new JTextField();
		
		cbxSituacao =  new JComboBox<Situacao>(Situacao.values());
		cbxUnidadeMedida = new JComboBox<String>(UnidadeMedida.getUnidades());
		
		btnInclui = new JButton ("Incluir");
		btnAltera= new JButton ("Alterar");
		btnExclui = new JButton ("Excluir");
		btnPesquisa = new JButton ("Pesquisar");
		
		pnCampos = new JPanel (new GridLayout(7,2));
		pnBotoes = new JPanel (new GridLayout(1,4));
		
		//3- Passo adicionar Botoes aos Campos
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		
		pnCampos.add(lbDescricao);
		pnCampos.add(txtDescricao);
		
		pnCampos.add(lbUnidadeMedida);
		pnCampos.add(cbxUnidadeMedida);
		
		pnCampos.add(lbComprimento);
		pnCampos.add(txtComprimento);
		
		pnCampos.add(lbLocalizacao);
		pnCampos.add(txtLocalizacao);
		
		pnCampos.add(lbLargura);
		pnCampos.add(txtLargura);
		
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		
		add(pnCampos, BorderLayout.CENTER);
		
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//4- Passo Incluir os elementos Listener de A��es
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInclui) {
			bdProduto.add(instanciar());
		}
		if(e.getSource() == btnAltera) {
			for(Produto p: bdProduto) {
				if(p.getCodigo() == p.getCodigo()) {
					Produto objeto = instanciar();
					if(objeto != null) {
						p = objeto;
					}
				}
			}
		}
		
		System.out.println(bdProduto);
		
	}

	private Produto instanciar() {
		Produto p = new Produto();
		try {
			p.setCodigo(Integer.parseInt(txtCodigo.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "C�digo do Produto Inv�lido", "Valida��o", JOptionPane.ERROR_MESSAGE);
		}
		
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
		
		try { 
			p.setLargura(Integer.parseInt(txtComprimento.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Largura do Produto Inv�lida", "Valida��o", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			p.setComprimento(Integer.parseInt(txtComprimento.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Comprimento do Produto Inv�lido", "Valida��o", JOptionPane.ERROR_MESSAGE);
		}
		
		p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
		p.setLocalizacao(txtLocalizacao.getText());
		
		return p;
	}
	
	
	public static void main (String[] args) {
		frmProduto frm = new frmProduto();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
