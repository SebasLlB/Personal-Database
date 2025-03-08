package com.personal;

/*Main libraries used:
 * Scanner
 * MongoClient
 * MongoClients
 * MongoDatabase
 */
import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class dbFile {
    /*Starting Values(Scanner, Client and Database access)
     * Every file will use this access
     */
    static String connectionString = "my-connection-string";
    static MongoClient client = MongoClients.create(connectionString);
    static MongoDatabase database = client.getDatabase("Projects");

    /*Input Scanner, Collection list and while variable */
    static Scanner input = new Scanner(System.in);
    static String[] collections = {"circuitry", "robotic", "design", "software"};
    static Boolean invalidCollection = true;
        /*Program starts here. */
        public static void main(String[] args) {
            String category = "";
            /*"Access which collection?" */
            System.out.print("Type the name of the project category: ");
            category = input.next();
            /*Set category to a standard, lowercased comparatible string*/
            category = category.toLowerCase();
            
            /*Checks if the first answer is a valid collection */
            for(String s : collections){
                if(s.equals(category)){
                    invalidCollection = false;
                    pause();
                    System.out.println("Accessing " + capitalize(category) + " collection...");
                    /*Ask the user if the project needs to be added or found
                     * If an invalid response is given, then the whole program repeats
                     */
                    System.out.println("Add/Access?");
                    String action = input.next();
                    if(action.equals("access")){
                        displayProjects.listAll(capitalize(category));
                    } else if(action.equals("add")){
                        insertDoc.insertDocument(category);   
                    } else{
                        System.out.println("not an option.");
                        main(null);
                    }
                }
            }
            /*As long as the response isn't valid, then the program will keep asking for the collection*/
            while(invalidCollection){
                System.out.println("That's not a category. Try again");
                category = input.next();
                category = category.toLowerCase();
                for(String s : collections){
                    if(s.equals(category)){
                        invalidCollection = false;
                        pause();
                        System.out.println("Accessing " + capitalize(category) + " collection...");
                        /*Ask the user if the project needs to be added or found
                        * If an invalid response is given, then the whole program repeats
                        */
                        System.out.println("Add/Access?");
                        String action = input.next();
                        if(action.equals("access")){
                            displayProjects.listAll(capitalize(category));
                        } else if(action.equals("add")){
                            insertDoc.insertDocument(category);   
                        } else{
                            System.out.println("not an option.");
                            main(null);
                        }
                    }
                }
            }
            
        }

        /*Capitalizes the first character of a given word*/
        public static String capitalize(String word){
            String capital = word.substring(0,1);
            capital = capital.toUpperCase();
            String rest = word.substring(1, word.length());
            return capital.concat(rest);
        }
        /*Pauses the program briefly*/
        public static void pause(){
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
}
}
