package rpg.test;

import rpg.dominio.*;

import java.util.Scanner;

public class JogoTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();

        System.out.println("==================================================");
        System.out.println("      BEM-VINDO AO RPG: A JORNADA DE ELDORIA!     ");
        System.out.println("==================================================");
        System.out.print("Digite o nome do seu herói: ");

        String nome = "";
        if (scanner.hasNextLine()) {
            nome = scanner.nextLine().trim();
        }
        if (nome.isEmpty()) {
            nome = "Arthur";
            System.out.println("Nenhum nome informado. Nome padrão atribuído: Arthur");
        }

        Heroi heroi = new Heroi();
        cadastroHeroi.cadastrar(heroi, nome, 100, 16, 5);

        // Configuração das três fases de Eldoria
        Fase[] fases = new Fase[3];

        // Fase 1: Floresta Sombria — Goblin
        fases[0] = new Fase();
        fases[0].nome = "Floresta Sombria";
        Monstro goblin = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 30, 7, 2, 15, 100);
        fases[0].inimigo = goblin;

        // Fase 2: Caverna dos Ossos — Esqueleto
        fases[1] = new Fase();
        fases[1].nome = "Caverna dos Ossos";
        Monstro esqueleto = new Monstro();
        cadastroMonstro.cadastrar(esqueleto, "Esqueleto", 50, 10, 3, 30, 150);
        fases[1].inimigo = esqueleto;

        // Fase 3: Castelo das Sombras — Guardião Sombrio (Chefe Final)
        fases[2] = new Fase();
        fases[2].nome = "Castelo das Sombras";
        Monstro guardiao = new Monstro();
        cadastroMonstro.cadastrar(guardiao, "Guardião Sombrio", 85, 14, 4, 60, 200);
        fases[2].inimigo = guardiao;

        Jogo jogo = new Jogo();
        jogo.configurar(heroi, fases);
        jogo.iniciar(scanner);
    }
}
