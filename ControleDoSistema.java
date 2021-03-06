package sistemadegerenciamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleDoSistema 
{
    
    public static Scanner Ler = new Scanner(System.in);
    
    private ArrayList<Projeto> ListaDeProjetos;
    private ArrayList<Professor> ListaDeProfessores;
    private ArrayList<Aluno> ListaDeAlunos;
    private ArrayList<Pessoa> Colaboradores;
    private ArrayList<Publicacao> ListaDePublicacoes;
    
     public ControleDoSistema(){
        
        this.ListaDeProjetos = new ArrayList();
        this.ListaDeProfessores = new ArrayList();
        this.ListaDeAlunos = new ArrayList();
        this.ListaDePublicacoes = new ArrayList();
        this.Colaboradores = new ArrayList();
        
    }
     
    public ArrayList<Projeto> getListaDeProjetos() {
        return ListaDeProjetos;
    }

    public ArrayList<Professor> getListaDeProfessores() {
        return ListaDeProfessores;
    }

    public ArrayList<Aluno> getListaDeAlunos() {
        return ListaDeAlunos;
    }
   
    public ArrayList<Publicacao> getListaDePublicacoes() {
        return ListaDePublicacoes;
    }
    
    public ArrayList<Pessoa> getColaboradores() {
      return Colaboradores;
    }
    
    public void setColaboradores(Pessoa Colaboradores) {
      this.Colaboradores.add(Colaboradores);
    }
    
    //  ----------Funcões do Sistema ------------------
    
    public void MenuPrincipal(){
        
        System.out.println("\n- - - Menu Principal - - - ");
        System.out.println("Informe a opcao desejada: \n");
        System.out.println("1 - Cadastrar Professor;");
        System.out.println("2 - Cadastrar Aluno;");
        System.out.println("3 - Cadastrar Projeto;");
        System.out.println("4 - Adicionar Publicacao;");
        System.out.println("5 - Alocar Participantes");
        System.out.println("6 - Alocar Publicação;");
        System.out.println("7 - Alterar Status");
        System.out.println("8 - Consulta;");
        System.out.println("9 - Relatorio de Produção Acadêmica;");
        System.out.println("0 - Sair;");
        System.out.println("- - - - - - - - - - - - - -\n");
    }
    public void CadastrarProjeto()
    {
        String informacao, limparLixo;
        int dia=0, mes=0, ano=0;
        double valor;
        
        if(this.getListaDeProfessores().size() > 0)
        {
            Projeto novoProjeto = new Projeto();
            boolean verifica = false;
            
            try
            {
                System.out.println("Informe os seguintes topicos para criar o projeto: \n");
                System.out.println("Titulo: ");
                informacao = Ler.nextLine();
                novoProjeto.setTitulo(informacao);
                System.out.println("Objetivo: ");
                informacao = Ler.nextLine();
                novoProjeto.setObjetivo(informacao);
                System.out.println("Descrição: ");
                informacao = Ler.nextLine();
                novoProjeto.setDescricao(informacao);

                System.out.println("Agencia Financiadora: ");
                informacao = Ler.nextLine();
                novoProjeto.setAgenciaFinaciadora(informacao);
                System.out.println("Valor Financiado: ");
                valor = Ler.nextDouble();
                novoProjeto.setValorFinanciado(valor);

                System.out.println("Informe a data de Inicio do Projeto: ");
                System.out.println("Dia: ");
                dia = Ler.nextInt();
                System.out.println("Mês: ");
                mes = Ler.nextInt();

                System.out.println("Ano: ");
                ano = Ler.nextInt();
                novoProjeto.setDataInicio(dia, mes, ano);

                System.out.println("Informe a data de Término do Projeto: ");
                System.out.println("Dia: ");
                dia = Ler.nextInt();
                System.out.println("Mês: ");
                mes = Ler.nextInt();
                System.out.println("Ano: ");
                ano = Ler.nextInt();
                novoProjeto.setDataTermino(dia, mes, ano);

                limparLixo = Ler.nextLine();
            }catch(InputMismatchException II){
                verifica = true;
                System.out.println("\n-> Erro! Tipo de dado incorreto, abortando o cadastro do novo projeto!");
            }
            
            if(!verifica)
            {
                
                System.out.println("É necessario vincular um professor ao projeto!");
                System.out.println("Informe o nome do Professor escolhido: ");
                informacao = Ler.nextLine();

                for(Professor Item : this.getListaDeProfessores()){
                    if(Item.getNome().equals(informacao)){
                        novoProjeto.setProfessoresVinculados(Item);
                        novoProjeto.setInformacaoCompleta(true);
                        Item.setProjetosDePesquisa(novoProjeto);
                        this.ListaDeProjetos.add(novoProjeto);
                        System.out.println("\n-> Projeto criado com sucesso");
                        break;
                    }
                }
            }
        }else{
            System.out.println("Um projeto deve possui ao menos um professor como participante!");
            System.out.println("Dica: Não ha professores cadastrados!");
        }
    }
    public void MostarProjetos()      
    {
        for(Projeto Item : this.getListaDeProjetos()){
            System.out.println("\n");
            Item.MostrarProjeto();
        }
    }
    public void CadastrarProfessor(){
        String informacao;
        
        Professor novoProfessor = new Professor();
        novoProfessor.CadastrarPessoa();
        novoProfessor.setNivelUniversitario("Professor");
        
        this.ListaDeProfessores.add(novoProfessor);
        this.Colaboradores.add(novoProfessor);
        
        System.out.println("\n-> Professor cadastrado com sucesso!");
    }
    public void CadastrarAluno(){
        String informacao;
        
        Aluno novoAluno = new Aluno();
        
        novoAluno.CadastrarPessoa();
        this.ListaDeAlunos.add(novoAluno);
        this.Colaboradores.add(novoAluno);
        System.out.println("\n-> Aluno cadastrado com sucesso!");
    }
 
    public void AlocarParticipantes(){
        
            int opcao = 0;
            String auxiliar;
            String limparLixo;
            
            System.out.println("Informe o nome do Projeto para o qual deseja alocar participantes: ");
            auxiliar = Ler.nextLine();
            
            for(Projeto projeto : this.getListaDeProjetos()){
                if(projeto.getTitulo().equals(auxiliar)){
                    
                    if(projeto.getStatus().equals("Em elaboração"))
                    {
                        System.out.println("Informe qual o tipo de participante deseja alocar para o projeto: \n");
                        System.out.println("1 - Aluno;");
                        System.out.println("2 - Professor;\n");

                        opcao = Ler.nextInt();
                        limparLixo = Ler.nextLine();
                        
                        if(opcao == 1){

                            System.out.println("Informe o nome do Aluno que deseja alocar para o projeto: ");
                            auxiliar = Ler.nextLine();
                            for(Aluno aluno : this.ListaDeAlunos)
                            {
                                if(aluno.getNome().equals(auxiliar)){
                                    
                                    if(projeto.getAlunosVinculados().contains(aluno)){
                                        System.out.println("Aluno já esta vinculado ao projeto!");
                                    }else{
                                        projeto.setAlunosVinculados(aluno);
                                        aluno.setProjetosDePesquisa(projeto);
                                        
                                        for(Professor prof : this.ListaDeProfessores){
                                            prof.setOrientacoes(aluno);
                                        }
                                        System.out.println("\n-> Alocação efetuada com sucesso!");
                                    }
                                    break;
                                }
                            }
                        }else{
                           
                            System.out.println("\nInforme o nome do Professor que deseja Alocar para o projeto:\n");
                            auxiliar = Ler.nextLine();
                            
                            for(Professor professor : this.getListaDeProfessores()){
                                if(professor.getNome().equals(auxiliar)){
                                    
                                    if(projeto.getProfessoresVinculados().contains(professor)){
                                        System.out.println("Este professor ja esta vinculado ao projeto!");
                                    }else{
                                        professor.setProjetosDePesquisa(projeto);
                                        projeto.setProfessoresVinculados(professor);
                                    }
                                    break;
                                }
                            }
                            System.out.println("\n-> Alocação efetuada com sucesso!");
                        }
                    }else{
                        System.out.println("\n-> O status do Projeto não permite a alocação de participantes!");
                    }
                }
            }       
    }
    public void AlterarStatus()
    {
        int opcao;
        String auxiliar;
        String Lixo;
        Aluno novoAluno = null;

        System.out.println("Informe o Titulo do projeto que deseja alterar o Status: ");
        auxiliar = Ler.nextLine();

        for(Projeto projeto : this.ListaDeProjetos)
        {
            if(projeto.getTitulo().equals(auxiliar))
            {
                System.out.println("Informe a opção desejada: \n");
                System.out.println("1 - De 'Em elaboração' para 'Em andamento';");
                System.out.println("2 - De 'Em andamento' para 'Concluido';");

                opcao = Ler.nextInt();
                Lixo = Ler.nextLine();

                if(opcao == 1)
                {
                    //Procurar os alunos graduando

                    for(Aluno aluno : projeto.getAlunosVinculados())
                    {
                        if(aluno.getNivelUniversitario().equals("Graduacao"))
                        {
                            if(aluno.getQuantidadeEmAndamento() == 2)
                            {
                                aluno.setQuantidadeEmAndamento();
                                System.out.println("Aluno '"+ aluno.getNome() + "' já esta vinculado a dois projetos 'Em andamento'!");
                                System.out.println("É necessario substituir um dos projetos 'Em andamento' pelo projeto que tera o status alterado!");

                                System.out.println("\nProjetos 'Em andamento' que o aluno está vinculado: ");
                                for(Projeto projeto1 : aluno.getProjetosDePesquisa())
                                {
                                    if(projeto1.getStatus().equals("Em andamento"))
                                    {
                                        System.out.println("Titulo: " + projeto1.getTitulo());
                                        System.out.println("Descrição: " + projeto1.getDescricao());
                                    }
                                }

                                System.out.println("\n Informe o Titulo do projeto que deseja desvincular do aluno em questão: ");
                                auxiliar = Ler.nextLine();

                                // Desvincula o aluno atual do projeto em andamento escolhido
                                for(Projeto projeto1 : aluno.getProjetosDePesquisa())
                                {
                                    if(projeto1.getTitulo().equals(auxiliar))
                                    {
                                        projeto1.getAlunosVinculados().remove(aluno);
                                        aluno.getProjetosDePesquisa().remove(projeto1);
                                        for(Professor prof : projeto1.getProfessoresVinculados()){
                                            prof.getOrientacoes().remove(aluno);
                                        }
                                        aluno.setDiminuirQuantidadeEmAndamento();

                                        // atualiza a listaDeProjetos com o projeto do qual o aluno foi removido!
                                        for(Projeto projeto2 : this.ListaDeProjetos)
                                        {
                                            if(projeto2.getTitulo().equals(projeto1))
                                            {
                                                projeto2 = projeto1;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }

                            }else{
                                aluno.setQuantidadeEmAndamento();
                            }

                        }
                    }
                    projeto.setStatus("Em andamento");
                    System.out.println("\nStatus alterado com sucesso!\n");
                    break;
                }else{

                    if(projeto.getPublicacoesVinculadas().size() > 0)
                    {

                        projeto.setStatus("Concluido");
                        for(Aluno aluno : projeto.getAlunosVinculados())
                        {
                            if(aluno.getNivelUniversitario().equals("Graduacao"))
                            {
                                aluno.setDiminuirQuantidadeEmAndamento();

                                for(Aluno aluno1 : this.ListaDeAlunos)
                                {
                                    if(aluno1.getNome().equals(aluno.getNome()))
                                    {
                                        aluno1 = aluno;
                                        break;
                                    }
                                }
                            }
                        }
                        System.out.println("Status alterado com sucesso!\n");
                    }else{
                        System.out.println("Não ha publicações vinculadas ao projeto!");
                    }
                }
            }
        }
}
    public void MostrarAluno(){
        
        String nome;
        System.out.println("Informe o nome do aluno que deseja ver as informações: ");
        nome = Ler.nextLine();
        
        for(Aluno aluno : this.ListaDeAlunos){
            
            if(aluno.getNome().equals(nome)){
                aluno.MostrarPessoa();
                System.out.println("\n");
            }
        }
    }
    public void AdicionarPublicacao(){
        
        Publicacao novaPublicacao = new Publicacao();
        
        String auxiliar;
        String lixo;
        
        int ano;
        int opcao;
        int quantidade = 0;
        boolean checar = false;
        boolean verifica = false;
        
        try
        {
            System.out.println("Informe o Titulo da publicação: ");
            auxiliar = Ler.nextLine();
            novaPublicacao.setTituloPublicacao(auxiliar);
            System.out.println("Informe o nome da conferencia onde foi publicada: ");
            auxiliar = Ler.nextLine();
            novaPublicacao.setNomeConferencia(auxiliar);
            System.out.println("Informe o ano de publicação: ");
            ano = Ler.nextInt();
            lixo = Ler.nextLine();
            novaPublicacao.setAnoPublicacao(ano);

            System.out.println("Informe quantos autores tera a publicação:\n ");
            quantidade = Ler.nextInt();
            lixo = Ler.nextLine();
        }catch(InputMismatchException I){
            verifica = true;
            System.out.println("-> Não será possivel adicionar a publicação, tipo de dado inesperado inserido!");
            System.out.println("-> Interrompendo a operação!");
        }

        if(!verifica)
        {
            for(int i = 0; i < quantidade ; i++)
            {
                System.out.println("Informe o nome do autor " + i + ": ");
                auxiliar = Ler.nextLine();

                for(Aluno aluno : this.ListaDeAlunos)
                {
                    if(aluno.getNome().equals(auxiliar))
                    {
                        novaPublicacao.setAutores(aluno);
                        aluno.setPublicacoes(novaPublicacao);
                        checar = true;
                        break;
                    }
                }
                if(!checar){

                    for(Professor professor : this.ListaDeProfessores)
                    {
                        if(professor.getNome().equals(auxiliar))
                        {
                            novaPublicacao.setAutores(professor);
                            professor.setPublicacoes(novaPublicacao);
                            break;
                        }
                    }
                     checar = false;
                }
            }
            System.out.println("Autor(es) adicionado(os) com sucesso!\n");
            this.ListaDePublicacoes.add(novaPublicacao);
        }
    }
    public void AlocarPublicacao(){
        
        String auxiliar;
        boolean verifica = false;
        
        System.out.println("Lista de Projetos Disponiveis: \n");
        for(Projeto projeto : this.ListaDeProjetos)
        {
            if(projeto.getStatus().equals("Em andamento"))
            {
                verifica = true;
                System.out.println("Titulo do projeto: " + projeto.getTitulo());
                System.out.println("Descrição: " + projeto.getDescricao());
            }
        }
        
        boolean verifica1 = false;
        
        if(verifica)
        {    
            System.out.println("Informe o Titulo do projeto para o qual deseja vincular uma publicação: ");
            auxiliar = Ler.nextLine();

            for(Projeto projeto : this.ListaDeProjetos)
            {
                if(projeto.getTitulo().equals(auxiliar) && projeto.getStatus().equals("Em andamento"))
                {
                    System.out.println("Publicações Disponiveis: \n");
                    for(Publicacao pub : this.ListaDePublicacoes)
                    {
                        if(!projeto.getPublicacoesVinculadas().contains(pub))
                        {
                            System.out.println("Titulo de Publicação: " + pub.getTituloPublicacao());
                        }
                    }
                    
                    System.out.println("\nInforme a Publicação que deseja vincular ao projeto: ");
                    auxiliar = Ler.nextLine();

                    for(Publicacao pub : this.ListaDePublicacoes)
                    {
                        if(pub.getTituloPublicacao().equals(auxiliar))
                        {
                            projeto.setPublicacoesVinculadas(pub);
                            pub.setProjetosAssociados(projeto);
                            System.out.println("Publicação alocada com sucesso!");
                            verifica1 = true;
                            break;
                        }
                    }
                }
                  if(verifica1){
                        break;
                    }
            }
        }else{
            System.out.println("Não ha projetos 'Em andamento' disponiveis!");
        }
    }
    public void Consulta(){
        
        String auxiliar;
        String lixo;
        int opcao;
        
        try
        {
            System.out.println("Informe a consulta que deseja fazer: \n");
            System.out.println("1 - Colaborador;");
            System.out.println("2 - Projeto;\n");

            opcao = Ler.nextInt();
            lixo = Ler.nextLine();

            if(opcao == 1){

                System.out.println("Informe o nome do Colaborador que deseja consultar: ");
                auxiliar = Ler.nextLine();

                for(Pessoa pessoa : this.Colaboradores)
                {
                    if(pessoa.getNome().equals(auxiliar))
                    {
                        pessoa.MostrarPessoa();
                    }
                }
            }else{

                System.out.println("Informe o nome do Projeto que deseja consultar: \n");
                auxiliar = Ler.nextLine();

                for(Projeto projeto : this.ListaDeProjetos)
                {
                    if(projeto.getTitulo().equals(auxiliar))
                    {
                        projeto.MostrarProjeto();
                    }
                }
            }
        }catch(InputMismatchException III){
            
            System.out.println("-> Consulta não poderá ser realizada! Tipo de dado esperado não informado!");
        }
    }
    public void Relatorio(){
        
        int c = 0, c1=0, c2=0;
        
        System.out.println("Relatorio de Produção academica: \n");
        System.out.println("Numero de Colaboradores: " + this.Colaboradores.size());
        System.out.print("Numero de Projetos 'Em elaboração': ");
        for(Projeto projeto : this.ListaDeProjetos)
        {
            if(projeto.getStatus().equals("Em elaboração"))c+=1;
            else if(projeto.getStatus().equals("Em andamento"))c1+=1;
            else if(projeto.getStatus().equals("Concluido"))c2+=1;
        }
        System.out.println(c);
        
        System.out.println("Numero de Projetos 'Em andamento': " + c1);
        System.out.println("Numero de Projetos Concluidos: " + c2);
        System.out.println("Numero total de Projetos: " + this.ListaDeProjetos.size());
        System.out.println("Numero de Publicações: " + this.ListaDePublicacoes.size());
        
    }
}
