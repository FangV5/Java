import java.util.Scanner;

public class ProjectDriver {

	public static void main(String[] args) {
		// ������ص���Ϣ
		Scanner scan = new Scanner(System.in);
		System.out.println("��������Ŀ����");
		String projectName = scan.next();

		System.out.println("��������ĿԤ��");
		double budget = scan.nextDouble();

		System.out.println("��������ĿԱ��1������");
		String emp1Name = scan.next();
		System.out.println("��������ĿԱ��1���ţ�");
		String emp1Department = scan.next();
		System.out.println("��������ĿԱ��1��н��");
		double baseSalary1 = scan.nextDouble();

		System.out.println("��������ĿԱ��2������");
		String emp2Name = scan.next();
		System.out.println("��������ĿԱ��2���ţ�");
		String emp2Department = scan.next();
		System.out.println("��������ĿԱ��2��н��");
		double baseSalary2 = scan.nextDouble();

		Employee emp1 = new Employee(emp1Department, emp1Name, baseSalary1);
		Employee emp2 = new Employee(emp2Department, emp2Name, baseSalary2);

		Project project = new Project(projectName, budget, emp1, emp2);
		project.updateBudget();

		System.out.println("��Ԥ��Ϊ=" + project.getBudget());

		String msg = project.toString();
		System.out.println(msg);

	}

}
