package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;

public class HeroiTest09 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Heroi arthur = new Heroi();
        cadastro.cadastrar(arthur, "Arthur", 100, 15, 5);

        System.out.println("=== Dados Iniciais ===");
        System.out.println(arthur.gerarResumo());
        System.out.println("XP atual: " + arthur.experiencia);

        System.out.println("\n--- Adicionando 120 de XP (Necessário para Nível 2: 100) ---");
        arthur.experiencia += 120;
        arthur.receberDano(40); // Ferido antes de subir de nível para testar a recuperação
        System.out.println("Vida antes da verificação: " + arthur.vida + "/" + arthur.vidaMaxima);
        arthur.verificarSubidaDeNivel();

        System.out.println("\n--- Status Após 1 Subida de Nível ---");
        System.out.println(arthur.gerarResumo());
        System.out.println("XP restante: " + arthur.experiencia);

        System.out.println("\n--- Adicionando 550 de XP (Necessário para Nível 3: 200, Nível 4: 300) ---");
        arthur.experiencia += 550;
        arthur.verificarSubidaDeNivel();

        System.out.println("\n--- Status Final Após Múltiplas Subidas ---");
        System.out.println(arthur.gerarResumo());
        System.out.println("XP restante: " + arthur.experiencia);
    }
}

