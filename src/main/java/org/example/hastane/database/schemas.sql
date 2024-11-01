CREATE TABLE IF NOT EXISTS doctors (
    tc  VARCHAR(11) NOT NULL UNIQUE PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS patients (
    tc  VARCHAR(11) NOT NULL UNIQUE PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    cinsiyet VARCHAR(1) NOT NULL,
    dogum_tarihi DATE NOT NULL,
    telefon VARCHAR(11) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS appointments (
    doctor_tc  VARCHAR(11) REFERENCES doctors(tc),
    patient_tc VARCHAR(11) REFERENCES patients(tc),
    appointment_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (doctor_tc, patient_tc)
    );

CREATE TABLE IF NOT EXISTS prescriptions (
    doctor_tc VARCHAR(11) REFERENCES doctors(tc),
    patient_tc VARCHAR(11) REFERENCES patients(tc),
    prescription TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (doctor_tc, patient_tc)
    );