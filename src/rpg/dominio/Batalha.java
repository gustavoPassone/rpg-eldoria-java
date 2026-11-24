package rpg.dominio;

import java.util.Scanner;

public class Batalha {
    public boolean recompensaEntregue;

    public void atacarComHeroi(Heroi heroi, Monstro monstro) {
        if (heroi == null || monstro == null) {
            return;
        }
        if (!heroi.estaVivo() || !monstro.estaVivo()) {
            System.out.println("O ataque nao pode ocorrer pois um dos personagens nao esta vivo.");
            return;
        }
        int dano = heroi.calcularDano(monstro.defesa);
        monstro.receberDano(dano);
        System.out.println(heroi.nome + " atacou " + monstro.nome + " causando " + dano + " de dano!");
    }

    public void atacarComMonstro(Monstro monstro, Heroi heroi) {
        if (monstro == null || heroi == null) {
            return;
        }
        if (!monstro.estaVivo() || !heroi.estaVivo()) {
            System.out.println("O contra-ataque nao pode ocorrer pois um dos personagens nao esta vivo.");
            return;
        }
        int dano = monstro.calcularDano(heroi.defesa);
        heroi.receberDano(dano);
        System.out.println(monstro.nome + " contra-atacou " + heroi.nome + " causando " + dano + " de dano!");
    }

    public void entregarRecompensa(Heroi heroi, Monstro monstro) {
        if (heroi == null || monstro == null) {
            return;
        }
        if (!monstro.estaVivo() && heroi.estaVivo()) {
            if (!this.recompensaEntregue) {
                heroi.receberRecompensa(monstro);
                this.recompensaEntregue = true;
                System.out.println("Vitoria de " + heroi.nome + "! Recompensa recebida: +" +
                        monstro.ouroRecompensa + " de ouro e +" + monstro.experienciaRecompensa + " de XP!");
            } else {
                System.out.println("A recompensa desta batalha ja foi entregue anteriormente.");
            }
        }
    }

    public void executarTurno(Heroi heroi, Monstro monstro) {
        if (heroi == null || monstro == null) {
            return;
        }
        if (!heroi.estaVivo()) {
            System.out.println(heroi.nome + " esta derrotado e nao pode lutar.");
            return;
        }
        if (!monstro.estaVivo()) {
            System.out.println(monstro.nome + " ja foi derrotado.");
            return;
        }

        this.atacarComHeroi(heroi, monstro);

        if (monstro.estaVivo()) {
            this.atacarComMonstro(monstro, heroi);
        } else {
            System.out.println(monstro.nome + " foi derrotado!");
            this.entregarRecompensa(heroi, monstro);
        }

        System.out.println("[Status] " + heroi.nome + " HP: " + heroi.vida + "/" + heroi.vidaMaxima +
                " | " + monstro.nome + " HP: " + monstro.vida);
    }

    public boolean iniciarBatalha(Heroi heroi, Monstro monstro, Pocao pocao, Scanner scanner) {
        if (heroi == null || monstro == null) {
            return false;
        }
        this.recompensaEntregue = false;
        System.out.println("\n========================================");
        System.out.println("   BATALHA INICIADA: " + heroi.nome + " VS " + monstro.nome);
        System.out.println("========================================");

        while (heroi.estaVivo() && monstro.estaVivo()) {
            System.out.println("\n" + heroi.nome + " [HP: " + heroi.vida + "/" + heroi.vidaMaxima +
                    " | Pocoes: " + (heroi.inventario != null ? heroi.inventario.quantidadePocoes : 0) + "]");
            System.out.println(monstro.nome + " [HP: " + monstro.vida + "]");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar pocao");
            System.out.println("3 - Fugir");
            System.out.print("Escolha uma acao: ");

            int escolha;
            try {
                String linha = scanner.nextLine().trim();
                escolha = Integer.parseInt(linha);
            } catch (Exception e) {
                System.out.println("Opcao invalida! Digite 1, 2 ou 3.");
                continue;
            }

            boolean acaoValida = false;
            switch (escolha) {
                case 1:
                    this.atacarComHeroi(heroi, monstro);
                    acaoValida = true;
                    break;
                case 2:
                    if (pocao == null) {
                        pocao = new Pocao();
                        pocao.nome = "Pocao Padrao";
                        pocao.pontosCura = 25;
                    }
                    if (heroi.usarPocao(pocao)) {
                        System.out.println(heroi.nome + " usou uma " + pocao.nome + " e recuperou " + pocao.pontosCura + " de vida!");
                        System.out.println("Vida atual: " + heroi.vida + "/" + heroi.vidaMaxima);
                        acaoValida = true;
                    } else {
                        System.out.println("Nao foi possivel usar pocao! (Sem pocoes ou vida ja cheia).");
                    }
                    break;
                case 3:
                    System.out.println(heroi.nome + " fugiu da batalha!");
                    return false;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }

            if (acaoValida && monstro.estaVivo()) {
                this.atacarComMonstro(monstro, heroi);
            }
        }

        if (heroi.estaVivo() && !monstro.estaVivo()) {
            System.out.println("\n" + monstro.nome + " foi derrotado!");
            this.entregarRecompensa(heroi, monstro);
            return true;
        } else {
            System.out.println("\n" + heroi.nome + " foi derrotado em combate...");
            return false;
        }
    }
}
