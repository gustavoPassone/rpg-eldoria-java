package rpg.dominio;

public class Loja {

    public boolean comprarPocao(Heroi heroi, Pocao pocao) {
        if (heroi == null || pocao == null) {
            return false;
        }
        if (pocao.preco <= 0) {
            System.out.println("Erro: Tentativa de compra com preco invalido (" + pocao.preco + ").");
            return false;
        }
        if (heroi.ouro >= pocao.preco) {
            heroi.ouro -= pocao.preco;
            if (heroi.inventario == null) {
                heroi.inventario = new Inventario();
            }
            heroi.inventario.quantidadePocoes++;
            System.out.println(heroi.nome + " comprou " + pocao.nome + " por " + pocao.preco + " de ouro.");
            return true;
        }
        System.out.println(heroi.nome + " nao tem ouro suficiente para comprar " + pocao.nome + " (Necessario: " + pocao.preco + ", Possui: " + heroi.ouro + ").");
        return false;
    }

    public boolean comprarArma(Heroi heroi, Arma arma) {
        if (heroi == null || arma == null) {
            return false;
        }
        if (arma.preco <= 0) {
            System.out.println("Erro: Tentativa de compra com preco invalido (" + arma.preco + ").");
            return false;
        }
        if (heroi.ouro >= arma.preco) {
            heroi.ouro -= arma.preco;
            if (heroi.inventario == null) {
                heroi.inventario = new Inventario();
            }
            heroi.inventario.armaEquipada = arma;
            System.out.println(heroi.nome + " comprou e equipou " + arma.nome + " por " + arma.preco + " de ouro.");
            return true;
        }
        System.out.println(heroi.nome + " nao tem ouro suficiente para comprar " + arma.nome + " (Necessario: " + arma.preco + ", Possui: " + heroi.ouro + ").");
        return false;
    }
}
