package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;
import rpg.dominio.ImpressoraRPG;

public class InventarioTest02 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        ImpressoraRPG impressora = new ImpressoraRPG();

        Heroi heroiSemArma = new Heroi();
        cadastro.cadastrar(heroiSemArma, "Arthur", 100, 15, 5);

        System.out.println("=== Teste 1: Herói sem arma equipada ===");
        impressora.imprimirInventario(heroiSemArma);

        System.out.println("\n=== Teste 2: Herói com arma equipada ===");
        Arma machado = new Arma();
        machado.nome = "Machado de Batalha";
        machado.bonusAtaque = 12;
        machado.preco = 50;
        heroiSemArma.inventario.armaEquipada = machado;
        impressora.imprimirInventario(heroiSemArma);

        System.out.println("\n=== Teste 3: Herói com inventário nulo (Sem NullPointerException) ===");
        Heroi heroiInventarioNulo = new Heroi();
        heroiInventarioNulo.nome = "Viajante Desconhecido";
        heroiInventarioNulo.ouro = 5;
        heroiInventarioNulo.inventario = null;
        impressora.imprimirInventario(heroiInventarioNulo);
    }
}

