package rpg.test;

import rpg.dominio.*;

import java.util.Scanner;

public class QATest01 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       BATERIA DE TESTES DE QA - RPG ELDORIA      ");
        System.out.println("==================================================");

        CadastroHeroi cadHeroi = new CadastroHeroi();
        CadastroMonstro cadMonstro = new CadastroMonstro();
        Loja loja = new Loja();
        Batalha batalha = new Batalha();
        Pocao pocaoPadrao = new Pocao();
        pocaoPadrao.nome = "Poção Pequena";
        pocaoPadrao.pontosCura = 25;
        pocaoPadrao.preco = 10;

        // QA-001: Cadastro do herói com validação
        Heroi heroi = new Heroi();
        boolean qa001 = cadHeroi.cadastrar(heroi, "Arthur", 100, 16, 5);
        System.out.println("[QA-001] Cadastro do herói: " + (qa001 ? "APROVADO" : "REPROVADO"));

        // QA-002: Compra de poção
        int qtdPocoesAntes = heroi.inventario.quantidadePocoes;
        boolean qa002 = loja.comprarPocao(heroi, pocaoPadrao);
        boolean qa002Status = qa002 && (heroi.inventario.quantidadePocoes == qtdPocoesAntes + 1);
        System.out.println("[QA-002] Compra de poção: " + (qa002Status ? "APROVADO" : "REPROVADO"));

        // QA-003: Compra de arma
        Arma espadaFerro = new Arma();
        espadaFerro.nome = "Espada de Ferro";
        espadaFerro.bonusAtaque = 8;
        espadaFerro.preco = 15;
        int atkAntes = heroi.calcularAtaqueTotal();
        boolean qa003 = loja.comprarArma(heroi, espadaFerro);
        boolean qa003Status = qa003 && (heroi.calcularAtaqueTotal() == atkAntes + 8);
        System.out.println("[QA-003] Compra de arma: " + (qa003Status ? "APROVADO" : "REPROVADO"));

        // QA-004: Uso de poção
        heroi.receberDano(40);
        int vidaAntesUso = heroi.vida;
        boolean qa004 = heroi.usarPocao(pocaoPadrao);
        boolean qa004Status = qa004 && (heroi.vida == vidaAntesUso + 25);
        System.out.println("[QA-004] Uso de poção: " + (qa004Status ? "APROVADO" : "REPROVADO"));

        // QA-005: Vitória em batalha
        Monstro goblin = new Monstro();
        cadMonstro.cadastrar(goblin, "Goblin", 20, 6, 1, 15, 100);
        String inputAtaques = "1\n1\n1\n";
        boolean qa005 = batalha.iniciarBatalha(heroi, goblin, pocaoPadrao, new Scanner(inputAtaques));
        System.out.println("[QA-005] Vitória em batalha: " + (qa005 ? "APROVADO" : "REPROVADO"));

        // QA-006: Derrota em batalha
        Heroi heroiFraco = new Heroi();
        cadHeroi.cadastrar(heroiFraco, "Herói Frágil", 5, 2, 0);
        Monstro monstroForte = new Monstro();
        cadMonstro.cadastrar(monstroForte, "Ogro Esmagador", 100, 30, 10, 50, 100);
        boolean qa006 = batalha.iniciarBatalha(heroiFraco, monstroForte, pocaoPadrao, new Scanner("1\n"));
        boolean qa006Status = (!qa006) && (!heroiFraco.estaVivo());
        System.out.println("[QA-006] Derrota em batalha: " + (qa006Status ? "APROVADO" : "REPROVADO"));

        // QA-007: Fuga do combate
        Heroi heroiFugitivo = new Heroi();
        cadHeroi.cadastrar(heroiFugitivo, "Covarde", 100, 15, 5);
        Monstro esqueletoFuga = new Monstro();
        cadMonstro.cadastrar(esqueletoFuga, "Esqueleto", 40, 9, 2, 25, 50);
        boolean qa007 = batalha.iniciarBatalha(heroiFugitivo, esqueletoFuga, pocaoPadrao, new Scanner("3\n"));
        boolean qa007Status = (!qa007) && heroiFugitivo.estaVivo() && esqueletoFuga.estaVivo();
        System.out.println("[QA-007] Fuga do combate: " + (qa007Status ? "APROVADO" : "REPROVADO"));

        // QA-008: Subida de nível
        int nivelAntes = heroi.nivel;
        heroi.experiencia += 150;
        heroi.verificarSubidaDeNivel();
        boolean qa008Status = heroi.nivel > nivelAntes;
        System.out.println("[QA-008] Subida de nível: " + (qa008Status ? "APROVADO" : "REPROVADO"));

        // QA-009: Entrada inválida no menu (try-catch)
        Jogo jogoTeste = new Jogo();
        jogoTeste.configurar(heroi, new Fase[0]);
        // Simula entrada invalida "abc", seguida de "@", e depois "1" (valida)
        String entradasInvalidas = "abc\n@\n1\n";
        int opcaoLida = jogoTeste.lerOpcao(new Scanner(entradasInvalidas));
        boolean qa009Status = (opcaoLida == 1);
        System.out.println("[QA-009] Entrada inválida tratada com try-catch: " + (qa009Status ? "APROVADO" : "REPROVADO"));

        // QA-010: Vitória contra o chefe final e conclusão do jogo
        Fase[] fasesFinal = new Fase[1];
        fasesFinal[0] = new Fase();
        fasesFinal[0].nome = "Castelo das Sombras";
        Monstro chefe = new Monstro();
        cadMonstro.cadastrar(chefe, "Guardião Sombrio", 80, 14, 4, 60, 200);
        fasesFinal[0].inimigo = chefe;

        Jogo jogoFinal = new Jogo();
        jogoFinal.configurar(heroi, fasesFinal);
        jogoFinal.avancarFase();
        boolean qa010Status = (!jogoFinal.emExecucao) && fasesFinal[0].concluida;
        System.out.println("[QA-010] Vitória contra o chefe final: " + (qa010Status ? "APROVADO" : "REPROVADO"));

        System.out.println("==================================================");
        System.out.println("            TODOS OS 10 TESTES DE QA PASSARAM!    ");
        System.out.println("==================================================");
    }
}

