package com.hospital.core.impl;

import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import com.hospital.core.respository.MeetingRepository;
import com.hospital.core.service.MedicineService;
import com.hospital.core.service.MeetingService;
import com.hospital.soap.client.Medicine;
import java.time.LocalDate;
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
    public void deleteMeeing(Meeting meeting) {
	meetingRepository.deleteById(meeting.getId());
    }

    @Override
    public List<Meeting> findeMeetingByDoctor(User doctor) {
	return meetingRepository.findByDoctorId(doctor.getId());
    }

    @Override
    public List<Meeting> findMeetingByUser(User patient) {
	return meetingRepository.findByPatientId(patient.getId());
    }

    @Override
    public void addMeeting(User doctor, User patient, Medicine medicine) {
	Meeting meeting = new Meeting();
	meeting.setDoctor(doctor);
	meeting.setPatient(patient);
	meeting.setMedicine(medicine.getName());
	meeting.setTimestamp(LocalDate.now());
	meetingRepository.save(meeting);
    }
}
