CREATE TABLE IF NOT EXISTS task (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    completed BOOLEAN
);
