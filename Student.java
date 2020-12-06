package School;
public class Student extends Member {
    private Course selectedCourse;
    public Student(int id, String name, String sex, Course selectedCourse) {
        super(id, name, sex);
        this.selectedCourse = selectedCourse;
    }//ID,姓名，性别，选课
    public Student(int id, String name, String sex) {
        super(id, name, sex);
    }//ID，姓名，性别

    public Course getSelectedCourse()
    { return selectedCourse; }

    public void setSelectedCourse(Course selectedCourse)
    { this.selectedCourse = selectedCourse; }

    public boolean hasSelectedCourse()
    { return this.selectedCourse != null; }//判定学生是否选课

    public String toString()
    { return getName(); }

}