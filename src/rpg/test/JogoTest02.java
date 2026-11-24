package rpg.test;

import rpg.dominio.*;

public class JogoTest02 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();

        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);

        // Criando as 3 fases do jogo (Exercício 32)
        Fase[] fases = new Fase[3];

        fases[0] = new Fase();
        fases[0].nome = "Floresta Sombria";
        Monstro goblin = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 15);
        fases[0].inimigo = goblin;

        fases[1] = new Fase();
        fases[1].nome = "Caverna dos Ossos";
        Monstro esqueleto = new Monstro();
        cadastroMonstro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 25, 35);
        fases[1].inimigo = esqueleto;

        fases[2] = new Fase();
        fases[2].nome = "Castelo das Sombras";
        Monstro guardiao = new Monstro();
        cadastroMonstro.cadastrar(guardiao, "Guardião Sombrio", 75, 12, 3, 50, 80);
        fases[2].inimigo = guardiao;

        // Configurando o jogo (Exercício 33)
        Jogo jogo = new Jogo();
        jogo.configurar(arthur, fases);

        System.out.println("Jogo: " + jogo.titulo);
        System.out.println("Herói: " + jogo.heroi.nome);
        System.out.println("Total de fases: " + jogo.fases.length);
        System.out.println("Fase inicial: " + jogo.fases[jogo.faseAtual].nome + " (Inimigo: " + jogo.fases[jogo.faseAtual].inimigo.nome + ")");
        System.out.println("Em execução: " + jogo.emExecucao);
    }
}

