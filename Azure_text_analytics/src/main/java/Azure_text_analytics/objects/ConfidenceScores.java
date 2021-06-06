package Azure_text_analytics.objects;

public class ConfidenceScores implements Comparable<ConfidenceScores> {
    private  Double positive;
    private  Double neutral;
    private  Double negative;

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    public Double getNegative() {
        return negative;
    }

    public void setNegative(Double negative) {
        this.negative = negative;
    }


    @Override
    public int compareTo(ConfidenceScores o1) {
        int result;
        result = Double.compare(negative, o1.negative);
        if (result != 0) return result;
        result = Double.compare(neutral, o1.neutral);
        if (result != 0) return result;
        result = Double.compare(positive, o1.positive);
        return result;
    }

    public int myCompareTo(ConfidenceScores o1, String sentiment) {
        switch (sentiment){
            case "negative":
                return Double.compare(negative, o1.negative);
            case "neutral":
                return Double.compare(neutral, o1.neutral);
            case "positive":
                return Double.compare(positive, o1.positive);

        }
        return 0;


    }
}
