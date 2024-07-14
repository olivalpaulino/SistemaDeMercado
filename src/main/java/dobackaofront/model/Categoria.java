package dobackaofront.model;

import java.util.ArrayList;

public class Categoria {
    private int codigo;
    private String nome;
    private ArrayList<Item> itens;

    public Categoria(String nome) {
        this.setNome(nome);
        setItens(new ArrayList<>());
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

    public void adicionarItem(Item item) {
        getItens().add(item);
    }

    public void removerItem(int codigo) {
        System.out.println(getItens().get(codigo).getNome()+" foi removido da categoria");
        getItens().remove(codigo);
    }


    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
