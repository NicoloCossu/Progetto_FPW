<%-- 
 login presenta le stesse caratteristiche dell'omonima pagina in html
con la differenza che al suo interno sono collegate le varie pagine e controlli
creati tramite jsp 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${not empty user}">
        <c:redirect url="index.jsp"/>
    </c:if>
    
    <c:if test="${empty user}">
            <head>

                <title>Login </title>
                <jsp:include page="head.jsp" />
                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
                <script type="text/javascript" src="js/jquery_Login.js"></script>

            </head>
            <body>
                <header>

                    <div class="col-2">
                        <a href="index.jsp" id="torna">
                            <img title="Logo" alt="Logo EuroSpirri" src="img/nuovo logo progetto.png" width="150" height="150" id="logo">
                        </a>
                    </div>

                    <div class="col-10">
                        <h1>Login</h1>
                    </div>

                </header>

                <jsp:include page="nav.jsp" />

                <div class="col-8" id="colonna_sinistra">
                    <article id="login">

                        <section>
                            <h2>Accedi</h2>
                            <form method="post" action="Login" id="formAccedi" ">
                                <label for="user">Username</label>
                                <input type="text" id="user" name="user"/>
                                
                                <br><br>
                                <h5 id="erroreUsername"><h5/>
                                    
                                <label for="pass">Password</label> 
                                <input type="password" id="pass" name="pass"/><br><br>
                                <h5 id="errorePass"><h5/>
                                    
                                <input type="submit" id="tastoAccedi" value="Accedi"/><br><br>
                            </form>
                        </section>

                        <section>
                            <h2>Registrati</h2>
                            <form action="AddUser" method="post">
                                
                                <label for="user">E-mail</label> 
                                <input type="text" id="email" name="email"/><br><br>
                                <h5 id="erroreEmail"><h5/>
                                    
                                <label for="user">Username</label> 
                                <input type="text" id="userR" name="user"/><br><br>
                                <h5 id="erroreUserR"><h5/>
                                    
                                <label for="pass">Password</label> 
                                <input type="password" id="passR" name="pass"/><br><br>
                                <h5 id="errorePassR"><h5/>
                                    
                                <label for="pass">Conferma Password</label>
                                <input type="password" id="passR2" name="pass2"/><br><br>
                                <h5 id="errorePassR2"><h5/>
                                    
                                <label for="name">Nome</label>
                                <input type="text" id="name" name="name"/><br><br>
                                <h5 id="erroreName"><h5/>
                                
                                <label for="cogn">Cognome</label>
                                <input type="text" id="cognome" name="cognome"/><br><br>
                                <h5 id="erroreCognome"><h5/>
                                    
                                <label for="citta">Citta</label>
                                <input type="text" id="citta" name="citta"/><br><br>
                                <h5 id="erroreCitta"><h5/>
                                    
                                <input type="submit" id="tastoRegistrati" value="Registrati"/><br><br>
                            </form>
                        </section>

                    </article>
                </div>

                <jsp:include page="aside.jsp" />
                <jsp:include page="footer.jsp" />

            </body>

    </c:if>
    </html>
