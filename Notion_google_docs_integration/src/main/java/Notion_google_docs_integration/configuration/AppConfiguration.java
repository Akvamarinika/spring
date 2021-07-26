package Notion_google_docs_integration.configuration;

import Notion_google_docs_integration.API_objects.Google.GoogleAPI;
import Notion_google_docs_integration.API_objects.Google.GoogleFilesManager;
import Notion_google_docs_integration.API_objects.NotionAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean
    public NotionAPI notionAPIBean(){
        return new NotionAPI();
    }

    @Bean
    public GoogleAPI googleAPIBean(){
        return new GoogleAPI();
    }

    @Bean
    public GoogleFilesManager googleFilesManagerBean(){
        return new GoogleFilesManager(googleAPIBean());
    }
}
