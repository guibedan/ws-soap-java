<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Erro Busca</title>
</head>
<body>

<h2>Erro ao buscar cliente!</h2>

<%
    String mensagem = (String) request.getAttribute("mensagem");
    String cpf = (String) request.getAttribute("cpf");

    if (mensagem != null) {
%>

<h3>CPF informado: <%= cpf %></h3>
<h3>Erro: <%= mensagem %></h3>

<%
    }
%>

<br/><br/>

<button onclick="history.back()">Voltar</button>

</body>
</html>