<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../outils/entete.jspf"%>

<body>
	<%@ include file="../outils/menu.jsp"%>

	<div class="container">
		<h1 class="my-2">Détail article</h1>

		<div class="row d-flex justify-content-center py-3">
			<!-- Formulaire d'inscription -->
			<div class="col-md-8 bg-light m-3 p-4">
				<div class="row">
					<div class="col-8">
						<h2>
							<c:out value="${ article.nomArticle }" />
						</h2>
					</div>
					<div class="col-4">
						<c:if test="${ article.etatVente =='EN_COURS' }">
							<div class="alert alert-success">En cours</div>
						</c:if>
						<c:if test="${ article.etatVente =='NON_DEBUTEE' }">
							<div class="alert alert-warning">Prochainement</div>
						</c:if>
						<c:if test="${ article.etatVente =='TERMINEE' }">
							<div class="alert alert-danger">Vente terminée</div>
						</c:if>
					</div>
				</div>
				<img src="images/cyber.jpeg" class="img-fluid my-3" alt="Image">
				<div class="d-flex">
					<div class="row py-3 col-10">
						<div class="col-1">
							<div class="text-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-card-text" viewBox="0 0 16 16">
  <path
										d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z" />
  <path
										d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 8zm0 2.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z" />
</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<strong>Description</strong> <br>
								<c:out value="${ article.description }" />
							</p>
						</div>

						<div class="col-1">
							<div class="text-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-person-circle"
									viewBox="0 0 16 16">
  							<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
  							<path fill-rule="evenodd"
										d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
							</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<strong>Vendeur</strong> </br>
								<c:out value="${ article.vendeur.nom }" />
								<c:out value="${ article.vendeur.prenom }" />
							</p>
						</div>

						<div class="col-1">
							<div class="text-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-calendar-x"
									viewBox="0 0 16 16">
  <path
										d="M6.146 7.146a.5.5 0 0 1 .708 0L8 8.293l1.146-1.147a.5.5 0 1 1 .708.708L8.707 9l1.147 1.146a.5.5 0 0 1-.708.708L8 9.707l-1.146 1.147a.5.5 0 0 1-.708-.708L7.293 9 6.146 7.854a.5.5 0 0 1 0-.708z" />
  <path
										d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<strong>Fin de l'enchère</strong> </br>
								<c:out value="${ article.dateFinEncheres }" />

							</p>
						</div>

						<div class="col-1">
							<div class="text-end">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-tag-fill" viewBox="0 0 16 16">
  <path
										d="M2 1a1 1 0 0 0-1 1v4.586a1 1 0 0 0 .293.707l7 7a1 1 0 0 0 1.414 0l4.586-4.586a1 1 0 0 0 0-1.414l-7-7A1 1 0 0 0 6.586 1H2zm4 3.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z" />
</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<strong>Catégorie</strong> </br>
								<c:out value="${ article.categorie.libelle }" />

							</p>
						</div>

					</div>

					<!-- CADRE DERNIERE ENCHERE -->

					<div class="col-2">
						<div class="card p-3">
							<strong>Dernière enchère</strong>
							<h2>
								<c:out value="${ article.prixVente }" />
							</h2>
							<p>Crédits</p>
						</div>

					</div>
				</div>
			</div>



		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="../outils/footer.jspf"%>

</body>
</html>