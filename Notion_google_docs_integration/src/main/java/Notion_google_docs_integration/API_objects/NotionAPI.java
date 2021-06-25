package Notion_google_docs_integration.API_objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component("notionAPIBean")
public class NotionAPI {
    @Value("${notionAPI.token}")
    private String token;

    @Value("${notionAPI.QueryDB}")
    private String urlQueryDB;

    @Value("${notionAPI.dataBaseId}")
    private String dataBaseId;

    private static HttpHeaders headers;
    private static RestTemplate restTemplate;
    private static HttpEntity<String> entity;

    static {
        headers = new HttpHeaders();
        restTemplate = new RestTemplate();
    }



    public void POSTQueryDatabase(){
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        headers.add("Notion-Version", "2021-05-13");
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<>(headers);
        Test test = restTemplate.postForObject("https://api.notion.com/v1/databases/4cfb4c09a07449b39a8edbaa68fa8c59/query", entity, Test.class);
        System.out.println(test.getObject());


    }

}
