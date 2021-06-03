import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties ( ignoreUnknown  =  true )
public class DocumentsWrapper {
    private List<Documents> documentsList =  new ArrayList<>();

    public List<Documents> getDocuments() {
        return documentsList;
    }

    public void setDocuments(List<Documents> documents) {
        this.documentsList = documents;
    }
}
