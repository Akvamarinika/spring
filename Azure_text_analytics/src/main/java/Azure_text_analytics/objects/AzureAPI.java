package Azure_text_analytics.objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AzureAPI {
    private static final String URL_FOR_APIRequest = "https://westeurope.api.cognitive.microsoft.com/text/analytics/v3.0/sentiment";
    private static HttpClient httpclient = null;
    private static HttpPost request = new HttpPost(URL_FOR_APIRequest);
    private static String textUser;
    private static final String KEY = "e48c3577fb7e4dd8bf0b39035c345244";
    private static String textWithTag;

    public static String getTextWithTag() {
        return textWithTag;
    }

    public static void setTextWithTag(DocumentsWrapper documentsWrapper) {
        StringBuilder builder = new StringBuilder();
        documentsWrapper.getDocuments().forEach(documents -> documents.getSentences().forEach(sentences1 -> builder.append(sentences1.addTagSentence())));
        AzureAPI.textWithTag = builder.toString();
    }

    public static void setTextUser(String textUser) {
        AzureAPI.textUser = textUser;
    }

    public static void APIRequest() throws URISyntaxException, IOException {
        String JSON_CONTENT = "{\"documents\":[{\"language\": \"en\", \"id\": \"1\", \"text\": \"" + textUser + "\"}]}";
        httpclient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(URL_FOR_APIRequest);
        //  builder.setParameter("model-version", "{string}");
        //  builder.setParameter("showStats", "{boolean}");
        URI uri = builder.build();
        request = new HttpPost(uri);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", KEY);

        // Request body
        StringEntity reqEntity = new StringEntity(JSON_CONTENT);
        request.setEntity(reqEntity);
    }

    public static String getResponse() throws IOException {
        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            return EntityUtils.toString(entity);
        }
        return null;
    }

    public static DocumentsWrapper parseJSON(String jsonArray) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonArray, DocumentsWrapper.class);
    }

    public static void printInfo(DocumentsWrapper documentsWrapper){
        documentsWrapper.getDocuments().forEach(documents -> documents.getSentences().forEach(sentences1 -> System.out.println(sentences1.getText())));

    }

    public static void sortSentences(DocumentsWrapper documentsWrapper){
        //documentsWrapper.getDocuments().forEach(documents -> System.out.println(documents.getSentences()));

        documentsWrapper.getDocuments()
                .forEach(
                        doc -> doc.getSentences()
                                .sort(Sentences::compareTo));

        //documentsWrapper.getDocuments().forEach(documents -> System.out.println(documents.getSentences()));

    }

}
