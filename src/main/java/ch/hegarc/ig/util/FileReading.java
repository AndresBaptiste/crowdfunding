package ch.hegarc.ig.util;

import ch.hegarc.ig.business.Donateur;
import ch.hegarc.ig.business.Projet;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import org.apache.commons.io.FilenameUtils;


public class FileReading {

  private Projet projectList;

  public void build() {

    //getfilename() à la place du nom
    String type = FilenameUtils.getExtension("employees.json");

    switch (type) {
      case ".json":

        projectList = new Projet();

        String keyName = null;

        try {

          JsonParser jparser = Json.createParser(new FileReader("FILENAME.JSON"));

          while (jparser.hasNext()) {
            JsonParser.Event event = jparser.next();

            if (event == Event.KEY_NAME) {
              if ("project".equals(jparser.getString())) {
                while (jparser.next() != Event.END_ARRAY) {
                  Donateur donateur = new Donateur();
                  Event e2 = jparser.next();
                  while (e2 != Event.END_OBJECT) {
                    switch (e2) {
                      case KEY_NAME:
                        keyName = jparser.getString();
                        break;
                      case VALUE_STRING:
                        switch (keyName) {
                          case "id":
                            donateur.setId(Integer.parseInt(jparser.getString()));
                            break;
                          case "prenom":
                            donateur.setPrNom(jparser.getString());
                            break;
                          case "nom":
                            donateur.setNom(jparser.getString());
                            break;
                          case "email":
                            donateur.setEmail(jparser.getString());
                            break;
                          case "langue":
                            donateur.setLangue(jparser.getString());
                            break;
                          case "adresse":
                            donateur.setAdresse(jparser.getString());
                            break;
                          case "ville":
                            donateur.setVille(jparser.getString());
                            break;
                          case "monnaie":
                            donateur.setMonnaie(jparser.getString());
                            break;
                          case "dateDon":
                            donateur.setDateDon(jparser.getString());
                            break;
                          case "dateVersement":
                            donateur.setDateVersement(jparser.getString());
                            break;
                          default:
                            /* ??? --> Dans le fichier json, qu'en faire?
                            "paye": true,
                            "annule": true,*/
                            break;
                        }
                        break;
                      case VALUE_NUMBER:
                        switch (keyName) {
                          case "somme":
                            donateur.setSomme(Long.parseLong(jparser.getString()));
                            break;
                        }
                    }
                    e2 = jparser.next();
                  }
                  if (donateur != null) {
                    projectList.getDonateurs().add(donateur);
                  }
                }
              }
            }
          }
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    }
  }
}
