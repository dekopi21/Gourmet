package controllers.portail.livreur;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import play.mvc.With;

@With(Secure.class)
@Check("Livreur")
public class Dashboards extends CRUD {
    public static void dashboard(){
        render();
    }
}
