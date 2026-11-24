package rpg.test;

import rpg.dominio.*;

public class ImpressoraRPGTest01 {
    public static void main(String[] args) {
        ImpressoraRPG impressora = new ImpressoraRPG();

        Heroi heroi1 = new Heroi();
        heroi1.nome = "Arthur";
        heroi1.vida = 100;
        heroi1.vidaMaxima = 100;
        heroi1.ataque = 15;
        heroi1.defesa = 5;
        heroi1.nivel = 1;
        heroi1.experiencia = 0;
        heroi1.ouro = 50;
        Inventario inv1 = new Inventario();
        inv1.quantidadePocoes = 2;
        Arma espada = new Arma();
        espada.nome = "Espada de Ferro";
        espada.bonusAtaque = 8;
        inv1.armaEquipada = espada;
        heroi1.inventario = inv1;

        Heroi heroi2 = new Heroi();
        heroi2.nome = "Luna";
        heroi2.vida = 80;
        heroi2.vidaMaxima = 80;
        heroi2.ataque = 20;
        heroi2.defesa = 3;
        heroi2.nivel = 1;
        heroi2.experiencia = 0;
        heroi2.ouro = 30;

        Monstro monstro1 = new Monstro();
        monstro1.nome = "Goblin";
        monstro1.vida = 30;
        monstro1.ataque = 6;
        monstro1.defesa = 1;
        monstro1.ouroRecompensa = 10;
        monstro1.experienciaRecompensa = 15;

        Monstro monstro2 = new Monstro();
        monstro2.nome = "Guardião Sombrio";
        monstro2.vida = 75;
        monstro2.ataque = 12;
        monstro2.defesa = 3;
        monstro2.ouroRecompensa = 50;
        monstro2.experienciaRecompensa = 80;

        impressora.imprimirHeroi(heroi1);
        System.out.println();
        impressora.imprimirHeroi(heroi2);
        System.out.println();
        impressora.imprimirMonstro(monstro1);
        System.out.println();
        impressora.imprimirMonstro(monstro2);
    }
}

