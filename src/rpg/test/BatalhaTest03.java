package rpg.test;

import rpg.dominio.*;

public class BatalhaTest03 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();
        Batalha batalha = new Batalha();

        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);

        Monstro goblin = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 30, 8, 2, 10, 15);

        System.out.println("=== Início do Combate: Arthur vs Goblin ===");
        int turno = 1;
        while (arthur.estaVivo() && goblin.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            batalha.executarTurno(arthur, goblin);
            turno++;
        }

        System.out.println("\n=== Combate Encerrado ===");
        if (arthur.estaVivo()) {
            System.out.println("Vencedor: " + arthur.nome + "!");
        } else {
            System.out.println("Vencedor: " + goblin.nome + "!");
        }
    }
}

