package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.Heroi;
import rpg.dominio.Inventario;

public class HeroiTest07 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        heroi.vida = 100;
        heroi.vidaMaxima = 100;
        heroi.ataque = 15;
        heroi.defesa = 5;
        heroi.nivel = 1;

        Arma espada = new Arma();
        espada.nome = "Espada Longa";
        espada.bonusAtaque = 10;

        Inventario inventario = new Inventario();
        inventario.armaEquipada = espada;
        heroi.inventario = inventario;

        // Guardando a String retornada em uma variável antes de imprimir
        String resumoDoHeroi = heroi.gerarResumo();

        System.out.println("Resumo obtido pelo método:");
        System.out.println(resumoDoHeroi);
    }
}

