package rpg.test;

import rpg.dominio.Monstro;

public class MonstroTest04 {
    public static void main(String[] args) {
        Monstro monstro = new Monstro();
        monstro.nome = "Goblin";
        monstro.vida = 30;

        System.out.println("Monstro: " + monstro.nome + " | Vida inicial: " + monstro.vida);
        System.out.println("Está vivo? " + monstro.estaVivo());

        System.out.println("\nAplicando ataque de 12 de dano...");
        monstro.receberDano(12);
        System.out.println("Vida atual: " + monstro.vida + " | Está vivo? " + monstro.estaVivo());

        System.out.println("\nAplicando ataque de 12 de dano...");
        monstro.receberDano(12);
        System.out.println("Vida atual: " + monstro.vida + " | Está vivo? " + monstro.estaVivo());

        System.out.println("\nAplicando ataque final de 10 de dano...");
        monstro.receberDano(10);
        System.out.println("Vida atual: " + monstro.vida + " | Está vivo? " + monstro.estaVivo());
    }
}

