
CREATE TABLE departments(
                            id BIGSERIAL NOT NULL,
                            name VARCHAR(25),
                            min_salary INT,
                            max_salary INT,
                            PRIMARY KEY (id)
);

CREATE TABLE details(
                        id BIGSERIAL NOT NULL,
                        city VARCHAR(25),
                        phone_number VARCHAR(15),
                        email VARCHAR(35),
                        PRIMARY KEY (id)
);

CREATE TABLE employee(
                         id BIGSERIAL NOT NULL,
                         name VARCHAR(15),
                         surname VARCHAR(25),
                         department VARCHAR(20),
                         salary INT,
                         department_id BIGINT,
                         details_id BIGINT,
                         PRIMARY KEY (id),
                         FOREIGN KEY (department_id) REFERENCES departments(id),
                         FOREIGN KEY (details_id) REFERENCES details(id)
);

INSERT INTO departments(name, min_salary, max_salary) VALUES
('IT', 300, 1000),
('sales', 500, 1200),
('HR', 600,1300);

INSERT INTO details(city, phone_number, email) VALUES
('New-York', '8-989-777-1000', 'alex1000@gmail.com'),
('Moscow', '8-924-123-1234', 'mike-petrov@mail.ru'),
('Novosibirsk', '8-950-111-2323','anna.sidorova@gmail.com');

INSERT INTO employee(name, surname, department, salary, department_id, details_id) VALUES
('Alex', 'Aleksandrov', 'IT', 550, 1, 1),
('Mike', 'Petrov', 'sales', 800, 3, 2),
('Anna', 'Sidorova', 'HR', 700, 2, 3);