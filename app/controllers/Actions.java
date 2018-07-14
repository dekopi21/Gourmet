/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import play.Play;

import static controllers.TypeImage.*;
import static controllers.TypeUtilisateur.*;


public class Actions {

    public static String enregImage(File image, TypeImage typeImage, TypeUtilisateur typeUtilisateur) throws Exception {

        //Initialaisation
        String error = "";
        if(typeUtilisateur.equals(RAS)) {
            //Dossier
            File nompCompletDossier = new File(Play.applicationPath, getDirImage(typeImage));

            //Créer le dossier s'il n'existe pas.
            if (!nompCompletDossier.exists()) {

                if (!nompCompletDossier.mkdirs())
                    return "2";
            }

            String nomCompletFichier = new SimpleDateFormat("Yyyyddmm_hhmmss").format(new Date()) + "." + getFileExtension(image);

            fileName(nomCompletFichier , nompCompletDossier, typeImage,image);

        }else {
            File nompCompletDossier = new File(Play.applicationPath, getDirImage(typeImage)+getDirUtilisateur(typeUtilisateur));

            //Créer le dossier s'il n'existe pas.
            if (!nompCompletDossier.exists()) {

                if (!nompCompletDossier.mkdirs())
                    return "2";
            }

            String nomCompletFichier = new SimpleDateFormat("Yyyyddmm_hhmmss").format(new Date()) + "." + getFileExtension(image);

            fileName(nomCompletFichier , nompCompletDossier, typeImage,image);

        }
        return error;
    }

    private static void fileName(String fichierImage, File fichierDossier, TypeImage typeImage, File image) throws Exception {
        try {
            //on crée un nouveau fichier qu'on ajoute au chemin du er +**/
            File nomComplet = new File(fichierDossier, fichierImage);

            //on enrégistre le chemin absolu vers le fichier image dans error **/
            getDirImage(typeImage).concat("/" + fichierImage);

            //déplace l'image vers le dossier nomCpmplet **/
            FileUtils.moveFile(image, nomComplet);
            // (fichier de départ , fichier d'arrivé)**/

        } catch (IOException ioe) {
            //error = "1";

        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    private static String getDirImage(TypeImage typeImage) {
        String dir = "";

        switch(typeImage)
        {
            case PLATS:
                dir = PLATS.toString();
                break;
            case CATEGORIES:
                dir = CATEGORIES.toString();
                break;
            case UTILISATEURS:
                dir = UTILISATEURS.toString();
                break;
            case MENU:
                dir = MENU.toString();
                break;
            case RESTAURANT:
                dir = RESTAURANT.toString();
                break;
        }
        
        return dir;
        
    }

    private static String getDirUtilisateur(TypeUtilisateur typeUtilisateur) {
        String dirUtili ="";
        switch (typeUtilisateur){
            case AGENT:
                dirUtili = AGENT.toString();
                break;
            case CLIENT:
                dirUtili = CLIENT.toString();
                break;
            case LIVREUR:
                dirUtili = LIVREUR.toString();
                break;
            case ADMINSTRATEUR:
                dirUtili = ADMINSTRATEUR.toString();
                break;
        }
        return dirUtili;
    }

}
