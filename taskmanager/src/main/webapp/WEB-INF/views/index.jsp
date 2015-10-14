<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>G R I N D</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/tyyli.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="../resources/js/javascript.js"></script>

</head>
<body>
	<c:if test="${empty tehtavat}">
		<c:redirect url="/grind/hae" />
	</c:if>
	<div class="container">
		<div class="header">
			<h1>G R I N D</h1>
		</div>
		<div class="tasks">
			<div class="task">

				<c:if test="${not empty tehtavat}">
					<c:forEach var="tehtava" items="${tehtavat}" varStatus="counter">
						<p class="tasks">
							<c:out value="${tehtava.kuvaus}" />&nbsp;-&nbsp;<c:out value="${tehtava.lisatiedot}" /><br>
							Tila:&nbsp;<c:set value="${tehtava.status}" var="st" /><c:out value="${st == 0 ? 'avoin': 'tehty'}"/><br>
							Suoritettava:&nbsp;<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${tehtava.pvmaika}" /><br>
							Hälytys:&nbsp;<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${tehtava.muistutusPvmaika}" />							
						</p>
					</c:forEach>
				</c:if>
			</div>
			<div class="edit">
				<button type="button" class="btn btn-default btn-lg editbtn btn-xs">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				</button>
			</div>
		</div>

		<button type="button" class="btn btn-default btn-lg btn-xs"
			id="addtaskbtn">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
		</button>

		<div id=addtaskform hidden="">
			<form class="form-inline" target="lisaa" method="post">
				<div class="form-group">
					<input id="task" type="text" class="form-control inline" placeholder="Uusi tehtävä" />
				</div>
				<div class="form-group">
					<input id="info" type="text" class="form-control inline" placeholder="Lisätiedot" />
					<!-- tähän se datepickeri -->
				</div>
				<div class="form-group">
					<button id="add" type="submit" class="btn btn-default">Lisää</button>
				</div>
			</form>

		</div>
	</div>



</body>
</html>