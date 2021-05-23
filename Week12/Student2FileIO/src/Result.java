public class Result {
    private String subject;
    private double sumScore;
    private int count;

    public Result(String subject, double sumScore, int count) {
        this.subject = subject;
        this.sumScore = sumScore;
        this.count = count;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getSumScore() {
        return sumScore;
    }

    public void setSumScore(double sumScore) {
        this.sumScore = sumScore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double averageScore() {
        return sumScore / count;
    }

    @Override
    public String toString() {
        return subject + "\t" + String.format("%.2f", averageScore());
    }
}
