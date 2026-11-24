package rpg.test;

import rpg.dominio.CadastroMonstro;
import rpg.dominio.ImpressoraRPG;
import rpg.dominio.Monstro;

public class CadastroMonstroTest01 {
    public static void main(String[] args) {
        CadastroMonstro cadastro = new CadastroMonstro();
        ImpressoraRPG impressora = new ImpressoraRPG();

        Monstro goblin = new Monstro();
        cadastro.cadastrar(goblin, "Goblin", 30, 6, 1, 10, 15);

        Monstro esqueleto = new Monstro();
        cadastro.cadastrar(esqueleto, "Esqueleto", 45, 9, 2, 25, 35);

        Monstro guardiao = new Monstro();
        cadastro.cadastrar(guardiao, "Guardião Sombrio", 75, 12, 3, 50, 80);

        impressora.imprimirMonstro(goblin);
        System.out.println();
        impressora.imprimirMonstro(esqueleto);
        System.out.println();
        impressora.imprimirMonstro(guardiao);
    }
}

