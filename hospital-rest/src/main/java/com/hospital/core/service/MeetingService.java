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


    public List<Meeting> findeMeetingByDoctor(User doctor){

    }

    public List<Meeting> findMeetingByUser(User patient){

    }

    public void addMeeting(User doctor, User patient, Medicine medicine){
        Meeting meeting = new Meeting();
        meeting.setDoctor(doctor);
        meeting.setPatient(patient);
        meeting.setMedicineId(medicine.getId());
        meeting.setTimestamp(LocalDate.now());
        meetingRepository.save(meeting);
    }

}
