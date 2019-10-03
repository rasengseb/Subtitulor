<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Editer les sous-titres</title>
<link href="bootstrap/dist/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class="col-lg-5">
			<p class="charger">Charger un fichier</p>
		</div>
		<div class="col-lg-5">
			<p class="reprendre">Reprendre un fichier</p>
		</div>
		<div class="col-lg-2">
			<p class="sauver">Sauvegarder</p>
		</div>
	</div>










    <form method="post">
		<input type="text" value="Language Traduction"/>
        <input type="submit" value="Enregistrer" />
	    <table>
	        <c:forEach items="${ subtitles }" var="line" varStatus="status">
	        	<tr>
	        		<td style="text-align:right;"><c:out value="${ line }" /></td>
	        		<td><input type="text" name="line${ status.index }" id="line${ status.index }" size="35" /></td>
	        	</tr>
	    	</c:forEach>
	    </table>
    </form>
</body>
</html>