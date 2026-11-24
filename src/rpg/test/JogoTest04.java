package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Fase;
import rpg.dominio.Heroi;
import rpg.dominio.Jogo;

import java.util.Scanner;

public class JogoTest04 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 15, 5);
        arthur.ouro = 60; // saldo para compras

        Jogo jogo = new Jogo();
        jogo.configurar(arthur, new Fase[0]);

        System.out.println("=== Teste do Menu da Loja (Comprar Poção, Arma e Sair) ===");
        // Entradas da loja:
        // 1 (comprar pocao pequena - 10 ouro)
        // 4 (comprar espada de ferro - 40 ouro)
        // 5 (voltar ao menu principal)
        String entradasLoja = "1\n4\n5\n";
        Scanner scannerLoja = new Scanner(entradasLoja);
        jogo.abrirLoja(scannerLoja);

        System.out.println("\n=== Teste do Menu do Inventário (Usar poção após dano e voltar) ===");
        arthur.receberDano(30);
        // Entradas inventario:
        // 1 (usar pocao)
        // 2 (voltar)
        String entradasInv = "1\n2\n";
        Scanner scannerInv = new Scanner(entradasInv);
        jogo.abrirInventario(scannerInv);
    }
}

