package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;

public class CadastroHeroiTest02 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();

        System.out.println("=== Teste 1: Nome vazio ou espacos ===");
        Heroi h1 = new Heroi();
        boolean c1 = cadastro.cadastrar(h1, "   ", 100, 15, 5);
        System.out.println("Cadastrou? " + c1 + " | Nome no objeto: " + h1.nome);

        System.out.println("\n=== Teste 2: Vida máxima menor ou igual a zero ===");
        Heroi h2 = new Heroi();
        boolean c2 = cadastro.cadastrar(h2, "Galahad", 0, 15, 5);
        System.out.println("Cadastrou? " + c2 + " | Vida no objeto: " + h2.vidaMaxima);

        System.out.println("\n=== Teste 3: Ataque negativo ===");
        Heroi h3 = new Heroi();
        boolean c3 = cadastro.cadastrar(h3, "Lancelot", 100, -5, 5);
        System.out.println("Cadastrou? " + c3 + " | Ataque no objeto: " + h3.ataque);

        System.out.println("\n=== Teste 4: Defesa negativa ===");
        Heroi h4 = new Heroi();
        boolean c4 = cadastro.cadastrar(h4, "Percival", 100, 15, -2);
        System.out.println("Cadastrou? " + c4 + " | Defesa no objeto: " + h4.defesa);

        System.out.println("\n=== Teste 5: Cadastro válido (Sucesso) ===");
        Heroi h5 = new Heroi();
        boolean c5 = cadastro.cadastrar(h5, "Arthur", 100, 15, 5);
        System.out.println("Cadastrou? " + c5 + " | Herói: " + h5.nome + " | Vida: " + h5.vida + "/" + h5.vidaMaxima);
    }
}

