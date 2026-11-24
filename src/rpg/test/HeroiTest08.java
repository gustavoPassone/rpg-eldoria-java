package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;
import rpg.dominio.Pocao;

public class HeroiTest08 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Heroi arthur = new Heroi();
        cadastro.cadastrar(arthur, "Arthur", 100, 15, 5);

        Pocao pocaoPequena = new Pocao();
        pocaoPequena.nome = "Poção Pequena";
        pocaoPequena.pontosCura = 20;

        System.out.println("Tentando usar poção com vida cheia (" + arthur.vida + "/" + arthur.vidaMaxima + ")...");
        boolean usouComVidaCheia = arthur.usarPocao(pocaoPequena);
        System.out.println("Poção usada? " + usouComVidaCheia);

        System.out.println("\nHerói sofre 40 de dano...");
        arthur.receberDano(40);
        System.out.println("Vida atual: " + arthur.vida + "/" + arthur.vidaMaxima);
        System.out.println("Poções disponíveis: " + arthur.inventario.quantidadePocoes);

        System.out.println("\nUsando poção ferido...");
        boolean usouFerido = arthur.usarPocao(pocaoPequena);
        System.out.println("Poção usada? " + usouFerido);
        System.out.println("Vida após uso: " + arthur.vida + "/" + arthur.vidaMaxima);
        System.out.println("Poções restantes: " + arthur.inventario.quantidadePocoes);

        System.out.println("\nGastando a última poção...");
        arthur.receberDano(30);
        arthur.usarPocao(pocaoPequena);
        System.out.println("Poções restantes: " + arthur.inventario.quantidadePocoes);

        System.out.println("\nTentando usar poção com inventário zerado...");
        arthur.receberDano(10);
        boolean usouSemPocao = arthur.usarPocao(pocaoPequena);
        System.out.println("Poção usada? " + usouSemPocao);
    }
}

