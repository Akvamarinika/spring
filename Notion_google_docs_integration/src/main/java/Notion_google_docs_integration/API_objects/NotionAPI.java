package Notion_google_docs_integration.API_objects;
import Notion_google_docs_integration.API_objects.json_notion_obj.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


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
        Data data = restTemplate.postForObject(urlQueryDB, entity, Data.class);
        assert data != null;
        System.out.println(data.getResults().get(0).getProperties().getName().getTitles().get(0).getPlainText());


    }

}
