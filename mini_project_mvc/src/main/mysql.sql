CREATE TABLE employee(
                         id BIGSERIAL,
                         name VARCHAR(15),
                         surname VARCHAR(25),
                         department VARCHAR(20),
                         salary INT,
                         PRIMARY KEY (id)
);

INSERT INTO employee(name, surname, department, salary) VALUES
('Alex', 'Aleksandrov', 'IT', 550),
('Mike', 'Petrov', 'sales', 800),
('Anna', 'Sidorova', 'HR', 700);