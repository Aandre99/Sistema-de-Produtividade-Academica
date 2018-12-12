import java.util.ArrayList;

public class Alunos {

    private PerfilColaborador perfilAluno;
    private String nivelAluno;
    private int qtdProjetosAnd;
    private ArrayList <Publicacoes> publicacoes_Aluno;
    private ArrayList <Projetos> projetos_Aluno;


    public Alunos(){
        this.nivelAluno = null;
        this.qtdProjetosAnd = 0;
        this.publicacoes_Aluno = new ArrayList<>();
        this.projetos_Aluno = new ArrayList<>();
        this.perfilAluno = new PerfilColaborador();
    }
    //-------------Geters------------------

    public PerfilColaborador getPerfilAluno() {
        return perfilAluno;
    }

    public ArrayList<Publicacoes> getPub_Aluno() {
        return publicacoes_Aluno;
    }
    public int getQtdProjetosAnd(){
        return qtdProjetosAnd;
    }
    public ArrayList<Projetos> getProjetos_Aluno(){
        return projetos_Aluno;
    }

    //-------------Seters------------------

    public void setPub_Aluno(Publicacoes pub_Aluno) {
        this.publicacoes_Aluno.add(pub_Aluno);
    }
    public void setQtdProjetosAnd(){
        this.qtdProjetosAnd  = this.qtdProjetosAnd + 1;
    }
    public void setProjetos_Aluno(Projetos projeto){
        this.projetos_Aluno.add(projeto);
    }
    public boolean PertenceDoisProjetosAndamento(){

        int contador = 0;
        for (Projetos Item : this.projetos_Aluno){
            if(Item.getStatus().equals("Em andamento")){
                contador = contador + 1;
            }
            if(contador >= 2){
                return true;
            }
        }
        return false;
    }

}
