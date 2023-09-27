<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../outils/entete.jspf"%>

<body>
	<%@ include file="../outils/menu.jsp"%>

	<div class="container">
		<h1 class="my-2">Bienvenue</h1>

		<div class="row d-flex justify-content-between py-3">
			<!-- Cartes principales -->
			<div class="col-md-8 bg-light">
				<h2>Objets en vente</h2>

				<div class="row">
					<c:forEach var="articles" items="${ articles }">

						<!-- 					Vérifier l'article Activate (mode dev pour l'instant) -->

						<c:if test="${ articles.activate = true }">
							<div class="col-lg-4 col-md-6 mb-3">
								<c:if test="${not empty sessionScope.profilConnecte}">
									<a href="article?noArticle=<c:out value="${ articles.noArticle }" />"
									class="text-decoration-none">
									</c:if>
									<div class="card h-100" id="carteArticle">
									<img src="images/cyber.jpeg" class="card-img-top" alt="Image">
										<div class="card-body">
											<h3 class="text-end">
												<c:out value="${ articles.prixVente }" /> €
											</h3>
											<h5 class="card-title">
												<c:out value="${ articles.nomArticle }" />
											</h5>
											<p>
												Fin de la vente le : <c:out value="${ articles.dateFinEncheres }" />
											</p>
											
										</div>
										
										<!-- AFFICHAGE DE L'ETAT DE LA VENTE -->
										<c:if test="${ articles.etatVente =='EN_COURS' }">
											<div class="card-footer border-success">
												<small class="text-body-secondary"><c:out value="${ articles.categorie.libelle }" /></small>
											</div>
										</c:if>
										<c:if test="${ articles.etatVente =='NON_DEBUTEE' }">
												<div class="card-footer border-warning">
												<small class="text-body-secondary"><c:out value="${ articles.categorie.libelle }" /></small>
											</div>
										</c:if>
										<c:if test="${ articles.etatVente =='TERMINEE' }">
											<div class="card-footer border-danger">
												<small class="text-body-secondary"><c:out value="${ articles.categorie.libelle }" /></small>
											</div>
										</c:if>
									</div>
								<c:if test="${not empty sessionScope.profilConnecte}">
									</a>
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>
				
			</div>


			<div class="col-md-3 bg-light">
				<h2>Mes enchères</h2>
				<div class="row">
					<!-- Première carte -->
					<div class="col-lg-12 mb-3">
						<a href="#" class="text-decoration-none">
							<div class="card">
								<img src="images/cyber.jpeg" class="card-img-top" alt="Image">
								<div class="card-body">
									<h3 class="card-title">Objet 1</h3>
								</div>
							</div>
						</a>
					</div>

					<!-- Deuxième carte -->
					<div class="col-lg-12 mb-3">
						<a href="#" class="text-decoration-none">
							<div class="card">
								<img src="images/cyber.jpeg" class="card-img-top" alt="Image">
								<div class="card-body">
									<h3 class="card-title">Objet 2</h3>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	
	<!-- MODAL DE CARTE -->

	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Détails de la carte</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<!-- Contenu dynamique sera inséré ici -->
				</div>
			</div>
		</div>
	</div>



<c:out value="${ articles }" />
	<!-- FOOTER -->

	<%@ include file="../outils/footer.jspf"%>
	<script>
		$(document).ready(
				function() {
					$('#myModal').on(
							'show.bs.modal',
							function(event) {
								var button = $(event.relatedTarget);
								var cardId = button.data('card-id');

								console.log('Card ID:', cardId); // Ajoutez cette ligne pour déboguer
								var modal = $(this);
								modal.find('.modal-body').html(
										'Contenu de la carte ' + cardId);
							});
				});
	</script>
</body>
</html>