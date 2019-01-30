# Sistema de Produtividade Academica

## <h2/>  Funcionalidades: <br/>
   # <h4/> 1 - Cadastrar Professor; <br/><br/>
   Nesta função é necessário inserir as informações básicas de um colaborador do tipo *Professor*, tais como nome, e-mail, endereço , etc; 
  ##  <h4/> 2 - Cadastrar Aluno;
  -  Nesta função é necessário inserir as informações basicas de um colaborador do tipo *Aluno*, como mensaionado no comentário anterior
   ##  <h4/> 3 - Cadastrar Projeto;
  -  Necessita das informações básicas de um *Projeto*, tais como Título, Objetivo, Descrição, Agência Financiadora, datas de início e término do projeto;<br/> Obs: É necessário a existencia de um Professor cadastrado no sistema para que um projeto possa ser criado e iniciado;
  ## <h4/> 4 - Adicionar Publicação;
  - Para a criação de um publicação , é necessário informar o Titulo, Conferência na qual esta foi publicada, ano de publicação e os colaboradores responsáveis pela propria publicação;
  ## <h4/> 5 -  Alocação de Colaboradores;
  - Esta função é responsável por vincular colaboradores ao projeto escolhido. <br/>Para vincular um colaborador a um projeto é necessário que o status do projeto esteja *'Em elaboração'*  e com todas as suas informações completas.
  ## <h4/> 6 -  Alocacar Publicação;
  - Esta funcão associa uma publicação armazenada no sistema a um projeto qualquer.<br/> Obs: A publicação so pode ser vinculado ao projeto se seu status atual é *'Em andamento'*;
  ## <h4/> 7 -  Alterar Status do Projeto;
  - Para tal função é necessario informar o tipo de alteração, (1) 'Em elaboração' para 'Em andamento' ou (2) 'Em andamento' para 'Concluido'.<br/>A alteração do tipo (1) só é possivel se o projeto possui todas as informações básicas completas;<br/>A alteração do tipo (2) so será efetuada se o projeto possuir publicações vinculadas.
  ## <h4/> 8 - Consulta;
  - Nesta função é possivel o acesso a informações sobre colaboradores (Professor ou Aluno) e projetos cadastrados no sistema de produção acadêmica;
   ## <h4/> 9 - Relatório de Produção Acadêmica;
   -  Mostra um resumo geral do Sistema de Gerenciamento Acadêmico, incluindo quantidade de projetos, colaboradores, publicações e suas especifidades;  <br/>
   # <h2/> Classes:<br/>
   -  ## <h4/> 1 - Pessoa;
      - **Motivação**: Criação de um Tipo que referenciasse um colaborador em geral, seus atributos basicos e fuções de acesso, lembrando que um colaborador(Pessoa) pode ser do Professor ou Aluno(Graduação, Mestrado, Doutorado) e que estes dois tipos possuem atributos unicos para cada caso; 
      - **Solução**: Criou-se uma classe que representa da forma mais comum os dois tipos de Pessoas envolvidas.Pessoa é uma classe Abstrata pois não precisa ser refenciada e funciona apenas como um modelo para os dois tipo de colaboradores.
      - **Vantagens**: Diminui codigos duplos e aplica o conceito de Herança , tornando os processos mais efetivos de forma simples. 
      - **Desvantagens**: 
   -  ## <h4/>2 -  Aluno;
      - **Motivação**: Havia a necessidade de representar um colaborador do tipo aluno que podesse ser graduando, mestrando e doutorando e  que seria uma subclasse do tipo 'Pessoa', buscando organizar a divisão e representação dos diferentes tipos de colaborados e seus atributos.
      - **Solução**: Implementou-se uma classe que possui atributos referentes ao tipo Aluno, tais como Listas de professores dos quais este aluno tem orientação e quantidade de projetos vinculados com status 'Em andamento' , uma vez que alunos de graduação não podem estar associados a mais de dois projetos com este status.
      - **Vantagens**: Maior facilidade em atribuir e editar informações deste Aluno buscando sempre aplicar os conceitos de encapsulamento.
       - **Desvantagens**: 
   -  ## <h4/> 3 - Professor;
      - **Motivação**: Representar um calaborador do tipo Professor subclasse de 'Pessoa'.
      - **Solução**: Criou-se uma classe responsável por atributos e funções relacionadas a um Professor, possuindo unicamento uma lista de Oriemtações usada para armazenar objetos do tipo Aluno, os quais são orientados pelo professor em questão. 
      - **Vantagens**: Organização do sistema e facil acesso ao Objeto 'Professor' e suas funcões proprias.
      - **Desvantagens**:
   -  ## <h4/> 4 - Projeto;
      - **Motivação**: Representar a estrutura de um projeto, amenizando os processos referentes ao sistema de gerenciamento e tornando sistema mais simples e direto.
      - **Solução**: Criou-se uma classe possuidora de atributos referentes a um projeto genérico, tais como: Titulo, Objetivo, Status, Descrição, datas de início e término, Listas de Alunos, professores e projetos vinculados.
      - **Vantagens**: Melhor gerenciamento do projeto, fácil acesso e representação simples.
      - **Desvantagens**: 
   -  ## <h4/> 5 - Publicação;
      - **Motivação**: Representar de forma simples como seria a estrutura de uma publicação, seus atributos e utiliza-la em conjunto com as outras classes a fim de organizar o sistema aumentando o seu desempenho.
      - **Solução**: A classe publicação deveria possuir atributos voltados ao armazenamento de conjunto, tais como Autores, Projetos associados e informações básicas, tais como: Titulo, Conferência na qual foi publicada e ano de publicação.
      - **Vantagens**: Melhor representação dos dados , fácil manuseio de funções de edição e atributos.
      - **Desvantagens**:
   -  ## <h4/> 5 - ControleDoSistema;
      - **Motivação**: Criar uma classe que possuisse os atributos gerais do sistema e que fosse responsavel por controlar todas as suas funções, tais como as funcionalidades citadas no início desta descrição.
      - **Solução**: A classe de Controle possui os atributos gerias do sistema de gerenciamento, tais como Listas de Projetos, Professores, Alunos,Colaboradores e Publicações e as funcões de edição citadas no inicio da descrição.
      - **Vantagens**: Alem de gerenciar todo o sistema, esta classe possui todas as funcões responsáveis por este gerenciamento, ocasionando um fácil acesso as listas de dados e suas funções especificas.
      - **Desvantagens**: Por possuir todas as funcionalidades contidas em si, esta classe possui um tamamho considerável.

