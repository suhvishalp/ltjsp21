
create table patient(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(30),
phone varchar(30),
provider_name varchar(30),          //insurance provider
copay decimal(10,5)                 //
)

create table doctor(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(30),
speciality varchar(30)          //you can create a separate class and make it embeddable 
)

create table patients_doctors(
patient_id int,
doctor_id int,
FOREIGN KEY (patient_id)
REFERENCES patient(id),
FOREIGN KEY (doctor_id)
REFERENCES doctor(id)
)

create table appointment(
id int PRIMARY KEY AUTO_INCREMENT,
patient_id int,
doctor_id int,
appointment_time datetime,
started TINYINT(1),
ended TINYINT(1),
reason varchar(200),
FOREIGN KEY (patient_id)
REFERENCES patient(id),
FOREIGN KEY (doctor_id)
REFERENCES doctor(id)
)
