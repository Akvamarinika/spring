
public class Sentences implements Comparable<Sentences> {
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

    @Override
    public int compareTo(Sentences o2) {
        if (sentiment.equals(o2.sentiment)) return confidenceScores.myCompareTo(o2.confidenceScores, sentiment);
        if (sentiment.equals("negative") && o2.sentiment.equals("neutral")) return -1;
        if (sentiment.equals("negative") && o2.sentiment.equals("positive")) return -1;
        if (sentiment.equals("neutral") && o2.sentiment.equals("negative")) return 1;
        if (sentiment.equals("neutral") && o2.sentiment.equals("positive")) return -1;
        if (sentiment.equals("positive") && o2.sentiment.equals("negative")) return 1;
        if (sentiment.equals("positive") && o2.sentiment.equals("neutral")) return 1;
        return 0;
    }
}
