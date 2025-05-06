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
    @Test
    public void CalculoTotalVenda(){
        Produto produto = new Produto("Melzinho", 5.5, 10);
        Venda venda = new Venda(produto, 4);

        boolean sucesso = venda.realizarVenda();

        assertTrue(sucesso);
        assertEquals(22, venda.getTotalVenda());
    }

    @Test
    public void EstoqueDiminuiVenda(){
        Produto produto = new Produto("Cadeira", 50, 10);
        Venda venda = new Venda(produto, 2);

        boolean sucesso = venda.realizarVenda();

        assertTrue(sucesso);
        assertEquals(8, produto.getEstoque());
    }

    @Test
    public void DiminuiEstoqueAposVendaBemSucedida() {
        Produto produto = new Produto("Caneta", 1.50, 15);
        Venda venda = new Venda(produto, 5);

        boolean sucesso = venda.realizarVenda();

        assertTrue(sucesso);
        assertEquals(10, produto.getEstoque());
    }

    @Test
    public void CriarVendaNegativa() {
        Produto produto = new Produto("Caderno", 15.0, 10);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Venda(produto, -3);
        });

        assertEquals("Quantidade de venda não pode ser negativa!", exception.getMessage());
    }
    @Test
    public void AlterarEstoqueInsuficiente() {
        Produto produto = new Produto("Borracha", 2.0, 3);
        Venda venda = new Venda(produto, 5);

        boolean resultado = venda.realizarVenda();

        assertFalse(resultado);
        assertEquals(3, produto.getEstoque());
    }
    @Test
    public void MultiplasVendas() {
        Produto produto1 = new Produto("Caneta", 2.50, 10);
        Produto produto2 = new Produto("Lápis", 1.50, 5);

        Venda venda1 = new Venda(produto1, 3);
        Venda venda2 = new Venda(produto2, 2);

        assertTrue(venda1.realizarVenda());
        assertTrue(venda2.realizarVenda());


        assertEquals(7, produto1.getEstoque());
        assertEquals(3, produto2.getEstoque());


        assertEquals(7.50, venda1.getTotalVenda(), 0.001);
        assertEquals(3.00, venda2.getTotalVenda(), 0.001);
    }
    @Test
    public void CalcularPrecoAntesVenda() {
        Produto produto = new Produto("Caderno", 10.0, 10);
        Venda venda = new Venda(produto, 2);

        produto.setPreco(12.5);

        boolean resultado = venda.realizarVenda();

        assertTrue(resultado);
        assertEquals(25.0, venda.getTotalVenda(), 0.001);
        assertEquals(8, produto.getEstoque());
    }
    @Test
    public void VendaEstoqueZero() {
        Produto produto = new Produto("Marca-texto", 3.0, 0);
        Venda venda = new Venda(produto, 1);

        boolean resultado = venda.realizarVenda();

        assertFalse(resultado);
        assertEquals(0, produto.getEstoque());
        assertEquals(0.0, venda.getTotalVenda(), 0.001);
    }
    @Test
    public void VendaAntesReposicao() {
        Produto produto = new Produto("Borracha", 1.00, 0);
        Venda vendaAntesReposicao = new Venda(produto, 1);


        assertFalse(vendaAntesReposicao.realizarVenda());
        assertEquals(0, produto.getEstoque());
        assertEquals(0.0, vendaAntesReposicao.getTotalVenda(), 0.001);


        produto.aumentarEstoque(5);
        assertEquals(5, produto.getEstoque());


        Venda vendaAposReposicao = new Venda(produto, 2);
        assertTrue(vendaAposReposicao.realizarVenda());
        assertEquals(3, produto.getEstoque()); // 5 - 2
        assertEquals(2.00, vendaAposReposicao.getTotalVenda(), 0.001);
    }
}
