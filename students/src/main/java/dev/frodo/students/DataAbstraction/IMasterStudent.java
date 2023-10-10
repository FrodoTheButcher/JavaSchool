package dev.frodo.students.DataAbstraction;

public interface IMasterStudent {
    String getGraduatedUniversityName();
    void setGraduatedUniversityName(String graduatedUniversityName);

    double getGraduationNote();
    void setGraduationNote(double graduationNote);

    public String getTeacherSupervisorId();
        public void setTeacherSupervisorId(String teacherSupervisorId);
    }
