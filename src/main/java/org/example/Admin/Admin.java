package org.example.Admin;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

public class Admin {
    public void adminPrisijungimas(Scanner scanner, MongoCollection<Document> collection) {

        KurtiKlausima kurtiKlausima=new KurtiKlausima();
        PerziuretiPazymius perziuretiPazymius=new PerziuretiPazymius();

        System.out.println("Admin prisijungimas");
        System.out.print("Įveskite admin slaptažodį: ");
        String adminSlaptazodis = scanner.nextLine();




        // Patikrinkime, ar įvestas slaptažodis atitinka admin slaptažodį
        if (adminSlaptazodis.equals("admin")) {
            System.out.println("Admin prisijungta sėkmingai!");

            // meniu
            int adminChoice;
            do {
                System.out.println("Admin veiksmai:");
                System.out.println("1. Peržiūrėti vartotojų pažymius");
                System.out.println("2. Kurti naują klausimą su atsakymais");
                System.out.println("0. Grįžti į pagrindinį meniu");
                System.out.print("Jūsų pasirinkimas: ");
                adminChoice = scanner.nextInt();
                scanner.nextLine();

                switch (adminChoice) {
                    case 1:
                       perziuretiPazymius.perziuretiPazymius(collection);
                        break;
                    case 2:
                        kurtiKlausima.kurtiKlausima(scanner,collection);
                        break;
                    case 0:
                        System.out.println("Grįžtama į pagrindinį meniu.");
                        break;
                    default:
                        System.out.println("Neteisingas pasirinkimas.");
                        break;
                }

                System.out.println();
            } while (adminChoice != 0);

        } else {
            System.out.println("Admin prisijungimas nepavyko. Patikrinkite slaptažodį.");
        }
    }
}



