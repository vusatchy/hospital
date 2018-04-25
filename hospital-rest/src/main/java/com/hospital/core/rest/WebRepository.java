package com.hospital.core.rest;

import com.google.common.collect.Lists;
import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;

import com.hospital.core.respository.MeetingRepository;
import com.hospital.core.respository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRepository {

    @Autowired
    private UserRepository repository;

    @Autowired
    private MeetingRepository meetingReository;

    @RequestMapping("/users")
    public String findAll() {
        StringBuilder res = new StringBuilder();
        List<User> users = Lists.newArrayList(repository.findAll());
        for (User user : users) {
            res.append(user).append("\n");
        }
        return res.toString();
    }

    @RequestMapping("/meetings")
    public String findAllMeetings() {
        StringBuilder res = new StringBuilder();
        List<Meeting> meetings = Lists.newArrayList(meetingReository.findAll());
        for (Meeting user : meetings) {
            res.append(user).append("\n");
        }
        return res.toString();
    }

}