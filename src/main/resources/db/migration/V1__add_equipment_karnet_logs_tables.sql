CREATE TABLE Karnety (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         type INT NOT NULL,
                         price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Equipment (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NULL,
                           price DECIMAL(10, 2) NOT NULL  -- Changed to rental_rate if needed for clarity
);

CREATE TABLE KarnetLogs (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            log_date DATE NOT NULL,
                            karnet_type_id BIGINT NOT NULL,
                            quantity INT NOT NULL,
                            total_price DECIMAL(10, 2) NOT NULL,
                            notes TEXT,
                            UNIQUE KEY unique_karnet_daily (log_date, karnet_type_id),
                            FOREIGN KEY (karnet_type_id) REFERENCES Karnety(id) ON DELETE RESTRICT
);

CREATE TABLE EquipmentLogs (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               log_date DATE NOT NULL,
                               equipment_type_id BIGINT NOT NULL,
                               quantity INT NOT NULL,
                               total_price DECIMAL(10, 2) NOT NULL,
                               notes TEXT,
                               UNIQUE KEY unique_equipment_daily (log_date, equipment_type_id),
                               FOREIGN KEY (equipment_type_id) REFERENCES Equipment(id) ON DELETE RESTRICT
);
