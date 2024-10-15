package com.example.groups_app.controller;

import com.example.groups_app.model.Group;
import com.example.groups_app.model.GroupDTO;
import com.example.groups_app.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public String getGroups(Model model) {
        List<GroupDTO> groups = groupRepository.findAllGroups();
        model.addAttribute("groups", groups);
        return "group/list";
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addGroup(@RequestParam String groupName) {
        Group group = new Group();
        group.setGroupName(groupName);
        group.setCreationTime(LocalDateTime.now());
        groupRepository.save(group);
        return ResponseEntity.ok(group.getId());
    }
}
