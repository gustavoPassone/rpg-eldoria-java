package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Fase;
import rpg.dominio.Heroi;
import rpg.dominio.Jogo;

import java.util.Scanner;

public class JogoTest03 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);

        Jogo jogo = new Jogo();
        jogo.configurar(arthur, new Fase[0]);

        System.out.println("=== Teste Boas-Vindas e Menu ===");
        jogo.exibirBoasVindas();
        jogo.exibirMenu();

        System.out.println("\n=== Teste de Execução do Laço com Entrada Simulada (Status -> Sair) ===");
        // Simulando entradas: 1 (status do heroi), depois 5 (sair)
        String entradasSimuladas = "1\n5\n";
        Scanner scannerSimulado = new Scanner(entradasSimuladas);
        jogo.iniciar(scannerSimulado);

        System.out.println("\nStatus emExecucao apos sair: " + jogo.emExecucao);
    }
}

