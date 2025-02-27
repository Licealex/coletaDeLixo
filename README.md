<h1>API Documentation - FIAP - Coleta de Lixo</h1>

<h2>Sumário</h2>
<ol>
<li><a href="#introdu%C3%A7%C3%A3o">Introdução</a></li>
<li><a href="#autentica%C3%A7%C3%A3o">Autenticação</a></li>
<li><a href="#autentica%C3%A7%C3%A3o">Banco de dados</a></li>
<li><a href="#endpoints">Exemplo de um endpoint</a>
   <ul>
      <li><a href="#post-apiresource">GET /api/clientes</a></li>
   </ul>
<li><a href="#endpoints">Exemplo do endpoint para o banco de dados H2</a>
   <ul>
      <li><a href="#post-apiresource">BDH2 /api/h2-console</a></li>
</ul>
</li>
</li>
<li><a href="#c%C3%B3digos-de-status">Códigos de Status</a></li>
<li><a href="#exemplos-de-uso">Exemplos de Uso</a></li>
<li><a href="#erros-comuns">Erros Comuns</a></li>
</ol>

<h2><a id="introdu%C3%A7%C3%A3o"></a>Introdução</h2>

<p>Bem-vindo à documentação da <strong>Rotas de Coleta API</strong>. Esta API permite que você interaja com o nosso serviço de maneira programática. Utilize os endpoints listados abaixo para realizar operações como <strong>cadastrar nova rota ou cliente</strong>, <strong>atualizar rota ou cliente</strong>, <strong>consultar rota ou cliente</strong> e <strong>excluir rota ou cliente</strong> dados.</p>

<p>Base URL da API: </p>
<pre><code>http://localhost:8080/api
</code></pre>

<h2><a id="autentica%C3%A7%C3%A3o"></a>Autenticação (AINDA PRECISA FAZER)</h2>

<p>Esta API utiliza <strong>autenticação baseada em tokens</strong> (ex: JWT) para verificar as permissões dos usuários. Para cada requisição, você deve incluir o token de autenticação no cabeçalho da requisição.</p>

<h3>Exemplo de Cabeçalho de Autenticação</h3>
<pre><code>Authorization: Bearer {seu_token_aqui}
</code></pre>

<h3>Obtendo o Token</h3>
<p>O token pode ser obtido através do endpoint de login:</p>
<pre><code>POST /auth/login
</code></pre>
<p>Envie suas credenciais no corpo da requisição e receba o token de acesso.</p>

<hr>

<h2><a id="autentica%C3%A7%C3%A3o"></a>Banco de dados</h2>

<p>Banco de dados tem que ser configurado no arquivo application.properties</p>

<p>Caminho do arquivo src/main/java/br.com.fiap.coleDeLixo/resources/application.properties</p>

### ORACLE BD ###

>spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
>
>spring.datasource.username=RM000000
>
>spring.datasource.password=ddmmyy
>
>spring.flyway.baselineOnMigrate=true
>
>spring.jpa.show-sql=true
>
>spring.jpa.properties.hibernate.format_sql=true

### BANCO DE DADOS H2 ###

>spring.datasource.url=jdbc:h2:mem:DB_API_COLETA
>
>spring.datasource.driverClassName=org.h2.Driver
>
>spring.datasource.username=sa
>
>spring.datasource.password=sem senha
>
>spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
>
>spring.h2.console.enabled=true
>
>spring.h2.console.path=/h2-console</p>

<h2><a id="endpoints"></a>Endpoints</h2>

<h3><a id="get-apiresource"></a>GET /api/rotas</h3>
<p>Retorna uma lista de rotas de coleta.</p>

<h4>Requisição</h4>
<ul>
<li><strong>Método:</strong> <code>GET</code></li>
<li><strong>URL:</strong> <code>/api/rotas</code></li>
<li><strong>Autenticação:</strong> Necessária</li>
</ul>

