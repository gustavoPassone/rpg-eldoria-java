package rpg.test;

import rpg.dominio.Heroi;

public class HeroiTest06 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        heroi.vida = 50;
        heroi.vidaMaxima = 100;

        System.out.println("Herói: " + heroi.nome);
        System.out.println("Vida atual: " + heroi.vida + "/" + heroi.vidaMaxima);

        System.out.println("\nUsando cura de 20 pontos...");
        heroi.curar(20);
        System.out.println("Vida após cura: " + heroi.vida + "/" + heroi.vidaMaxima);

        System.out.println("\nUsando cura de 50 pontos (vida atual 70 + 50 = 120, limite é 100)...");
        heroi.curar(50);
        System.out.println("Vida após cura com limite: " + heroi.vida + "/" + heroi.vidaMaxima);
    }
}

