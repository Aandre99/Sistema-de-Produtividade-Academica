import java.util.Scanner;

public class Main {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args){
        int opcao;

        SistemaDeGerenciamento SistemaGeral = new SistemaDeGerenciamento();

        do
        {
            MenuPrincipal();
            opcao = ler.nextInt();
            if(opcao == 0){
                break;
            }
            switch (opcao)
            {
                case 1:
                    SistemaGeral.AdicionarAlunos(SistemaGeral);
                    break;
                case 2:
                    SistemaGeral.AdicionarProfessores(SistemaGeral);
                    break;
                case 3:
                    SistemaGeral.AdicionarProjetos(SistemaGeral);
                    break;
                case 4:
                    SistemaGeral.AlocarParticipantes(SistemaGeral);
                    break;
                case 5:
                    SistemaGeral.EditarProjetos(SistemaGeral);
                    break;
                case 6 :
                    SistemaGeral.AdicionarPublicacao(SistemaGeral);
                    break;
                case 7:
                    SistemaGeral.MostrarCadastrados(SistemaGeral);
                    break;
            }
        }while(true);
    }
    public static void MenuPrincipal(){

        System.out.println("----------MENU-------------");
        System.out.println("Informe a opção desejada: \n");
        System.out.println("1 - Adicionar um aluno ao Sistema:");
        System.out.println("2 - Adicionar um Professor ao Sistema:");
        System.out.println("3 - Adicionar um Projeto ao Sistema:");
        System.out.println("4 - Alocar colaboradores;");
        System.out.println("5 - Editar Status do projeto;");
        System.out.println("6 - Adicionar novaPublicacao;");
        /*System.out.println("7 - Realizar uma consulta;");
        System.out.println("8  -Relatorio de Produção Acadêmica;");*/
        System.out.println("7 - IMprimir;");
        System.out.println("0 - Sair;");
        System.out.println("-------------------------------");
    }
}
