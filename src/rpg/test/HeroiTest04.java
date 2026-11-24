package rpg.test;

import rpg.dominio.Heroi;

public class HeroiTest04 {
    public static void main(String[] args) {
        Heroi heroi = new Heroi();
        heroi.nome = "Arthur";
        heroi.ataque = 15;

        int defesaInimigo1 = 3;
        int danoCausado1 = heroi.calcularDano(defesaInimigo1);
        System.out.println("Herói: " + heroi.nome + " | Ataque total: " + heroi.calcularAtaqueTotal());
        System.out.println("Contra inimigo com defesa " + defesaInimigo1 + " -> Dano calculado: " + danoCausado1);

        int defesaInimigo2 = 20;
        int danoCausado2 = heroi.calcularDano(defesaInimigo2);
        System.out.println("Contra inimigo com defesa " + defesaInimigo2 + " -> Dano calculado (mínimo 1): " + danoCausado2);
    }
}

