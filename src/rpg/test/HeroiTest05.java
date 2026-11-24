package rpg.test;

import rpg.dominio.Heroi;

public class HeroiTest05 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        heroi.vida = 100;
        heroi.vidaMaxima = 100;

        System.out.println("Herói: " + heroi.nome);
        System.out.println("Vida inicial: " + heroi.vida);

        System.out.println("\nAplicando 25 de dano...");
        heroi.receberDano(25);
        System.out.println("Vida após dano: " + heroi.vida);

        System.out.println("\nAplicando dano excessivo de 120...");
        heroi.receberDano(120);
        System.out.println("Vida após dano excessivo (não pode ser menor que zero): " + heroi.vida);
    }
}

