package rpg.test;

import rpg.dominio.Batalha;
import rpg.dominio.Heroi;
import rpg.dominio.Monstro;

public class BatalhaTest01 {
    public static void main(String[] args) {
        Batalha batalha = new Batalha();

        System.out.println("=== CASO 1: Batalha Normal (Herói 100 HP, Monstro 30 HP) ===");
        Heroi h1 = new Heroi();
        h1.nome = "Arthur";
        h1.vida = 100;
        h1.vidaMaxima = 100;
        h1.ataque = 15;
        h1.defesa = 5;

        Monstro m1 = new Monstro();
        m1.nome = "Goblin";
        m1.vida = 30;
        m1.ataque = 8;
        m1.defesa = 2;

        batalha.atacarComHeroi(h1, m1);
        batalha.atacarComMonstro(m1, h1);
        System.out.println("Resultado: Herói HP: " + h1.vida + " | Monstro HP: " + m1.vida);

        System.out.println("\n=== CASO 2: Herói pode ser derrotado (Herói 1 HP, Monstro 30 HP) ===");
        Heroi h2 = new Heroi();
        h2.nome = "Arthur Ferido";
        h2.vida = 1;
        h2.vidaMaxima = 100;
        h2.defesa = 2;

        Monstro m2 = new Monstro();
        m2.nome = "Goblin";
        m2.vida = 30;
        m2.ataque = 10;

        batalha.atacarComMonstro(m2, h2);
        System.out.println("Herói está vivo? " + h2.estaVivo() + " | Vida do herói (mínimo 0): " + h2.vida);

        System.out.println("\n=== CASO 3: Monstro pode ser derrotado (Herói 100 HP, Monstro 1 HP) ===");
        Heroi h3 = new Heroi();
        h3.nome = "Arthur";
        h3.vida = 100;
        h3.vidaMaxima = 100;
        h3.ataque = 20;

        Monstro m3 = new Monstro();
        m3.nome = "Goblin Fraco";
        m3.vida = 1;
        m3.defesa = 1;

        batalha.atacarComHeroi(h3, m3);
        System.out.println("Monstro está vivo? " + m3.estaVivo() + " | Vida do monstro (mínimo 0): " + m3.vida);

        System.out.println("\n=== CASO 4: Herói morto não pode atacar (Herói 0 HP, Monstro 30 HP) ===");
        Heroi h4 = new Heroi();
        h4.nome = "Arthur Caído";
        h4.vida = 0;
        h4.ataque = 15;

        Monstro m4 = new Monstro();
        m4.nome = "Goblin";
        m4.vida = 30;
        m4.defesa = 2;

        batalha.atacarComHeroi(h4, m4);
        System.out.println("Vida do monstro permaneceu intacta: " + m4.vida);

        System.out.println("\n=== CASO 5: Monstro morto não pode atacar (Herói 100 HP, Monstro 0 HP) ===");
        Heroi h5 = new Heroi();
        h5.nome = "Arthur";
        h5.vida = 100;
        h5.defesa = 5;

        Monstro m5 = new Monstro();
        m5.nome = "Goblin Morto";
        m5.vida = 0;
        m5.ataque = 10;

        batalha.atacarComMonstro(m5, h5);
        System.out.println("Vida do herói permaneceu intacta: " + h5.vida);

        System.out.println("\n=== CASO 6: Verificação de dano mínimo (nunca negativo) ===");
        Heroi h6 = new Heroi();
        h6.nome = "Arthur Fraco";
        h6.ataque = 2;
        int danoCalculado = h6.calcularDano(50); // defesa do monstro = 50
        System.out.println("Ataque 2 contra defesa 50 -> Dano: " + danoCalculado + " (Esperado: >= 1)");
    }
}
