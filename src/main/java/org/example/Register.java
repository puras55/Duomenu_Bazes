package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

public class Register {
    MongoClient mongoClient=new MongoClient();


    public void registracija(Scanner scanner, MongoCollection<Document> collection) {
        System.out.println("Registracija");
        System.out.print("Įveskite vardą: ");
        String vardas = scanner.nextLine();
        System.out.print("Įveskite pavardę: ");
        String pavarde = scanner.nextLine();
        System.out.print("Įveskite slaptažodį: ");
        String slaptazodis = scanner.nextLine();
        System.out.print("Įveskite mokyklos pavadinimą: ");
        String mokykla = scanner.nextLine();
        System.out.print("Įveskite amžių: ");
        int amzius = scanner.nextInt();
        scanner.nextLine();

        Document user = collection.find(new Document("vardas", vardas)).first();
        if (user != null) {
            System.out.println("Vartotojas jau egzistuoja. Registracija nepavyko.");
        } else {
            Document newUser = new Document("vardas", vardas)
                    .append("pavarde", pavarde)
                    .append("slaptazodis", slaptazodis)
                    .append("mokykla", mokykla)
                    .append("amzius", amzius);
            collection.insertOne(newUser);
            System.out.println("Registracija sėkminga!");
        }
    }
}

