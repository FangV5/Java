public class Enrolment {
    Student list[];
    Subject subject;
    int count;

    public Enrolment(int max, String name, String id) {
        list = new Student[max];
        count = 0;
        this.subject = new Subject(name, id, max);
    }

    public boolean add(Student student) {
        if (student == null || list.length <= count)
            return false;
        list[count++] = student;
        return true;
    }

    public boolean remove(int index) {
        if (index >= count || index < 0) {
            return false;
        }
        list[index] = null;
        count--;
        if (index == count - 1 || count == 0) {
            return true;
        }
        for (int i = index; i < count; i++) {
            list[index] = list[index + 1];
        }
        return true;
    }

    public int indexOf(String id) {
        for (int i = 0; i < list.length && list[i] != null; i++) {
            if (list[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Student get(int index) {
        return list[index];
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String msg = subject.toString() + "\n";
        msg += "选课人数：" + count + "\n";
        msg += "学号 姓名" + "\n";
        for (int i = 0; i < list.length && list[i] != null; i++) {
            msg += list[i].toString() + "\n";
        }
        return msg;
    }
}
