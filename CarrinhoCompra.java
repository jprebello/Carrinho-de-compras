import java.util.*;

public class CarrinhoCompra {
	private EstoqueProdutos estoque;
	private float valorTotal=0;
	private List<ProdutoEstoque> carrinho = new ArrayList<>();
	
	public CarrinhoCompra(EstoqueProdutos estoque) {
		this.estoque=estoque;
	}
	
	public void adicionaItem(String nomeProduto, int quantidade) {
		ProdutoEstoque novoProduto;
		for (ProdutoEstoque produtoEstoque : estoque.getProdutos()) {
			if(produtoEstoque.getNome().equals(nomeProduto)) {
				if(produtoEstoque.getQuantidade()>=quantidade) {
					novoProduto = new ProdutoEstoque(nomeProduto, produtoEstoque.getValor(), quantidade);
					carrinho.add(novoProduto);
					valorTotal=valorTotal+(produtoEstoque.getValor()*quantidade);
					System.out.println("Produto adicionado ao carrinho.");	
					return;
				} else {
					System.out.println("Quantidade insuficiente no estoque.");
					return;
				}
			} 
		} 
		System.out.println("Produto nao econtrado no estoque.");	
	}

	public void finalizaCompra() {
	    for (ProdutoEstoque produtoCarrinho : carrinho) {
	        for (ProdutoEstoque produtoEstoque : estoque.getProdutos()) {
	            if (produtoCarrinho.getNome().equals(produtoEstoque.getNome())) {
	            	int novaQuantidade;
	            	novaQuantidade = produtoEstoque.getQuantidade() - produtoCarrinho.getQuantidade();
	                produtoEstoque.setQuantidade(novaQuantidade);
	                break;
	            }
	        }
	    }

	    valorTotal=0;
	    carrinho.clear();
	    System.out.println("Compra finalizada.");
	}
	
	public float calculaTotal() {
		return valorTotal;
	}
	
	public EstoqueProdutos getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueProdutos estoque) {
		this.estoque = estoque;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ProdutoEstoque> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<ProdutoEstoque> carrinho) {
		this.carrinho = carrinho;
	}

}