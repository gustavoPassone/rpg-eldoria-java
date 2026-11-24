package rpg.dominio;

public class Heroi {
    public String nome;
    public int vida;
    public int vidaMaxima;
    public int ataque;
    public int defesa;
    public int nivel;
    public int experiencia;
    public int ouro;
    public Inventario inventario;

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public int calcularAtaqueTotal() {
        int bonus = 0;
        if (this.inventario != null && this.inventario.armaEquipada != null) {
            bonus = this.inventario.armaEquipada.bonusAtaque;
        }
        return this.ataque + bonus;
    }

    public int calcularDano(int defesaInimigo) {
        int dano = this.calcularAtaqueTotal() - defesaInimigo;
        if (dano < 1) {
            return 1;
        }
        return dano;
    }

    public void receberDano(int dano) {
        if (dano <= 0) {
            return;
        }
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public void curar(int pontosDeCura) {
        if (pontosDeCura <= 0) {
            return;
        }
        this.vida += pontosDeCura;
        if (this.vida > this.vidaMaxima) {
            this.vida = this.vidaMaxima;
        }
    }

    public boolean usarPocao(Pocao pocao) {
        if (pocao == null || pocao.pontosCura <= 0) {
            return false;
        }
        if (this.inventario == null || this.inventario.quantidadePocoes <= 0) {
            return false;
        }
        if (this.vida >= this.vidaMaxima) {
            return false;
        }
        this.curar(pocao.pontosCura);
        this.inventario.quantidadePocoes--;
        return true;
    }

    public void receberRecompensa(Monstro monstro) {
        if (monstro == null) {
            return;
        }
        this.ouro += monstro.ouroRecompensa;
        this.experiencia += monstro.experienciaRecompensa;
    }

    public void verificarSubidaDeNivel() {
        while (this.experiencia >= this.nivel * 100) {
            int xpNecessaria = this.nivel * 100;
            this.experiencia -= xpNecessaria;
            this.nivel++;
            this.ataque += 3;
            this.vidaMaxima += 10;
            this.vida = this.vidaMaxima;
            System.out.println("\n*** SUBIDA DE NIVEL! ***");
            System.out.println(this.nome + " alcancou o Nivel " + this.nivel + "!");
            System.out.println("Ataque base aumentado em +3! (Novo ataque: " + this.ataque + ")");
            System.out.println("Vida maxima aumentada em +10! (Nova vida maxima: " + this.vidaMaxima + ")");
            System.out.println("Vida restaurada ao maximo: " + this.vida + "/" + this.vidaMaxima);
            System.out.println("XP restante: " + this.experiencia);
        }
    }

    public String gerarResumo() {
        return "Heroi: " + this.nome +
                " | Vida: " + this.vida + "/" + this.vidaMaxima +
                " | Ataque Total: " + this.calcularAtaqueTotal() +
                " | Defesa: " + this.defesa +
                " | Nivel: " + this.nivel;
    }
}
