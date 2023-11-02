CREATE TABLE Customer (
    customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_first_name VARCHAR(255) NOT NULL,
    customer_last_name VARCHAR(255) NOT NULL,
    customer_address VARCHAR(255),
    customer_phone VARCHAR(10)
);
CREATE TABLE Pet (
    pet_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_name VARCHAR(255) NOT NULL,
    pet_age INT,
    pet_species VARCHAR(255),
    pet_breed VARCHAR(255),
    shelter_id INT FOREIGN KEY Shelter(shelter_id)
);
CREATE TABLE Adopts (
    adopt_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT NOT NULL FOREIGN KEY Pet(pet_id),
    customer_id INT NOT NULL FOREIGN KEY Customer(customer_id),
    volunteer_id INT NOT NULL FOREIGN KEY Volunteer(volunteer_id),
    adopt_date DATE NOT NULL
);
CREATE TABLE Shelter (
    shelter_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shelter_name VARCHAR(255) NOT NULL,
    shelter_address VARCHAR(255) NOT NULL,
    shelter_phone VARCHAR(255) NOT NULL,
    shelter_num_adoptions INT NOT NULL
);
CREATE TABLE Volunteer (
    volunteer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    volunteer_first_name VARCHAR(255) NOT NULL,
    volunteer_last_name VARCHAR(255) NOT NULL,
    volunteer_hours_worked INT NOT NULL
);
CREATE TABLE VolunteersAt (
    volunteer_id INT NOT NULL FOREIGN KEY Volunteer(volunteer_id),
    shelter_id INT NOT NULL FOREIGN KEY Shelter(shelter_id)
);