package com.hospital.core.respository;

import com.hospital.core.model.Meeting;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface MeetingRepository extends CrudRepository<Meeting, Long> {

    List<Meeting> findByDoctorId(long doctorId);

    List<Meeting> findByPatientId(long patientId);
}
