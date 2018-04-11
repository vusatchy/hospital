package com.hospital.core.respository;

import com.hospital.core.model.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface MeetingReository extends CrudRepository<Meeting, Long> {

}
