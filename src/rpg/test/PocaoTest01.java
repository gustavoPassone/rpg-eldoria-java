package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;
import rpg.dominio.Pocao;

public class PocaoTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Heroi heroi = new Heroi();
        cadastro.cadastrar(heroi, "Arthur", 100, 15, 5);

        Pocao pocaoValida = new Pocao();
        pocaoValida.nome = "Poção Pequena";
        pocaoValida.pontosCura = 20;

        Pocao pocaoGrande = new Pocao();
        pocaoGrande.nome = "Poção Grande";
        pocaoGrande.pontosCura = 50;

        Pocao pocaoInvalida = new Pocao();
        pocaoInvalida.nome = "Poção Estragada";
        pocaoInvalida.pontosCura = -15;

        System.out.println("=== CENÁRIO 1: Herói com vida completa ===");
        System.out.println("Vida: " + heroi.vida + "/" + heroi.vidaMaxima + " | Poções: " + heroi.inventario.quantidadePocoes);
        boolean r1 = heroi.usarPocao(pocaoValida);
        System.out.println("Usou poção? " + r1 + " (Esperado: false)");
        System.out.println("Vida: " + heroi.vida + "/" + heroi.vidaMaxima + " | Poções: " + heroi.inventario.quantidadePocoes);

        System.out.println("\n=== CENÁRIO 2: Herói ferido com poção disponível ===");
        heroi.receberDano(40); // Vida vai para 60/100
        System.out.println("Vida antes: " + heroi.vida + "/" + heroi.vidaMaxima + " | Poções: " + heroi.inventario.quantidadePocoes);
        boolean r2 = heroi.usarPocao(pocaoValida);
        System.out.println("Usou poção? " + r2 + " (Esperado: true)");
        System.out.println("Vida após: " + heroi.vida + "/" + heroi.vidaMaxima + " (Esperado: 80) | Poções: " + heroi.inventario.quantidadePocoes);

        System.out.println("\n=== CENÁRIO 3: Cura maior que a vida faltante (Respeita vida máxima) ===");
        System.out.println("Vida antes: " + heroi.vida + "/" + heroi.vidaMaxima + " | Poções: " + heroi.inventario.quantidadePocoes);
        boolean r3 = heroi.usarPocao(pocaoGrande); // Cura 50, mas só faltavam 20
        System.out.println("Usou poção? " + r3 + " (Esperado: true)");
        System.out.println("Vida após: " + heroi.vida + "/" + heroi.vidaMaxima + " (Esperado: 100/100) | Poções: " + heroi.inventario.quantidadePocoes);

        System.out.println("\n=== CENÁRIO 4: Inventário com zero poções ===");
        heroi.receberDano(30);
        System.out.println("Vida antes: " + heroi.vida + "/" + heroi.vidaMaxima + " | Poções: " + heroi.inventario.quantidadePocoes);
        boolean r4 = heroi.usarPocao(pocaoValida);
        System.out.println("Usou poção? " + r4 + " (Esperado: false)");
        System.out.println("Vida após: " + heroi.vida + "/" + heroi.vidaMaxima + " | Poções: " + heroi.inventario.quantidadePocoes);

        System.out.println("\n=== CENÁRIO 5: Cura inválida (Não altera a vida) ===");
        heroi.inventario.quantidadePocoes = 2; // adicionando pocoes para testar cura invalida
        System.out.println("Vida antes de cura inválida: " + heroi.vida + "/" + heroi.vidaMaxima);
        boolean r5 = heroi.usarPocao(pocaoInvalida);
        System.out.println("Usou poção inválida? " + r5 + " (Esperado: false)");
        heroi.curar(-30);
        System.out.println("Vida após chamar curar(-30): " + heroi.vida + "/" + heroi.vidaMaxima + " (Esperado: 70)");
        System.out.println("Poções restantes: " + heroi.inventario.quantidadePocoes + " (Esperado: 2)");
    }
}
