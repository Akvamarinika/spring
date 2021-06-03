import java.util.ArrayList;
import java.util.List;

public class SentencesWrapper {
    private List<Sentences> sentencesList =  new ArrayList<>();

    public List<Sentences> getSentencesList() {
        return sentencesList;
    }

    public void setSentencesList(List<Sentences> sentencesList) {
        this.sentencesList = sentencesList;
    }
}
