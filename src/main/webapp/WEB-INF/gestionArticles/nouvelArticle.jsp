<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Nouvelle vente</title>
	</head>
	
	<body>
	
		<form method="post" action="ServletNouvelleVente">
			<label for="nomArticle">Article :</label>
			<input type="text" name="nomArticle" id="nomArticle" size="55" maxlength="50" autofocus required><br>
			<label for="description">Description :</label>
			<textarea id="description" name="description" maxlength="800" rows="10" cols="85"></textarea><br>
			<label for="libelleCategorie">Catégorie :</label>
			<input type="text" name="libelleCategorie" id="libelleCategorie" size="35" maxlength="30" required><br>
			<label for="miseAPrix">Mise à prix :</label>
			<input type="number" name="miseAPrix" id="miseAPrix" size="5" min=0 required><br>
			<label for="dateDebutEncheres">Début de l'enchère </label>
			<input type="date" name="dateDebutEncheres" id="dateDebutEncheres" value="" min=""><br>
			<!-- mise en place des valeurs par défaut et minimum pour la date de début des enchères -->
			<script>
        		const dateActuelle = new Date().toISOString().split('T')[0];
		        const dateDebutEncheres = document.getElementById("dateDebutEncheres");
		        dateDebutEncheres.value = dateActuelle;
		        dateDebutEncheres.min = dateActuelle;
   			</script>
   			<label for="dateFinEncheres">Fin de l'enchère </label>
			<input type="date" name="dateFinEncheres" id="dateFinEncheres" min=""><br>
			<script>
		        const dateFinEncheres = document.getElementById("dateFinEncheres");
		        dateFinEncheres.min = dateActuelle;
   			</script>
			<fieldset style="width:50%">
				<legend>Retrait</legend>
				<label for="rue">Rue :</label>
				<input type="text" name="rue" id="rue" size="55" maxlength="50" required><br>
				<label for="ville">Ville :</label>
				<input type="text" name="ville" id="ville" size="55" maxlength="30" required><br>
				<label for=codePostal>Code postal :</label>
				<input type="text" name="codePostal" id="codePostal" size="6" required>
			</fieldset><br>
			<input type="submit" value="Envoyer">
		</form>
		
		<form method="get" action="ServletDeTest">
			<input type="submit" value="Retour à la page d'accueil">
		</form>
	
	</body>

</html>