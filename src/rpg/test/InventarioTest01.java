package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.Heroi;
import rpg.dominio.Inventario;

public class InventarioTest01 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        heroi.vida = 100;
        heroi.vidaMaxima = 100;
        heroi.ataque = 15;
        heroi.defesa = 5;

        Arma espada = new Arma();
        espada.nome = "Espada de Ferro";
        espada.bonusAtaque = 8;
        espada.preco = 60;

        Inventario inventario = new Inventario();
        inventario.armaEquipada = espada;
        inventario.quantidadePocoes = 3;

        heroi.inventario = inventario;

        System.out.println("Herói: " + heroi.nome);
        System.out.println("Arma equipada: " + heroi.inventario.armaEquipada.nome);
        System.out.println("Bônus de ataque da arma: +" + heroi.inventario.armaEquipada.bonusAtaque);
        System.out.println("Quantidade de poções: " + heroi.inventario.quantidadePocoes);
    }
}