<h4>Parâmetros (Query):</h4>
<table>
<thead>
<tr>
<th>Parâmetro</th>
<th>Tipo</th>
<th>Descrição</th>
<th>Obrigatório</th>
</tr>
</thead>
<tbody>
<tr>
<td><code>page</code></td>
<td><code>int</code></td>
<td>Número da página para paginação</td>
<td>Não</td>
</tr>
<tr>
<td><code>limit</code></td>
<td><code>int</code></td>
<td>Quantidade de itens por página</td>
<td>Não</td>
</tr>
</tbody>
</table>

<h4>Exemplo de Requisição</h4>
<pre><code>curl -X GET "http://localhost:8080/api/rotas
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>{
  "data": {
  "clientes": [
{
  "rotasDeColeta": [
    {
      "id": 1,
      "nomeRota": "Rota Norte",
      "localInicio": "Rua Amazonas, 123",
      "localFim": "Avenida Brasil, 456",
      "horarioInicio": "08:00",
      "horarioFim": "12:00",
      "diasDeOperacao": ["Segunda-feira", "Quarta-feira", "Sexta-feira"]
    },
    {
      "id": 2,
      "nomeRota": "Rota Sul",
      "localInicio": "Rua das Flores, 789",
      "localFim": "Avenida Paulista, 1000",
      "horarioInicio": "13:00",
      "horarioFim": "18:00",
      "diasDeOperacao": ["Terça-feira", "Quinta-feira"]
    },
    {
      "id": 3,
      "nomeRota": "Rota Leste",
      "localInicio": "Praça da Liberdade, 55",
      "localFim": "Rua XV de Novembro, 200",
      "horarioInicio": "06:00",
      "horarioFim": "10:00",
      "diasDeOperacao": ["Segunda-feira", "Quarta-feira", "Sábado"]
    }
  ]
}
</code></pre>

<hr>

<h2><a id="c%C3%B3digos-de-status"></a>Códigos de Status</h2>

<table>
<thead>
<tr>
<th>Código</th>
<th>Descrição</th>
</tr>
</thead>
<tbody>
<tr>
<td><code>200</code></td>
<td>Requisição bem-sucedida</td>
</tr>
<tr>
<td><code>201</code></td>
<td>Recurso criado com sucesso</td>
</tr>
<tr>
<td><code>400</code></td>
<td>Requisição inválida (parâmetros faltando/incorretos)</td>
</tr>
<tr>
<td><code>401</code></td>
<td>Não autorizado (token inválido ou ausente)</td>
</tr>
<tr>
<td><code>403</code></td>
<td>Acesso negado (permissões insuficientes)</td>
</tr>
<tr>
<td><code>404</code></td>
<td>Recurso não encontrado</td>
</tr>
<tr>
<td><code>500</code></td>
<td>Erro interno no servidor</td>
</tr>
</tbody>
</table>

<hr>

<h3>Usando Postman</h3>
<ol>
<li>Abra o Postman.</li>
<li>Crie uma nova requisição.</li>
<li>Defina o método (<code>GET</code>, <code>POST</code>, <code>DEL</code>, <code>PUL</code> etc.) e a URL do endpoint.</li>
<li>Adicione o cabeçalho <code>Authorization</code> com o token JWT.</li> (Não habilitado)
<li>No caso de <code>POST</code> ou <code>PUT</code>, defina o corpo da requisição em formato JSON.</li>
</ol>

<hr>

<h3>Usando Insomnia</h3>
<ol>
<li>Abra o Insomnia.</li>
<li>Crie uma nova requisição.</li>
<li>Defina o método (<code>GET</code>, <code>POST</code>, <code>DEL</code>, <code>PUL</code> etc.) e a URL do endpoint.</li>
<li>Adicione o cabeçalho <code>Authorization</code> com o token JWT.</li> (Não habilitado)
<li>No caso de <code>POST</code> ou <code>PUT</code>, defina o corpo da requisição em formato JSON.</li>
</ol>

<hr>

<h2><a id="erros-comuns"></a>Erros Comuns</h2>

<ul>
<li><strong>401 Unauthorized:</strong> O token de autenticação não foi enviado ou é inválido.
