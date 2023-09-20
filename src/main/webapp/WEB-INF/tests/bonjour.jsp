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

				

				<!-- CARTES DE BASE  -->
				<div class="row">
					<c:forEach var="utilisateur" items="${ utilisateurs }">
					<div class="col-lg-4 col-md-6 mb-3">
						<a href="#" class="text-decoration-none" data-toggle="modal"
							data-target="#myModal" data-card-id="1">
							<div class="card">
								<img src="images/cyber.jpeg" class="card-img-top" alt="Image">
								<div class="card-body">
									<h3 class="card-title"><c:out value="${ utilisateur.prenom }" /></h3>
									<p><c:out value="${ utilisateur.nom }" /></p>
									<p><c:out value="${ utilisateur.pseudo }" /></p>
									<p><c:out value="${ utilisateur.rue }" /></p>
									<p><c:out value="${ utilisateur.codePostal }" /> <c:out value="${ utilisateur.ville }" /></p>
									<p><c:out value="${ utilisateur.credit }" /></p>
									<p><c:out value="${ utilisateur.identifiant }" /></p>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
					<!-- Ajoutez autant de cartes que nécessaire -->
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