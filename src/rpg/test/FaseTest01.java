package rpg.test;

import rpg.dominio.Fase;
import rpg.dominio.Monstro;

public class FaseTest01 {
    public static void main(String[] args) {
        Monstro goblin = new Monstro();
        goblin.nome = "Goblin";
        goblin.vida = 30;
        goblin.ataque = 6;
        goblin.defesa = 1;
        goblin.ouroRecompensa = 10;
        goblin.experienciaRecompensa = 15;

        Fase fase = new Fase();
        fase.nome = "Floresta Sombria";
        fase.inimigo = goblin;
        fase.concluida = false;

        System.out.println("Fase: " + fase.nome);
        System.out.println("Monstro encontrado: " + fase.inimigo.nome);
        System.out.println("Vida do monstro: " + fase.inimigo.vida);
        System.out.println("Status de conclusão: " + (fase.concluida ? "Concluída" : "Não concluída"));
    }
}

