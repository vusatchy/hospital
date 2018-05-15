package com.hospital.core.controller;

import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import com.hospital.core.service.MeetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping(value = "/meeting/doctor", method = RequestMethod.GET)
    public List<Meeting> findByDoctor(@RequestParam(name = "id") long doctorId) {
	User user = new User();
	user.setId(doctorId);
	return meetingService.findMeetingByDoctor(user);
    }

    @RequestMapping(value = "/meeting/patient", method = RequestMethod.GET)
    public List<Meeting> findByUser(@RequestParam(name = "id") long userId) {
	User user = new User();
	user.setId(userId);
	return meetingService.findMeetingByUser(user);
    }

    @RequestMapping(value = "/meeting", method = RequestMethod.POST)
    public Meeting saveMeeting(@RequestParam(name = "patient_id") long patient_id,
	@RequestParam(name = "doctor_id") long doctor_id,
	@RequestParam(name = "usage") String usage) {

	User patient = new User();
	User doctor = new User();
	patient.setId(patient_id);
	doctor.setId(doctor_id);
	return meetingService.addMeeting(doctor, patient, usage);
    }

    @RequestMapping(value = "/meeting", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id") long id) {
	Meeting meeting = new Meeting();
	meeting.setId(id);
	meetingService.deleteMeeting(meeting);
    }

    @RequestMapping(value = "/meetings", method = RequestMethod.GET)
    public List<Meeting> all() {
	return meetingService.getAllMeeting();
    }


}
