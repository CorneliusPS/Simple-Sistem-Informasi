package Tubes;

public class Course {
    private String nameCourse;
    private String idCourse;
    private String description;
    
    public Course(String nameCourse, String idCourse, String description ){
        this.nameCourse = nameCourse;
        this.idCourse = idCourse;
        this.description = description;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public String getDescription() {
        return description;
    }
}
