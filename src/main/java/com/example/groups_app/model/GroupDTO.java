package com.example.groups_app.model;

public class GroupDTO {
    private Long id;
    private String groupName;
    private long studentCount;

    public GroupDTO(Long id, String groupName, long studentCount) {
        this.id = id;
        this.groupName = groupName;
        this.studentCount = studentCount;
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public long getStudentCount() {
        return studentCount;
    }
}