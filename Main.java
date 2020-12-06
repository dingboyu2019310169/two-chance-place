import School.Member;
import School.Teacher;
import School.Student;
import School.Course;
public class Main {
        public static void studentUnselectCourse(Student stu) {
            studentUnselectCourse(stu, false);
        }
        public static void studentUnselectCourse(Student stu, boolean forced) {
            System.out.print("学生 " + stu + " 执行退课...");
            if (forced || stu.hasSelectedCourse()) {
                Course c = stu.getSelectedCourse();
                if (c != null)
                    c.removeStudent(stu);
                stu.setSelectedCourse(null);
                System.out.println("退课成功！");
            } else {
                System.out.println("退课失败！");
            }
        }
        //学生退课方法

        public static void studentSelectCourse(Student stu, Course c) {
            System.out.print("学生 " + stu + " 执行选课 " + c.getName() + " ...");
            if (!c.hasSpace()) {
                System.out.println("选课失败！");
                return;
            }
            if (stu.hasSelectedCourse()) {
                System.out.println("已有课程，需要先退课");
                studentUnselectCourse(stu, true);
            }
            c.addStudent(stu);
            stu.setSelectedCourse(c);
            System.out.println("选课成功！");
        }
        //学生选课方法

        public static void main(String[] args) {
        Student s1 = new Student(1001, "张三", "男");
        Student s2 = new Student(1002, "李四", "男");
        Teacher t1 = new Teacher(2001, "张老师", "男");
        Teacher t2 = new Teacher(2001, "李老师", "女");
        Course c1 = new Course(101, "课程A", "#101", "09:55-11:15", t1, 30);
        Course c2 = new Course(101, "课程B", "#102", "09:55-11:15", t2, 30);
        studentSelectCourse(s1, c1);
        System.out.println(c1);
        System.out.println("============ ");
        studentSelectCourse(s2, c1);
        System.out.println(c1);
        System.out.println("============ ");
        studentSelectCourse(s2, c2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("=============");
        studentUnselectCourse(s1);
        System.out.println(c1);
    }
}
