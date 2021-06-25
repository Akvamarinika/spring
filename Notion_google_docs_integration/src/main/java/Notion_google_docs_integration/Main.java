package Notion_google_docs_integration;

import Notion_google_docs_integration.API_objects.NotionAPI;
import Notion_google_docs_integration.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext springContextMain = SpringApplication.run(Main.class, args);
        NotionAPI notionAPI = springContextMain.getBean(NotionAPI.class);
        notionAPI.POSTQueryDatabase();

    }
}
