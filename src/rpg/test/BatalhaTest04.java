package rpg.test;

import rpg.dominio.*;

public class BatalhaTest04 {
    public static void main(String[] args) {
        CadastroHeroi cadastroHeroi = new CadastroHeroi();
        CadastroMonstro cadastroMonstro = new CadastroMonstro();
        Batalha batalha = new Batalha();

        Heroi arthur = new Heroi();
        cadastroHeroi.cadastrar(arthur, "Arthur", 100, 20, 5); // Ouro inicial = 30, XP = 0

        Monstro goblin = new Monstro();
        cadastroMonstro.cadastrar(goblin, "Goblin", 25, 5, 2, 15, 20);

        System.out.println("=== Dados Iniciais de " + arthur.nome + " ===");
        System.out.println("Ouro: " + arthur.ouro + " | Experiência: " + arthur.experiencia);

        System.out.println("\n=== Executando Batalha até a Vitória ===");
        while (arthur.estaVivo() && goblin.estaVivo()) {
            batalha.executarTurno(arthur, goblin);
        }

        System.out.println("\n=== Dados de " + arthur.nome + " Após a Vitória ===");
        System.out.println("Ouro: " + arthur.ouro + " (Esperado: 30 + 15 = 45)");
        System.out.println("Experiência: " + arthur.experiencia + " (Esperado: 0 + 20 = 20)");

        System.out.println("\n=== Tentando entregar recompensa novamente para a mesma vitória ===");
        batalha.entregarRecompensa(arthur, goblin);

        System.out.println("\n=== Dados Finais de " + arthur.nome + " (Não deve ter duplicado) ===");
        System.out.println("Ouro: " + arthur.ouro);
        System.out.println("Experiência: " + arthur.experiencia);
    }
}

