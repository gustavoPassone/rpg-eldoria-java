package rpg.test;

import rpg.dominio.Arma;
import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;
import rpg.dominio.Loja;

public class LojaTest02 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Loja loja = new Loja();

        Heroi arthur = new Heroi();
        cadastro.cadastrar(arthur, "Arthur", 100, 15, 5);
        arthur.ouro = 50; // Ajustando saldo para permitir a compra

        Arma espadaFerro = new Arma();
        espadaFerro.nome = "Espada de Ferro";
        espadaFerro.bonusAtaque = 8;
        espadaFerro.preco = 40;

        System.out.println("--- Antes da Compra ---");
        System.out.println("Herói: " + arthur.nome);
        System.out.println("Ataque total: " + arthur.calcularAtaqueTotal());
        System.out.println("Ouro disponível: " + arthur.ouro);

        System.out.println("\nComprando arma...");
        boolean sucesso = loja.comprarArma(arthur, espadaFerro);

        System.out.println("\n--- Depois da Compra ---");
        System.out.println("Compra efetuada? " + sucesso);
        System.out.println("Arma equipada: " + arthur.inventario.armaEquipada.nome);
        System.out.println("Ataque total: " + arthur.calcularAtaqueTotal());
        System.out.println("Ouro restante: " + arthur.ouro);
    }
}

