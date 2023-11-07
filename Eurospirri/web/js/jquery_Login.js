/*
 * Controlli sui form con la sintassi Jquery e javascript
 * TODO rivedere contacaratteri
 */
$(document).ready(function () {

    // PARTE LOGIN

    // controlla username
    $('#erroreUsername').hide(); // hide del messaggio di errore
    let usernameCheck = true; // serve per la validate intera
    $('#user').keyup(function () {
        checkUsername();
    });
    function checkUsername() {
        let user = $('#user').val();
        if (user.length <= 0) {
            $("#erroreUsername").show();
            $("#erroreUsername").html("si deve inserire almeno un carattere");
            $("#erroreUsername").css("color", "red");
            usernameCheck = false;
            return false;
        } else {
            if (user.length > 50) {
                $("#erroreUsername").show();
                $("#erroreUsername").html("massimo 50 caratteri");
                $("#erroreUsername").css("color", "red");
                usernameCheck = false;
                return false;
            } else {
                $('#erroreUsername').hide();
                usernameCheck = true;
                return true;
            }
        }

    }

    // controlla password
    $('#errorePass').hide(); // hide del messaggio di errore
    let passwordCheck = true; // serve per la validate intera
    $('#pass').keyup(function () {
        checkPasswordLogin();
    });
    function checkPasswordLogin() {


        let password = $('#pass').val();
        if (password.length <= 4) {
            $("#errorePass").show();
            $("#errorePass").html("si deve inserire almeno 5 caratteri");
            $("#errorePass").css("color", "red");
            passwordCheck = false;
            return false;
        } else {
            if (password.length > 50) {
                $("#errorePass").show();
                $("#errorePass").html("massimo 50 caratteri");
                $("#errorePass").css("color", "red");
                passwordCheck = false;
                return false;
            } else {
                $('#errorePass').hide();
                passwordCheck = true;
                return true;
            }
        }


    }


    // validazione completa parte di Login
    $("#tastoAccedi").click(function () {
        // tutti i controlli
        checkUsername();
        checkPasswordLogin();

        if (usernameCheck === true && passwordCheck === true) {
            return true;
        } else {
            return false;
        }
    });





















    // PARTE REGISTRAZIONE

    // email
    $('erroreEmail').hide();
    let emailCheck = true;
    $('#email').keyup(function () {
        checkEmail();
    });

    function isEmail(email) {
        var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!regex.test(email)) {
            return false;
        } else {
            return true;
        }
    }

    function checkEmail() {


        let email = $('#email').val();



        if (email.length <=0) {
            $("#erroreEmail").show();
            $("#erroreEmail").html("non è stata inserita l'email");
            $("#erroreEmail").css("color", "red");
            emailCheck = false;
            return false;
        }else{
            if (email.length > 50) {
                $("#erroreEmail").show();
                $("#erroreEmail").html("massimo 50 caratteri");
                $("#erroreEmail").css("color", "red");
                emailCheck = false;
            }else{
                if (!isEmail(email)) {
                    $("#erroreEmail").show();
                    $("#erroreEmail").html("questa non è un email");
                    $("#erroreEmail").css("color", "red");
                    emailCheck = false;
                    return false;
                }else{
                    $("#erroreEmail").hide();
                    emailCheck = true;
                    return true;
                }
            } 
        }

            

                
    

    }



    // username
    $('#erroreUserR').hide(); // hide del messaggio di errore
    let userRCheck = true; // serve per la validate intera
    $('#userR').keyup(function () {
        checkUserR();
    });
    function checkUserR() {
        let userR = $('#userR').val();
        if (userR.length <= 0) {
            $("#erroreUserR").show();
            $("#erroreUserR").html("si deve inserire almeno un carattere");
            $("#erroreUserR").css("color", "red");
            userRCheck = false;
            return false;
        } else {
            if (userR.length > 50) {
                $("#erroreUserR").show();
                $("#erroreUserR").html("massimo 50 caratteri");
                $("#erroreUserR").css("color", "red");
                userRCheck = false;
                return false;
            } else {
                $('#erroreUserR').hide();
                userRCheck = true;
                return true;
            }
        }

    }



    // controlla password registrazione
    $('#errorePassR').hide(); // hide del messaggio di errore
    let passwordRCheck = true; // serve per la validate intera
    $('#passR').keyup(function () {
        checkPasswordReg();
    });
    function checkPasswordReg() {


        let pass = $('#passR').val();
        if (pass.length <= 4) {
            $("#errorePassR").show();
            $("#errorePassR").html("si deve inserire almeno 5 caratteri");
            $("#errorePassR").css("color", "red");
            passwordRCheck = false;
            return false;
        } else {
            if (pass.length > 50) {
                $("#errorePassR").show();
                $("#errorePassR").html("massimo 50 caratteri");
                $("#errorePassR").css("color", "red");
                passwordRCheck = false;
                return false;
            } else {
                $('#errorePassR').hide();
                passwordRCheck = true;
                return true;
            }
        }


    }



    // controlla conferma password registrazione
    $('#errorePassR2').hide(); // hide del messaggio di errore
    let passwordR2Check = true; // serve per la validate intera
    $('#passR2').keyup(function () {
        checkPasswordRegCon();
    });
    function checkPasswordRegCon() {


        let pass2 = $('#passR2').val();
        if (pass2.length <= 4) {
            $("#errorePassR2").show();
            $("#errorePassR2").html("si deve inserire almeno 5 caratteri");
            $("#errorePassR2").css("color", "red");
            passwordR2Check = false;
            return false;
        } else {
            if (pass2.length > 50) {
                $("#errorePassR2").show();
                $("#errorePassR2").html("massimo 50 caratteri");
                $("#errorePassR2").css("color", "red");
                passwordR2Check = false;
                return false;
            } else {
                if ($('#passR').val() !== $('#passR2').val()) {
                    $("#errorePassR2").show();
                    $("#errorePassR2").html("le due password sono diverse");
                    $("#errorePassR2").css("color", "red");
                    passwordR2Check = false;
                    return false;
                } else {
                    $('#errorePassR2').hide();
                    passwordR2Check = true;
                    return true;
                }

            }
        }


    }


    // nome
    $('#erroreName').hide(); // hide del messaggio di errore
    let nameCheck = true; // serve per la validate intera
    $('#name').keyup(function () {
        checkName();
    });
    function checkName() {
        let name = $('#name').val();
        if (name.length <= 0) {
            $("#erroreName").show();
            $("#erroreName").html("si deve inserire almeno un carattere");
            $("#erroreName").css("color", "red");
            nameCheck = false;
            return false;
        } else {
            if (name.length > 50) {
                $("#erroreName").show();
                $("#erroreName").html("massimo 50 caratteri");
                $("#erroreName").css("color", "red");
                nameCheck = false;
                return false;
            } else {
                $('#erroreName').hide();
                nameCheck = true;
                return true;
            }
        }

    }


    // cognome
    $('#erroreCognome').hide(); // hide del messaggio di errore
    let cognomeCheck = true; // serve per la validate intera
    $('#cognome').keyup(function () {
        checkCognome();
    });
    function checkCognome() {
        let cogn = $('#cognome').val();
        if (cogn.length <= 0) {
            $("#erroreCognome").show();
            $("#erroreCognome").html("si deve inserire almeno un carattere");
            $("#erroreCognome").css("color", "red");
            cognomeCheck = false;
            return false;
        } else {
            if (cogn.length > 50) {
                $("#erroreCognome").show();
                $("#erroreCognome").html("massimo 50 caratteri");
                $("#erroreCognome").css("color", "red");
                cognomeCheck = false;
                return false;
            } else {
                $('#erroreCognome').hide();

                cognomeCheck = true;
                return true;
            }
        }

    }


    // citta
    $('#erroreCitta').hide(); // hide del messaggio di errore
    let cittaCheck = true; // serve per la validate intera
    $('#citta').keyup(function () {
        checkCitta();
    });
    function checkCitta() {
        let citta = $('#citta').val();
        if (citta.length <= 0) {
            $("#erroreCitta").show();
            $("#erroreCitta").html("si deve inserire almeno un carattere");
            $("#erroreCitta").css("color", "red");
            cittaCheck = false;
            return false;
        } else {
            if (citta.length > 50) {
                $("#erroreCitta").show();
                $("#erroreCitta").html("massimo 50 caratteri");
                $("#erroreCitta").css("color", "red");
                cittaCheck = false;
                return false;
            } else {
                $('#erroreCitta').hide();
                cittaCheck = true;
                return true;
            }
        }

    }



    // validazione completa parte di Registrazione
    $("#tastoRegistrati").click(function () {
        // tutti i controlli
        checkEmail(); // email
        checkUserR(); // username
        checkPasswordReg(); // password registrazione
        checkPasswordRegCon(); // conferma password
        checkName(); // nome
        checkCognome(); // cognome
        checkCitta(); // citta

        if (emailCheck === true && userRCheck === true && passwordRCheck === true && passwordR2Check === true && nameCheck === true && cognomeCheck === true && cittaCheck === true) {

            return true;
        } else {
            return false;
        }
    });





    


    // tasti per modificare la dimensione del font

    $('#font_down').click(function () {
        $('.col-8 *').css({'font-size': '10px'});
    });

    $('#font_normal').click(function () {
        $('.col-8 *').css({'font-size': '24px'});
    });

    $('#font_up').click(function () {
        $('.col-8 *').css({'font-size': '40px'});
    });










    // CONTACARATTERI PARTE REGISTRAZIONE
    // parte per contacaratteri
    $('#email').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#email').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#email').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });


    $('#name').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#name').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#name').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });



    $('#cognome').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#cognome').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#cognome').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });
    
    
     $('#citta').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#citta').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#citta').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });
    
    
     $('#userR').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#userR').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#userR').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });
    
    
     $('#passR').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#passR').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#passR').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });
    
    
    
     $('#passR2').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#passR2').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#passR2').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });
    
    
    // CONTACARATTERI PARTE LOGIN
    
    // USER
     $('#user').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#user').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#user').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });
    
    
     $('#pass').keydown(function (e)
    {
        $('#contaCaratteri').remove();
        var key = e.keyCode || e.charCode;
        if (this.value.lenght >= 50)
            if (!(key === 46 || key === 8))
                e.preventDefault();
    });


    $('#pass').keyup(function () {
        var prova = $("<h5/>");
        if ($('#contaCaratteri').lenght)
        {
        } else {
            $('#contaCaratteri').remove();
        }
        prova.attr('id', 'contaCaratteri');
        $('#pass').after(prova);
        if ($(this).val().length > 50) {
            prova.text("ERRORE: Troppi caratteri inseriti!!");
        } else {
            prova.text("Caratteri: " + (50 - $(this).val().length));
        }
    });

});