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
                <h4 class="my-1">-> Gestion des Enchères</h4><br>
                
                <c:forEach var="article" items="${articles}">
                 	<h4 class="my-2">
	                	#<c:out value="${article.noArticle}" /> --> <c:out value="${article.nomArticle}" />
	           		</h4>
	           		<p>Début : <c:out value="${article.dateDebutEncheres}" /> - Fin : <c:out value="${article.dateFinEncheres}" /></p>
	           		
					<c:if test="${empty article.encheres}">
					    <h4 class="my-2">--- Aucune Enchère ---</h4>
					    <br>
					</c:if>
	           		
	           		<c:forEach var="enchere" items="${article.encheres}">
	           		 
	           			<table class="table">
						    <thead>
						    
								<tr>
						            <th scope="col" class="col-1">#</th>
						            <th scope="col" class="col-2">Date</th>
						            <th scope="col" class="col-2">Enchérisseur</th>
						            <th scope="col" class="col-2">Montant</th>
						            <th scope="col" class="col-1">État</th>
						            <th scope="col" class="col-1"></th>
						        </tr>
						    </thead>
						    
					    	<tbody>
					    	
					           <tr class="${enchere.etatEnchere == 'PERDU' ? 'table-danger' : (enchere.etatEnchere == 'MEILLEUR' ? 'table-success' : 'table-warning')}">
					                
					                <th scope="row"><c:out value="${enchere.noEnchere}" /></th>
									<th scope="row"><c:out value="${enchere.dateEnchere}" /></th>
					                <th scope="row"><c:out value="${enchere.pseudoUtilisateur}" /></th>
					                <th scope="row"><c:out value="${enchere.montantEnchere}" />&nbsp;&euro;</th>
					                <th scope="row"><c:out value="${enchere.etatEnchere}" /></th>
					                
									<td>
									
										<c:if test="${enchere.etatEnchere ne 'GAGNE'}">
									
											<input type="checkbox" id="activateSwitch-${enchere.noEnchere}" data-on-text="ON" data-off-text="OFF" 
												data-on-color="success" data-off-color="danger" ${enchere.activate ? 'checked' : ''} 
										        data-servlet-url="<%=request.getContextPath()%>/espace_admin/gestion_encheres" 
										        data-enchere-id="${enchere.noEnchere}" name="activateSwitch" />
										        
										    <script>
										    	$(document).ready(function() {
										
										           	$('#activateSwitch-${enchere.noEnchere}').bootstrapSwitch();
										
										           	$('#activateSwitch-${enchere.noEnchere}').on('switchChange.bootstrapSwitch', function(event, state) {
										           	
										               	// Cette fonction sera exécutée lorsque l'utilisateur coche ou décoche la case à cocher.
										               	var servletURL = $(this).data('servlet-url');
										               	var enchereId = $(this).data('enchere-id');
														
										                // Envoie une requête Ajax au servlet avec l'identifiant de l'utilisateur et l'état de la case à cocher	                
										                console.log('servletURL:', servletURL);
														console.log('enchereId:', enchereId);
														console.log('state:', state);
										                
										                $.ajax({
										                    type: "POST",
										                    url: servletURL,
										                    data: {
										                    	enchereId: enchereId,
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
										   	
										</c:if>   
									        
									</td>
									
									<td>
									
										<c:if test="${enchere.etatEnchere ne 'GAGNE'}">
									
						              		<button type="submit" class="btn btn-danger btn-sm"
						              			data-bs-toggle="modal" data-bs-target="#deleteOneEnchere-${enchere.noEnchere}">
						                    	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
		  											<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
		  											<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
												</svg>
						                		&nbsp;Supprimer
						                   	</button>
						                   	
						                    <!-- Structure de la fenêtre modale -->
						                    <div class="modal fade" id="deleteOneEnchere-${enchere.noEnchere}" tabindex="-1"
												aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog">
		
													<form method="post"
														action="<%=request.getContextPath()%>/espace_admin/gestion_encheres"
														class="row">
														<div class="modal-content">
															<div class="modal-header">
																<h1 class="modal-title fs-5" id="exampleModalLabel">
																	Suppression de l'Enchère n°<c:out value="${enchere.noEnchere}" /><br>
																	"<c:out value="${article.nomArticle}" />"
																</h1>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close">
																</button>
															</div>
															<div class="modal-body">
																<p>Attention, cette action est irréversible !</p>
																<div class="form-check">
																	<input type="hidden" name="enchereId"
																		 value="${enchere.noEnchere}">
																	<input class="form-check-input" type="checkbox"
																		value="" id="invalidCheck2" required>
																	<label class="form-check-label" for="invalidCheck2">
																		Oui, je désire supprimer cet article
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
																	name="deleteOneEnchere">
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
											
										</c:if>
										
									</td>
	
					           	</tr>
					           	
					  		</tbody>
					  		
						</table><br>	 
	           		 </c:forEach>
	           		
                </c:forEach>
 	
					
            </main>
            
        </div>
    </div>

    <!-- FOOTER -->
    <%@ include file="includes/footer.jspf"%>
    
</body>
</html>
