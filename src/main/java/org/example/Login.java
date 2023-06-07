package org.example;


import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

public class Login {



    public void prisijungimas(Scanner scanner, MongoCollection<Document> collection,Testas testas) {


        System.out.println("Prisijungimas");
        System.out.print("Įveskite vardą: ");
        String vardas = scanner.nextLine();
        System.out.print("Įveskite slaptažodį: ");
        String slaptazodis = scanner.nextLine();
        Document user = collection.find(new Document("vardas", vardas)).first();
        if (user != null && user.getString("slaptazodis").equals(slaptazodis)) {
            System.out.println("Prisijungta sėkmingai!");

            int balai = testas.sprestiTesta(scanner);
            System.out.println("Balai: " + balai);

            user.put("balai", balai);
            collection.replaceOne(new Document("_id", user.get("_id")), user);
        } else {
            System.out.println("Prisijungimas nepavyko. Patikrinkite duomenis.");
        }
    }
    }

