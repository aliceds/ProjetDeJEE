<%-- 
    Document   : inscription
    Created on : 9 juin 2017, 16:13:36
    Author     : Leen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="header" value="header" />
</jsp:include> 

<jsp:include page="menu.jsp" flush="true">
    <jsp:param name="menu" value="menu" />
</jsp:include> 

<form method="post" action="Inscription">
    <fieldset>
        <table class="formulaire">
            <th colspan="2">Inscription</th>
            <tr>
                <td><label for="nom">Adresse email <span class="requis">*</span></label></td>
                <td><input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" /></td>
                <span class="erreur">${form.erreurs['email']}</span>
            </tr>

            <tr>
                <td><label for="motdepasse">Mot de passe <span class="requis">*</span></label></td>
                <td><input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /></td>
                <span class="erreur">${form.erreurs['motdepasse']}</span>
            </tr>
            
            <tr>
                <td><label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label></td>
                <td><input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20"/></td>
                <span class="erreur">${form.erreurs['confirmation']}</span>
            </tr>
                
            <tr>
                <td><label for="nom">Nom d'utilisateur</label></td>
                <td><input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" /></td>
                <span class="erreur">${form.erreurs['nom']}</span>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Inscription" class="sansLabel" /></td>
            </tr>
        </table>
        
        <p class="indication"><span class="requis">Les champs marqués de * sont obligatoires</span></p>

        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

        <%-- vérification de la présence d'un objet utilisateur en session --%>
        <c:if test="${!empty sessionScope.sessionUtilisateur}">
            <%-- si l'utilisateur existe en session, alors affichage adresse email --%>
            <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
        </c:if>

    </fieldset>
</form>

<jsp:include page="footer.jsp" flush="true">
    <jsp:param name="footer" value="footer" />
</jsp:include> 
