package dobackaofront.controller;

import dobackaofront.model.Categoria;
import dobackaofront.model.Item;

import java.io.*;
import java.util.ArrayList;

public class BancoDeDados {
    private ArrayList<Categoria> categorias;
    ArrayList<Item> itens;

    public BancoDeDados() {
        ArrayList<String> linhas = lerArquivo();
        categorias = transformarLinhasEmObjetos(linhas);
    }

    public ArrayList<String> lerArquivo() {
        try {
            InputStream is = new FileInputStream("itens.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            ArrayList<String> linhas = new ArrayList<>();

            String linha = br.readLine();

            while(linha != null) {
                linhas.add(linha);
                System.out.println(linha);
                linha = br.readLine();
            }

            br.close();
            isr.close();
            is.close();

            System.out.println("Finalizei de ler o arquivo!");
            return linhas;
        } catch (Exception e) {
            System.out.println("Não consegui ler o arquivo!");
            return null;
        }
    }

    public ArrayList<Categoria> transformarLinhasEmObjetos(ArrayList<String> linhas) {
        String[] dados = new String[3];
        String nome;
        double preco;
        String categoria;
        ArrayList<Categoria> categorias = new ArrayList<>();

        for(int i=0; i<linhas.size(); i++){
            dados = linhas.get(i).split(",");
            nome = dados[0];
            preco = Double.parseDouble(dados[1]);
            categoria = dados[2];

            Item item = new Item(nome, preco);
            Categoria c = new Categoria(categoria);
            boolean opcao = false;

            for (int j=0; j<categorias.size(); j++) {
                if (categorias.get(j).getNome().equals(c.getNome())) {
                    categorias.get(j).adicionarItem(item);
                    opcao = true;
                }
            }

            if (opcao == false) {
                c.adicionarItem(item);
                categorias.add(c);
            }
        }

        return categorias;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void escreverArquivo(Item item, int codigoCategoria) {
        try {
            OutputStream os = new FileOutputStream("itens.txt", true);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            String linha = "";

            if (codigoCategoria == 0) {
                linha = item.getNome()+","+item.getPreco()+",alimentos";
                bw.write(linha);
                bw.newLine();
            } else if (codigoCategoria == 1) {
                linha = item.getNome()+","+item.getPreco()+",higiene1";
                bw.write(linha);
                bw.newLine();
            } else if (codigoCategoria == 2) {
                linha = item.getNome()+","+item.getPreco()+",higiene2";
                bw.write(linha);
                bw.newLine();
            }

            bw.close();
            osw.close();
            os.close();
        } catch (Exception e) {
            System.out.println("Não foi possível escrever no arquivo de texto!");
        }
    }
}
