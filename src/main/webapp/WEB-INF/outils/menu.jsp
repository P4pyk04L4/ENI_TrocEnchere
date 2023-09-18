<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg">
	<div class="container">
		<!-- LOGO -->
		<a class="navbar-brand" href="#"> <img
			src="images/cocarde_francaise.png" height="50px">
		</a>

		<!--         Bouton du menu déroulant (s'affiche sur les petits écrans) -->
		<button class="navbar-toggler border-0" type="button"
			data-toggle="collapse" data-target="#navbarNav"
			aria-controls="navbarNav" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon navbar-dark"></span>
		</button>

		<!-- Contenu du menu -->
		<div class="collapse navbar-collapse" id="navbarNav">
			<!-- Menu des pages principales à gauche -->
			<ul class="navbar-nav col-10">
				<li class="nav-item active"><a class="nav-link" href="#">Accueil</a></li>
				<li class="nav-item"><a class="nav-link" href="#">À propos</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Services</a></li>
			</ul>

			<!-- Menu du profil avec menu déroulant à droite -->
			<ul class="navbar-nav col-2">
				<!-- Utilisez ml-auto ici aussi -->
				<%
				// Récupérez la variable de session
				Boolean profilConnecte = (Boolean) session.getAttribute("profilConnecte");

				// Vérifiez si le profil est connecté
				if (profilConnecte != null && profilConnecte) {
				%>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="profilDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <svg xmlns="http://www.w3.org/2000/svg"
							width="30" height="30" fill="currentColor"
							class="bi bi-person-circle" viewBox="0 0 16 16">
  							<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
  							<path fill-rule="evenodd"
								d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
							</svg>
				</a>
					<div class="dropdown-menu dropdown-menu-end"
						aria-labelledby="profilDropdown">
						<a class="dropdown-item" href="#">Paramètres</a> <a
							class="dropdown-item" href="#">Se déconnecter</a>
					</div></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="#">S'inscrire</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#connexionModal">Se connecter</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>

	<!-- Modal de Connexion -->
	<div class="modal fade" id="connexionModal" tabindex="-1" role="dialog"
		aria-labelledby="connexionModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="connexionModalLabel">Se connecter</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Formulaire de Connexion -->
					<form method="post"
						action="<%=request.getContextPath()%>/ServletDeTest">
						<div class="form-group">
							<label for="nom">Nom</label> <input type="text"
								class="form-control" id="nom" name="nom" placeholder="Nom">
						</div>
						<div class="form-group">
							<label for="prenom">Prénom</label> <input type="text"
								class="form-control" id="prenom" name="prenom"
								placeholder="Prénom">
						</div>
						<div class="form-group">
							<label for="mot de passe">Mot de Passe</label> <input
								type="password" class="form-control" id="mot_de_passe"
								name="mot de passe" placeholder="Mot de passe">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fermer</button>
							<button type="submit" class="btn btn-primary">Se
								Connecter</button>
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>
</nav>
