# two-chance-place
第二次实验新建的代码仓库，只是从第一个代码仓库中修改位置
＃Java-



一、实验目的
初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；
掌握面向对象的类设计方法（属性、方法）；
掌握类的继承用法，通过构造方法实例化对象；
学会使用super()，用于实例化子类；
掌握使用Object根类的toString（）方法,应用在相关对象的信息输出中。




二、实验要求
说明： 学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。从简化系统考虑，每名教师仅教授一门课程，每门课程的授课教师也仅有一位，每名学生选仅选一门课程。
对象： 
人员（编号、姓名、性别）
教师（编号、姓名、性别、所授课程）
学生（编号、姓名、性别、所选课程）
课程（编号、课程名称、上课地点、时间、授课教师、最多选课人数、选课学生名单）



三、实验设计与核心代码
结构设计
1.课程类
2.成员类
3.教师类
4.学生类
5.主类
父类
public class Member{
    private int id;//编号
    private String name;//姓名
    private String sex; //性别
    public Member(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    
    
    
子类
public class Teacher extends Member{
    private Course course;
    public Teacher(int id, String name, String sex, Course course) {
        super(id, name, sex);
        this.course = course;
    }
    public Teacher(int id, String name, String gender) {
        super(id, name, gender);
    }
    
    
(其中父类使成员类，子类使教师类和学生类，子类继承父类的属性)



选课和退课设计
1.选课设计
当进行选课时，判断课程是否满员，如果满员则直接结束，选课失败。如果没有满员，那么继续判断。当学生选课超过一门时不能再选课，这时调用退课系统。
全部判断通过后，将学生对象放入目标课程选课名单中，并将课程对象放入学生对象的已选课程中，选课结束。
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
        
        
        
2.退课设计
当程序判定由学生选课超过一门时，直接退课。如果没有超过一门，那么无需退课，直接结束退课系统。
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
 
 
 
四、实验结果
见屏幕截图(70).png



五、实验感想
    这次综合实验教会了我如何用to string()输出信息，父类与子类的继承用法，以及选课时如何用方法判定人数是否满员，满员就调用退课；如果选课超过一门那么也调用退课。
这次实验真的很辛苦，但使我学习到了如何合理地构建类和对象的框架，使各个类之间满足关系，由于继承关系，因此我省去了定义全部属性，而是将一部分参数放入构造方法中。还有就是super（）继承父类的用法。总之这次实验我真的是收获颇丰！
