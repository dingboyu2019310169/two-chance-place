package School;
import java.util.ArrayList;
import java.util.List;
public class Course {
    private int id;//编号
    private String name;//课程名
    private String classroom;//授课地点
    private String Time;//时间
    private Teacher teacher;//授课教师
    private List<Student> selectedStudents;//选课学生
    private int maxStudents = 30;//最大选课人数
    public Course(int id, String name, String classroom, String Time, Teacher teacher, int maxStudents) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
        this.Time = Time;
        this.teacher = teacher;
        teacher.setCourse(this);
        this.maxStudents = maxStudents;
        this.selectedStudents = new ArrayList<>();
    }

    public int getId()
    { return id; }
    public void setId(int id)
    { this.id = id; }


    public String getName()
    { return name; }
    public void setName(String name)
    { this.name = name; }


    public String getClassroom()
    { return classroom; }
    public void setClassroom(String classroom)
    { this.classroom = classroom; }


    public String getTime()
    { return Time; }
    public void setCourseTime(String Time)
    { this.Time = Time; }


    public Teacher getTeacher()
    { return teacher; }
    public void setTeacher(Teacher teacher)
    { this.teacher = teacher; }


    public void addStudent(Student stu)
    { selectedStudents.add(stu); }//学生选课


    public void removeStudent(Student stu)
    { selectedStudents.remove(stu); }//学生退课


    public boolean studentInList(Student stu)
    { return selectedStudents.contains(stu); }//判定学生是否退课


    public List<Student> getSelectedStudents()
    { return selectedStudents; }//获取学生数量


    public int getSelectedStudentCount()
    { return selectedStudents.size(); }//获取选课学生数量


    public int getMaxStudents()
    { return maxStudents; }//获取选课学生上限
    public void setMaxStudents(int maxStudents)
    { this.maxStudents = maxStudents; }


    public boolean hasSpace()
    { return selectedStudents.size() < maxStudents; }//判定选课数是否到达最大容量

    public String getStudentNames() {
        StringBuilder names = new StringBuilder();
        for (Student s : selectedStudents) {
            names.append(s).append(", ");
        }
        return names.toString();
    }
    public String toString() {
        int studentsCount = selectedStudents.size();
        return "课程信息 {" +
                "\n\t课程编号=" + id +
                "\n\t课程名称='" + name + '\'' +
                "\n\t所在教室='" + classroom + '\'' +
                "\n\t上课时间='" + Time + '\'' +
                "\n\t授课教师=" + teacher +
                "\n\t选课学生=(" + studentsCount + ")" + (studentsCount > 0 ? "=>" + getStudentNames() : "") +
                "\n\t人数上限=" + maxStudents +
                "\n}\n";
    }
}