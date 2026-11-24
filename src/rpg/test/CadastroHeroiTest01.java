package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;
import rpg.dominio.ImpressoraRPG;

public class CadastroHeroiTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        ImpressoraRPG impressora = new ImpressoraRPG();

        Heroi arthur = new Heroi();
        cadastro.cadastrar(arthur, "Arthur", 100, 15, 5);

        Heroi luna = new Heroi();
        cadastro.cadastrar(luna, "Luna", 80, 20, 3);

        impressora.imprimirHeroi(arthur);
        System.out.println();
        impressora.imprimirHeroi(luna);
    }
}

