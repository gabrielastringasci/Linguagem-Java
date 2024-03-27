package pjAula07;
/**
 * Classe de Modelagem Conceitual do Produto
 * @author Gabriela Stringasci
 * Data: 26/03/2024
 */

public class Produto {
	//Atributos
	private int codigo;
	private String descricao;
	private float quantidade;
	private boolean status;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "  Codigo " + getCodigo()
		+ "  Descricao " + getDescricao()
		+"  Quantidade " + getQuantidade()
		+(isStatus() ? "  Aivo" : "  Inativo");
	}

}
