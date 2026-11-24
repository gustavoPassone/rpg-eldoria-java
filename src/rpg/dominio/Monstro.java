package rpg.dominio;

public class Monstro {
    public String nome;
    public int vida;
    public int ataque;
    public int defesa;
    public int ouroRecompensa;
    public int experienciaRecompensa;

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public int calcularDano(int defesaHeroi) {
        int dano = this.ataque - defesaHeroi;
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

    public String gerarResumo() {
        return "Monstro: " + this.nome +
                " | Vida: " + this.vida +
                " | Ataque: " + this.ataque +
                " | Defesa: " + this.defesa +
                " | Recompensa: " + this.ouroRecompensa + " ouro / " + this.experienciaRecompensa + " XP";
    }
}
