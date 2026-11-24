package rpg.dominio;

public class ImpressoraRPG {

    public void imprimirHeroi(Heroi heroi) {
        if (heroi == null) {
            System.out.println("Heroi invalido (null).");
            return;
        }
        System.out.println("--- Dados do Heroi ---");
        System.out.println("Nome: " + heroi.nome);
        System.out.println("Vida: " + heroi.vida + "/" + heroi.vidaMaxima);
        System.out.println("Ataque Total: " + heroi.calcularAtaqueTotal());
        System.out.println("Defesa: " + heroi.defesa);
        System.out.println("Nivel: " + heroi.nivel);
        System.out.println("Experiencia: " + heroi.experiencia);
        System.out.println("Ouro: " + heroi.ouro);
        if (heroi.inventario != null) {
            System.out.println("Pocoes: " + heroi.inventario.quantidadePocoes);
            if (heroi.inventario.armaEquipada != null) {
                System.out.println("Arma Equipada: " + heroi.inventario.armaEquipada.nome + " (+" + heroi.inventario.armaEquipada.bonusAtaque + " de ataque)");
            } else {
                System.out.println("Arma Equipada: Nenhuma arma equipada.");
            }
        }
    }

    public void imprimirMonstro(Monstro monstro) {
        if (monstro == null) {
            System.out.println("Monstro invalido (null).");
            return;
        }
        System.out.println("--- Dados do Monstro ---");
        System.out.println("Nome: " + monstro.nome);
        System.out.println("Vida: " + monstro.vida);
        System.out.println("Ataque: " + monstro.ataque);
        System.out.println("Defesa: " + monstro.defesa);
        System.out.println("Ouro de Recompensa: " + monstro.ouroRecompensa);
        System.out.println("Experiencia de Recompensa: " + monstro.experienciaRecompensa);
    }

    public void imprimirInventario(Heroi heroi) {
        if (heroi == null) {
            System.out.println("Heroi invalido (null).");
            return;
        }
        System.out.println("--- Inventario do Heroi ---");
        System.out.println("Nome: " + heroi.nome);
        if (heroi.inventario != null && heroi.inventario.armaEquipada != null) {
            System.out.println("Arma equipada: " + heroi.inventario.armaEquipada.nome +
                    " (+" + heroi.inventario.armaEquipada.bonusAtaque + " de ataque)");
        } else {
            System.out.println("Arma equipada: Nenhuma arma equipada.");
        }
        int pocoes = (heroi.inventario != null) ? heroi.inventario.quantidadePocoes : 0;
        System.out.println("Quantidade de pocoes: " + pocoes);
        System.out.println("Ouro disponivel: " + heroi.ouro + " de ouro");
    }
}
