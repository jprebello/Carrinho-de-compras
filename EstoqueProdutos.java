import java.util.*;

public class EstoqueProdutos {
	private List<ProdutoEstoque> produtos = new ArrayList<>();
	
	public List<ProdutoEstoque> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEstoque> produtos) {
		this.produtos = produtos;
	}

	public void adicionaProduto(ProdutoEstoque produto) {
		produtos.add(produto);
	}
}