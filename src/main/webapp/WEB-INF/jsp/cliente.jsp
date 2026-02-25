<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sistema Cliente</title>
</head>
<body>

<h2>Consulta de Cliente (LEGACY)</h2>

<form method="post" action="/cliente/buscar">
    CPF:
    <input type="text" name="cpf"/>
    <button type="submit">Buscar</button>
</form>

<hr/>

<%
    String nome = (String) request.getAttribute("nome");
    String cpf = (String) request.getAttribute("cpf");

    if (nome != null) {
%>

<h3>Resultado:</h3>
<p>CPF: <%= cpf %></p>
<p>Nome: <%= nome %></p>

<%
    }
%>

</body>
</html>