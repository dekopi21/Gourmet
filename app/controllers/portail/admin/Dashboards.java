package controllers.portail.admin;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import play.mvc.With;

@With(Secure.class)
@Check("Administrateur")
public class Dashboards extends CRUD {
    public static void dashboard(){
        render();
    }
}
