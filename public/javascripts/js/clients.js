

var idPlat = 0;

$(document).ready(function () {
    var email = $("#inputEmail2").val();
    var telephone = $("#Tel").val();
    var ville = $("#Ville").val();
    var quartier = $("#Quartier").val();
    var pass = $("#inputMdp").val();
    var pass1 = $("#pwd").val();
    var nom = $("#nom").val();
    var prenom = $("#prem").val();
    var login = $("#login").val();
    var sexe = $("#sexe").val();
    var nomUser = $("#nomUs").val();
    //les bouttons previous
    $("#btn-previous-1").on("click", function () {
        if (true)
            previous(this);
    });

    $("#btn-previous-2").on("click", function () {
        if (true)
            previous(this);
    });

    $("#btn-previous-3").on("click", function () {
        if (true)
            previous(this);
    });

    $("#btn-previous-4").on("click", function () {
        if (true)
            previous(this);
    });
//#######################################################
    $("#btn-next-1").on("click", function () {
        if (true)
            next(this);
    });
    $("#btn-next-2").on("click", function () {
        if (true)
            next(this);
        addClient();

    });

    $("#btn-next-3").on("click", function () {
        if (true)
          // getStep3();
            next(this);
    });

    $("#btn-next-4").on("click", function () {
        if (true)
         //   getStep4();
       // recapitulatif();
       // alert(getStep3());
            next(this);
    });
    $("#btn-next-5").on("click", function () {
        if (true)
            next(this);
    });



    var bool = false;
    $("#partenaire").hide();

    $("#detail").show();
    $("#detail").click(function () {
        $("#dish").show();
        $("#panier-dish").css("margin-top", "-55rem");
        bool = true;
    });

    //#############################################################//
    //#############################################################//
    //#############################################################//

var prixUnitaire = 0;
    $(".imagePlat").click(function () {
        $("#showImg").attr("src",$(this).data("img"));
        $("#titre").text($(this).data("titre"));
        $("#montant").text($(this).data("montant"));
        prixUnitaire = $(this).data("montant");
        $("#description").text($(this).data("desc"));
        $("#id").text($(this).data("id"));
         idPlat = $(this).data("id");
        $("#mtTotal").text(0.00);
        $("#quantite").text(0.00);
        $("#quantite").id;
        $(".modal").show();

    });
    var quantite = 0;
    var rest = 0;


    $("#plus").click(function () {
        quantite === 0;
        quantite++;
        $("#quantite").text(quantite);
      $("#mtTotal").text(quantite * prixUnitaire);
      rest = quantite * prixUnitaire;
    });

    $("#moin").click(function () {
        //partie a revoir
        if(quantite != 0){
            quantite--;
            $("#quantite").text(quantite);

            $("#mtTotal").text( rest - prixUnitaire);
            rest = prixUnitaire * quantite;
        }else if(quantite === 0){
            $("#mtTotal").text(0.00);
        }

    });

    $("#rouge").click(function () {
        var mtn = $("#mtTotal").text();
        addProductToCart(idPlat, quantite);
        $("#exampleModal").hide();
        quantite === 0;

    });

    $("#noir").click(function () {
        $("#exampleModal").hide();
        quantite === 0;

    });
    $("#btnClose").click(function () {
        $("#exampleModal").hide();
        quantite === 0;

    });
    // afficher le montant total apres le click sur ce boutton


    //#################################################################//

    function addProductToCart(platID,quantity){

        $.ajax({
            type : "POST" ,
            url : "/portail/Dashboards/addToCart",
            data : {
                "idPlat" : platID,
                "quantite" : quantity
            },
            success: function(data){
                if(!data["error"]){
                    console.log(data);
                    var qte = data["qte"];
                    var oldQte = $("#count").text();
                    $("#count").text(parseInt(qte) + parseInt(oldQte));
                   // $("#panier"+platID).removeClass("btn-primary");
                  //  $("#panier"+platID).addClass("btn-success");
                    console.log(data["qte"]);
                }else{
                    console.log(data);
                    alert("Impossible d'ajouter au panier");
                }
            },
            error:function(data){
                console.log(data);
            }

        });
    }
    //#################################################################//


    $("#txt").click(function () {
        if (confirm("SUPPRIMER LA COMMANDE ?")) {
            $("#secs").remove();
        }
        alert($('#nmbre').val());
    });


    $("#rd1-message").className = "alert-danger";
    $("#rd1-message").css("margin-top","5px");
    $("#rd1-message").css("color","black");
    $("#rd1-message").css("background-color","red");


    //###################################

    var valeur_retrait = "";

    $("#mode-de-preparation2").click(function () {
        $("#champ_retrait").show();
        valeur_retrait = $("#champ_retrait").textContent;
    });

//###########################################

    function addClient() {
        //  passVerif(pass, pass1);
        if (email != null || telephone!=  null || ville != null || quartier != null || nom != null
            || prenom != null || login != null || sexe != null){
            //addclient();
        }
    }

    function passVerif(pass1, pass2){
        if (pass1 === null || pass === "" || pass2 === null || pass2 === "") {
            document.getElementById("rd1-message").innerHTML = "Mot de passe ou login non vide";

        } else if (pass1 != pass2) {
            document.getElementById("rd1-message").innerHTML = "les deux champs de mots de passe doivent etre identique";
            return false;
        } else if (pass1 < 5 || pass2 > 25 && pass1 < 5 || pass2 > 25) {
            document.getElementById("rd1-message").innerHTML = "Mot de passe trop court";
            return false;
        } else if (pass === pass1) {


        }
    }



    function recapitulatif() {
        $("#adresseLiv").text("Adresse de livraison : "+$("#radioRetrait").val());
        $("#modeLivraison").text("Mode  de livraison : "+$("#radioRetrait").val());
        $("#modPaie").text("Mode  de paiement : "+$("#radioRetrait").val());
        $("#adrFactu").text("Adresse de facturation : "+$("#inputadrFac").val());

    }

    function showFrais() {
        $("#formPasDeCompte").addClass("hidden");
        $("#fAdr").removeClass("hidden");
        $("#fAdr").addClass("show");
        return $("#inputadr").val();
    }

    function hideFrais() {
        $("#fAdr").removeClass("show");
        $("#fAdr").addClass("hidden");
        return $("#radioRetrait").val();
    }

    function getStep3() {
        hideFrais();
        showFrais();

    }

    function getStep4() {
        $("#radioCarte").click(function () {
            alert($("#radioCarte").val());
        });
        $("#radioPorte").click(function () {
            alert($("#radioPorte").val());
        });

        //alert();
    }


});

