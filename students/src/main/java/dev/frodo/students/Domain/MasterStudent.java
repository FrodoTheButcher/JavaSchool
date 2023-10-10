package dev.frodo.students.Domain;

import org.springframework.data.mongodb.core.mapping.Document;

import dev.frodo.students.DataAbstraction.IMasterStudent;

@Document(collection = "MasterStudentCollection")
public class MasterStudent extends Student implements IMasterStudent {

    public MasterStudent()
    {
        
    }

    public MasterStudent(String id, String name, int age, String gender, String email) {
        super(id, name, age, gender, email);
    }

    private String GraduatedUniversityName;
    private double GraduationNote;
    private String teacherSupervisorId = ""; // Updated property name

    public String getGraduatedUniversityName() {
        return GraduatedUniversityName;
    }

    public void setGraduatedUniversityName(String graduatedUniversityName) {
        this.GraduatedUniversityName = graduatedUniversityName;
    }

    public double getGraduationNote() {
        return GraduationNote;
    }

    @Override
    public void setGraduationNote(double graduationNote) {
        this.GraduationNote = graduationNote;
    }

    public String getTeacherSupervisorId() { // Updated getter method name
        return teacherSupervisorId;
    }
    @Override
    public void setTeacherSupervisorId(String teacherSupervisorId) { // Updated setter method name
        this.teacherSupervisorId = teacherSupervisorId;
    }
}
