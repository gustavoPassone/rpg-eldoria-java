package rpg.dominio;

import java.util.Scanner;

public class Jogo {
    public String titulo;
    public Heroi heroi;
    public boolean emExecucao;
    public Fase[] fases;
    public int faseAtual;

    public void configurar(Heroi heroi, Fase[] fases) {
        this.titulo = "RPG - Eldoria: A Jornada de Eldoria";
        this.heroi = heroi;
        this.fases = fases;
        this.faseAtual = 0;
        this.emExecucao = true;
    }

    public void exibirBoasVindas() {
        System.out.println("==================================================");
        System.out.println("      BEM-VINDO AO RPG: A JORNADA DE ELDORIA!     ");
        System.out.println("==================================================");
        System.out.println("O outrora pacífico Reino de Eldoria está sob ataque.");
        System.out.println("Criaturas sombrias invadiram as florestas, cavernas e castelo.");
        System.out.println("Herói " + (this.heroi != null ? this.heroi.nome : "Viajante") + ", sua missão é derrotar as criaturas");
        System.out.println("e eliminar o terrível Guardião Sombrio no Castelo das Sombras!");
        System.out.println("==================================================");
    }

    public void exibirMenu() {
        System.out.println("\n================================");
        System.out.println("       RPG - ELDORIA");
        System.out.println("================================");
        System.out.println("1 - Ver status do herói");
        System.out.println("2 - Explorar / Lutar");
        System.out.println("3 - Abrir inventário");
        System.out.println("4 - Visitar loja");
        System.out.println("5 - Sair do jogo");
        System.out.print("\nEscolha uma opção: ");
    }

