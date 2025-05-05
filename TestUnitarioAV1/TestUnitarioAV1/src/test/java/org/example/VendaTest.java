package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {

    @Test
    public void VenderAMaisEstoque(){
        Produto produto = new Produto("Colher", 5.0, 10);
        Venda venda = new Venda(produto, 3);
        boolean sucesso = venda.realizarVenda();

        assertTrue(sucesso);
        assertEquals(7, produto.getEstoque());
        assertEquals(15.0, venda.getTotalVenda());
    }

    @Test
    public void VendaIgualEstoque(){
        Produto produto = new Produto("Biscoito", 3.00, 10);
        Venda venda = new Venda(produto, 10);
        boolean sucesso = venda.realizarVenda();

        assertTrue(sucesso);
        assertEquals(0, produto.getEstoque());
        assertEquals(30, venda.getTotalVenda());
    }

    @Test
    public void VendaMaiorEstoque(){
        Produto produto = new Produto("Doce", 5.0, 5);
        Venda venda = new Venda(produto, 10);

        boolean sucesso = venda.realizarVenda();

        assertFalse(sucesso);
        assertEquals(5, produto.getEstoque());
        assertEquals(0.0, venda.getTotalVenda());
    }
}
