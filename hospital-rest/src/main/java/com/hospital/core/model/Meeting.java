package com.hospital.core.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meetings")
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private User doctor;

    @OneToOne
    @JoinColumn(name="patient_id")
    private User patient;

    @Column(name = "id_of_medicine")
    private int medicineId;

    @Column(name = "meeting_time")
    private Timestamp timestamp;

    public Meeting(long id, User doctor, User patient, int medicineId, Timestamp timestamp) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medicineId = medicineId;
        this.timestamp = timestamp;
    }

    public Meeting() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Meeting meeting = (Meeting) o;

        if (id != meeting.id) {
            return false;
        }
        if (medicineId != meeting.medicineId) {
            return false;
        }
        if (doctor != null ? !doctor.equals(meeting.doctor) : meeting.doctor != null) {
            return false;
        }
        if (patient != null ? !patient.equals(meeting.patient) : meeting.patient != null) {
            return false;
        }
        return timestamp != null ? timestamp.equals(meeting.timestamp) : meeting.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + medicineId;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Meeting{");
        sb.append("id=").append(id);
        sb.append(", doctor=").append(doctor.getId());
        sb.append(", patient=").append(patient.getId());
        sb.append(", medicineId=").append(medicineId);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
