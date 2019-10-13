<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/styleSubtitlor.css" rel="stylesheet">
    <title>Editer les sous-titres</title>
</head>
<body>
<div class="container-fluid">

    <!-- Titre -->
    <div class="col-lg-offset-4 col-lg-5">
        <h1>Traduction des sous-titres de vidéos</h1>
    </div>


    <div class="row">
        <!-- Ouvrir un fichier -->
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
            <div class="panel">
                <div class="panel-heading text-center">
                    <h2>Ouvrir un fichier</h2>
                </div>
                <div class="panel-body text-center">
                    <form method="post" id="chargement">
                        <div class="row">
                            <div class="nom col-lg-6 nom_video">
                                <label>Nom de la vidéo : </label>
                                <div>
                                    <input type="text" name="name_video">
                                </div>
                            </div>

                            <div class="language col-lg-6">
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
                            <div class="col-lg-12 file">
                                <div>
                                    <label for="btn_fichier"> Choisir un fichier : </label> <input type="file "
                                                                                                   name="fichier"
                                                                                                   class="fichier"
                                                                                                   id="btn_fichier"/>
                                </div>
                            </div>
                        </div>
                        <div class="envoie">
                            <input type="submit" value="Charger" class="btn btn-primary btn-sm" id="envoie_fichier">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Base de Données -->
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
            <div class="panel">
                <div class="panel-heading text-center">
                    <h2>Base de Données</h2>
                </div>
                <div class="panel-body text-center">
                    <form method="post">
                        <div class="Enregistrer">
                            <input type="submit" class="btn btn-primary btn-sm" value="Enregistrer">
                        </div>
                        <label>Choissez une vidéo</label>
                        <div>
                            <select name="fichiers" id="fichiers" class="fichiers">
                                <option value="">En cours</option>
                            </select>
                        </div>
                        <div class="boutons">
                            <input type="submit" value="Lire" class="btn btn-primary btn-sm">
                            <input type="submit" value="Supprimer" class="btn btn-primary btn-sm supprimer">
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- Sauver un fichier -->
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
            <div class="panel">
                <div class="panel-heading text-center">
                    <h2>Sauvegarder un fichier</h2>
                </div>
                <div class="panel-body text-center">
                    <form method="post">
                        <input type="submit" class="btn btn-primary btn-sm">
                    </form>
                </div>
            </div>
        </div>
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
                <td><input style="margin-left: 10px" class="champTrad" type="text" name="line${ status.index }"
                           id="line${ status.index }" size="35"/></td>
                <td><input style="margin-left: 10px" type="text" class="champTrad" name="line${ status.index }"
                           id="line${ status.index }" size="35"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>