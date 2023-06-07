package org.example;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Admin.Admin;

import java.util.Scanner;

public class Main {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public static void main(String[] args) {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDatabase("usersdb");
        collection = database.getCollection("users");

        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Register register = new Register();
        Testas testas = new Testas();
        Admin admin = new Admin();

        int choice;

        do {
            System.out.println("Pasirinkite veiksmą:");
            System.out.println("1. Prisijungimas");
            System.out.println("2. Registracija");
            System.out.println("3. Admin prisijungimas");
            System.out.println("0. Išeiti");
            System.out.print("Jūsų pasirinkimas: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login.prisijungimas(scanner, collection, testas);
                    break;
                case 2:
                    register.registracija(scanner, collection);
                    break;
                case 3:
                    admin.adminPrisijungimas(scanner, collection);
                    break;
                case 0:
                    System.out.println("Programa baigia darbą.");
                    break;
                default:
                    System.out.println("Neteisingas pasirinkimas.");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        mongoClient.close();
    }
}