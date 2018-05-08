package com.hospital.core.service;

import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import com.hospital.core.respository.MeetingRepository;
import com.hospital.soap.client.Medicine;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private MedicineService medicineService;


    public void updateMeeting(Meeting meeting) {
	meetingRepository.save(meeting);
    }

    public void deleteMeeing(Meeting meeting) {
	meetingRepository.deleteById(meeting.getId());
    }

    public List<Meeting> findeMeetingByDoctor(User doctor) {
	return meetingRepository.findByDoctorId(doctor.getId());
    }

    public List<Meeting> findMeetingByUser(User patient) {
	return meetingRepository.findByPatientId(patient.getId());
    }

    public void addMeeting(User doctor, User patient, Medicine medicine) {
	Meeting meeting = new Meeting();
	meeting.setDoctor(doctor);
	meeting.setPatient(patient);
	meeting.setMedicineId(medicine.getId());
	meeting.setTimestamp(LocalDate.now());
	meetingRepository.save(meeting);
    }

}
