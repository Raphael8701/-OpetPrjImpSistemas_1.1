<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
 <div align="center">
  <h1>Cadastro de Alunos</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Nome</td>
     <td><input type="text" name="nome" /></td>
    </tr>
    <tr>
     <td>Nome de usuario</td>
     <td><input type="text" name="nome_user" /></td>
    </tr>
    <tr>
     <td>Senha</td>
     <td><input type="password" name="senha" /></td>
    </tr>
    <tr>
     <td>Contato</td>
     <td><input type="text" name="contato" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>