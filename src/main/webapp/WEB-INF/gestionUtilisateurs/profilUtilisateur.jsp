<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../outils/entete.jspf"%>

<body>
	<%@ include file="../outils/menu.jsp"%>

	<div class="container">
		<h1 class="my-2">Mon profil</h1>

		<div class="row d-flex justify-content-center py-3">
			<!-- Formulaire d'inscription -->
			<div class="col-md-8 bg-light m-3">
				<h2>
					<c:out value="${ user.nom }" />
					<c:out value="${ user.prenom }" />
				</h2>
				<div class="d-flex">
					<div class="row py-3 col-10">
						<div class="col-1">
							<div class="text-right">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-telephone-fill"
									viewBox="0 0 16 16">
  <path fill-rule="evenodd"
										d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z" />
</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<c:out value="${ user.telephone }" />
							</p>
						</div>
						<div class="col-1">
							<div class="text-right">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-envelope-fill"
									viewBox="0 0 16 16">
  <path
										d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555ZM0 4.697v7.104l5.803-3.558L0 4.697ZM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757Zm3.436-.586L16 11.801V4.697l-5.803 3.546Z" />
</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<c:out value="${ user.email }" />
							</p>
						</div>
						<div class="col-1">
							<div class="text-right">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-geo-alt-fill"
									viewBox="0 0 16 16">
  <path
										d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
</svg>
							</div>
						</div>
						<div class="col-11">
							<p>
								<c:out value="${ user.rue }" />
								</br>
								<c:out value="${ user.codePostal }" />
								<c:out value="${ user.ville }" />
							</p>
						</div>
					</div>
					<div class="col-2">
						<div class="card p-3">
							<h2>
								<c:out value="${ user.credit }" />
							</h2>
							<p>Crédits</p>
						</div>

					</div>
				</div>
			</div>

			<div class="col-md-8 bg-light m-3">
				<h2>Modifier mon profil</h2>
				<form method="post"
					action="<%=request.getContextPath()%>/ServletProfilUtilisateur"
					class="row">
					<div class="form-group col-6">
						<label for="pseudo">Pseudo</label> <input type="text"
							class="form-control" id="pseudo" name="pseudo"
							value="<c:out value="${ user.pseudo }" />">
					</div>
					<div class="form-group col-6">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" name="nom"
							value="<c:out value="${ user.nom }" />">
					</div>
					<div class="form-group col-6">
						<label for="prenom">Prénom</label> <input type="text"
							class="form-control" id="prenom" name="prenom"
							value="<c:out value="${ user.prenom }" />">
					</div>
					<div class="form-group col-6">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							value="<c:out value="${ user.email }" />">
					</div>
					<div class="form-group col-6">
						<label for="telephone">Téléphone</label> <input type="tel"
							class="form-control" id="telephone" name="telephone"
							value="<c:out value="${ user.telephone }" />">
					</div>
					<div class="form-group col-6">
						<label for="rue">Rue</label> <input type="text"
							class="form-control" id="rue" name="rue"
							value="<c:out value="${ user.rue }" />">
					</div>
					<div class="form-group col-6">
						<label for="codePostal">Code postal</label> <input type="number"
							class="form-control" id="codePostal" name="codePostal"
							value="<c:out value="${ user.codePostal }" />">
					</div>
					<div class="form-group col-6">
						<label for="ville">Ville</label> <input type="text"
							class="form-control" id="ville" name="ville"
							value="<c:out value="${ user.ville }" />">
					</div>
					<div class="my-4 text-center">
						<div class="col-4 mx-auto">
							<button type="submit" class="btn btn-primary mr-2">Modifier
								le profil</button>
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