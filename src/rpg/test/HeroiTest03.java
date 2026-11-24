package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.Heroi;
import rpg.dominio.Inventario;

public class HeroiTest03 {
    public static void main(String[] args) {
        Heroi heroiComArma = new Heroi();
        heroiComArma.nome = "Arthur";
        heroiComArma.ataque = 15;

        Arma espada = new Arma();
        espada.nome = "Espada de Ferro";
        espada.bonusAtaque = 8;

        Inventario inventario = new Inventario();
        inventario.armaEquipada = espada;
        heroiComArma.inventario = inventario;

        Heroi heroiSemArma = new Heroi();
        heroiSemArma.nome = "Luna";
        heroiSemArma.ataque = 20;

        System.out.println("Herói: " + heroiComArma.nome);
        System.out.println("Ataque básico: " + heroiComArma.ataque);
        System.out.println("Arma: " + heroiComArma.inventario.armaEquipada.nome + " (+" + heroiComArma.inventario.armaEquipada.bonusAtaque + ")");
        System.out.println("Ataque total: " + heroiComArma.calcularAtaqueTotal());

        System.out.println("\nHerói: " + heroiSemArma.nome);
        System.out.println("Ataque básico: " + heroiSemArma.ataque);
        System.out.println("Arma: Nenhuma");
        System.out.println("Ataque total: " + heroiSemArma.calcularAtaqueTotal());
    }
}

