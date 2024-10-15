package com.example.groups_app.repository;

import com.example.groups_app.model.Group;
import com.example.groups_app.model.GroupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("""
            SELECT new com.example.groups_app.model.GroupDTO(g.id, g.groupName, COUNT(s))
            FROM Group g
            LEFT JOIN g.students s
            GROUP BY g.id, g.groupName
            ORDER BY g.creationTime DESC
            """)
    List<GroupDTO> findAllGroups();

}


