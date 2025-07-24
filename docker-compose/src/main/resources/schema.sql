CREATE TABLE IF NOT EXISTS monster (                         
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         health INT,
                         attacks INT,
                         defense INT,
                         damage INT
);
