public class Subject {
    private String name;
    private String id;
    private int maxStudent;

    public Subject(String name, String id, int maxStudent) {
        this.name = name;
        this.id = id;
        this.maxStudent = maxStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    @Override
    public String toString() {
        return "课程ID：" + id + "  最大学生数：" + maxStudent + "  课程名称：" + name;
    }

}
