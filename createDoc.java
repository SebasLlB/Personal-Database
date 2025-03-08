package com.personal;
import org.bson.Document;

//Document libraries (Scanner, LocalDate, DateTimeFormatter)
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class createDoc {
    public static Scanner input = new Scanner(System.in);

    public static Document project(String category){
        String name = "";

        //Creates time object, and its format object
        LocalDate currentTime = LocalDate.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = currentTime.format(formatTime);

        //Asks for the project's name
        dbFile.pause();    
        System.out.print("Project name: ");
        dbFile.pause();

        while(name.equals("")){
            name = input.nextLine();
        }

        dbFile.pause();

        //Asks for the project's description
        System.out.println("Project description: ");
        String description = input.nextLine();

        //Creates the document with the values accordingly
        Document doc = new Document("Project", name);
        doc.append("Date", formattedDate);
        doc.append("Description", description);
        doc.append("Category", category);
        doc.append("Met", false);
        return doc;
    }
    

}