## <h2/>  Distribuição de Métodos: <br/>
-   os metódos que representam as funcionalidades principais foram dispostos na Classe **ControleDoSistema**, pois os atribuitos reponsáveis pelo armazenamento geral do sistema foram listados dentro desta classe, tornando a manipulação mais simples e eficaz.
-  ## <h4/> 1 - Menu Principal() ;
      - **Motivação**: Criar uma função que informasse ao usuario, as possibilidades oferecidas pelo Sistema.
      - **Solução**: Mostrar um menu personalizado demonstrando todas as opções do sistemas , numeradas na ordem crescente de escolha.
      - **Vantagens**: Interação com o usuário.
      - **Desvantagens**: 
-  ## <h4/> 2 - Contrutor ControleDoSitema() ;
      - **Motivação**: Inicializar os atributos da Classe/Sistema, criando incialmente as listas de armazenamento geral.
      - **Solução**: Inicializa as listas atribuindo-lhes referencias a conjunto de dados do tipo especificado.
      - **Vantagens**: Evita erros de incialização e utilização destes atributos.
      - **Desvantagens**: 
-  ## <h4/> 3 - CadastrarProjeto() ;
      - **Motivação**: Pelo fato da lista de projetos de armazenamento geral esta localizada na classe ControleDoSistema, esta função foi disposta nesta classe a fim de facilitar o acesso aos dados necessários para efetivar a função por esta referenciada e ainda pelo fato da ação de Criar um projeto ser uma possibilidade marcante do sistema.
      - **Solução**: A função requer a entrada das informações basicas do novo projeto, tais como Titulo, Descrição, data de Início e Término.
      - **Vantagens**: Fácil acesso a lista de Projetos associados, podendo um projeto ser adicionado rapidamente por meio desta função.
      - **Desvantagens**: Se não houver ao menos um professor cadastrado no Sitema o projeto não poderá ser adicionado.
-  ## <h4/> 4 - CadastrarProfessor() ;
      - **Motivação**: Adicionar novos professores ao sistema, que podem ser vinculados a projetos, responsaveis por orientar alunos ou resposaveis por uma publicação. Esta função foi posta na Classe ControleDoSistema, pois foi notado que seria de fácil acesso a manipulção da lista geral de professores localizada no classe citada.
      - **Solução**: A função CadastrarProfessor() utiliza a facilidade da herança para cadastrar as informações comuns a *Pessoas* por meio da Função CadastrarPessoa() localizada na superclasse. Estas duas funções necessitam das informações básicas de um colaborador(Pessoa), tais como nome, e-mail, endereço etc.
      - **Vantagens**: Fácil acesso a lista de alunos/colaboradores disposta na classe ControleDoSistema.
      - **Desvantagens**:
-  ## <h4/> 5 - CadastrarAluno() ;
      - **Motivação**: Adicionar novos alunos ao sistema, que podem ser vinculados a projetos, ou responsáveis por uma publicação. Esta função foi posta na Classe ControleDoSistema, pois foi notado que seria de fácil acesso a manipulção da lista geral de alunos localizada no classe citada.
      - **Solução**: A função CadastrarAluno() funciona da mesma forma que a função CadastrarPreofessor(), porém e adicionado o atributo NivelUniversitário, então ao preencher estas informações o novo aluno e adicionado na listas geral de alunos e de colaboradores.
      - **Vantagens**: Fácil acesso a lista de alunos/colaboradores disposta na classe ControleDoSistema.
      - **Desvantagens**:
