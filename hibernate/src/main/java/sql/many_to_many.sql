CREATE TABLE children (
                                id BIGSERIAL NOT NULL,
                                name varchar(15),
                                age int,
                                PRIMARY KEY (id)
);

CREATE TABLE section (
                               id BIGSERIAL NOT NULL,
                               name varchar(15),
                               PRIMARY KEY (id)
);

CREATE TABLE child_section (
                                     child_id BIGINT NOT NULL,
                                     section_id BIGINT NOT NULL,
                                     PRIMARY KEY (child_id, section_id),
                                     FOREIGN KEY (child_id) REFERENCES children(id),
                                     FOREIGN KEY (section_id) REFERENCES section(id));