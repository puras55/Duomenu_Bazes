package org.example.Admin;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class PerziuretiPazymius {
    public void perziuretiPazymius(MongoCollection<Document> collection) {
        System.out.println("Vartotojų pažymiai:");

        for (Document user : collection.find()) {
            String vardas = user.getString("vardas");
            int balai = user.getInteger("balai", 0);

            System.out.println("Vartotojas: " + vardas + ", Balai: " + balai);
        }
    }
}
