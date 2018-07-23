$(document).ready(function () {

    // ***les variables globales de la partie client***
    var email;
    var telephone;
    var ville;
    var quartier;
    var pass;
    var pass1;
    var modeLivraison;
    var addresseLivraison;

    $("#rad1").click(function () {
        $("#rd1").show();
        $("#rd2").hide();
    });
    $("#rad2").click(function () {
        $("#rd2").show();
        $("#rd1").hide();
    });

    $("#btn3").click(function () {

             modeLivraison = $("#mode-de-preparation").val();
             addresseLivraison = $("#AdresseLivraisonClient").val();
            if(addresseLivraison === null || addresseLivraison === "" ||  modeLivraison === null ||  modeLivraison === ""){
                alert("What the fuck!!!!\t")
            }else {
                $("#sec2").hide();
                $("#sec3").show();
            }
        }
    );


    $("#btn4").click(function () {
            $("#panier").hide();
            $("#sec3").hide();
            $("#sec4").show();
            $("#txt").hide();
            $(document).window.href = "@{controllers.commandes.Clients.addClient()}";
            $(document).window.href = "@{controllers.commandes.Clients.addClient()}";
            $(document).window.href = "@{controllers.commandes.Clients.addClient()}";
            $(document).window.href = "@{controllers.commandes.Clients.addClient()}";

        }
    );

    var bool = false;
    $("#partenaire").hide();

    $("#detail").show();
    $("#detail").click(function () {
        $("#dish").show();
        $("#panier-dish").css("margin-top", "-55rem");
        bool = true;
    });

    $("img").click(function () {
        $(".modal").show();
    });

    $("#txt").click(function () {
        if (confirm("SUPPRIMER LA COMMANDE ?")) {
            $("#secs").remove();
        }
        alert($('#nmbre').val());

    });

    $("#btn-retour-1").click(function () {
        $("#sec1").show();
        $("#sec2").hide();
    });
    $("#btn-retour-4").click(function () {
        $("#sec3").show();
        $("#sec4").hide()
    });


    $("#rd1-message").className = "alert-danger";
    $("#rd1-message").css("margin-top","5px");
    $("#rd1-message").css("color","black");
    $("#rd1-message").css("background-color","red");

    $("#btn2").click(function () {
         email = $('#EmailClient').val();
         telephone = $('#TelephoneClient').val();
         ville = $('#VilleClient').val();
         quartier = $('#QuartierClient').val();
         pass = $('#password').val();
        pass1 = $("#password1").val();

        if (pass === null || pass === "" || pass1 === null || pass1 === ""){
            pass1.css("border-color","red");
            pass.css("border-color","red");
        }else if(pass != pass1){
            document.getElementById("rd1-message").innerHTML = "les deux champs de mots de passe doivent etre identique";
            return false;
        }else if(pass <5 || pass>25 && pass1 < 5 || pass1 > 25){
            document.getElementById("rd1-message").innerHTML = "Mot de passe trop court";
            return false;
        }else if(pass === pass1){
                $("#sec1").hide();
                $("#sec2").show();

        }
    });

});

