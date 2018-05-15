package com.hospital.core.service;

import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import java.util.List;


public interface MeetingService {

    void updateMeeting(Meeting meeting);

    void deleteMeeting(Meeting meeting);

    List<Meeting> findMeetingByDoctor(User doctor);

    List<Meeting> findMeetingByUser(User patient);

    Meeting addMeeting(User doctor, User patient, String medicineUsage);

    List<Meeting> getAllMeeting();

}
