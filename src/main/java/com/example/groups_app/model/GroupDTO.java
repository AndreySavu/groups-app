package com.example.groups_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupDTO {
    private Long id;
    private String groupName;
    private long studentCount;
}