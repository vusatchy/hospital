package com.hospital.core.rest;

import com.google.common.collect.Lists;
import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import com.hospital.core.respository.MeetingReository;
import com.hospital.core.respository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRepository {

    @Autowired
    UserRepository repository;

    @Autowired
    MeetingReository meetingReository;

    @RequestMapping("/users")
    public List<User> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @RequestMapping("/meetings")
    public List<Meeting> findAllMeetings() {
        return Lists.newArrayList(meetingReository.findAll());
    }

}