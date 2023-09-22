<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="includes/entete.jspf"%>

<body>

	<%@ include file="includes/menu.jspf"%>
	
    <div class="container-fluid">
        <div class="row">
            <!-- Menu horizontal à gauche -->
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="position-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="<%=request.getContextPath()%>/espace_admin/accueil">
                                Accueil
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/espace_admin/gestion_utilisateurs">
                                Utilisateurs
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/espace_admin/gestion_categories">
                                Catégories d'Articles
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                Articles en Vente
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>

            <!-- Contenu principal -->
            <main class="col-md-10 ms-sm-auto">
            
                <h1 class="my-2">Espace Administrateur</h1> 
					
            </main>
        </div>
    </div>

    <!-- FOOTER -->
    <%@ include file="includes/footer.jspf"%>
    
</body>
</html>
