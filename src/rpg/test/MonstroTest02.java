package rpg.test;

import rpg.dominio.Monstro;

public class MonstroTest02 {
    public static void main(String[] args) {
        Monstro monstroVivo = new Monstro();
        monstroVivo.nome = "Goblin";
        monstroVivo.vida = 30;

        Monstro monstroDerrotado = new Monstro();
        monstroDerrotado.nome = "Esqueleto";
        monstroDerrotado.vida = 0;

        System.out.println("O monstro " + monstroVivo.nome + " está vivo? " + monstroVivo.estaVivo());
        System.out.println("O monstro " + monstroDerrotado.nome + " está vivo? " + monstroDerrotado.estaVivo());
    }
}

