<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Falha no Processamento</h1>
        <hr>
        <ul>
            <li><%= request.getAttribute("msg")%></li>
        </ul>
        <button onclick="javascript:history.back();">Voltar</button>
    </body>
</html>