-  ## <h4/> 6 - AlocarParticipantes() ;
      - **Motivação**: Esta função foi disposta nesta classe pelo fato do acesso aos dados necessarios para efetivar a sua função estão localizados na classe ControleDoSistema. 
      - **Solução**: A função AlocarParticipantes() é reponsavel por vincular os colaboradores à projetos escolhidos pelo administrador do sistema, ela checa se o status do sistema é 'Em andamento' e se for retornado true a função aloca o colaborador.
      - **Vantagens**: É possivel escolher o tipo de colaborador, Aluno ou Professor a ser alocar para determinado projeto.
      - **Desvantagens**:
-  ## <h4/> 7- AlterarStatus();
      - **Motivação**: Fácil acesso as listas de projetos e colaboradores(Alunos e Professores) disposto na classe ControleDoSistema  , classe esta em que a função se encontra.
      - **Solução**: A função em questão pode alterar o status do projeto de (1) Em elaboração para Em andamento ou (2) Em andamento para Concluído. A função também verifica se no projeto o qual se quer alterar o status existem alunos de Graduação já vinculados em dois projetos 'Em andamento' (Não e permitido que um aluno de graduação estaja vinculado a mais de dois projetos 'Em andamento') então se isto acontecer o sistema pede ao usuario para desvincular o determinado aluno de um outro projeto em andamento ja vinculado, o que faz com que a regra não seja violada.
      - **Vantagens**: Controle mais efetivo da alteração do status de um projeto, alem da facilidade do acesso as informaçes.
      - **Desvantagens**: Se um aluno ja estiver vinculado a dois projetos em andamento e necessário desvincula-lo de um destes projeto se desejar realmente fazer a alteração do status do projeto.
-  ## <h4/> 8 - MostrarAluno()
      - **Motivação**: desenvolver uma maneira de vizualizar facilmente as informações de um dado aluno.
      - **Solução**: A função MostrarAluno() utiliza a facilidade do polimorfismo da superclasse 'Pessoa' para imprimir as informações do aluno que s queira verificar.
      - **Vantagens**: Pode-se facilmente ter acesso a essa função e aos atributos acessados por ela, pois a função se encontra na origem do armazenamento do sistema.
      - **Desvantagens**:
-  ## <h4/> 9 - AdicionarPublicacao()
      - **Motivação**: Como uma publicação pode ser vinculada a um projeto , ela deve ser criada inicialmente e armazenada na lista geral de publicações, isso demonstra o por que desta função estar localizada na classe ControleDoSistema 
      - **Solução**: Esta função necessita das informações básicas de uma publicação , tais como Titulo. Conferencia onde foi publicada e ano de publicação.Ainda e responsavel por adicionar os autores a nova publicação, o que torna-se facil uma vez que a função foi colocada na classe ControleDoSistema , onde estão localizadas as listas de Aluno e Professores.
      - **Vantagens**: É possivel escolher a quantidade de autores de uma publicação.
      - **Desvantagens**:
-  ## <h4/> 10 - AlocarPublicacao()
      - **Motivação**: As informacões necessarias para a efetivação da funcionalidade estão dispostas em ControleDoSistema, sendo assim, e mais fácil obter as informações utilizadas na função AlocarPublicacao.
      - **Solução**: A função necessita do projeto  que se deseja vincular e que este projeto possua o status 'Em andamento', se isto for confirmado a publicação é vinculada ao projeto.
      - **Vantagens**: A vinculação pode ser feita quando desejavel, sendo atendidas todas as regras para a alocação.
      - **Desvantagens**:
-  ## <h4/> 11 - Consulta()
      - **Motivação**: As informacões necessarias para a efetivação da funcionalidade estão dispostas em ControleDoSistema, sendo assim, e mais fácil obter as informações utilizadas na função Consulta, facilitando a execução desta funcionalidade.
      - **Solução**: Esta função mostra as informações de um colaborador qualquer, tais como: nome, e-mail, historico de projetos, publicações associadas etc.
      - **Vantagens**: facil acesso as informações que se quer visualizar.
      - **Desvantagens**:
-  ## <h4/> 12 - Relatório()
      - **Motivação**: Esta função foi posta na classe ControleDoSistema devido ao fácil acesso as informações por ela utilizada.
      - **Solução**: Mostrar um relatorio geral do Sistema de Gerenciamento Acadêmico.
      - **Vantagens**: Fácil vizualização das informações atual do sistema.
      - **Desvantagens**:
-   ## <h2/>  Herança: <br/>
      - **Motivação**: Os dois tipos de colaboradores possuem varios atributos em comum, dai a ideia de utilizar a herança.As classe Aluno e Professor são subclasses de Pessoa, que é uma classe Abstrata.
      - **Solução**: As duas classes (Aluno e Professor) são subclasses de Pessoa;
      - **Vantagens**: Utilização dos conceitos de herança para aumentar a facilidade do projeto.
      - **Desvantagens**:
-   ## <h2/>  Abstrata: <br/>
      - **Motivação**: Era necessário criar uma superclasse para facilitar o uso da herança no projeto, porem a classe pessoa não precisa ser instanciada, serve apenas como modelo para as suas subclasses.
      - **Solução**:
      - **Vantagens**:
      - **Desvantagens**:
