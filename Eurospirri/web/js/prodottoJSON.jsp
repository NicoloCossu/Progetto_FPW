
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%> 
<json:object>
    
    <%-- l'utente che ha inserito il prodotto --%>
    <json:property name="owner" value="${owner}"/>
    
    <%-- attributi del prodotto --%>
    <json:property name="foto" value="${prodotto.getFoto()}"/>
    <json:property name="nomeProdotto" value="${prodotto.getNome()}"/>
    <json:property name="descrizione" value="${prodotto.getDescrizione()}"/>
    <json:property name="quantita" value="${prodotto.getQuantita()}"/> 
    <json:property name="scadenza" value="${prodotto.getScadenza()}"/>
    <json:property name="prezzo" value="${prodotto.getPrezzo()}"/>

</json:object>