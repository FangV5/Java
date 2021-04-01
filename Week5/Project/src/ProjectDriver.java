import java.util.Scanner;

public class ProjectDriver {

	public static void main(String[] args) {
		// 键盘相关的信息
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入项目名称");
		String projectName = scan.next();

		System.out.println("请输入项目预算");
		double budget = scan.nextDouble();

		System.out.println("请输入项目员工1姓名：");
		String emp1Name = scan.next();
		System.out.println("请输入项目员工1部门：");
		String emp1Department = scan.next();
		System.out.println("请输入项目员工1底薪：");
		double baseSalary1 = scan.nextDouble();

		System.out.println("请输入项目员工2姓名：");
		String emp2Name = scan.next();
		System.out.println("请输入项目员工2部门：");
		String emp2Department = scan.next();
		System.out.println("请输入项目员工2底薪：");
		double baseSalary2 = scan.nextDouble();

		Employee emp1 = new Employee(emp1Department, emp1Name, baseSalary1);
		Employee emp2 = new Employee(emp2Department, emp2Name, baseSalary2);

		Project project = new Project(projectName, budget, emp1, emp2);
		project.updateBudget();

		System.out.println("新预算为=" + project.getBudget());

		String msg = project.toString();
		System.out.println(msg);

	}

}
