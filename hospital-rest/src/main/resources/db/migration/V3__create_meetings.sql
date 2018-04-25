CREATE TABLE meetings (
	id BIGSERIAL ,
	doctor_id BIGINT,
	patient_id BIGINT,
	id_of_medicine INT,
	meeting_time TIMESTAMP,
	FOREIGN KEY (doctor_id) REFERENCES users(id),
	FOREIGN KEY (patient_id) REFERENCES users(id),
	PRIMARY KEY (id)
)
