package com.hospital.core.service;

import com.hospital.core.model.Meeting;
import com.hospital.core.model.User;
import com.hospital.soap.client.Medicine;
import java.util.List;


public interface MeetingService {

     void updateMeeting(Meeting meeting);

     void deleteMeeing(Meeting meeting);

     List<Meeting> findeMeetingByDoctor(User doctor);

     List<Meeting> findMeetingByUser(User patient);

     void addMeeting(User doctor, User patient, Medicine medicine);

}
