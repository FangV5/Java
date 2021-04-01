import java.util.Scanner;

public class ClassListDriver {

	private static ClassList list = null;

	public static void main(String[] args) {
		int choose = menu();
		while (choose != 3) {
			switch (choose) {
			case 1:
				createList();
				break;
			case 2:
				printList();
				break;
			default:
				System.out.println("��Ч��ѡ��");
			}
			choose = menu();
		}
		System.out.println("��ӭ�´�ʹ�ã�");
	}

	public static int menu() {
		int choose = 0;
		System.out.println("========�γ̹���ϵͳ========");
		System.out.println("1.Create List");
		System.out.println("2.Print List");
		System.out.println("3.Exit");
		System.out.print("please choose(1-2):");
		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();

		return choose;
	}

	public static void createList() {
		Scanner scan = new Scanner(System.in);
		if (list != null) {
			System.out.print("�γ��Ѿ��������Ƿ����´���(y/n):");
			String again = scan.next();
			if (again.equalsIgnoreCase("n")) {
				return;
			}
		}

		System.out.print("������ѧ��:");
		int year = scan.nextInt();
		System.out.print("������ѧ��(1,2):");
		int semester = scan.nextInt();

		System.out.print("������γ̴���:");
		String subId = scan.next();
		System.out.print("������γ�����:");
		String subName = scan.next();
		Subject subj = new Subject(subId, subName);

		System.out.print("������ѧ��1ѧ��:");
		String s1Id = scan.next();
		System.out.print("������ѧ��1����:");
		String s1Name = scan.next();
		System.out.print("������ѧ��2ѧ��:");
		String s2Id = scan.next();
		System.out.print("������ѧ��2����:");
		String s2Name = scan.next();
		Student s1 = new Student(s1Name, s1Id);
		Student s2 = new Student(s2Name, s2Id);

		list = new ClassList(year, semester, subj, s1, s2);

	}

	public static void printList() {

		if (list == null) {
			System.out.println("����ִ�е�һ����");
			return;
		}

		System.out.println(list.toString());
	}

}
