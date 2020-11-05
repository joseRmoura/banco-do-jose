<h1 align="center">Banco do José</h1>

<p>Para ter acesso ao Swagger da aplicação acesse a URL:http://localhost:8080/swagger-ui.html/</p>
<p>OBS:para acessar o Swagger é necessário criar email e senhas de acesso.</p>

<p align="justify">Esta é uma API feita para uma empresa de empréstimos que solicitou a atualização 
de seu sistema de análise de crédito para fornecer aos seus clientes.</p>

<p align="justify">A API consiste das seguintes funcionalidades:</p>
<p>•Cadastro</p>
<p>•Login</p>
<p>•Buscar usuário</p>
<p>•Solicitação de empréstimo</p>
<p>•Acompanhamento das propóstas por usuário</p>

<h2>Acesso aos end points:</h2>

<p>•Foi encaminhado junto ao e-mail um arquivo chamado "tqi teste.postman_collection "
onde se encontra todas as URL's para teste. </p>
<p>•Dentro da pasta "diagramas" estão os diagramas da aplicação.</p>

<h3>Cadastro de Usuário</h3>

<p>Para realizar o cadastro de usuário, utilize o endpoint [POST] http://localhost:8080/usuarios,no body da requisição
especifique os atributos utilizando a estrutura JSON</p>
<p>
{
    "nome": "João Silva",
    "email": "teste2@gmail.com",
    "senha": "teste2"
}

Se o usuário for criado será retornado o http status 201,
 no payload da resposta terá os dados do usuário criado seguindo a estrutura JSON abaixo:

{
    "id": 1,
    "nome": "João Silva",
    "email": "teste2@gmail.com",
    "emprestimos": []
}

guarde o id para consultas futuras.
</p>

<h3>Buscar Usuário:</h3>

<p>Para realizar a busca de usuário é necessário informar o email e senha de login em Authorization,
 assim o postman irá criar o header Authorization Basic nos headers da requisição</p>
<p>OBS:Caso o email ou a senha estiverem incorretos, não será possível fazer a consulta retornando o http status 401.</p>
<p>Após a etapa anterior utilize o endpoint [GET] "http://localhost:8080/usuarios/{id}"</p>
<p>No payload da resposta terá os dados da busca de usuário:
{
    "id": 1,
    "nome": "João Silva",
    "email": "teste2@gmail.com",
    "emprestimos": []
}
</p>

<h3>Solicitar Empréstimo:</h3>

<p>Para realizar a solicitação é necessário realizar o login novamente.</p>
<p>Utilize o endpoint [POST] "http://localhost:8080/emprestimos", no body da requisição especifique os atributos
utilizando a estrutura JSON:</p>
<p>
{
    "motivo": "Comprar carro",
    "valor": 35311,
    "situacao": "APROVADO",
    "usuario": {
        "id": 1
    }
}

Se o empréstimo for solicitado, no payload da resposta
terá os dados da solicitação.

{
    "id": 1,
    "motivo": "Comprar carro",
    "valor": 35311,
    "situacao": "APROVADO",
    "createdAt": "2020-08-31",
    "updatedAt": "2020-08-31"
}
</p>

<h3>Consultar emprestimos do usuario:</h3>

<p>Efetue o login novamente e prossiga com a consulta.</p>
<p>Para realziar a consulta de emprestimos de um usuário utilize o endpoint
[GET]"http://localhost:8080/emprestimos?usuario={id}".</p>
<p>Será retornado no payload da resposta os dados da consulta:
[
    {
        "id": 1,
        "motivo": "Comprar carro",
        "valor": 35311.00,
        "situacao": "APROVADO",
        "createdAt": "2020-08-31",
        "updatedAt": "2020-08-31"
    }
]
</p>