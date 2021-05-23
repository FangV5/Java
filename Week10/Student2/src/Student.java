import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private String gender;
    private ArrayList<Score> scoreList;

    public Student(String id, String name, String gender, ArrayList<Score> scoreList) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.scoreList = scoreList;
    }

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        ArrayList<Score> scoreList = new ArrayList<Score>();
        this.scoreList = scoreList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public void addScore(Score score) {
        scoreList.add(score);
    }

    public Double averageScore() {
        Double sum = 0.0;
        for (Score score : scoreList) {
            sum += score.getScore();
        }
        return sum / scoreList.size();
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + gender + "\t" + String.format("%.2f", averageScore());
    }
}
