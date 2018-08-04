package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import play.mvc.With;

@With(Secure.class)
@Check({"Agent","Livreur"})
public class Livraisons extends CRUD{
}
