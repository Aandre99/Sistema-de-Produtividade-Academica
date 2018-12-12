import jdk.nashorn.internal.runtime.regexp.joni.ast.QuantifierNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Publicacoes {

    public static Scanner ler = new Scanner(System.in);

    private String Titulo;
    private String nomeConferencia;
    private int anoPublicacao;
    private ArrayList<Projetos> projetosAssociados;
    private ArrayList<Alunos> alunosPublicacao;

    public Publicacoes(){
        this.projetosAssociados = new ArrayList<>();
        this.alunosPublicacao = new ArrayList<>();
        this.Titulo = null;
        this.nomeConferencia = null;
        this.anoPublicacao = 0;
    }

    //  ------------Geters-----------------------

    public String getTitulo() {
        return Titulo;
    }
    public String getNomeConferencia() {
        return nomeConferencia;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public ArrayList<Projetos> getProjetosAssociados(){
        return projetosAssociados;
    }
    public ArrayList<Alunos> getAlunosPublicacao(){
        return alunosPublicacao;
    }

    // --------------Seters-----------------------

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setProjetosAssociados(Projetos novoProjeto) {
         this.projetosAssociados.add(novoProjeto);
    }

public void setAlunosPublicacao(Alunos aluno) {
    this.alunosPublicacao.add(aluno);
}
}
