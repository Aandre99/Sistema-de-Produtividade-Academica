
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeGerenciamento {

public static Scanner ler = new Scanner(System.in);

private ArrayList<Alunos> alunosCadastrados;
private ArrayList<Projetos> projetosCadastrados;
private ArrayList<Professores> professoresCadastrados;

public SistemaDeGerenciamento() {
    alunosCadastrados = new ArrayList<>();
    projetosCadastrados = new ArrayList<>();
    professoresCadastrados = new ArrayList<>();
}

public ArrayList<Alunos> getAlunosCadastrados() {
    return alunosCadastrados;
}

public void setAlunosCadastrados(Alunos novoAluno) {
    this.alunosCadastrados.add(novoAluno);
}

public ArrayList<Projetos> getProjetosCadastrados() {
    return projetosCadastrados;
}

public void setProjetosCadastrados(Projetos novoProjeto) {
    this.projetosCadastrados.add(novoProjeto);
}

public ArrayList<Professores> getProfessoresCadastrados() {
    return professoresCadastrados;
}

public void setProfessoresCadastrados(Professores novoProfessor) {
    this.professoresCadastrados.add(novoProfessor);
}

public void EditarProjetos(SistemaDeGerenciamento Sistema) {

    String titulo = null;
    int opcao;

    System.out.println("Projetos cadastrados: ");
    for (Projetos Item : Sistema.getProjetosCadastrados()) {
        System.out.println(Item.getTitulo());
    }

    System.out.println("Informe o nome do Projeto que deseja editar: ");
    titulo = ler.nextLine();


    for (Projetos Item : Sistema.getProjetosCadastrados()) {
        if (Item.getTitulo().equals(titulo)) {

            System.out.println("Informe a opcao que deseja efetuar:");
            System.out.println("1 - Alterar status de 'Em elaboracao' para 'Em andamento':");
            System.out.println("2 - Alterar status de 'Em andamento' para 'Concluido':");
            opcao = ler.nextInt();

            if (opcao == 1) {
                if (Item.getInfoCompleta() && Item.getStatus().equals("Em elaboracao")) {
                    Item.setStatus("Em andamento");
                    System.out.println("Edicao efetuada!");
                } else {
                    System.out.println("Projeto nao possui todas as informacoes basicas necessarias!");
                }
            } else {
                if (Item.getPublicacoesAssociadas().size() > 0) {
                    Item.setStatus("Concluido");
                    System.out.println("Edicao efetuada!");
                } else {
                    System.out.println("Nao ha publicacoes associadas ao projeto projeto!");
                }
            }
            break;
        }
    }
}

public void AdicionarAlunos(SistemaDeGerenciamento Sistema) {

    Alunos novoAluno = new Alunos();
    String info;

    System.out.println("Informe os dados necessarios para adicionar o novo Aluno:");
    System.out.println("Nome: ");
    info = ler.nextLine();
    novoAluno.getPerfilAluno().setNome(info);
    System.out.println("E-mail: ");
    info = ler.nextLine();
    novoAluno.getPerfilAluno().setE_mail(info);
    System.out.println("Nivel (Graduacao, Mestrado ou Doutorado): ");
    info = ler.nextLine();
    novoAluno.getPerfilAluno().setNivel(info);
    System.out.println("Data de Nascimento: ");
    info = ler.nextLine();
    novoAluno.getPerfilAluno().setDataNascimento(info);
    System.out.println("CPF: ");
    info = ler.nextLine();
    novoAluno.getPerfilAluno().setCpf(info);

    Sistema.setAlunosCadastrados(novoAluno);
    System.out.println("Aluno cadastrado com sucesso!");
    System.out.println("\n");
}

public void AdicionarProfessores(SistemaDeGerenciamento Sistema) {

    Professores novoProfessor = new Professores();
    novoProfessor.getPerfilProfessor().setNivel("Professor");

    String info;

    System.out.println("Informe os dados necessarios para adicionar o novo professor:\n");
    System.out.println("Nome: ");
    info = ler.nextLine();
    novoProfessor.getPerfilProfessor().setNome(info);
    System.out.println("E-mail: ");
    info = ler.nextLine();
    novoProfessor.getPerfilProfessor().setE_mail(info);
    System.out.println("Data de Nascimento: ");
    info = ler.nextLine();
    novoProfessor.getPerfilProfessor().setDataNascimento(info);
    System.out.println("CPF: ");
    info = ler.nextLine();
    novoProfessor.getPerfilProfessor().setCpf(info);

    Sistema.setProfessoresCadastrados(novoProfessor);
    System.out.println("Professor cadastrado com sucesso!");
    System.out.println("\n");

}

public void AdicionarProjetos(SistemaDeGerenciamento Sistema) {

    Projetos novoProjeto = new Projetos();
    String info;
    int data;
    double valor;

    System.out.println("Informe os dados necessarios para adicionar um novo Projeto:");
    System.out.println("Titulo: ");
    info = ler.nextLine();
    novoProjeto.setTitulo(info);

    //---------------------------Datas--------------------

    System.out.println("Informe as datas do Inicio do Projeto");

    System.out.println("Dia: ");
    data = ler.nextInt();
    novoProjeto.setDia_inicio(data);
    System.out.println("Mês: ");
    data = ler.nextInt();
    novoProjeto.setMes_inicio(data);
    System.out.println("Ano:");
    data = ler.nextInt();
    novoProjeto.setAno_inicio(data);

    System.out.println("Informe as datas do Termino do Projeto");

    System.out.println("Dia: ");
    data = ler.nextInt();
    novoProjeto.setDia_fim(data);
    System.out.println("Mês: ");
    data = ler.nextInt();
    novoProjeto.setMes_fim(data);
    System.out.println("Ano:");
    data = ler.nextInt();
    info = ler.nextLine();
    novoProjeto.setAno_fim(data);
    //----------------------------------------------------------
    System.out.println("Agencia Financiadora: ");
    info = ler.nextLine();
    novoProjeto.setAgenciaFinanciadora(info);
    System.out.println("Valor Financiado: ");
    valor = ler.nextDouble();
    info = ler.nextLine();
    novoProjeto.setValorFinanciado(valor);
    System.out.println("Objetivo: ");
    info = ler.nextLine();
    novoProjeto.setObjetivo(info);
    System.out.println("Descricao: ");
    info = ler.nextLine();
    novoProjeto.setDescricao(info);
    novoProjeto.setInfoBasicaCompleta();
    Sistema.setProjetosCadastrados(novoProjeto);

    if (Sistema.getProfessoresCadastrados().size() > 0) {

        System.out.println("É necessario vincular ao menos um professor responsavel pelo projeto!\n");
        System.out.println("Informe o nome do professor que sera responsavel pelo novo projeto:");
        String info2;
        info2 = ler.nextLine();

        for (Professores Item : Sistema.getProfessoresCadastrados()) {
            if (Item.getPerfilProfessor().getNome().equals(info2)) {
                novoProjeto.setProfessores(Item);
                System.out.println("Alocacao do Professor e Criacao do novo Projeto efetuadas com sucesso!");
                novoProjeto.setQtd_professores();
                break;
            }
        }
    } else {
        System.out.println("Nao ha professores cadastrados, Adicione um novo professor os ao sistema e vincule-o ao projeto");
    }
    System.out.println("\n");
}

public void AlteracaoStatus(SistemaDeGerenciamento Sistema) {

    String nomeP = null;
    String limpar;
    int opcao;

    System.out.println("Informe o Titulo do Projeto o qual deseja alterar o status: ");
    nomeP = ler.nextLine();

    for (Projetos Item : Sistema.getProjetosCadastrados()) {

        if (Item.getTitulo().equals(nomeP)) {
            System.out.println("Informe a opcao desejada:");
            System.out.println("1 - Alterar Status de 'Em elaboracao' para 'Em andamento':");
            System.out.println("2 - Alterar Status de 'Em andamento' para 'Concluido':");

            opcao = ler.nextInt();
            limpar = ler.nextLine();

            if (opcao == 1) {
                if (Item.getInfoCompleta()) {
                    Item.setStatus("Em andamento");
                } else {
                    System.out.println("As informacoes do projeto em questao nao estao completas!");
                }
            }
        }
    }
}

public void MostrarCadastrados(SistemaDeGerenciamento Sistema) {

    System.out.println("Alunos: \n");

    for (Alunos Item : Sistema.getAlunosCadastrados()) {
        System.out.println("Nome: " + Item.getPerfilAluno().getNome());
        System.out.println("Data de Nascimento: " + Item.getPerfilAluno().getDataNascimento());
        System.out.println("E-mail: " + Item.getPerfilAluno().getE_mail());
        System.out.println("Nivel: " + Item.getPerfilAluno().getNivel());
        System.out.println("CPF: " + Item.getPerfilAluno().getCpf() + "\n");
    }

    System.out.println("Professores: \n");

    for (Professores Item : Sistema.getProfessoresCadastrados()) {
        System.out.println("Nome: " + Item.getPerfilProfessor().getNome());
        System.out.println("Data de Nascimento: " + Item.getPerfilProfessor().getDataNascimento());
        System.out.println("Cargo: " + Item.getPerfilProfessor().getNivel());
        System.out.println("E-mail: " + Item.getPerfilProfessor().getE_mail());
        System.out.println("Nivel: " + Item.getPerfilProfessor().getNivel());
        System.out.println("CPF: " + Item.getPerfilProfessor().getCpf() + "\n");
    }

    System.out.println("Projetos: ");

    for (Projetos Item : Sistema.getProjetosCadastrados()) {
        System.out.println("Titulo: " + Item.getTitulo());
        System.out.println("Objetivo: " + Item.getObjetivo());
        System.out.println("Descricao: " + Item.getDescricao());
        System.out.println("Status: " + Item.getStatus());
        System.out.println("Data de Incio: " + Item.getDia_inicio() + "/" + Item.getMes_inicio() + "/" + Item.getAno_inicio());
        System.out.println("Data de Fim: " + Item.getDia_fim() + "/" + Item.getMes_fim() + "/" + Item.getAno_fim());
        System.out.println("Agencia Financiadora: " + Item.getAgenciaFinanciadora());
        System.out.println("Valor Financiado: " + Item.getValorFinanciado());

        System.out.println("Lista de Alunos no projeto: ");
        for (Alunos aluno : Item.getAlunosAssociados()) {
            System.out.println(aluno.getPerfilAluno().getNome());
        }
        System.out.println("Lista de Professores no Projeto: \n");
        for (Professores professor : Item.getProfessoresAssociados()) {
            System.out.println(professor.getPerfilProfessor().getNome());
        }
    }

    System.out.println("\n");
}

public void AlocarParticipantes(SistemaDeGerenciamento Sistema) {
    String nomeProjeto;
    int opcao;
    String nome = null;
    String tipo;
    String limpar;
    boolean verifica = false;

    System.out.println("Informe o nome do projeto para o qual deseja fazer a alocacao de colaboradores: ");
    nomeProjeto = ler.nextLine();

    for (Projetos Item : Sistema.getProjetosCadastrados()) {

        if (Item.getTitulo().equals(nomeProjeto) && Item.getStatus().equals("Em elaboracao")) {

            System.out.println(Item.getTitulo().equals(nomeProjeto));
            System.out.println(Item.getStatus() + "\n");

            System.out.println("Informe qual o tipo de colaborador deseja cadastrar:");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            opcao = ler.nextInt();
            limpar = ler.nextLine();

            if (opcao == 1) {

                System.out.println("Informe o nome do Aluno a ser Alocado:");
                nome = ler.nextLine();

                for (Alunos aluno : Item.getAlunosAssociados()) {
                    if (aluno.getPerfilAluno().getNome().equals(nome)) {
                        verifica = true;
                        break;
                    }
                }
                if (verifica) {
                    System.out.println(nome + " ja faz parte do projeto!");
                    break;
                }

                for (Alunos aluno : Sistema.getAlunosCadastrados()) {

                    if (aluno.getPerfilAluno().getNome().equals(nome)) {

                        if (Item.getQtd_professores() == 0) {
                            System.out.println("Não ha professores cadastrados no projeto, vincule um professor para alocar colaboradores ao projeto");
                        } else {

                            if (aluno.getPerfilAluno().getNivel().equals("Graduacao")) {

                                System.out.println("Quantidade de P: " + aluno.getQtdProjetosAnd());
                                if (aluno.PertenceDoisProjetosAndamento()) {
                                    System.out.println("O aluno ja faz parte de dos Projetos 'Em andamento'!");
                                    break;
                                } else {

                                    aluno.setQtdProjetosAnd();
                                    aluno.setProjetos_Aluno(Item);
                                    Item.setAlunosAssociados(aluno);
                                    System.out.println("Aluno alocado com sucesso");
                                    break;
                                }
                            } else {
                                aluno.setProjetos_Aluno(Item);
                                Item.setAlunosAssociados(aluno);
                                System.out.println("Aluno alocado com sucesso");
                                break;
                            }
                        }
                    }
                }

            } else {
                System.out.println("Informe o nome do Professor:");
                nome = ler.nextLine();

                for (Professores professor : Sistema.getProfessoresCadastrados()) {

                    if (professor.getPerfilProfessor().getNome().equals(nome)) {
                        Item.setProfessores(professor);
                        Item.setQtd_professores();
                        professor.setProjetosAssociados(Item);
                        System.out.println("Professor alocado com sucesso!");
                        break;
                    }
                }
            }
        }
    }
    System.out.println("\n");
}


public void AdicionarPublicacao(SistemaDeGerenciamento Sistema) {

    int quantidade;
    int ano;
    boolean vincularProj = false;
    String limpar;
    String info;

    Publicacoes novaPublicacao = new Publicacoes();

    // Adicionar informacoes basicas

    System.out.println("informe o Titulo da publicacao:");
    info = ler.nextLine();
    novaPublicacao.setTitulo(info);
    System.out.println("Informe o nome da conferencia de publicacao:");
    info = ler.nextLine();
    novaPublicacao.setNomeConferencia(info);
    System.out.println("Infome o ano de publicacao:");
    ano = ler.nextInt();
    novaPublicacao.setAnoPublicacao(ano);

    System.out.println("Deseja associar pojetos a publicacao?");
    vincularProj = ler.nextBoolean();

    if (vincularProj) {

        System.out.println("Informe o titulo do projeto que deseja vincular:");
        info = ler.nextLine();

        for (Projetos Item : Sistema.getProjetosCadastrados()) {
            if (Item.getTitulo().equals(info)) {

                if (Item.getStatus().equals("Em andamento")) {
                    novaPublicacao.setProjetosAssociados(Item);
                    novaPublicacao.setProjetosAssociados(Item);
                    System.out.println("Projeto(os) Adicionado(os) com sucesso!");
                } else {
                    System.out.println("O status do projeto nao permite vincular publicacoes:");
                }
                break;
            }
        }
    }
    System.out.println("Informe quantos autores tera a publicacao");
    quantidade = ler.nextInt();
    limpar = ler.nextLine();

    // Vincular alunos a publicacao

    for (int i = 0; i < quantidade; i++) {
        System.out.println("informe o nome do aluno que deseja vincular a publicacao: ");
        info = ler.nextLine();

        for (Alunos alunos : Sistema.getAlunosCadastrados()) {
            if (alunos.getPerfilAluno().getNome().equals(info)) {
                novaPublicacao.setAlunosPublicacao(alunos);
                alunos.setPub_Aluno(novaPublicacao);
                System.out.println("Aluno vinculado com sucesso!");
                break;
            }
        }
    }

}

public void Consulta(SistemaDeGerenciamento Sistema) {

    int opcao;
    String limpar;
    String info;

    System.out.println("Informe que tipo de consulta dejesa fazer:");
    System.out.println("1 - Consulta por colaborador;");
    System.out.println("2 - Consulta por projeto;");

    opcao = ler.nextInt();
    limpar = ler.nextLine();

    if (opcao == 1) {

        System.out.println("Informe que tipo de colaborador deseja consultar:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");

        opcao = ler.nextInt();
        limpar = ler.nextLine();

        if (opcao == 1) {
            System.out.println("Informe o nome do aluno que deseja consultar:");
            info = ler.nextLine();

            for (Alunos alunos : Sistema.getAlunosCadastrados()) {

                if (alunos.getPerfilAluno().getNome().equals(info)) {

                    System.out.println("Nome : " + alunos.getPerfilAluno().getNome());
                    System.out.println("E- mail : " + alunos.getPerfilAluno().getE_mail());

                    System.out.println("Lista de Projetos: ");

                    if (alunos.getProjetos_Aluno().size() > 0) {

                        for (Projetos proj : alunos.getProjetos_Aluno()) {
                            System.out.println("Titulo do Projeto: " + proj.getTitulo());
                        }
                    } else {
                        System.out.println("Nao ha projetos para mostrar!");
                    }

                    System.out.println("Producao Academica: ");

                    if (alunos.getPub_Aluno().size() > 0) {

                        for (Publicacoes pub : alunos.getPub_Aluno()) {
                            System.out.println("Titulo da Publicacao: " + pub.getTitulo());
                        }
                    } else {
                        System.out.println("Nao ha publicacoes para mostrar!");
                    }

                }
            }
        }else{

            System.out.println("Infome o nome do Professor que deseja Consultar: ");
            info = ler.nextLine();

            for(Professores prof : Sistema.getProfessoresCadastrados()){
                if(prof.getPerfilProfessor().getNome().equals(info)){

                        System.out.println("Nome: " + prof.getPerfilProfessor().getNome());
                        System.out.println("E-mail: " + prof.getPerfilProfessor().getE_mail());

                        if(prof.getProjetosAssociados().size() > 0){
                            System.out.println("Lista de Projetos Associados: ");

                            for(Projetos projetos : prof.getProjetosAssociados()){
                                System.out.println(projetos.getTitulo());
                            }
                        }else{
                            System.out.println("Nao ha projetos associados!");
                        }

                        if(prof.getPub_professores().size() > 0){
                            System.out.println("Lista de publicacoes associadas");

                            for(Publicacoes publicacoes : prof.getPub_professores()){
                                System.out.println("Titulo da Publicacao: " + publicacoes.getTitulo());
                            }

                        }else{
                            System.out.println("Nao ha publicacoes associadas!");
                        }
                    }
                }
            }
        }
    else {

        System.out.println("Informe o Titulo do Projeto que deseja consultar: ");
        info = ler.nextLine();

        for (Projetos proj : Sistema.getProjetosCadastrados()) {

            if (proj.getTitulo().equals(info)) {
                proj.InformacoesProjeto(proj);
                break;
            }
        }
    }
    }
}