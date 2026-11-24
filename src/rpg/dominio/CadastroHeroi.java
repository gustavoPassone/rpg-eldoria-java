package rpg.dominio;

public class CadastroHeroi {

    public boolean cadastrar(Heroi heroi, String nome, int vidaMaxima, int ataque, int defesa) {
        if (heroi == null) {
            System.out.println("Erro: Objeto Heroi nao pode ser nulo.");
            return false;
        }
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro no cadastro: O nome nao pode ser vazio.");
            return false;
        }
        if (vidaMaxima <= 0) {
            System.out.println("Erro no cadastro: A vida maxima deve ser maior que zero (recebido: " + vidaMaxima + ").");
            return false;
        }
        if (ataque < 0) {
            System.out.println("Erro no cadastro: O ataque nao pode ser negativo (recebido: " + ataque + ").");
            return false;
        }
        if (defesa < 0) {
            System.out.println("Erro no cadastro: A defesa nao pode ser negativa (recebido: " + defesa + ").");
            return false;
        }

        heroi.nome = nome.trim();
        heroi.vidaMaxima = vidaMaxima;
        heroi.vida = vidaMaxima;
        heroi.ataque = ataque;
        heroi.defesa = defesa;
        heroi.nivel = 1;
        heroi.experiencia = 0;
        heroi.ouro = 30;

        heroi.inventario = new Inventario();
        heroi.inventario.quantidadePocoes = 2;
        return true;
    }
}
