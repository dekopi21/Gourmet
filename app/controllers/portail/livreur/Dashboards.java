package controllers.portail.livreur;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import controllers.Security;
import play.mvc.With;

@With(Security.class)
@Check({"Livreur","Administrateur"})
public class Dashboards extends CRUD {
    public static void dashboard(){
        render();
    }
}
