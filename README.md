<h1>PostNow</h1>


Este projeto consiste na implementação de um aplicativo de Blog que permite listar e criar posts, utilizando uma API mockada para simular o backend. Abaixo estão detalhadas as telas e funcionalidades desenvolvidas.

**Telas do Aplicativo**

**Tela de Listagem de Posts:**

-Esta tela é a tela inicial do aplicativo.

-Apresenta uma lista dinâmica de posts, exibindo o título e a data de criação de cada post.

-Clicar em um post direciona o usuário para a tela de detalhes daquele post.

-Inclui um botão para criar um novo post, que leva o usuário para a tela de adição de novo post.

-A lista é scrollável verticalmente para lidar com diferentes quantidades de posts.



**Tela de Detalhes do Post:**

-Exibida ao clicar em um post na tela de listagem.

-Mostra o título, a data de criação e a descrição completa do post.

-Possui um botão "voltar" que retorna o usuário para a tela de listagem de posts.



**Tela de Adição de Novo Post:**

-Apresenta campos para inserir o título e o conteúdo (descrição) do novo post.

-Inclui um botão "voltar" que retorna o usuário para a tela inicial, sem salvar dados inseridos.

-Um botão de conclusão permite ao usuário adicionar o novo post, desde que todos os campos estejam preenchidos corretamente (sem títulos ou conteúdos vazios).


**Tecnologias Utilizadas**

Linguagem: Kotlin

Arquitetura: MVVM (Model-View-ViewModel)

Biblioteca para Requisições HTTP: Retrofit 


**Link para a API mockada**

https://www.postman.com/restless-shuttle-127877/workspace/postnow/request/17739715-deece5ee-2244-4843-8ab2-62df82062db3


