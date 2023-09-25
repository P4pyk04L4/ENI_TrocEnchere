<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../outils/entete.jspf"%>

<body>

	<%@ include file="../outils/menu.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<!-- Menu horizontal à gauche -->
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="position-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active" href="#">
								Accueil </a></li>
						<li class="nav-item"><a class="nav-link" href="#">
								Utilisateurs </a></li>
						<li class="nav-item"><a class="nav-link" href="#">
								Catégories d'Articles </a></li>
						<li class="nav-item"><a class="nav-link" href="#">
								Articles en Vente </a></li>
					</ul>
				</div>
			</nav>

			<!-- Contenu principal -->
			<main class="col-md-10 ms-sm-auto">

				<h1 class="my-2">Espace Administrateur</h1>

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
								<th scope="row"><c:out
										value="${ utilisateurs.identifiant }" /></th>
								<td><c:out value="${ utilisateurs.pseudo }" /></td>
								<td><c:out value="${ utilisateurs.nom }" /></td>
								<td><c:out value="${ utilisateurs.prenom }" /></td>
								<td><c:out value="${ utilisateurs.email }" /></td>
								<td><c:if test="${ utilisateurs.administrateur }">
										<input type="checkbox" checked disabled />
									</c:if> <c:if test="${ !utilisateurs.administrateur }">
										<input type="checkbox" disabled />
									</c:if></td>
								<td><c:if test="${ utilisateurs.activate }">
										<input type="checkbox" checked disabled />
									</c:if> <c:if test="${ !utilisateurs.activate }">
										<input type="checkbox" disabled />
									</c:if></td>
								<td>
									<form method="post"
										action="<%=request.getContextPath()%>/espace_admin">
										<input type="hidden" name="idUser"
											value="${utilisateurs.identifiant}">
										<c:if test="${utilisateurs.activate}">
											<button type="submit" class="btn btn-warning btn-sm"
												name="buttonClick" value="desactivateUser">
												<i class="fas fa-trash"></i> Désactiver
											</button>
										</c:if>
										<c:if test="${!utilisateurs.activate}">
											<button type="submit" class="btn btn-success btn-sm"
												name="buttonClick" value="activateUser">
												<i class="fas fa-trash"></i> Activer
											</button>
										</c:if>
									</form>
								</td>
								<td>

									<button type="button" class="btn btn-danger"
										data-bs-toggle="modal" data-bs-target="#exampleModal">
										Supprimer mon compte</button> <!-- Modal -->
									<div class="modal fade" id="exampleModal" tabindex="-1"
										aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">

											<form method="post"
												action="<%=request.getContextPath()%>/espace_admin"
												class="row">
												<div class="modal-content">
													<div class="modal-header">
														<h1 class="modal-title fs-5" id="exampleModalLabel">Supprimer
															mon compte</h1>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<p>Attention, cette action est irréversible.</p>
														<div class="form-check">
															<input type="hidden" name="idUser"
																value="${utilisateurs.identifiant}"> <input
																class="form-check-input" type="checkbox" value=""
																id="invalidCheck2" required> <label
																class="form-check-label" for="invalidCheck2">
																Oui, je désire supprimer mon compte </label>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Annuler</button>
														<button type="submit" class="btn btn-danger btn-sm"
															name="buttonClick" value="deleteUser">
															<svg xmlns="http://www.w3.org/2000/svg" width="20"
																height="20" fill="white" class="bi bi-trash"
																viewBox="0 0 16 16">
  <path
																	d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z" />
  <path
																	d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z" />
</svg>
															Supprimer
														</button>
													</div>
												</div>
											</form>
										</div>
									</div>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</main>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="../outils/footer.jspf"%>

</body>
</html>