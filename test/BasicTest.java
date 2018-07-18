import controllers.Actions;
import controllers.TypeImage;
import controllers.TypeUtilisateur;
import models.Commandes.Client;
import models.restaurants.Agent;
import models.restaurants.Categorie;
import models.utilisateurs.Utilisateur;
import org.junit.*;

import java.io.File;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void insertCategorie() {
        try {
            new Categorie("Entrer","o|o", Actions.enregImage(new File("C:\\Users\\gangami\\Downloads\\plats\\images1.jpg"), TypeImage.CATEGORIES, TypeUtilisateur.RAS));
        } catch (Exception e) {
            assertEquals(1, 2);
            e.printStackTrace();
        }
        assertEquals(2, 2);
}
}
