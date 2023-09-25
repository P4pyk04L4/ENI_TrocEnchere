<!-- HEADER -->
<%@ include file="includes/entete.jspf"%>

<body>

	<!-- MENU -->
	<%@ include file="includes/menu.jspf"%>
	
    <div class="container-fluid">
        <div class="row">
        
            <!-- MENU ADMIN -->
			<%@ include file="includes/menu_admin.jspf"%>

            <!-- Contenu principal -->
            <main class="col-md-10 ms-sm-auto">
            
                <h1 class="my-2">Espace Administrateur</h1>
                <h4 class="my-1">-> Gestion des Utilisateurs</h4><br>
                	
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Pseudo</th>
							<th scope="col">Nom</th>
							<th scope="col">Prénom</th>
							<th scope="col">E-Mail</th>
							<th scope="col">Administrateur</th>
							<th scope="col">Activation</th>
							<th scope="col"></th>
						   </tr>
					</thead>
					<tbody>
						<c:forEach var="utilisateurs" items="${utilisateurs}">
							<tr>
							    <th scope="row"><c:out value="${utilisateurs.identifiant}" /></th>
							    <td><c:out value="${utilisateurs.pseudo}" /></td>
								<td><c:out value="${utilisateurs.nom}" /></td>
							 	<td><c:out value="${utilisateurs.prenom}" /></td>
								<td><c:out value="${utilisateurs.email}" /></td>
								<td>
								
								    <input type="checkbox" id="adminSwitch-${utilisateurs.identifiant}" data-on-text="ON" data-off-text="OFF" 
								    	data-on-color="success" data-off-color="danger" ${utilisateurs.administrateur ? 'checked' : ''} 
								        data-servlet-url="<%=request.getContextPath()%>/espace_admin/gestion_utilisateurs" 
								        data-utilisateur-id="${utilisateurs.identifiant}" name="adminSwitch" />
								        
								    <script>
								    	$(document).ready(function() {
								
								           	$('#adminSwitch-${utilisateurs.identifiant}').bootstrapSwitch();
								
								           	$('#adminSwitch-${utilisateurs.identifiant}').on('switchChange.bootstrapSwitch', function(event, state) {
								           	
								               	// Cette fonction sera exécutée lorsque l'utilisateur coche ou décoche la case à cocher.
								               	var servletURL = $(this).data('servlet-url');
								               	var utilisateurId = $(this).data('utilisateur-id');
												
								                // Envoie une requête Ajax au servlet avec l'identifiant de l'utilisateur et l'état de la case à cocher	                
								                console.log('servletURL:', servletURL);
												console.log('utilisateurId:', utilisateurId);
												console.log('state:', state);
								                
								                $.ajax({
								                    type: "POST",
								                    url: servletURL,
								                    data: {
								                        utilisateurId: utilisateurId,
								                        adminSwitch: state
								                    },
								                    success: function(response) {
								                    	 console.log('Requête réussie, réponse du serveur');
								                    },
								                    error: function(jqXHR, textStatus, errorThrown) {
								                    	console.error('Erreur lors de la requête :', errorThrown);
								                    }
								                });
								               	
								           	});
								       	});
								   	</script>    
								        
								</td>
								<td>
								
									<input type="checkbox" id="activateSwitch-${utilisateurs.identifiant}" data-on-text="ON" data-off-text="OFF" 
										data-on-color="success" data-off-color="danger" ${utilisateurs.activate ? 'checked' : ''} 
								        data-servlet-url="<%=request.getContextPath()%>/espace_admin/gestion_utilisateurs" 
								        data-utilisateur-id="${utilisateurs.identifiant}" name="activateSwitch" />
								        
								    <script>
								    	$(document).ready(function() {
								
								           	$('#activateSwitch-${utilisateurs.identifiant}').bootstrapSwitch();
								
								           	$('#activateSwitch-${utilisateurs.identifiant}').on('switchChange.bootstrapSwitch', function(event, state) {
								           	
								               	// Cette fonction sera exécutée lorsque l'utilisateur coche ou décoche la case à cocher.
								               	var servletURL = $(this).data('servlet-url');
								               	var utilisateurId = $(this).data('utilisateur-id');
												
								                // Envoie une requête Ajax au servlet avec l'identifiant de l'utilisateur et l'état de la case à cocher	                
								                console.log('servletURL:', servletURL);
												console.log('utilisateurId:', utilisateurId);
												console.log('state:', state);
								                
								                $.ajax({
								                    type: "POST",
								                    url: servletURL,
								                    data: {
								                        utilisateurId: utilisateurId,
								                        activateSwitch: state
								                    },
								                    success: function(response) {
								                    	 console.log('Requête réussie, réponse du serveur');
								                    },
								                    error: function(jqXHR, textStatus, errorThrown) {
								                    	console.error('Erreur lors de la requête :', errorThrown);
								                    }
								                });
								               	
								           	});
								       	});
								   	</script>    
								        
								</td>
								<td>
												                    
				              		<button type="submit" class="btn btn-danger btn-sm"
				              			data-bs-toggle="modal" data-bs-target="#deleteOneUser-${utilisateurs.identifiant}">
				                    	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  											<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
  											<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
										</svg>
				                		&nbsp;Supprimer
				                   	</button> <!-- Modal -->
				                    
				                    <div class="modal fade" id="deleteOneUser-${utilisateurs.identifiant}" tabindex="-1"
										aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">

											<form method="post"
												action="<%=request.getContextPath()%>/espace_admin/gestion_utilisateurs"
												class="row">
												<div class="modal-content">
													<div class="modal-header">
														<h1 class="modal-title fs-5" id="exampleModalLabel">
															Suppression de l'Utilisateur n°<c:out value="${utilisateurs.identifiant}" /><br>
															"<c:out value="${utilisateurs.prenom}" />&nbsp;<c:out value="${utilisateurs.nom}" />"
														</h1>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close">
														</button>
													</div>
													<div class="modal-body">
														<p>Attention, cette action est irréversible !</p>
														<div class="form-check">
															<input type="hidden" name="utilisateurId"
																 value="${utilisateurs.identifiant}">
															<input class="form-check-input" type="checkbox"
																value="" id="invalidCheck2" required>
															<label class="form-check-label" for="invalidCheck2">
																Oui, je désire supprimer cet utilisateur
															</label>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary btn-sm"
															data-bs-dismiss="modal">
															<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
															  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
															  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
															</svg>
															&nbsp;Annuler
														</button>
														<button type="submit" class="btn btn-danger btn-sm"
															name="deleteOneUser">
									                    	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
					  											<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
					  											<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
															</svg>
									                		&nbsp;Supprimer
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
    <%@ include file="includes/footer.jspf"%>
    
</body>

</html>
