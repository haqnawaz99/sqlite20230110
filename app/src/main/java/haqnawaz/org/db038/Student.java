package haqnawaz.org.db038;

public class Student {
    private String name;
    private String rollNo;
    private boolean isEnroll;

    public Student(String name, String rollNo, boolean isEnroll) {
        this.name = name;
        this.rollNo = rollNo;
        this.isEnroll = isEnroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public boolean isEnroll() {
        return isEnroll;
    }

    public void setEnroll(boolean enroll) {
        isEnroll = enroll;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", isEnroll=" + isEnroll + "]";
    }

}
