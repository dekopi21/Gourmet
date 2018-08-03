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


$(document).ready(function () {

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

var montantTotal = 0;
    $(".imagePlat").click(function () {
        $("#showImg").attr("src",$(this).data("img"));
        $("#titre").text($(this).data("titre"));
        $("#montant").text($(this).data("montant"));
        montantTotal = $(this).data("montant");
        $("#description").text($(this).data("desc"));
        $("#mtTotal").text(0.00);
        $("#quantite").text(0.00);
        $(".modal").show();

    });
    var quantite = 0;
    var rest = 0;
    $("#plus").click(function () {
        quantite++;
        $("#quantite").text(quantite);
      $("#mtTotal").text(quantite * montantTotal);
      rest = quantite * montantTotal;
      // alert(rest);
    });

    $("#moin").click(function () {
        //partie a revoir
        if(quantite != 0){
            quantite--;
            $("#quantite").text(quantite);

            $("#mtTotal").text( rest / quantite);
            rest = montantTotal * quantite;
        }else if(quantite === 0){
            $("#mtTotal").text(0.00);
        }
  
    });
    // afficher le montant total apres le click sur ce boutton
    $("#rouge").click(function () {
        var mtn = $("#mtTotal").text();
        alert("Montant total du plat est\t" + $("#mtTotal").text());
    });

    //#################################################################//
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
});

    function addProductToCart(id){
        var productID = $("#produit"+id).val();
        var quantity = $("#quantite"+id).val();

        $.ajax({
            type : "POST" ,
            url : "@{addToCart()}",
            data : {
                "idProduit" : productID,
                "quantite" : quantity,
            },
            success: function(data){
                if(!data["error"]){
                    var qte = data["qte"];
                    var oldQte = $("#count").text();
                    $("#count").text(qte + oldQte);
                    $("#panier"+productID).removeClass("btn-primary");
                    $("#panier"+productID).addClass("btn-success");
                    console.log(data["qte"]);
                }else{
                    alert("Impossible d'ajouter au panier");
                }
            },
            error:function(data){
                console.log(data);
            }

        });
    }
    function ClientAuth(){

        $.ajax({
            type : "POST" ,
            url : "@{controllers.Security.authenticate()}",
            data : {
                "username" : login,
                "password" : pass,
            },
            success: function(data){
                if(!data){
                    console.log(data);
                }else{
                    alert("Impossible d'ajouter au panier");
                }
            },
            error:function(data){
                console.log(data);
            }

        });
    }

    function addclient() {
        $.ajax({
            type : "POST" ,
            url : "@{controllers.commandes.Clients.addClient()}",
            data : {
                "nomEng" : nom,
                "prenomEng" : prenom,
                "loginEng" : login,
                "passwordEng" : pass,
                "EmailEng" : email,
                "TelephoneEng" : telephone,
                "VilleEng" : ville,
                "QuartierEng" : quartier,
                "sexeEng" : sexe,

            },
            success: function(data){
                if(!data["error"]){
                    console.log(data["qte"]);
                }else{
                    alert("Impossible d'ajouter au panier");
                }
            },
            error:function(data){
                console.log(data);pla
            }

        });

    }

    function showFCompte() {
        $("#formPasDeCompte").addClass("hidden");
        $("#formCompte").removeClass("hidden");
        $("#formCompte").addClass("show");

    }

    function showFPasCompte() {
        $("#formCompte").addClass("hidden");
        $("#formPasDeCompte").removeClass("hidden");
        $("#formPasDeCompte").addClass("show");

    }

    function passVerif(pass1, pass2){
       if (pass1 === null || pass === "" || pass2 === null || pass2 === "") {
           pass1.css("border-color", "red");
           pass2.css("border-color", "red");
       } else if (pass1 != pass2) {
           document.getElementById("rd1-message").innerHTML = "les deux champs de mots de passe doivent etre identique";
           return false;
       } else if (pass1 < 5 || pass2 > 25 && pass1 < 5 || pass2 > 25) {
           document.getElementById("rd1-message").innerHTML = "Mot de passe trop court";
           return false;
       } else if (pass === pass1) {


       }
}

    function addClient() {
        passVerif(pass, pass1);
    if (email != null || telephone!=  null || ville != null || quartier != null || nom != null
    || prenom != null || login != null || sexe != null){
        addclient();
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


