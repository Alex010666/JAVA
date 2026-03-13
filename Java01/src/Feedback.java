public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyzeFeedback(boolean isConcatenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isConcatenation) {
            this.completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            StringBuilder sb = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5);
            this.completeFeedback = sb.toString();
        }
        this.reviewID = createReviewID(this.firstName, this.lastName, this.completeFeedback);
        this.longFeedback = checkFeedbackLength(this.completeFeedback);
    }

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5){
        String concatenatedFeedback = sent1+ sent2+ sent3+ sent4+ sent5;
        return concatenatedFeedback;
    }

    private StringBuilder feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5){
        StringBuilder sb = new StringBuilder();
        sb.append(sent1);
        sb.append(sent2);
        sb.append(sent3);
        sb.append(sent4);
        sb.append(sent5);
        return sb;
    }

    private boolean checkFeedbackLength(String completeFeedback){
        this.longFeedback = completeFeedback.length() > 500;
        return this.longFeedback;
    }

    private String createReviewID(String firstName, String lastName, String completeFeedback){
        String nameSub = (firstName + lastName).substring(2,6).toUpperCase();
        String feedbackSub = completeFeedback.substring(10,15).toLowerCase();
        String len = completeFeedback.length() + "_";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String ID = nameSub + feedbackSub + len + timestamp;
        ID = ID.replace(" ","");
        return ID;
    }

    public String toString(){
        return "Feedback{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", completeFeedback='" + completeFeedback + '\'' +
                ", longFeedback=" + longFeedback +
                ", reviewID='" + reviewID + '\'' +
                '}';
    }

}