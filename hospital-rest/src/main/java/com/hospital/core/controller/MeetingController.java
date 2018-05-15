package com.hospital.core.controller;

import com.hospital.core.model.Meeting;
import com.hospital.core.service.MeetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public List<Meeting> findByDoctor(@RequestParam(name = "id") long doctorId) {
	return meetingService.findMeetingByDoctor(doctorId);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public List<Meeting> findByUser(@RequestParam(name = "id") long userId) {
	return meetingService.findMeetingByUser(userId);
    }

    @PostMapping
    public Meeting saveMeeting(@RequestParam(name = "patient_id") long patientId,
	@RequestParam(name = "doctor_id") long doctorId,
	@RequestParam(name = "usage") String usage) {
	return meetingService.addMeeting(doctorId, patientId, usage);
    }

    @DeleteMapping
    public void delete(@RequestParam(name = "id") long id) {
	meetingService.deleteMeeting(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Meeting> all() {
	return meetingService.getAllMeeting();
    }


}
