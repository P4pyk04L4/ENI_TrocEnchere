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
                <h4 class="my-1">-> Gestion des Utilisateurs</h4><br>
                	
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Pseudo</th>
							<th scope="col">Nom</th>
							<th scope="col">Prénom</th>
							<th scope="col">E-Mail</th>
							<th scope="col">Admin</th>
							<th scope="col">Activation</th>
							<th scope="col"></th>
							<th scope="col"></th>
						   </tr>
					</thead>
					<tbody>
						<c:forEach var="utilisateurs" items="${ utilisateurs }">
							<tr>
							    <th scope="row"><c:out value="${ utilisateurs.identifiant }" /></th>
							    <td><c:out value="${ utilisateurs.pseudo }" /></td>
								<td><c:out value="${ utilisateurs.nom }" /></td>
							 	<td><c:out value="${ utilisateurs.prenom }" /></td>
								<td><c:out value="${ utilisateurs.email }" /></td>
								<td>
									<c:if test="${ utilisateurs.administrateur }">
										<input type="checkbox" checked disabled />
									 </c:if>
									 <c:if test="${ !utilisateurs.administrateur }">
									   	<input type="checkbox" disabled />
									 </c:if>
								</td>
								<td>
									<c:if test="${ utilisateurs.activate }">
										<input type="checkbox" checked disabled />
									</c:if>
									<c:if test="${ !utilisateurs.activate }">
										<input type="checkbox" disabled />
									</c:if>
								</td>							  			                						
								<td>
									<form method="post" action="<%=request.getContextPath()%>/espace_admin">
										<input type="hidden" name="idUser" value="${utilisateurs.identifiant}">
										<c:if test="${utilisateurs.activate}">
											<button type="submit" class="btn btn-warning btn-sm" name="buttonClick" value="desactivateUser">
										    	<i class="fas fa-trash"></i> Désactiver
										 	</button>
									 	</c:if>
									  	<c:if test="${!utilisateurs.activate}">
										   	<button type="submit" class="btn btn-success btn-sm" name="buttonClick" value="activateUser">
										     	<i class="fas fa-trash"></i> Activer
										   	</button>
									  	</c:if>
									</form>
								</td>
								<td>
									<form method="post" action="<%=request.getContextPath()%>/espace_admin">
										<input type="hidden" name="idUser" value="${utilisateurs.identifiant}">
								    	<button type="submit" class="btn btn-danger btn-sm" name="buttonClick" value="deleteUser">
								        	<i class="fas fa-trash"></i> Supprimer
								  		</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					
            </main>
        </div>
    </div>

    <!-- FOOTER -->
    <%@ include file="includes/footer.jspf"%>
    
</body>
</html>
