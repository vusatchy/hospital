package com.hospital.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private User doctor;

    @OneToOne
    @JoinColumn(name="patient_id")
    private User patient;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "meeting_time")
    private LocalDate timestamp;

    public Meeting(long id, User doctor, User patient, String medicineId, LocalDate timestamp) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medicine = medicineId;
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

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
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
        if (doctor != null ? !doctor.equals(meeting.doctor) : meeting.doctor != null) {
            return false;
        }
        if (patient != null ? !patient.equals(meeting.patient) : meeting.patient != null) {
            return false;
        }
        if (medicine != null ? !medicine.equals(meeting.medicine) : meeting.medicine != null) {
            return false;
        }
        return timestamp != null ? timestamp.equals(meeting.timestamp) : meeting.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (medicine != null ? medicine.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Meeting{");
        sb.append("id=").append(id);
        sb.append(", doctor=").append(doctor.getId());
        sb.append(", patient=").append(patient.getId());
        sb.append(", medicine=").append(medicine);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
