
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>Admin</span>espace</a>
				
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name">admin</div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		
		<ul class="nav menu">
			<li><a href="${pageContext.request.contextPath }/backoffice/listechambres"><em class="fa fa-clone">&nbsp;</em>liste chambres</a></li>
				<li><a href="${pageContext.request.contextPath }/backoffice/listeequipement"><em class="fa fa-clone">&nbsp;</em>liste equipements</a></li>
			
			<li><a href="${pageContext.request.contextPath }/backoffice/InsertionChambrePage"><em class="fa fa-clone">&nbsp;</em>Ajouter chambre</a></li>
			<li><a href="${pageContext.request.contextPath }/backoffice/InsertionEquipementPage"><em class="fa fa-clone">&nbsp;</em>Ajouter equipement</a></li>
			<li><a href="${pageContext.request.contextPath }/backoffice/InsertionEquipementChambrePage"><em class="fa fa-clone">&nbsp;</em>Ajouter chambre equi</a></li>
			<li><a href="${pageContext.request.contextPath }/logout"><em class="fa fa-power-off">&nbsp;</em>Deconnexion</a></li>
		</ul>
		
	</div><!--/.sidebar-->