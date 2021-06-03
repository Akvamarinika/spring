import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;
import java.util.List;

@JsonIgnoreProperties ( ignoreUnknown  =  true )
public class Documents {
    private String id;
    private String sentiment;
    private ConfidenceScores confidenceScores;
    private List<Sentences> sentences;
    private String offset;
    private String length;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public ConfidenceScores getConfidenceScores() {
        return confidenceScores;
    }

    public void setConfidenceScores(ConfidenceScores confidenceScores) {
        this.confidenceScores = confidenceScores;
    }

    public List<Sentences> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentences> sentences) {
        this.sentences = sentences;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
