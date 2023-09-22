<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../outils/entete.jspf"%>

<body>
	<%@ include file="../outils/menu.jsp"%>

	<div class="container">
		<h1 class="my-2">Formulaire d'inscription</h1>

		<div class="row d-flex justify-content-center py-3">
			<!-- Formulaire d'inscription -->
			<div class="col-md-8 bg-light m-3">
				<form method="post"
					action="<%=request.getContextPath()%>/inscription" class="row">
					<div class="form-group col-6">
						<label for="pseudo">Pseudo</label> <input type="text"
							class="form-control" id="pseudo" name="pseudo"
							placeholder="Pseudo" value="${pseudo}">
					</div>
					<div class="form-group col-6">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" name="nom" placeholder="Nom" value="${nom}">
					</div>
					<div class="form-group col-6">
						<label for="prenom">Prénom</label> <input type="text"
							class="form-control" id="prenom" name="prenom"
							placeholder="Prénom" value="${prenom}">
					</div>
					<div class="form-group col-6">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="Email" value="${email}">
					</div>
					<div class="form-group col-6">
						<label for="telephone">Téléphone</label> <input type="tel"
							class="form-control" id="telephone" name="telephone"
							placeholder="Téléphone" value="${telephone}">
					</div>
					<div class="form-group col-6">
						<label for="rue">Rue</label> <input type="text"
							class="form-control" id="rue" name="rue" placeholder="Rue" value="${rue}">
					</div>
					<div class="form-group col-6">
						<label for="codePostal">Code postal</label> <input type="number"
							class="form-control" id="codePostal" name="codePostal"
							placeholder="Code postal" value="${codePostal}">
					</div>
					<div class="form-group col-6">
						<label for="ville">Ville</label> <input type="text"
							class="form-control" id="ville" name="ville" placeholder="Ville" value="${ville}">
					</div>
					<div class="form-group col-6">
						<label for="mot de passe">Mot de Passe</label> <input
							type="password" class="form-control" id="mot de passe"
							name="mot de passe" placeholder="Mot de passe">
					</div>
					<div class="form-group col-6">
						<label for="confirmation">Confirmation</label> <input
							type="password" class="form-control" id="confirmation"
							name="confirmation" placeholder="Confirmation">
					</div>

					<div>
						<p style="color: #ff0000">
							<strong>${erreur}</strong>
						</p>
					</div>

					<div class="my-4 text-center">
						<div class="col-4 mx-auto">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Annuler</button>
							<button type="submit" class="btn btn-primary mr-2">S'inscrire</button>
						</div>
					</div>

				</form>


			</div>
		</div>
	</div>





	<!-- FOOTER -->

	<%@ include file="../outils/footer.jspf"%>

</body>
</html>