public class Sentences {
    private String sentiment;
    private ConfidenceScores confidenceScores;
    private String offset;
    private String length;
    private String text;

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
