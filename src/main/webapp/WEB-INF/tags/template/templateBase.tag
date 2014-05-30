<%@tag import="org.tschiedel.blank.util.Paginas"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Web Blank Project</title>

<!-- Bootstrap -->
<link
	href="<c:url value="/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Fragmento caso seja necessario incluir alguma coisa no header -->
<jsp:invoke fragment="header" />
</head>
<body>
	<div id="main" class="container-fluid">
		<div class="row">
			<div id="menu" class="col-md-2">
				<div class="panel panel-default">
					<div class="panel-body" >
						<div class="list-group">
							<a href="<c:url value="<%=Paginas.INDEX_CAMINHO %>" />" class="list-group-item selected">Home</a>
						</div>
					</div>
				</div>
			</div>

			<div id="content" class="col-md-6">
				<jsp:doBody />
			</div>
		</div>
	</div>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="<c:url value="/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
</body>

</html>