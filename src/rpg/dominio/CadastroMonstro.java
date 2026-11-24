package rpg.dominio;

public class CadastroMonstro {

    public void cadastrar(Monstro monstro, String nome, int vida, int ataque, int defesa, int ouroRecompensa, int experienciaRecompensa) {
        if (monstro == null) {
            return;
        }
        monstro.nome = nome;
        monstro.vida = vida;
        monstro.ataque = ataque;
        monstro.defesa = defesa;
        monstro.ouroRecompensa = ouroRecompensa;
        monstro.experienciaRecompensa = experienciaRecompensa;
    }
}

