<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<%@ include file="../outils/entete.jspf"%>
	
<body>

	<%@ include file="../outils/menu.jsp"%>

	<div class="container">
	
		<h1 class="m-3">Vendre un article</h1>
		
		<div class="row d-flex justify-content-center py-3 col-md-7 bg-light m-3">
		
			<form method="post" action="ServletNouvelleVente">
			
				<div class="form-group">
					<label for="nomArticle">Nom de l'article :</label>
					<input type="text" name="nomArticle" id="nomArticle" class="form-control"
							maxlength="50" autofocus required>
				</div>
				
				<div class="form-group my-2">
					<label for="description">Description :</label>
					<textarea id="description" name="description" maxlength="800" class="form-control"
								required style="height: 150px"></textarea>
				</div>
				
				<div class="form-group my-2">
					<label for="libelleCategorie">Choisir une catégorie :</label>
					<input type="text" name="libelleCategorie" id="libelleCategorie" list="listeChoix"
					class="form-control" required>
					<datalist id="listeChoix">
						<option value="valeur1">
						<option value="valeur2">
					</datalist>
				</div>
				
				<div class="my-2">
					<label for="formFile">Photo de l'article</label>
					<input class="form-control" type="file" id="formFile" name="photoArticle">
				</div>
				
				<div class="form-group col-4 my-2">
					<label for="miseAPrix">Mise à prix :</label>
					<input type="number" name="miseAPrix" id="miseAPrix" min=0 class="form-control" required>					
				</div>
				
				<!-- Début conteneur réunissant les dates de début et fin d'enchères -->
				<div class="column d-flex my-2">	
					<div class="form-group col-7">
						<label for="dateDebutEncheres">Début de l'enchère</label>
						<div class="col-6">
							<input type="date" name="dateDebutEncheres" id="dateDebutEncheres" value="" 
									min="" class="form-control"><br>
						</div>
					</div>				
					<!-- mise en place des valeurs par défaut et minimum pour la date de début des enchères -->
					<script>
			       		const dateActuelle = new Date().toISOString().split('T')[0];
				        const dateDebutEncheres = document.getElementById("dateDebutEncheres");
				        dateDebutEncheres.value = dateActuelle;
				        dateDebutEncheres.min = dateActuelle;
			  		</script>
			  		
			  		<div class="form-group col-7">
						<label for="dateFinEncheres">Fin de l'enchère</label>
						<div class="col-6">
							<input type="date" name="dateFinEncheres" id="dateFinEncheres" value="" 
									min="" class="form-control"><br>
						</div>
					</div>
					<script>
				        const dateFinEncheres = document.getElementById("dateFinEncheres");
				        dateFinEncheres.min = dateActuelle;
			  		</script>
		  		</div>
		  		<!-- Fin conteneur réunissant les dates de début et fin d'enchères -->
		  		
				<fieldset class="border border-3 p-2 mb-3" style="border-radius: 15px">
				
					<legend>Retrait</legend>
					
					<div class="form-group col-10 my-2">
						<label for="rue">Rue :</label>
						<input class="form-control" type="text" name="rue" id="rue" maxlength="50" required>
					</div>
					
					<!-- début regroupement du code postal et de la ville sur une même ligne -->
					<div class="row">
					
						<div class="col-2">
							<label for=codePostal class="col-form-label">Code postal :</label>
						</div>
						<div class="col-2">
							<input class="form-control" type="text" name="codePostal" id="codePostal" 
									maxlength="6" required>
						</div>
						<div class="col-1"></div>						
						<div class="col-1 px-0 mx-0">
							<label for="ville" class="col-form-label">Ville :</label>
						</div>
						<div class="col-4">
							<input class="form-control" type="text" name="ville" id="ville" maxlength="30" required>
						</div>
						
					</div>
					<!-- fin regroupement du code postal et de la ville sur une même ligne -->
					
				</fieldset>								
					
				<input type="submit" class="btn btn-success" value="Valider">			
				
				<input type="reset" class="btn btn-secondary" value="Réinitialiser">							
				
				
			</form>
		
		</div>
		
	</div>
	
		<!-- FOOTER -->

	<%@ include file="../outils/footer.jspf"%>

</body>

</html>