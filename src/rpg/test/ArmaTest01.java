package rpg.test;

import rpg.dominio.Arma;

public class ArmaTest01 {
    public static void main(String[] args) {
        Arma espadaMadeira = new Arma();
        espadaMadeira.nome = "Espada de Madeira";
        espadaMadeira.bonusAtaque = 2;
        espadaMadeira.preco = 15;

        Arma espadaFerro = new Arma();
        espadaFerro.nome = "Espada de Ferro";
        espadaFerro.bonusAtaque = 8;
        espadaFerro.preco = 60;

        System.out.println("--- Arma 1 ---");
        System.out.println("Nome: " + espadaMadeira.nome);
        System.out.println("Bônus de Ataque: +" + espadaMadeira.bonusAtaque);
        System.out.println("Preço: " + espadaMadeira.preco + " de ouro");

        System.out.println("\n--- Arma 2 ---");
        System.out.println("Nome: " + espadaFerro.nome);
        System.out.println("Bônus de Ataque: +" + espadaFerro.bonusAtaque);
        System.out.println("Preço: " + espadaFerro.preco + " de ouro");
    }
}

