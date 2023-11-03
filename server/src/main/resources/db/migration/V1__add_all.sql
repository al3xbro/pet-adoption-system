CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT,
    customer_first_name VARCHAR(255) NOT NULL,
    customer_last_name VARCHAR(255) NOT NULL,
    customer_address VARCHAR(255),
    customer_phone VARCHAR(10),
    PRIMARY KEY (customer_id)
);
CREATE TABLE shelter (
    shelter_id INT NOT NULL AUTO_INCREMENT,
    shelter_name VARCHAR(255) NOT NULL,
    shelter_address VARCHAR(255) NOT NULL,
    shelter_phone VARCHAR(255) NOT NULL,
    shelter_num_adoptions INT NOT NULL,
    PRIMARY KEY (shelter_id)
);
CREATE TABLE volunteer (
    volunteer_id INT NOT NULL AUTO_INCREMENT,
    volunteer_first_name VARCHAR(255) NOT NULL,
    volunteer_last_name VARCHAR(255) NOT NULL,
    volunteer_hours_worked INT NOT NULL,
    PRIMARY KEY (volunteer_id)
);
CREATE TABLE pet (
    pet_id INT NOT NULL AUTO_INCREMENT,
    pet_name VARCHAR(255) NOT NULL,
    pet_age INT,
    pet_species VARCHAR(255),
    pet_breed VARCHAR(255),
    shelter_id INT,
    PRIMARY KEY (pet_id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(shelter_id)
);
CREATE TABLE volunteers_at (
    volunteer_id INT NOT NULL,
    shelter_id INT NOT NULL,
    UNIQUE (volunteer_id, shelter_id),
    PRIMARY KEY (volunteer_id, shelter_id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer(volunteer_id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(shelter_id)
);
CREATE TABLE adopts (
    adopt_id INT NOT NULL AUTO_INCREMENT,
    pet_id INT NOT NULL,
    customer_id INT NOT NULL,
    volunteer_id INT NOT NULL,
    shelter_id INT NOT NULL,
    adopt_date DATE NOT NULL,
    PRIMARY KEY (adopt_id),
    FOREIGN KEY (pet_id) REFERENCES pet(pet_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer(volunteer_id),
    FOREIGN KEY (shelter_id) REFERENCES shelter(shelter_id)
);