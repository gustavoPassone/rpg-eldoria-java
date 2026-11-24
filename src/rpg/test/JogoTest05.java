package rpg.test;

import rpg.dominio.*;

public class JogoTest05 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();

        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 25, 5);

        Fase[] fases = new Fase[3];

        fases[0] = new Fase();
        fases[0].nome = "Floresta Sombria";
        Monstro goblin = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 50);
        fases[0].inimigo = goblin;

        fases[1] = new Fase();
        fases[1].nome = "Caverna dos Ossos";
        Monstro esqueleto = new Monstro();
        cadastroMonstro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 25, 60);
        fases[1].inimigo = esqueleto;

        fases[2] = new Fase();
        fases[2].nome = "Castelo das Sombras";
        Monstro guardiao = new Monstro();
        cadastroMonstro.cadastrar(guardiao, "Guardião Sombrio", 75, 12, 3, 50, 100);
        fases[2].inimigo = guardiao;

        Jogo jogo = new Jogo();
        jogo.configurar(arthur, fases);

        System.out.println("=== Início da Jornada por Eldoria ===");
        System.out.println("Fase inicial: " + jogo.fases[jogo.faseAtual].nome);

        System.out.println("\nDerrotando o Goblin na Floresta Sombria...");
        arthur.receberRecompensa(goblin);
        jogo.avancarFase();

        System.out.println("\nDerrotando o Esqueleto na Caverna dos Ossos...");
        arthur.receberRecompensa(esqueleto);
        jogo.avancarFase();

        System.out.println("\nDerrotando o Guardião Sombrio no Castelo das Sombras...");
        arthur.receberRecompensa(guardiao);
        jogo.avancarFase();

        System.out.println("\n=== Status Final do Jogo ===");
        System.out.println("Fase atual (índice): " + jogo.faseAtual);
        System.out.println("Jogo ainda em execução? " + jogo.emExecucao);
        System.out.println("Status final do herói: " + arthur.gerarResumo());
        System.out.println("Todas as fases concluídas:");
        for (int i = 0; i < fases.length; i++) {
            System.out.println("- " + fases[i].nome + ": " + (fases[i].concluida ? "Concluída" : "Pendente"));
        }
    }
}

