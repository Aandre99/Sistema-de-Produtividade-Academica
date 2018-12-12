import java.util.ArrayList;

public class Professores {

    private PerfilColaborador perfilProfessor;
    private ArrayList <Publicacoes> pub_professores;
    private ArrayList <Alunos> orientacoes;
    private ArrayList<Projetos> projetosAssociados;


    public Professores(){
        this.pub_professores = new ArrayList<>();
        this.orientacoes = new ArrayList<>();
        this.perfilProfessor = new PerfilColaborador();
        this.projetosAssociados = new ArrayList<>();
    }
    // --------------Geters--------------

    public PerfilColaborador getPerfilProfessor(){
        return  perfilProfessor;
    }
    public ArrayList<Publicacoes> getPub_professores(){
        return pub_professores;
    }
    public ArrayList<Alunos> getOrientacoes(){
        return orientacoes;
    }
    public ArrayList<Projetos> getProjetosAssociados() {
        return projetosAssociados;
    }
//---------------Seters---------------

    public void setPub_professores(Publicacoes novaPublicacao){
        this.pub_professores.add(novaPublicacao);
    }
    public void setOrientacoes(Alunos novoOrientado){
        this.orientacoes.add(novoOrientado);
    }
    public void setProjetosAssociados(Projetos proj){

        this.projetosAssociados.add(proj);
    }
}
