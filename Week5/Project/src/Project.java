public class Project {
    private String projectName;
    private double budget;
    private Employee emp1;
    private Employee emp2;

    public Project() {

    }

    public Project(String projectName, double budget, Employee emp1, Employee emp2) {

        this.projectName = projectName;
        this.budget = budget;
        this.emp1 = emp1;
        this.emp2 = emp2;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void updateBudget() {
        // this.budget = this.budget *(1+0.2);
        this.setBudget(this.getBudget() * 1.2);
    }

    public String toString() {
        String info = "";
        info = "projectName=" + this.projectName;
        info = info + ",budget=" + this.budget;
        info += "\nemp1:\n";
        info += this.emp1.toString() + "\n";
        info += "emp2:\n";
        info += this.emp2.toString();
        return info;
    }

}
