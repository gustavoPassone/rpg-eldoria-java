package rpg.test;

import rpg.dominio.*;

public class BatalhaTest02 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();
        Batalha batalha = new Batalha();

        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);

        Monstro esqueleto = new Monstro();
        cadastroMonstro.cadastrar(esqueleto, "Esqueleto", 45, 10, 2, 25, 35);

        System.out.println("--- Início do Teste de Ataques ---");
        System.out.println("Vida inicial de " + arthur.nome + ": " + arthur.vida);
        System.out.println("Vida inicial de " + esqueleto.nome + ": " + esqueleto.vida);
        System.out.println();

        batalha.atacarComHeroi(arthur, esqueleto);
        System.out.println("Vida de " + esqueleto.nome + ": " + esqueleto.vida);
        System.out.println();

        batalha.atacarComMonstro(esqueleto, arthur);
        System.out.println("Vida de " + arthur.nome + ": " + arthur.vida);
    }
}

