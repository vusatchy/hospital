package com.hospital.core.service;

import com.hospital.core.model.Meeting;
import java.util.List;


public interface MeetingService {

    void updateMeeting(Meeting meeting);

    void deleteMeeting(long id);

    List<Meeting> findMeetingByDoctor(long doctorId);

    List<Meeting> findMeetingByUser(long patientId);

    Meeting addMeeting(long doctorId, long patientId, String medicineUsage);

    List<Meeting> getAllMeeting();

}
