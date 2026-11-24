package rpg.test;

import rpg.dominio.Monstro;

public class MonstroTest05 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.vida = 30;
        goblin.ataque = 6;
        goblin.defesa = 1;
        goblin.ouroRecompensa = 10;
        goblin.experienciaRecompensa = 15;

        Monstro esqueleto = new Monstro();
        esqueleto.nome = "Esqueleto";
        esqueleto.vida = 45;
        esqueleto.ataque = 9;
        esqueleto.defesa = 2;
        esqueleto.ouroRecompensa = 25;
        esqueleto.experienciaRecompensa = 35;

        Monstro guardiaoSombrio = new Monstro();
        guardiaoSombrio.nome = "Guardião Sombrio";
        guardiaoSombrio.vida = 75;
        guardiaoSombrio.ataque = 12;
        guardiaoSombrio.defesa = 3;
        guardiaoSombrio.ouroRecompensa = 50;
        guardiaoSombrio.experienciaRecompensa = 80;

        String resumoGoblin = goblin.gerarResumo();
        String resumoEsqueleto = esqueleto.gerarResumo();
        String resumoGuardiao = guardiaoSombrio.gerarResumo();

        System.out.println(resumoGoblin);
        System.out.println(resumoEsqueleto);
        System.out.println(resumoGuardiao);
    }
}

