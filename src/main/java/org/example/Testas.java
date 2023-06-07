package org.example;

import org.example.Admin.KurtiKlausima;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.example.Admin.sprestiTesta.klausimuJSONs;

public class Testas {
    public  int sprestiTesta(Scanner scanner) {
        System.out.println("Geografijos testas testas");
        int balai = 0;

        // Nuskaityti klausimus iš failo ir konvertuoti į JSON objektus
        skaitytiIsFailo();

        for (int i = 0; i < klausimuJSONs.length(); i++) {
            JSONObject klausimoJSON = klausimuJSONs.getJSONObject(i);

            String klausimas = klausimoJSON.getString("klausimas");
            String atsakymasA = klausimoJSON.getString("atsakymasA");
            String atsakymasB = klausimoJSON.getString("atsakymasB");
            String atsakymasC = klausimoJSON.getString("atsakymasC");
            String teisingasAtsakymas = klausimoJSON.getString("teisingasAtsakymas");

            System.out.println(klausimas);
            System.out.println("a) " + atsakymasA);
            System.out.println("b) " + atsakymasB);
            System.out.println("c) " + atsakymasC);
            System.out.print("Jūsų atsakymas: ");
            String atsakymas = scanner.nextLine();

            if (atsakymas.equalsIgnoreCase(teisingasAtsakymas)) {
                balai += 2;
            }
        }

        return balai;
    }

    private  void skaitytiIsFailo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("klausimai.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                JSONObject klausimoJSON = new JSONObject(line);
                klausimuJSONs.put(klausimoJSON);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Įvyko klaida skaitant iš failo: " + e.getMessage());
        }
    }
}
