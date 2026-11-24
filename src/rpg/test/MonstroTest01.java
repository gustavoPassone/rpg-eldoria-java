package rpg.test;

import rpg.dominio.Monstro;

public class MonstroTest01 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.vida = 30;
        goblin.ataque = 6;
        goblin.defesa = 1;
        goblin.ouroRecompensa = 10;
        goblin.experienciaRecompensa = 15;

        Monstro esqueleto = new Monstro();
        esqueleto.nome = "Esqueleto";
        esqueleto.vida = 45;
        esqueleto.ataque = 9;
        esqueleto.defesa = 2;
        esqueleto.ouroRecompensa = 25;
        esqueleto.experienciaRecompensa = 35;

        Monstro guardiaoSombrio = new Monstro();
        guardiaoSombrio.nome = "Guardião Sombrio";
        guardiaoSombrio.vida = 75;
        guardiaoSombrio.ataque = 12;
        guardiaoSombrio.defesa = 3;
        guardiaoSombrio.ouroRecompensa = 50;
        guardiaoSombrio.experienciaRecompensa = 80;

        System.out.println("--- Inimigo 1 ---");
        System.out.println("Nome: " + goblin.nome);
        System.out.println("Vida: " + goblin.vida);
        System.out.println("Ataque: " + goblin.ataque);
        System.out.println("Defesa: " + goblin.defesa);
        System.out.println("Ouro de Recompensa: " + goblin.ouroRecompensa);
        System.out.println("Experiência de Recompensa: " + goblin.experienciaRecompensa);

        System.out.println("\n--- Inimigo 2 ---");
        System.out.println("Nome: " + esqueleto.nome);
        System.out.println("Vida: " + esqueleto.vida);
        System.out.println("Ataque: " + esqueleto.ataque);
        System.out.println("Defesa: " + esqueleto.defesa);
        System.out.println("Ouro de Recompensa: " + esqueleto.ouroRecompensa);
        System.out.println("Experiência de Recompensa: " + esqueleto.experienciaRecompensa);

        System.out.println("\n--- Inimigo 3 ---");
        System.out.println("Nome: " + guardiaoSombrio.nome);
        System.out.println("Vida: " + guardiaoSombrio.vida);
        System.out.println("Ataque: " + guardiaoSombrio.ataque);
        System.out.println("Defesa: " + guardiaoSombrio.defesa);
        System.out.println("Ouro de Recompensa: " + guardiaoSombrio.ouroRecompensa);
        System.out.println("Experiência de Recompensa: " + guardiaoSombrio.experienciaRecompensa);
    }
}

