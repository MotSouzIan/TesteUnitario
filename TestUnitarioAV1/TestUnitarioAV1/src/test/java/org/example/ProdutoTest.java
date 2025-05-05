package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {
    @Test
    public void CriarProdutovalidos(){
        Produto produto = new Produto("Café", 12.50,81);

        assertEquals("Café", produto.getNome());
        assertEquals(12.50, produto.getPreco());
        assertEquals(81, produto.getEstoque());

    }

}
