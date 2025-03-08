package com.personal;
/*Document, List, and ArrayList libraries for Documents*/
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;
/*Collection library access */
import com.mongodb.client.MongoCollection;
/*Document retrieval help(easier to access) */
import static com.mongodb.client.model.Projections.*;

public class displayProjects {
    public static void listAll(String category){
        /*Access the collection from dbFile's database' */
        MongoCollection<Document> collection = dbFile.database.getCollection(dbFile.capitalize(category));
        /* Create a list to display all the collection projects
         * Only display their names.
         */
        List<Document> projects = collection.find()
                                  .projection(fields(excludeId(),
                                                     include("Project")))
                                  .into(new ArrayList<>());
        /*Print the contents of the list. */
        for(Document text : projects){
            System.out.println(text.toJson());
        }
    }
}
