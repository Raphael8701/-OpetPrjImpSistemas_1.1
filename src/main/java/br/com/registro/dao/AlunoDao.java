package br.com.registro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.registro.model.Aluno;

public class AlunoDao {

	   public int registerAluno(Aluno aluno) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO aluno" +
	            "  (nome, nome_user, senha, contato) VALUES " +
	            " (?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/alunos?useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "vsffdp22");
	        	
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            //preparedStatement.setInt(1, 1);
	            preparedStatement.setString(1, aluno.getNome());
	            preparedStatement.setString(2, aluno.getNome_user());
	            preparedStatement.setString(3, aluno.getSenha());
	            preparedStatement.setString(4, aluno.getContato());
	            

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	   
	    } 

}
