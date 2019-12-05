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
                    <form method="post" action="${pageContext.request.contextPath}/edit" id="soustitreForm1" enctype="multipart/form-data"> <!-- Formulaire upload fichier -->
                        <!--accept=".srt"-->
                        <div class="row">
                            <div class="nom col-lg-6 nom_video">
                                <label>Nom de la vidéo : </label>
                                <div>
                                    <input type="text" name="nom_video"/>
                                </div>
                            </div>

                            <div class="language col-lg-6">
                                <label>Langues :</label>
                                <div>
                                    <select id="langues" name="langues">
                                        <c:forEach items="${ langages }" var="langage" varStatus="status">
                                            <option value="${ langage.getLangue() }"> ${ langage.getLangue() }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <div>
                                    <label for="btn_fichier"> Choisir un fichier : </label> <input type="file"
                                                                                                   name="fichier"
                                                                                                   class="fichier"
                                                                                                   id="btn_fichier"/>
                                </div>
                            </div>
                        </div>
                        <div>
                            <input type="submit" value="Charger" name="charger" id="charger" class="btn btn-primary btn-sm">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/edit">
            <!-- Base de Données -->
            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                <div class="panel">
                    <div class="panel-heading text-center">
                        <h2>Base de Données</h2>
                    </div>
                    <div class="panel-body text-center">
                        <div class="Enregistrer">
                            <input type="submit" class="btn btn-primary btn-sm" value="Enregistrer" name="enregistrer">
                        </div>
                        <label>Choissez une vidéo</label>
                        <div>
                            <select name="fichiers" id="fichiers" class="fichiers">
                                <option value="">En cours</option>
                            </select>
                        </div>
                        <div class="boutons">
                            <input type="submit" value="Lire" name="lire" class="btn btn-primary btn-sm">
                            <input type="submit" value="Supprimer" class="btn btn-primary btn-sm supprimer">
                        </div>
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
                        <input type="submit" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </div>
    </div>

    <!-- Bandeau récapitulatif -->
    <c:if test="${ fichierCharger }">
        <div class="row">
            <p>Vidéo : ${ fichier } Langue : ${ langue } Fichier : ${ file } </p>
        </div>
        <!-- tableau fichier à traduire -->
        <c:forEach items="${ subtitles }" var="t" varStatus="status">
            <div class="row">
                <div class="col-lg-1">
                    <c:out value="${ status.index }">${ status.index }</c:out>
                </div>

                <div class="col-lg-3">
                    <c:out value="${ t.getTemps() }">${ t.getTemps() }</c:out>
                </div>

                <div class="form-group">
                    <div class="col-lg-4">
                        <c:out value="${ t.getLigne1_source() }">${ t.getLigne1_source() }</c:out>
                    </div>

                    <div class="col-lg-4">
                        <input class="form-control" type="text" name="line${ status.index }" id="line${ status.index }">
                    </div>

                    <c:if test="${ t.getLigne2_source() != null }">
                    <div class="row">
                        <div class="col-lg-offset-4 col-lg-4">
                            <c:out value="${ t.getLigne2_source() }">${ t.getLigne2_source() }</c:out>
                        </div>

                        <div class="col-lg-4">
                            <input class="form-control" type="text" name="line${ status.index }2" id="line${ status.index }2">
                        </div>
                    </div>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </c:if>

    </form>

</div>
</body>
</html>