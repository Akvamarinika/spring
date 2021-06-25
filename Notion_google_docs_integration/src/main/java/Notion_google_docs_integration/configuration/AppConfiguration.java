package Notion_google_docs_integration.configuration;

import Notion_google_docs_integration.API_objects.GoogleAPI;
import Notion_google_docs_integration.API_objects.NotionAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Bean
    public NotionAPI notionBean(){
        return new NotionAPI();
    }

    @Bean
    public GoogleAPI googleBean(){
        return new GoogleAPI();
    }
}
