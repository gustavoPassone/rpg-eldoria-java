package rpg.test;

import rpg.dominio.*;

public class LojaTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Loja loja = new Loja();

        Heroi heroi = new Heroi();
        cadastro.cadastrar(heroi, "Arthur", 100, 15, 5); // Ouro inicial = 30, pocoes = 2, sem arma

        Pocao pocaoPequena = new Pocao();
        pocaoPequena.nome = "Poção Pequena";
        pocaoPequena.pontosCura = 20;
        pocaoPequena.preco = 10;

        Pocao pocaoPrecoInvalido = new Pocao();
        pocaoPrecoInvalido.nome = "Poção Ilegal";
        pocaoPrecoInvalido.pontosCura = 20;
        pocaoPrecoInvalido.preco = -5;

        Arma espadaFerro = new Arma();
        espadaFerro.nome = "Espada de Ferro";
        espadaFerro.bonusAtaque = 8;
        espadaFerro.preco = 15;

        Arma espadaCara = new Arma();
        espadaCara.nome = "Espada Sagrada";
        espadaCara.bonusAtaque = 30;
        espadaCara.preco = 1000;

        System.out.println("=== ESTADO INICIAL ===");
        System.out.println("Ouro: " + heroi.ouro + " | Poções: " + heroi.inventario.quantidadePocoes + " | Ataque: " + heroi.calcularAtaqueTotal());

        System.out.println("\n=== 1 e 4: Compra de Poção com Ouro Suficiente e Atualização do Inventário ===");
        boolean comprouPocao = loja.comprarPocao(heroi, pocaoPequena);
        System.out.println("Comprou poção? " + comprouPocao + " (Esperado: true)");
        System.out.println("Ouro restante: " + heroi.ouro + " (Esperado: 20)");
        System.out.println("Poções no inventário: " + heroi.inventario.quantidadePocoes + " (Esperado: 3)");

        System.out.println("\n=== 5: Compra de Arma e Atualização do Ataque Total ===");
        int ataqueAntes = heroi.calcularAtaqueTotal();
        boolean comprouArma = loja.comprarArma(heroi, espadaFerro);
        System.out.println("Comprou arma? " + comprouArma + " (Esperado: true)");
        System.out.println("Ataque antes: " + ataqueAntes + " -> Ataque após equipar: " + heroi.calcularAtaqueTotal() + " (Esperado: 23)");
        System.out.println("Ouro restante: " + heroi.ouro + " (Esperado: 5)");

        System.out.println("\n=== 2 e 6: Compra com Ouro Insuficiente e Garantia de Ouro Não Negativo ===");
        boolean comprouCara = loja.comprarArma(heroi, espadaCara);
        System.out.println("Comprou arma cara? " + comprouCara + " (Esperado: false)");
        System.out.println("Ouro do herói (não pode ser negativo): " + heroi.ouro + " (Esperado: >= 0, atual: " + heroi.ouro + ")");

        System.out.println("\n=== 3: Tentativa de Compra com Preço Inválido ===");
        boolean comprouInvalida = loja.comprarPocao(heroi, pocaoPrecoInvalido);
        System.out.println("Comprou item com preço inválido? " + comprouInvalida + " (Esperado: false)");
        System.out.println("Ouro final do herói: " + heroi.ouro);
    }
}
