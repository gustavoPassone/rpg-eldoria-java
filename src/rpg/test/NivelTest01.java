package rpg.test;

import rpg.dominio.CadastroHeroi;
import rpg.dominio.Heroi;

public class NivelTest01 {
    public static void main(String[] args) {
        CadastroHeroi cadastro = new CadastroHeroi();
        Heroi heroi = new Heroi();
        cadastro.cadastrar(heroi, "Arthur", 100, 15, 5); // Nivel 1, XP 0, Ataque 15, VidaMax 100

        System.out.println("=== CASO 4: Experiência igual a zero ===");
        System.out.println("Antes: Nível " + heroi.nivel + " | XP: " + heroi.experiencia);
        heroi.verificarSubidaDeNivel();
        System.out.println("Depois: Nível " + heroi.nivel + " | XP: " + heroi.experiencia + " (Inalterado)");

        System.out.println("\n=== CASO 1: Experiência abaixo do necessário ===");
        heroi.experiencia += 70; // Precisa de 100
        System.out.println("Ganhou 70 XP. XP atual: " + heroi.experiencia + " (Necessário: 100)");
        heroi.verificarSubidaDeNivel();
        System.out.println("Nível: " + heroi.nivel + " (Esperado: 1) | Ataque: " + heroi.ataque + " | Vida Máx: " + heroi.vidaMaxima + " | XP restante: " + heroi.experiencia);

        System.out.println("\n=== CASO 2: Experiência exatamente igual ao necessário ===");
        heroi.experiencia += 30; // Total 100
        System.out.println("Ganhou +30 XP. XP total: " + heroi.experiencia + " (Necessário: 100)");
        heroi.verificarSubidaDeNivel();
        System.out.println("Nível: " + heroi.nivel + " (Esperado: 2) | Ataque: " + heroi.ataque + " (Esperado: 18) | Vida Máx: " + heroi.vidaMaxima + " (Esperado: 110) | XP restante: " + heroi.experiencia + " (Esperado: 0)");

        System.out.println("\n=== CASO 3: Experiência suficiente para subir dois níveis ===");
        // Nível 2 precisa de 200 XP para nível 3; Nível 3 precisa de 300 XP para nível 4.
        // Total para 2 níveis = 200 + 300 = 500 XP (+ 25 de sobra = 525 XP).
        heroi.experiencia += 525;
        System.out.println("Adicionando 525 de XP...");
        heroi.verificarSubidaDeNivel();
        System.out.println("Nível: " + heroi.nivel + " (Esperado: 4) | Ataque: " + heroi.ataque + " (Esperado: 24) | Vida Máx: " + heroi.vidaMaxima + " (Esperado: 130) | XP restante: " + heroi.experiencia + " (Esperado: 25)");
    }
}

