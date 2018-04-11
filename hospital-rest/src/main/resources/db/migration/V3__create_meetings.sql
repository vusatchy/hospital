DROP TABLE IF EXISTS meetings;
CREATE TABLE if NOT EXISTS meetings (
	id INT,
	doctor_id INT,
	patient_id INT,
	id_of_medicine INT,
	meeting_time TIMESTAMP,
	FOREIGN KEY (doctor_id) REFERENCES users(id),
	FOREIGN KEY (patient_id) REFERENCES users(id),
	PRIMARY KEY (id)
)
