package dobackaofront;

import dobackaofront.controller.BancoDeDados;
import dobackaofront.model.Categoria;
import dobackaofront.model.Item;
import dobackaofront.model.Mercado;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BancoDeDados b = new BancoDeDados();
        ArrayList<Categoria> categorias = b.getCategorias();
        Categoria c;
        for(int i=0; i<categorias.size(); i++) {
            ArrayList<Item> itens = categorias.get(i).getItens();

            System.out.println("Categoria: "+categorias.get(i).getNome());
            for (int j=0; j<itens.size(); j++) {
                System.out.println("Nome: "+itens.get(j).getNome()+", Preço: "+itens.get(j).getPreco());
            }

            System.out.println("");
        }


    }
}