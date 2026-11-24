package rpg.test;

import rpg.dominio.Monstro;

public class MonstroTest03 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.ataque = 10;

        int defesaHeroi1 = 3;
        int dano1 = goblin.calcularDano(defesaHeroi1);
        System.out.println("Monstro: " + goblin.nome + " | Ataque: " + goblin.ataque);
        System.out.println("Contra herói com defesa " + defesaHeroi1 + " -> Dano: " + dano1);

        int defesaHeroi2 = 12;
        int dano2 = goblin.calcularDano(defesaHeroi2);
        System.out.println("Contra herói com defesa " + defesaHeroi2 + " -> Dano (mínimo 1): " + dano2);
    }
}

