package com.hospital.core.impl;

import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import com.hospital.core.respository.MeetingRepository;
import com.hospital.core.service.MedicineService;
import com.hospital.core.service.MeetingService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImp implements MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private MedicineService medicineService;


    @Override
    public void updateMeeting(Meeting meeting) {
	meetingRepository.save(meeting);
    }

    @Override
    public void deleteMeeting(long id) {
	meetingRepository.deleteById(id);
    }

    @Override
    public List<Meeting> findMeetingByDoctor(long doctor) {
	return meetingRepository.findByDoctorId(doctor);
    }

    @Override
    public List<Meeting> findMeetingByUser(long patientId) {
	return meetingRepository.findByPatientId(patientId);
    }

    @Override
    public Meeting addMeeting(long doctorId, long patientId, String medicineUsage) {
	User patient = new User();
	User doctor = new User();
	patient.setId(patientId);
	doctor.setId(doctorId);
	Meeting meeting = new Meeting();
	meeting.setDoctor(doctor);
	meeting.setPatient(patient);
	meeting.setMedicine(medicineService.getMedicinesByUsage(medicineUsage).get(0).getName());
	meeting.setTimestamp(LocalDate.now());
	return meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> getAllMeeting() {
	List<Meeting> meetings = new ArrayList<>();
	meetingRepository.findAll().forEach(meetings::add);
	return meetings;
    }


}
