package dobackaofront.model;

import java.util.ArrayList;

public class Mercado {
    private int codigo;
    private String nome;
    private ArrayList<Categoria> categorias;

    public Mercado(String nome) {
        this.setCategorias(new ArrayList<>());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void removerCategoria(int codigo) {
        System.out.println(categorias.get(codigo).getNome()+" foi removido com sucesso!");
        categorias.remove(codigo);
    }

    public void apresentarCategorias() {
        for (int i=0; i<categorias.size(); i++) {
            System.out.println("Código: "+i+", Nome da Categoria: "+categorias.get(i).getNome());
        }
    }

    public void apresentarItens() {
       for (int i=0; i<categorias.size(); i++) {
           ArrayList<Item> itens = categorias.get(i).getItens();

           System.out.println("Categoria: "+i);
           for (int j=0; j<itens.size(); j++) {
               System.out.println("Nome: "+itens.get(j).getNome()+", Preço: "+itens.get(j).getPreco());
           }

           System.out.println("");
       }
    }

    public void apresentarCategoriaPorCodigo(int codigo) {
        for (int i=0; i<categorias.size(); i++) {
            if (codigo == 0) {
                for (int j=0; j<categorias.get(0).getItens().size(); j++) {
                    System.out.println(categorias.get(0).getItens().get(j).getNome());
                }
                i = categorias.size();
            } else if (codigo == 1) {
                for (int j=0; j<categorias.get(1).getItens().size(); j++) {
                    System.out.println(categorias.get(1).getItens().get(j).getNome());
                }
                i = categorias.size();
            } else if (codigo == 2) {
                for (int j=0; j<categorias.get(2).getItens().size(); j++) {
                    System.out.println(categorias.get(2).getItens().get(j).getNome());
                }
                i = categorias.size();
            }
        }
    }
}
