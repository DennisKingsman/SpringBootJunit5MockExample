DROP TABLE IF EXISTS Db_Data;

CREATE TABLE Db_Data (
    data_id INT AUTO_INCREMENT  PRIMARY KEY,
    dataset VARCHAR(30) NOT NULL
);

INSERT INTO Db_Data(dataset) VALUES
('data 1'),
('data 2'),
('data 3');