CREATE TABLE Equipment (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           price DECIMAL(10, 2) NOT NULL  -- Changed to rental_rate if needed for clarity
);


CREATE TABLE Logs (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               log_date DATE NOT NULL,
                               equipment_id BIGINT NOT NULL,
                               quantity INT NOT NULL,
                               total_price DECIMAL(10, 2) NOT NULL,
                               log_type varchar(255),
                               notes varchar(255),
                               UNIQUE KEY unique_equipment_daily (log_date, equipment_id),
                               FOREIGN KEY (equipment_id) REFERENCES Equipment(id) ON DELETE RESTRICT
);
