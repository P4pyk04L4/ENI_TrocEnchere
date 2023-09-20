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
			<h2><c:out value="${ user.nom }" /> <c:out value="${ user.prenom }" /></h2>
			<c:out value="${ user.identifiant }" />
			<h3>Adresse</h3>
				<c:out value="${ user.rue }" />
				<c:out value="${ user.codePostal }" />
				<c:out value="${ user.ville }" />
			<h3>Informations privée</h3>
				<c:out value="${ user.credit }" />
				<c:out value="${ user.telephone }" />
				<c:out value="${ user.email }" />
				<c:out value="${ user.administrateur }" />
				


			</div>
		</div>
	</div>





	<!-- FOOTER -->

	<%@ include file="../outils/footer.jspf"%>

</body>
</html>