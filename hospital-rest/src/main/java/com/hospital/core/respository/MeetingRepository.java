package com.hospital.core.respository;

import com.hospital.core.model.Meeting;
import org.springframework.data.repository.CrudRepository;



public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}
