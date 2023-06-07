package org.example.Admin;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KurtiKlausima {
    public void kurtiKlausima(Scanner scanner, MongoCollection<Document> collection) {
        System.out.print("Įveskite naują klausimą: ");
        String klausimas = scanner.nextLine();

        System.out.print("Įveskite atsakymą a): ");
        String atsakymasA = scanner.nextLine();

        System.out.print("Įveskite atsakymą b): ");
        String atsakymasB = scanner.nextLine();

        System.out.print("Įveskite atsakymą c): ");
        String atsakymasC = scanner.nextLine();

        System.out.print("Įveskite teisingo atsakymo raides (a, b arba c): ");
        String teisingasAtsakymas = scanner.nextLine();

        JSONObject klausimoJSON = new JSONObject();
        klausimoJSON.put("klausimas", klausimas);
        klausimoJSON.put("atsakymasA", atsakymasA);
        klausimoJSON.put("atsakymasB", atsakymasB);
        klausimoJSON.put("atsakymasC", atsakymasC);
        klausimoJSON.put("teisingasAtsakymas", teisingasAtsakymas);

        // Įrašyti klausimo JSON į failą
        irasytiIFaila(klausimoJSON.toString());

        System.out.println("Klausimas sukurtas ir įrašytas į failą.");
    }

    private  void irasytiIFaila(String klausimasJSON) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("klausimai.txt", true));
            writer.append(klausimasJSON);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Įvyko klaida įrašant į failą: " + e.getMessage());
        }
    }

}
