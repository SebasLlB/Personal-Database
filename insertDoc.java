package com.personal;

//Document library for project file
import org.bson.Document;
//All MongoDB libraries needed
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//Additional libraries
import java.util.Scanner;

public class insertDoc {

    //Database connection set up
    static String connectionString = "mongodb+srv://TheMechanic:MyCluster1@personaldb.lbxjn.mongodb.net/";
    static MongoClient client = MongoClients.create(connectionString);
    static MongoDatabase database = client.getDatabase("Projects");

    //User input object
    static Scanner input = new Scanner(System.in);
    static String[] collections = {"circuitry", "robotic", "design", "software"};
    static Boolean there = true;

    
        //Inserts the document into the Circuitry collection
        public static void insertDocument(String category){
            dbFile.pause();
            MongoCollection<Document> collection = database.getCollection(dbFile.capitalize(category));
            collection.insertOne(createDoc.project(category));
            dbFile.pause();
            System.out.println("Done");
            dbFile.pause();
        }

}

