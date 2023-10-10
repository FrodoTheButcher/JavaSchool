package dev.frodo.students.Application.TeacherApplication;

public class UpdateRelationRequest {
    private String masterStudentId;
    private String teacherId;

    public void setMasterStudentId(String masterStudentId )
    {
        this.masterStudentId = masterStudentId;
    }
    public void setTeacherId(String teacherId)
    {
        this.teacherId=teacherId;
    }

    public String getMasterStudentId()
    {
        return this.masterStudentId;
    }

    public String getTeacherID()
    {
        return this.teacherId;
    }
}
