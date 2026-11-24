package rpg.test;

import rpg.dominio.*;

import java.util.Scanner;

public class BatalhaTest05 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();
        Batalha batalha = new Batalha();

        Pocao pocao = new Pocao();
        pocao.nome = "Poção Pequena";
        pocao.pontosCura = 20;

        System.out.println("=== Teste 1: Batalha com Ataque, Cura e Vitória ===");
        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);

        Monstro goblin = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 25, 8, 2, 10, 15);

        // Simulando entradas: 1 (atacar), 2 (usar pocao), 1 (atacar final)
        String entradasVitoria = "1\n2\n1\n";
        Scanner scannerVitoria = new Scanner(entradasVitoria);

        boolean venceu = batalha.iniciarBatalha(arthur, goblin, pocao, scannerVitoria);
        System.out.println("Resultado da batalha: " + (venceu ? "Vitória do Herói!" : "Derrota/Fuga"));

        System.out.println("\n=== Teste 2: Batalha com Fuga ===");
        Heroi luna = new Heroi();
        cadastroHeroi.cadastrar(luna, "Luna", 80, 20, 3);

        Monstro esqueleto = new Monstro();
        cadastroMonstro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 25, 35);

        // Simulando entrada: 3 (fugir)
        String entradaFuga = "3\n";
        Scanner scannerFuga = new Scanner(entradaFuga);

        boolean venceuFuga = batalha.iniciarBatalha(luna, esqueleto, pocao, scannerFuga);
        System.out.println("Resultado da batalha (Fuga): " + (venceuFuga ? "Vitória" : "Fuga confirmada (retornou false)"));
    }
}

