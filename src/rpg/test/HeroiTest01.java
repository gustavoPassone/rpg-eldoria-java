package rpg.test;

import rpg.dominio.Heroi;

public class HeroiTest01 {
    public static void main(String[] args) {
        Heroi heroi1 = new Heroi();
        heroi1.nome = "Arthur";
        heroi1.vida = 100;
        heroi1.vidaMaxima = 100;
        heroi1.ataque = 15;
        heroi1.defesa = 5;
        heroi1.nivel = 1;
        heroi1.experiencia = 0;
        heroi1.ouro = 50;

        Heroi heroi2 = new Heroi();
        heroi2.nome = "Luna";
        heroi2.vida = 80;
        heroi2.vidaMaxima = 80;
        heroi2.ataque = 20;
        heroi2.defesa = 3;
        heroi2.nivel = 1;
        heroi2.experiencia = 0;
        heroi2.ouro = 75;

        System.out.println("--- Informações do Herói 1 ---");
        System.out.println("Nome: " + heroi1.nome);
        System.out.println("Vida: " + heroi1.vida + "/" + heroi1.vidaMaxima);
        System.out.println("Ataque: " + heroi1.ataque);
        System.out.println("Defesa: " + heroi1.defesa);
        System.out.println("Nível: " + heroi1.nivel);
        System.out.println("Experiência: " + heroi1.experiencia);
        System.out.println("Ouro: " + heroi1.ouro);

        System.out.println("\n--- Informações do Herói 2 ---");
        System.out.println("Nome: " + heroi2.nome);
        System.out.println("Vida: " + heroi2.vida + "/" + heroi2.vidaMaxima);
        System.out.println("Ataque: " + heroi2.ataque);
        System.out.println("Defesa: " + heroi2.defesa);
        System.out.println("Nível: " + heroi2.nivel);
        System.out.println("Experiência: " + heroi2.experiencia);
        System.out.println("Ouro: " + heroi2.ouro);
    }
}

