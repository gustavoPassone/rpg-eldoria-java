package rpg.test;

import rpg.dominio.Heroi;

public class HeroiTest02 {
    public static void main(String[] args) {
        Heroi heroiVivo = new Heroi();
        heroiVivo.nome = "Arthur";
        heroiVivo.vida = 50;

        Heroi heroiDerrotado = new Heroi();
        heroiDerrotado.nome = "Galahad";
        heroiDerrotado.vida = 0;

        System.out.println("O herói " + heroiVivo.nome + " está vivo? " + heroiVivo.estaVivo());
        System.out.println("O herói " + heroiDerrotado.nome + " está vivo? " + heroiDerrotado.estaVivo());
    }
}

