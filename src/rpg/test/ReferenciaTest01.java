package rpg.test;

import rpg.dominio.*;

public class ReferenciaTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();
        Batalha batalha = new Batalha();

        Heroi heroi = new Heroi();
        cadastroHeroi.cadastrar(heroi, "Arthur", 100, 15, 5);

        Monstro monstroOriginal = new Monstro();
        cadastroMonstro.cadastrar(monstroOriginal, "Goblin", 30, 6, 1, 10, 15);

        System.out.println("=== 1. Passagem de Parâmetros por Referência ===");
        System.out.println("Vida do monstro antes do ataque: " + monstroOriginal.vida);
        batalha.atacarComHeroi(heroi, monstroOriginal);
        System.out.println("Vida do monstro original após ataque no método da Batalha: " + monstroOriginal.vida);
        System.out.println("Comprovação: O objeto original na memória foi modificado pelo método.");

        System.out.println("\n=== 2. Duas Referências para o Mesmo Objeto ===");
        Monstro mesmaReferencia = monstroOriginal;
        System.out.println("Vida via 'monstroOriginal': " + monstroOriginal.vida);
        System.out.println("Vida via 'mesmaReferencia': " + mesmaReferencia.vida);

        System.out.println("\nAplicando dano diretamente através da segunda referência ('mesmaReferencia')...");
        mesmaReferencia.receberDano(5);

        System.out.println("Vida vista por 'monstroOriginal': " + monstroOriginal.vida);
        System.out.println("Vida vista por 'mesmaReferencia': " + mesmaReferencia.vida);
        System.out.println("As duas variáveis apontam para o mesmo objeto na memória heap? " + (monstroOriginal == mesmaReferencia));
    }
}

