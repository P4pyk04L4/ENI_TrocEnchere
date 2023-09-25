package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;

@WebServlet("/article")
public class ServletAffichageArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager articleManager = ArticleManager.getInstance();

       
    public ServletAffichageArticle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("article",	articleManager.selectById(Integer.valueOf(request.getParameter("noArticle"))));
		this.getServletContext().getRequestDispatcher("/WEB-INF/gestionArticles/detail_article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
