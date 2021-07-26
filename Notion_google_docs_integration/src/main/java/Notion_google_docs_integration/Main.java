package Notion_google_docs_integration;

import Notion_google_docs_integration.API_objects.Google.GoogleAPI;
import Notion_google_docs_integration.API_objects.Google.GoogleFilesManager;
import Notion_google_docs_integration.API_objects.NotionAPI;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext springContextMain = SpringApplication.run(Main.class, args);
        NotionAPI notionAPI = springContextMain.getBean("notionAPIBean", NotionAPI.class);
        notionAPI.POSTQueryDatabase();

        GoogleAPI googleAPI = springContextMain.getBean("googleAPIBean", GoogleAPI.class);
        GoogleFilesManager googleFilesManager = springContextMain.getBean(GoogleFilesManager.class);

        try {
            Drive service = googleAPI.getInstance();
            //List<File> files = googleFilesManager.listFiles(10);
            List<File> files = googleFilesManager.listFilesInFolder("1TALYHJdqVeKNwu2XPWY2NTWVNE-0RJSl");
            googleFilesManager.printList(files);
            String id = googleFilesManager.createFullPathAndGetIdFolder("11111/my_files/pages/blocks/content/33333");
            System.out.println(id);



        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }



    }
}
