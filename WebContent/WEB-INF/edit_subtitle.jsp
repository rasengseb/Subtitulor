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

    <!-- Ouvrir un fichier -->
    <div class="col-xs-4 chargement">
        <p class="jumbotron col-xs-12 charger">Ouvrir un fichier</p>
        <div class="row">
            <div class="nom col-xs-6 nom_video">
                <label>Nom de la vidéo : </label>
                <div>
                    <input type="text" name="name_video">
                </div>
            </div>
            <div class="language col-xs-6">
                <label>Langues :</label>
                <div>
                    <select name="langues" id="langues" class="langues">
                        <option value="fr">Français</option>
                        <option value="en">English</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 file">
                <label> Choisir un fichier : </label>
                <div>
                    <input type="file" name="fichier" class="fichier" style="display: none"/>
                    <input type="text" readonly="readonly" id="file" onclick="parcourir();"/>
                    <input type="button" value="Parcourir" onclick="parcourir();"/>
                </div>
            </div>
        </div>
        <div class="envoie">
            <input type="submit" value="Charger" class="btn btn-primary btn-sm" id="envoie_fichier">
        </div>
    </div>


    <!-- Base de Données -->
    <div class="col-xs-4 reprise">
        <p class="jumbotron col-xs-12 reprendre">Base de données</p>
        <div class="Enregistrer">
            <input type="submit" class="btn btn-primary btn-sm" value="Enregistrer">
        </div>
        <div>
            <label>Choissez une vidéo</label>
            <div>
                <select name="fichiers" id="fichiers" class="fichiers">
                    <option value="">En cours</option>
                </select>
            </div>
        </div>
        <div class="boutons">
            <input type="submit" value="Lire" class="btn btn-primary btn-sm">
            <input type="submit" value="Supprimer" class="btn btn-primary btn-sm supprimer">
        </div>
    </div>

    <!-- Sauver un fichier -->
    <div class="col-xs-4 save">
        <p class="jumbotron col-xs-12 sauver">Sauvegarder un fichier</p>
        <input type="submit" class="btn btn-primary btn-sm" id="Télécharger">
    </div>
</div>

<form method="post">
    <table>
        <c:forEach items="${ subtitles }" var="t" varStatus="status">
            <tr>
                <td style="text-align:right;"><c:out value="${ status.index }"/></td>
                <td style="text-align:right;"><c:out value="${ t }"/></td>
                <td style="text-align:right;"><c:out value="${ t }"/></td>
                <td style="text-align:right;"><c:out value="${ t }"/></td>
                <td><input style="margin-left: 10px" class="champTrad" type="text" name="line${ status.index }" id="line${ status.index }" size="35"/></td>
                <td><input style="margin-left: 10px" type="text" class="champTrad" name="line${ status.index }" id="line${ status.index }" size="35"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>