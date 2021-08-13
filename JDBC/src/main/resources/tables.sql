CREATE TABLE IF NOT EXISTS product_categories (
                                                  id BIGSERIAL PRIMARY KEY,
                                                  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS suppliers (
                                         id BIGSERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
                                         representative VARCHAR(255) NOT NULL,
                                         address VARCHAR(255),
                                         telephone VARCHAR(255) NOT NULL
);

CREATE TYPE position_enum AS ENUM('менеджер', 'юрист', 'бухгалтер', 'администратор', 'ген.директор');

CREATE TABLE IF NOT EXISTS employees (
                                         id BIGSERIAL PRIMARY KEY  NOT NULL,
                                         surname VARCHAR(255) NOT NULL,
                                         first_name VARCHAR(255) NOT NULL,
                                         middle_name VARCHAR(255) NOT NULL,
                                         position position_enum NOT NULL DEFAULT 'менеджер',
                                         date_of_birth DATE NOT NULL,
                                         address VARCHAR(255) NOT NULL,
                                         phone VARCHAR(255) NOT NULL,
                                         salary INTEGER NOT NULL
);

CREATE TYPE type_enum AS ENUM('Бронзовая', 'Серебряная', 'Золотая', 'Платиновая');

CREATE TABLE IF NOT EXISTS discount_card_types (
                                                   id BIGSERIAL PRIMARY KEY NOT NULL,
                                                   type type_enum NOT NULL DEFAULT 'Серебряная',
                                                   discount_percentage INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS clients (
                                       id BIGSERIAL PRIMARY KEY  NOT NULL,
                                       surname VARCHAR(255) NOT NULL,
                                       name VARCHAR(255) NOT NULL,
                                       middle_name VARCHAR(255) NOT NULL,
                                       telephone VARCHAR(255) NOT NULL,
                                       email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS discount_cards_customers (
                                                        id BIGSERIAL PRIMARY KEY  NOT NULL,
                                                        card_number VARCHAR(16) NOT NULL,
                                                        id_client INTEGER NOT NULL REFERENCES clients (id),
                                                        id_card_type INTEGER NOT NULL REFERENCES discount_card_types (id)
);

CREATE TABLE IF NOT EXISTS products_types (
                                              id BIGSERIAL PRIMARY KEY  NOT NULL,
                                              product_category_id INTEGER NOT NULL REFERENCES product_categories,
                                              type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products_receipt (
                                                id BIGSERIAL NOT NULL,
                                                invoice_number VARCHAR(255) NOT NULL,
                                                supplier_id INTEGER NOT NULL REFERENCES suppliers(id),
                                                delivery_date DATE NOT NULL,
                                                PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products (
                                        id BIGSERIAL NOT NULL,
                                        id_type_of_product INTEGER NOT NULL,
                                        id_invoice INTEGER NOT NULL,
                                        name VARCHAR(400) NOT NULL,
                                        characteristics VARCHAR(500) NOT NULL,
                                        wholesale_price INTEGER NOT NULL,
                                        retail_price INTEGER NOT NULL,
                                        quantity INTEGER,
                                        PRIMARY KEY (id),
                                        FOREIGN KEY (id_type_of_product) REFERENCES products_types(id),
                                        FOREIGN KEY (id_invoice) REFERENCES products_receipt(id)
);

CREATE TABLE IF NOT EXISTS sales (
                                     id BIGSERIAL NOT NULL,
                                     product_id INTEGER NOT NULL,
                                     quantity INTEGER NOT NULL,
                                     client_id INTEGER NOT NULL,
                                     employee_id INTEGER NOT NULL,
                                     implementation_date DATE NOT NULL,
                                     PRIMARY KEY (id),
                                     FOREIGN KEY (product_id) REFERENCES products(id),
                                     FOREIGN KEY (client_id) REFERENCES clients(id),
                                     FOREIGN KEY (employee_id) REFERENCES employees(id)
);
