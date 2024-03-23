
-- UNUSED because tables created through entity models

-- Create a table for participants
CREATE TABLE participant (
                       pid INT PRIMARY KEY AUTO_INCREMENT,  -- Auto-incrementing integer for unique user ID
                       name VARCHAR(50),
                       email VARCHAR(255) UNIQUE NOT NULL,  -- Email should be unique for each user
                       address VARCHAR(255),
                       phone_number123 VARCHAR(15)
);

-- Create a table for admins
CREATE TABLE admin (
                        adminid INT PRIMARY KEY AUTO_INCREMENT,  -- Auto-incrementing integer for unique admin ID
                        username VARCHAR(50),
                        password VARCHAR(100)
);
