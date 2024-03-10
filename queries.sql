CREATE TABLE patients (
    patient_id INT,
    first_name TEXT,
    last_name TEXT,
    gender CHAR(1),
    birth_date DATE,
    city TEXT,
    province_id CHAR(2),
    allergies TEXT,
    height INT,
    weight INT
);

INSERT INTO patients (patient_id, first_name, last_name, gender, birth_date, city, province_id, allergies, height, weight)
VALUES
    (1, 'John', 'Doe', 'M', '1990-05-15', 'New York', 'NY', 'Peanuts', 180, 75),
    (2, 'Jane', 'Smith', 'F', '1988-12-28', 'Los Angeles', 'CA', NULL, 165, 60),
    (3, 'Michael', 'Johnson', 'M', '1975-09-20', 'Chicago', 'IL', 'Shellfish, Penicillin', 175, 80),
    (4, 'Emily', 'Brown', 'F', '2000-02-10', 'Houston', 'TX', 'None', 160, 55),
    (5, 'David', 'Lee', 'M', '1995-11-30', 'Miami', 'FL', 'None', 170, 70);

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    specialty TEXT
);

INSERT INTO doctors (doctor_id, first_name, last_name, specialty)
VALUES
    (1, 'Sarah', 'Johnson', 'Cardiology'),
    (2, 'Michael', 'Smith', 'Pediatrics'),
    (3, 'Emily', 'Brown', 'Dermatology'),
    (4, 'David', 'Lee', 'Orthopedics'),
    (5, 'Jessica', 'Wang', 'Neurology');

CREATE TABLE admissions (
    patient_id INT PRIMARY KEY,
    admission_date DATE NOT NULL,
    discharge_date DATE,
    diagnosis TEXT,
    attending_doctor_id INT REFERENCES doctors(doctor_id)
);

INSERT INTO admissions (patient_id, admission_date, discharge_date, diagnosis, attending_doctor_id)
VALUES
    (1, '2023-05-10', '2023-05-15', 'Hypertension', 1),
    (2, '2023-08-20', '2023-08-25', 'Influenza', 2),
    (3, '2023-07-05', '2023-07-10', 'Pneumonia', 1),
    (4, '2023-09-12', '2023-09-18', 'Fractured arm', 4),
    (5, '2023-06-30', '2023-07-05', 'Migraine', 5);

CREATE TABLE province_names (
    province_id CHAR(2) PRIMARY KEY,
    province_name TEXT NOT NULL
);

INSERT INTO province_names (province_id, province_name)
VALUES
    ('AB', 'Alberta'),
    ('BC', 'British Columbia'),
    ('MB', 'Manitoba'),
    ('NB', 'New Brunswick'),
    ('NL', 'Newfoundland and Labrador');
