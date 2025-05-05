package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProdutoTest {
    @Test
    public void CriarProdutovalidos() {
        Produto produto = new Produto("Café", 12.50, 81);

        assertEquals("Café", produto.getNome());
        assertEquals(12.50, produto.getPreco());
        assertEquals(81, produto.getEstoque());

    }

    @Test
    public void CriarProdutoPrecoNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Açúcar", -2.0, 10);
        });
        assertEquals("O preço não deve ser negativo!", exception.getMessage());
    }

    @Test
    public void CriarProdutoEstoqueNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Mel", 24.00, -5);
        });
        assertEquals("O estoque não deve ser negativo!", exception.getMessage());
    }

    @Test
        public void AlterarNomeProduto(){
        Produto produto = new Produto("Sal", 11.22, 80);
        produto.setNome("Chá");

        assertEquals("Chá", produto.getNome());
    }

    @Test
    public void AlterarPrecoProduto(){
        Produto produto = new Produto("Chocolate", 2.50, 15);
        produto.setPreco(8);

        assertEquals(8, produto.getPreco());
    }
}
