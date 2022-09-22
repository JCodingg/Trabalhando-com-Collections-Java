package br.com;


/* Dados as seguintes infomações sobre meus cachorros, crie uma lista e ordene está lista exibindo :
        (nome-idade-cor);

 Cachorro 1 = nome: Jon, idade: 18, cor: preto
 Cachorro 2 = nome: Simba, idade: 6, cor: tigrado
 Cachorro 3 = nome: Jan, idade: 12, cor: amarelo

*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        List<Cachorro> meusCachorros = new ArrayList<>(){{
            add(new Cachorro("Jon", 12, "preto"));
            add(new Cachorro("Simba", 6, "tigrado"));
            add(new Cachorro("Jon", 18, "amarelo"));
        }};
        meusCachorros.sort(Comparator.comparing(Cachorro::getNome));


        System.out.println("--\tOrdem de Inserção\t---");
        System.out.println(meusCachorros);

        System.out.println("--\tOrdem aleatória\t---");
        Collections.shuffle(meusCachorros);
        System.out.println(meusCachorros);

        System.out.println("--\tOrdem Natural (Nome)\t---");
        Collections.sort(meusCachorros);
        System.out.println(meusCachorros);

        System.out.println("--\tOrdem Idade\t---");
//        Collections.sort(meusCachorros, new ComparatorIdade());
        meusCachorros.sort(new ComparatorIdade());
        System.out.println(meusCachorros);

        System.out.println("--\tOrdem cor\t---");
//        Collections.sort(meusCachorros, new ComparatorCor());
        meusCachorros.sort(new ComparatorCor());
        System.out.println(meusCachorros);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
//        Collections.sort(meusCachorros, new ComparatorNomeCorIdade());
        meusCachorros.sort(new ComparatorNomeCorIdade());
        System.out.println(meusCachorros);
    }
}

class Cachorro implements Comparable<Cachorro>{
    private String nome;
    private Integer idade;
    private String cor;

    public Cachorro(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cachorro cachorro) {
        return this.getNome().compareToIgnoreCase(cachorro.getNome());
    }
}

class ComparatorIdade implements Comparator<Cachorro> {
    @Override
    public int compare(Cachorro g1, Cachorro g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Cachorro> {

    @Override
    public int compare(Cachorro g1, Cachorro g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Cachorro> {

    @Override
    public int compare(Cachorro g1, Cachorro g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor !=0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}