    public int lerOpcao(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextLine()) {
                return -1;
            }
            try {
                String linha = scanner.nextLine().trim();
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                System.out.print("Tente novamente: ");
            }
        }
    }

    public void abrirInventario(Scanner scanner) {
        ImpressoraRPG impressora = new ImpressoraRPG();
        impressora.imprimirInventario(this.heroi);
        System.out.println("\n1 - Usar poção");
        System.out.println("2 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        int op = this.lerOpcao(scanner);
        if (op == 1) {
            Pocao pocao = new Pocao();
            pocao.nome = "Poção";
            pocao.pontosCura = 25;
            if (this.heroi.usarPocao(pocao)) {
                System.out.println("Poção utilizada com sucesso! Vida atual: " + this.heroi.vida + "/" + this.heroi.vidaMaxima);
            } else {
                System.out.println("Não foi possível usar a poção (sem poções ou vida cheia).");
            }
        }
    }

    public void abrirLoja(Scanner scanner) {
        Loja loja = new Loja();
        boolean naLoja = true;
        while (naLoja) {
            System.out.println("\n=================================");
            System.out.println("        LOJA DE ELDORIA          ");
            System.out.println("=================================");
            System.out.println("Seu Ouro: " + this.heroi.ouro);
            System.out.println("1 - Poção Pequena (+20 cura) - 10 de ouro");
            System.out.println("2 - Poção Grande (+50 cura) - 25 de ouro");
            System.out.println("3 - Espada de Madeira (+2 atk) - 15 de ouro");
            System.out.println("4 - Espada de Ferro (+8 atk) - 40 de ouro");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int op = this.lerOpcao(scanner);
            switch (op) {
                case 1:
                    Pocao pPequena = new Pocao();
                    pPequena.nome = "Poção Pequena";
                    pPequena.pontosCura = 20;
                    pPequena.preco = 10;
                    loja.comprarPocao(this.heroi, pPequena);
                    break;
                case 2:
                    Pocao pGrande = new Pocao();
                    pGrande.nome = "Poção Grande";
                    pGrande.pontosCura = 50;
                    pGrande.preco = 25;
                    loja.comprarPocao(this.heroi, pGrande);
                    break;
                case 3:
                    Arma espadaMadeira = new Arma();
                    espadaMadeira.nome = "Espada de Madeira";
                    espadaMadeira.bonusAtaque = 2;
                    espadaMadeira.preco = 15;
                    loja.comprarArma(this.heroi, espadaMadeira);
                    break;
                case 4:
                    Arma espadaFerro = new Arma();
                    espadaFerro.nome = "Espada de Ferro";
                    espadaFerro.bonusAtaque = 8;
                    espadaFerro.preco = 40;
                    loja.comprarArma(this.heroi, espadaFerro);
                    break;
                case 5:
                    naLoja = false;
                    break;
                default:
                    System.out.println("Opção inexistente (" + op + ")! Escolha uma opção entre 1 e 5.");
            }
        }
    }

    public void exibirMensagemVitoria() {
        System.out.println("\n=====================================");
        System.out.println("           PARABÉNS, HERÓI!          ");
        System.out.println("=====================================");
        System.out.println("\nVocê derrotou o Guardião Sombrio!\n");
        System.out.println("O Reino de Eldoria foi salvo!\n");
        System.out.println("Obrigado por jogar.");
        System.out.println("=====================================");
    }

    public void exibirMensagemDerrota() {
        System.out.println("\n=====================================");
        System.out.println("             GAME OVER               ");
        System.out.println("=====================================");
        System.out.println("\nSeu herói foi derrotado.\n");
        System.out.println("Sua jornada terminou...");
        System.out.println("=====================================");
    }

    public void avancarFase() {
        if (this.fases == null || this.faseAtual >= this.fases.length) {
            return;
        }
        Fase fase = this.fases[this.faseAtual];
        fase.concluida = true;
        this.heroi.verificarSubidaDeNivel();
        this.faseAtual++;

        if (this.faseAtual >= this.fases.length) {
            this.exibirMensagemVitoria();
            this.emExecucao = false;
        } else {
            System.out.println("\nFase concluída com sucesso! Próxima fase desbloqueada: " + this.fases[this.faseAtual].nome);
        }
    }

    public void explorar(Scanner scanner) {
        if (this.fases == null || this.faseAtual >= this.fases.length) {
            System.out.println("Todas as fases de Eldoria já foram concluídas!");
            return;
        }
        Fase fase = this.fases[this.faseAtual];
        if (fase.concluida) {
            System.out.println("A fase " + fase.nome + " já foi superada.");
            return;
        }

        System.out.println("\nVocê está explorando: " + fase.nome + "!");
        System.out.println("Inimigo avistado: " + fase.inimigo.nome + "!");

        Batalha batalha = new Batalha();
        Pocao pocaoBatalha = new Pocao();
        pocaoBatalha.nome = "Poção";
        pocaoBatalha.pontosCura = 25;

        boolean venceu = batalha.iniciarBatalha(this.heroi, fase.inimigo, pocaoBatalha, scanner);
        if (venceu) {
            this.avancarFase();
        } else if (!this.heroi.estaVivo()) {
            this.exibirMensagemDerrota();
            this.emExecucao = false;
        }
    }

    public void executarOpcao(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1:
                ImpressoraRPG impressora = new ImpressoraRPG();
                impressora.imprimirHeroi(this.heroi);
                break;
            case 2:
                this.explorar(scanner);
                break;
            case 3:
                this.abrirInventario(scanner);
                break;
            case 4:
                this.abrirLoja(scanner);
                break;
            case 5:
                System.out.println("Saindo do Reino de Eldoria... Até a próxima jornada!");
                this.emExecucao = false;
                break;
            default:
                System.out.println("Opção inexistente (" + opcao + ")! Escolha uma opção entre 1 e 5.");
        }
    }

    public void iniciar(Scanner scanner) {
        this.exibirBoasVindas();
        while (this.emExecucao && this.heroi.estaVivo()) {
            this.exibirMenu();
            int opcao = this.lerOpcao(scanner);
            this.executarOpcao(opcao, scanner);
        }
    }
}
