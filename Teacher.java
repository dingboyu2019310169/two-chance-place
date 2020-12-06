package School;
public class Teacher extends Member{
    private Course course;
    public Teacher(int id, String name, String sex, Course course) {
        super(id, name, sex);
        this.course = course;
    }

    public Teacher(int id, String name, String gender) {
        super(id, name, gender);
    }

    public Course getCourse()
    { return course; }

    public void setCourse(Course course)
    { this.course = course; }

    public String toString() {
        return getName();
    }

}