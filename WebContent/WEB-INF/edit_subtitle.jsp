<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Editer les sous-titres</title>
    <link href="bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link href="css/styleSubtitlor.css" rel="stylesheet">
</head>
<body>
<div class="col-lg-offset-4 col-lg-5">
    <p class="jumbotron titre">Traduction des sous-titres de vidéos</p>
</div>
<div class="row">
    <div class="col-xs-3 chargement">
        <p class="jumbotron charger">Charger un fichier</p>
        <input type="file" name="fichier" id="fichier">
        <input type="submit" value="Envoyer" class="envoie_fichier" id="envoie_fichier">
    </div>
    <div class="col-xs-3 reprise">
        <p class="jumbotron reprendre">Reprendre un fichier</p>
        <select name="fichiers" id="fichiers" class="fichiers">
            <option value="">En cours</option>
        </select>
    </div>
    <div class="col-xs-3 save">
        <p class="jumbotron sauver">Sauvegarder</p>
        <input type="submit" class="sauvegarder" id="sauvegarder">
    </div>
</div>

<div class="row">
    <form method="post">
        <input type="text" value="Language Traduction"/>
        <input type="submit" value="Enregistrer"/>
        <table>
            <c:forEach items="${ subtitles }" var="line" varStatus="status">
                <tr>
                    <td style="text-align:right;"><c:out value="${ line }"/></td>
                    <td><input type="text" name="line${ status.index }" id="line${ status.index }" size="35"/></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>