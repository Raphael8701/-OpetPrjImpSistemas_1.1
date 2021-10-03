package br.com.registro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.registro.dao.AlunoDao;
import br.com.registro.model.Aluno;


/**
 * Servlet implementation class AlunoServlet
 */
@WebServlet("/register")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AlunoDao alunoDao = new AlunoDao();
    public AlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/alunoregistro.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String nome_user = request.getParameter("nome_user");
		String senha = request.getParameter("senha");
		String contato = request.getParameter("contato");
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setNome_user(nome_user);
		aluno.setSenha(senha);
		aluno.setContato(contato);
		
		try {
			alunoDao.registerAluno(aluno);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/alunodetalhes.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
