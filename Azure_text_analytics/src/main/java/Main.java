
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
import java.util.Comparator;
import java.util.List;


public class Main {
    private static final String URL_FOR_APIRequest = "https://westeurope.api.cognitive.microsoft.com/text/analytics/v3.0/sentiment";
    private static HttpClient httpclient = null;
    private static HttpPost request = new HttpPost(URL_FOR_APIRequest);
    private static String textUser = "Hello world. This is some input text that I love. It's incredibly sunny outside! I'm so happy. Pike place market is my favorite Seattle attraction.She had not been working all day so she was energetic. He had not been reading a book. I had not been cooking any meal when she came to my home. You have not been smoking.";
    private static final String KEY = "e48c3577fb7e4dd8bf0b39035c345244";
    private static String JSON_CONTENT = "{\"documents\":[{\"language\": \"en\", \"id\": \"1\", \"text\": \"" +
            textUser +
            "\"}]}";
    private static List<Sentences> sentences = new ArrayList<>();

    public static void main(String[] args) {
        try {
            APIRequest();
            String json = getResponse();
            System.out.println(json);
            parseJSON(json);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }


    }

    public static void APIRequest() throws URISyntaxException, IOException {
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

    public static void parseJSON(String jsonArray) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DocumentsWrapper documentsWrappers = mapper.readValue(jsonArray, DocumentsWrapper.class);
        documentsWrappers.getDocuments().forEach(documents -> System.out.println(documents.getSentences()));
    //    documentsWrappers.getDocuments()
      //          .forEach(documents -> documents.getSentences().sort(Comparator.comparingDouble((sentences) -> sentences.getConfidenceScores().getNegative())));
        documentsWrappers.getDocuments()
                .forEach(
                        doc -> doc.getSentences()
                                .sort(Sentences::compareTo));




       /* documentsWrappers.getDocuments()
                .forEach(
                        doc -> doc.getSentences()
                                .sort((s1, s2) -> s1.getConfidenceScores().compareTo(s2.getConfidenceScores())));*/


       /* for (Documents doc : documentsWrappers.getDocuments()){
           for (Sentences s : doc.getSentences()){
               s.getConfidenceScores().sort(Comparator.comparingDouble(conf -> conf.getNegative()));
           }
        }*/
       // System.out.println(documentsWrappers.getDocuments());
       documentsWrappers.getDocuments().forEach(documents -> documents.getSentences().forEach(sentences1 -> System.out.println(sentences1.getText())));
        documentsWrappers.getDocuments().forEach(documents -> System.out.println(documents.getSentences()));


    }
}
