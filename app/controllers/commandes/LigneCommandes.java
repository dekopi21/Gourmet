package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Security;
import play.mvc.With;

@With(Security.class)
@Check({"Agent","Administrateur"})
public class LigneCommandes extends CRUD{
}
