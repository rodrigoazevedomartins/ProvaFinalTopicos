package br.edu.ifnmg.tads.provafinalii.DomainModel;

public class Pedido {
	
	private int idpedido;
	private String nomeloja;
	private String nomeproduto;
	private int quantidade;
	
	public Pedido(){
		idpedido = 0;
		nomeloja = "";
		nomeproduto = "";
		quantidade = 0;
	}
	
	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getNomeloja() {
		return nomeloja;
	}

	public void setNomeloja(String nomeloja) {
		this.nomeloja = nomeloja;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "\n\n" + "Nome da Loja: " + nomeloja + "\n\n" +
				"Nome do Produto: " + nomeproduto + "\n\n" +
				"Quantidade: " + quantidade;
	}
	
	

}
