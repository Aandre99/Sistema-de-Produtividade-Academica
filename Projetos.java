import java.util.ArrayList;
import java.util.Scanner;

public class Projetos {

public static Scanner ler = new Scanner(System.in);

private String Titulo;
private String Status;
private int ano_inicio;
private int mes_inicio;
private int dia_inicio;
private int ano_fim;
private int mes_fim;
private int dia_fim;
int qtd_professores;
private String agenciaFinanciadora;
private double valorFinanciado;
private String objetivo;
private String descricao;
private boolean infoBasicaCompleta;

private ArrayList<Professores> professoresAssociados;
private ArrayList<Alunos> alunosAssociados;
private ArrayList<Publicacoes> publicacoesAssociadas;

public Projetos() {

    this.professoresAssociados = new ArrayList<>();
    this.alunosAssociados = new ArrayList<>();
    this.publicacoesAssociadas = new ArrayList<>();
    this.Titulo = null;
    this.infoBasicaCompleta = false;
    this.Status = "Em elaboracao";
    this.valorFinanciado = 0;
    this.mes_fim = 0;
    this.mes_inicio=0;
    this.descricao =  null;
    this.dia_inicio = 0;
    this.dia_fim = 0;
    this.agenciaFinanciadora = null;
    this.objetivo = null;
    this.ano_fim = 0;
    this.ano_inicio = 0;
    this.qtd_professores = 0;
}
//--------------------Geters-------------------

public String getTitulo() {
    return Titulo;
}

public int getAno_inicio() {
    return ano_inicio;
}

public int getMes_inicio() {
    return mes_inicio;
}

public int getDia_inicio() {
    return dia_inicio;
}

public int getAno_fim() {
    return ano_fim;
}

public int getMes_fim() {
    return mes_fim;
}

public int getDia_fim() {
    return dia_fim;
}

public String getObjetivo() {
    return objetivo;
}

public String getAgenciaFinanciadora() {
    return agenciaFinanciadora;
}

public double getValorFinanciado() {
    return valorFinanciado;
}

public String getDescricao() {
    return descricao;
}

public ArrayList<Professores> getProfessoresAssociados() {
    return professoresAssociados;
}

public ArrayList<Alunos> getAlunosAssociados() {
    return alunosAssociados;
}

public int getQtd_professores() {
    return qtd_professores;
}

public String getStatus() {
    return Status;
}
public boolean getInfoCompleta(){
    return infoBasicaCompleta;
}
public ArrayList<Publicacoes> getPublicacoesAssociadas(){
    return publicacoesAssociadas;
}
//--------------Seters----------------------------

public void setTitulo(String titulo) {
    Titulo = titulo;
}

public void setAno_inicio(int ano_inicio) {
    this.ano_inicio = ano_inicio;
}

public void setMes_inicio(int mes_inicio) {
    this.mes_inicio = mes_inicio;
}

public void setDia_inicio(int dia_inicio) {
    this.dia_inicio = dia_inicio;
}

public void setAno_fim(int ano_fim) {
    this.ano_fim = ano_fim;
}

public void setMes_fim(int mes_fim) {
    this.mes_fim = mes_fim;
}

public void setDia_fim(int dia_fim) {
    this.dia_fim = dia_fim;
}

public void setStatus(String novoStatus) {
    this.Status = novoStatus;
}

public void setAgenciaFinanciadora(String agenciaFinanciadora) {
    this.agenciaFinanciadora = agenciaFinanciadora;
}

public void setValorFinanciado(double valorFinanciado) {
    this.valorFinanciado = valorFinanciado;
}

public void setObjetivo(String objetivo) {
    this.objetivo = objetivo;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public void setProfessores(Professores novoProfessor) {
    this.professoresAssociados.add(novoProfessor);
}

public void setAlunosAssociados(Alunos novoAluno) {
    this.alunosAssociados.add(novoAluno);
}

public void setQtd_professores() {
    this.qtd_professores  = this.qtd_professores + 1;
}
public void setInfoBasicaCompleta(){
    this.infoBasicaCompleta = true;
}
public void setPublicacoesAssociadas(Publicacoes novaPublicacao){
    this.publicacoesAssociadas.add(novaPublicacao);
}

    public void InformacoesProjeto(Projetos proj){

        System.out.println("Titulo: " + proj.getTitulo());
        System.out.println("Data de Inicio: " + proj.getDia_inicio() +"/"+proj.getMes_inicio()+"/"+proj.getAno_inicio());
        System.out.println("Data de Termino: " + proj.getDia_fim() +"/"+proj.getMes_fim()+"/"+proj.getAno_fim());
        System.out.println("Agencia Financiadora: " + proj.getAgenciaFinanciadora());
        System.out.println("Valor Financiado: "+ proj.getValorFinanciado());
        System.out.println("Objetivo: " + proj.getObjetivo());
        System.out.println("Descricao: " + proj.getDescricao());

        System.out.println("Colaboradores: \n");

            System.out.println("Professores: ");
            for(Professores prof : proj.getProfessoresAssociados()){
                System.out.println("Nome: " + prof.getPerfilProfessor().getNome());
            }

        System.out.println("\nAlunos :");
            for(Alunos aluno : proj.getAlunosAssociados()){
                System.out.println("Nome: " + aluno.getPerfilAluno().getNome());
            }
        System.out.println("\n");

        System.out.println("Producao Academica: ");

        for(Publicacoes pub : proj.getPublicacoesAssociadas()){
            System.out.println("Titulo: " + pub.getTitulo());
        }
    }
}