/*Заполнение таблиц:*/

INSERT INTO product_categories (name) VALUES
('Комплектующие для  ПК'),
('Ноутбуки'),
('Планшеты, эл. книги и др.'),
('Средства связи'),
('Аксессуары'),
('Игры и приставки'),
('Аудиотехника'),
('Сетевое оборудование'),
('Периферия'),
('Программное обеспечение'),
('Компьютерные системы');

INSERT INTO clients (surname, name, middle_name, telephone, email) VALUES
('Егорова', 'Екатерина', 'Васильевна', '89501235695', 'egorova_kate@yandex.ru'),
('Ефимов', 'Петр', 'Петрович', '89240565566', 'efimov85@gmail.com'),
('Усольцева', 'Василина', 'Павловна', '89141511561', 'vasilina_us@mail.ru'),
('Дмитриева', 'Инна', 'Сергеевна', '89146661488', 'inna-sergeevna@gmail.com'),
('Соколов', 'Алексей', 'Иванович', '89242121115', 'sokolov_alex@gmail.com'),
('Кондратьев', 'Федор', 'Олегович', '89504448489', 'fedor91@gmail.com'),
('Аксенова', 'Антонина', 'Вячеславовна', '89245458456', 'aksenova-av@mail.ru'),
('Капустина', 'Анна', 'Михайловна', '89505486489', 'anna92@yandex.ru'),
('Ткачук', 'Олег', 'Николаевич', '89525055456', 'tkachyk-oleg@yandex.ru'),
('Николаева', 'Александра', 'Сергеевна', '89501555886', 'sasha-nik@mail.ru');

INSERT INTO suppliers (name, representative,address, telephone) VALUES
('ООО "Медиа Маркет"', 'Корнеев Дмитрий Иванович', '603024, Нижний Новгород, ул. Тургенева, д.26-Б', '8(831)278-08-33'),
('ИП Кутовой В.Н.', 'Кутовой Василий Николаевич', '664435 г.Иркутск, м-р Университетский, д. 73', '8(3952)500-853'),
('ООО "Logitech"', 'Ткачева Екатерина Васильевна', '620075, Екатеринбург, Мамина-Сибиряка, 145 офис 379', '8(343)379-49-91'),
('ООО "Техно Эксперт"', 'Федотов Алексей Петрович', '664124 г.Иркутск, ул.Ширямова, д. 123', '8(3952)524-554'),
('ООО "Диалог"', 'Савчук Борис Дмитревич', '129029, г. Москва, Звездный бульвар, д. 21', '8(495)995-25-28'),
('ООО "ASUSTeK"', 'Афанасьев Петр Викторович', '128021 г.Москва, 2-ой Хорошевский проезд, д. 7/1', '8(499)154-10-71'),
('ООО "Мирекс"', 'Василенко Елена Павловна', '194100, г.Санкт-Петербург , Большой Сампсониевский, д.68', '8(812)324-28-70'),
('ООО "НИКС"', 'Андреев Артем Олегович', '127299, г.Москва, ул. Большая Академическая, д.5А', '8(495)920-62-93'),
('ООО "Бюро"', 'Перевалов Анатолий Егорович', '443070, г. Самара, ул. Верхнекарьерная, д. 6', '8(846)262-99-55'),
('ООО "Нью-Гейм"', 'Медведева Анна Игоревна', '127134, г. Москва, Дмитровское ш., дом 5/1', '8(495)920-62-93');

INSERT INTO employees (surname, first_name, middle_name, position, date_of_birth, address, phone, salary) VALUES
('Иванов', 'Сергей', 'Викторович', 'менеджер', '1988-06-18', '664211 г.Иркутск, ул. Свердлова, д. 35 кв. 12', '89501352344', 18500),
('Петрова', 'Мария', 'Александровна', 'юрист', '1989-05-20', '664015 г.Иркутск, ул. Ленина, д. 36 кв. 21', '89512476721', 25000),
('Михайлова', 'Ирина', 'Витальевна', 'бухгалтер', '1983-02-11', '664542 г.Иркутск, ул. Мира, д. 178, кв. 64', '89501244578', 28000),
('Александров', 'Игорь', 'Дмитриевич', 'менеджер', '1996-08-10', '664277 г.Иркутск, ул.Александра Невского, д. 74 кв. 10', '89504673555', 18500),
('Семенова', 'Наталья', 'Николаевна', 'менеджер', '1995-09-27', '664512 г.Иркутск, ул. Чехова, д. 125, кв.21', '89554646346', 18500),
('Федоров', 'Алексей', 'Витальевич', 'администратор', '1992-03-21', '664255 г.Иркутск, ул.Пушкина, д.1 кв. 34', '89525656777', 23500),
('Макаров', 'Андрей', 'Вячеславович', 'ген.директор', '1990-07-28', '664558 г.Иркутск, ул.Ленина, д.8 кв. 7', '89505535275', 65000),
('Стрелов', 'Владислав', 'Андреевич', 'менеджер', '1996-11-08', '664275 г.Иркутск, ул. Советская, д.88 кв. 21', '89217687688', 18500),
('Сирафимов', 'Александр', 'Викторович', 'менеджер', '1994-10-10', '664575 г.Иркутск, ул.Фрунзе, д.3, кв. 178', '89505563475', 18500),
('Морозов', 'Алексей', 'Игоревич', 'менеджер', '1993-12-19', '664235 г.Иркутск, ул. Маяковского, д. 25б кв. 3', '89532443470', 18500);

INSERT INTO products_receipt (invoice_number, supplier_id, delivery_date) VALUES
('4751545', 6, '2019-11-14'),
('4751546', 6, '2019-12-19'),
('1231351', 9, '2020-02-26'),
('7782354', 2, '2020-03-18'),
('2322313', 3, '2020-03-20'),
('1244644', 1, '2020-03-29'),
('8611321', 4, '2020-04-10'),
('5361354', 10, '2020-04-26'),
('1421301', 5, '2020-05-07'),
('5774684', 3, '2020-05-20'),
('7851331', 8, '2020-06-03'),
('9711547', 6, '2020-06-06'),
('2114004', 7, '2020-06-15'),
('4750014', 9, '2019-06-19'),
('4758781', 2, '2020-07-26'),
('7780120', 3, '2020-07-18'),
('2111201', 1, '2020-08-20'),
('1244744', 4, '2020-08-29'),
('8616521', 10, '2020-09-10'),
('5360141', 5, '2020-09-26'),
('1420124', 3, '2020-09-07'),
('5771453', 8, '2020-10-20'),
('7851452', 6, '2020-10-03'),
('9711024', 5, '2020-10-06');


INSERT INTO discount_cards_customers (card_number, id_client, id_card_type) VALUES
('1551154512515151', 5, 4),
('1551556488464650', 9, 1),
('1561005905905998', 2, 2),
('1515315610355521', 7, 3),
('1561561561513131', 3, 4),
('1561561561561565', 6, 3);


INSERT INTO products_types (product_category_id, type) VALUES
(11, 'Серверы'),
(11, 'Системные блоки'),
(11, 'Моноблоки'),
(11, 'Микрокомпьютеры'),
(11, 'Сенсорные моноблоки'),
(1, 'Процессоры'),
(1, 'Материнские платы'),
(1, 'Видеокарты'),
(1, 'Оперативная память'),
(1, 'Блоки питания'),
(1, 'Корпуса'),
(4, 'Смартфоны'),
(4, 'Сотовые телефоны'),
(4, 'Смарт-часы и браслеты'),
(4, 'Стационарные сотовые телефоны'),
(7, 'Акустические системы Hi-Fi'),
(7, 'AV-ресиверы'),
(7, 'Усилители Hi-Fi'),
(7, 'Домашние кинотеатры'),
(7, 'Колонки'),
(7, 'Сабвуферы'),
(7, 'Микрофоны'),
(7, 'Наушники'),
(9, 'Мониторы'),
(9, 'Клавиатуры'),
(9, 'Мыши'),
(9, 'Комплекты клавиатура+мышь'),
(9, 'Коврики для мыши'),
(9, 'Внешние накопители данных'),
(9, 'Веб-камеры'),
(9, 'USB разветвители'),
(9, 'Игровые клавиатуры'),
(9, 'Игровые мыши'),
(2, 'Ноутбуки'),
(2, 'Комплектующие для ноутбуков'),
(2, 'Аксессуары для ноутбуков');



INSERT INTO products (id_type_of_product, id_invoice, name, characteristics, wholesale_price, retail_price, quantity) VALUES
(2, 11, 'ПК Acer Aspire XC-830 [DT.B9VER.004]', 'Intel Pentium J5005, 4x1500 мГц, 4 ГБ DDR4, HDD 1000 ГБ, без ОС', 12500, 18500, 10),
(2, 11, 'ПК Lenovo V530-15ARR [10Y30006RU]', 'AMD Ryzen 3 2200G, 4x3500 МГц, 4 ГБ DDR4, HDD 1000 ГБ, Wi-Fi, DVD-RW, без ОС', 18254, 25999, 5),
(2, 11, 'ПК Lenovo Ideacentre 510-15ICB MT 90HU006HRS', 'Intel Core i5 8400, 6x2800 мГц, GeForce GTX 1050 Ti, 8 ГБ DDR4, HDD 1000 ГБ, SSD 128 ГБ, Windows 10 Домашняя', 56165,	70999,	NULL),
(2, 11, 'ПК HP Pavilion 590-a0004ur [4KC63EA]', 'AMD E2 9000, 2x1800 мГц, 4 ГБ DDR4, HDD 1000 ГБ, Wi-Fi, DVD-RW, без ОС', 10484, 17799, 12),
(2, 22, 'ПК HP EliteDesk 800 G4 [4KW61EA]', 'Intel Core i5 8500, 6x3000 мГц, 8 ГБ DDR4, HDD 1000 ГБ, DVD-RW, Windows 10 Pro', 68156, 73499, 3),
(2, 22, 'ПК HP Pavilion Gaming 690-0009ur [4JY82EA]', 'AMD Ryzen 7 2700, 8x3200 мГц, Radeon RX 580, 16 ГБ DDR4, HDD 1000 ГБ, SSD 256 ГБ, Wi-Fi, DVD-RW, без ОС', 69084, 83499, 1),
(33, 2, '15.6" Ноутбук ASUS VivoBook Max D540NA-GQ173', '1366x768, TN+film, Intel Pentium N4200, 4 х 1.1 ГГц, RAM 4 ГБ, HDD 500 ГБ, Intel HD 505 , Wi-Fi, BT, UNIX-подобная', 13456, 18799, 2),
(33, 1, '15.6" Ноутбук ASUS VivoBook X540MA-GQ064', '1366x768, TN+film, Intel Celeron N4000, 2 х 1.1 ГГц, RAM 4 ГБ, HDD 500 ГБ, Intel UHD 605 , Wi-Fi, BT, UNIX-подобная', 12584, 17799, 3),
(33, 3, '15.6" Ноутбук HP 15-rb039ur', '1366x768, SVA (TN+film), AMD A6-9220, 2 х 2.5 ГГц, RAM 4 ГБ, HDD 500 ГБ, Radeon R4 , Wi-Fi, BT, DOS', 13560, 18999, 4),
(33, 2, '15.6" Ноутбук ASUS VivoBook 15 X540NA-GQ005 коричневый', '1366x768, TN+film, Intel Celeron N3350, 2 х 1.1 ГГц, RAM 4 ГБ, HDD 500 ГБ, Intel HD 500 , Wi-Fi, BT, DOS', 15004, 19499, NULL),
(33, 1, '15.6" Ноутбук Lenovo IdeaPad 320-15IAP черный', '1366x768, TN+film, Intel Celeron N3350, 2 х 1.1 ГГц, RAM 4 ГБ, HDD 500 ГБ, Intel HD 500 , Wi-Fi, DOS', 15648, 19999, 3),
(33, 3, '11.6" Ультрабук Acer Spin 1 SP111-33-C4PH черный', '1366x768, TN+film, Intel Celeron N3350, 2 х 1.1 ГГц, RAM 4 ГБ, HDD 500 ГБ, Intel HD 500 , Wi-Fi, DOS', 16056, 21999, 5),
(33, 2, '15.6" Ноутбук Asus VivoBook D540MB-GQ080T черный', '1366x768, TN+film, Intel Core i3 8130U, 2 х 2.2 ГГц, RAM 4 ГБ, HDD 1000 ГБ, Intel UHD Graphics 620 , Wi-Fi, DOS', 20556, 26499, NULL),
(33, 22, '15.6" Ноутбук Lenovo ThinkPad E580 черный', '1920x1080, IPS, Intel Core i3 8145U, 2 х 2.1 ГГц, RAM 4 ГБ, HDD 1000 ГБ, Intel UHD Graphics 620 , Wi-Fi, BT, Windows 10', 35115, 40499, 2),
(33, 3, '14" Ноутбук Dell Inspiron 5482-5430 серый', '1920x1080, TN+film, Intel Core i5 7200U, 2 х 2.5 ГГц, RAM 8 ГБ, HDD 1000 ГБ, GeForce MX130 2 Гб, DVD-SMulti, Wi-Fi, BT, UNIX-подобная', 34408, 41499, 3),
(33, 22, '15.6" Ноутбук Acer Aspire E 15 E5-576G-5219 красный', '1920x1080, TN+film, Intel Core i5 7200U, 2 х 2.5 ГГц, RAM 8 ГБ, HDD 1000 ГБ, GeForce MX130 2 Гб, DVD-SMulti, Wi-Fi, BT, UNIX-подобная', 45556, 51999, 2),
(33, 2, '15.6" Ноутбук ASUS TUF Gaming FX505DY-BQ001 черный', '1920x1080, IPS, AMD Ryzen 5 3550H, 4 х 2.1 ГГц, RAM 8 ГБ, HDD 1000 ГБ, SSD 128 ГБ, Radeon RX 560X 4 Гб, Wi-Fi, DOS', 48516, 56499, 1),
(23, 22, '19.5" Монитор Philips 200V4LAB2 [200V4LAB2 00/(01)]', '1600x900@60 Гц, TN, 5 мс, 600:1, 200 Кд/м?, 90°/65°, VGA (D-sub), DVI-D', 4560, 5999, 10),
(23, 12, '21.5" Монитор ASUS VS228NE [90LMD8001T02211C-]', '1920x1080@60 Гц, TN, 5 мс, 1000:1, 200 Кд/м?, 90°/65°, VGA (D-sub), DVI-D', 4260, 6199, NULL),
(23, 12, '23.8" Монитор ASUS VA249HE VA249HE', '1920x1080@60 Гц, VA, 5 мс, 3000:1, 250 Кд/м?, 178°/178°, HDMI, VGA (D-sub', 6508, 9699, 7),
(23, 11, '23.8" Монитор LG 24MP88HV-S [24MP88HV-S.ARUZ]', '1920x1080@60 Гц, IPS, 5 мс, 1000:1, 250 Кд/м?, 178°/178°, VGA (D-sub), HDMI (2 шт)', 8921, 10799, NULL),
(23, 11, '27" Монитор Samsung C27H580FDI [LC27H580FDIXCI]', '1920x1080@60 Гц, VA, 4 мс, 3000:1, 250 Кд/м?, 178°/178°, HDMI, VGA (D-sub), DisplayPort, AMD FreeSync', 9545, 13799, 4),
(24, 7, 'Клавиатура Sven Standard 301', 'проводная, мембранная, клавиш - 105, USB, белая', 250, 480, 23),
(24, 3, 'Клавиатура Defender OfficeMate MM-810', 'проводная, мембранная, клавиш - 124, USB, черная', 300, 599, NULL),
(24, 7, 'Клавиатура Qumo Sigma K38', 'проводная, мембранная, клавиш - 104, USB, черная', 350, 699, 15),
(24, 3, 'Клавиатура DEXP Liquid metal', 'проводная, мембранная, клавиш - 104, USB, серебристая', 420, 899, 6),
(24, 6, 'Клавиатура Razer Cynosa Chroma', 'проводная, мембранная, клавиш - 104, USB, черная', 3558, 5399, NULL),
(24, 10, 'Клавиатура Logitech G512 Carbon', 'проводная, механическая Romer-g, клавиш - 104, USB, черная', 3540, 5499, 5),
(24, 3, 'Клавиатура Razer Ornata Chroma Destiny 2', 'проводная, мембранная (частично механика) Razer Mecha-Membrane, клавиш - 104, USB, черная', 4552, 6999, 3),
(24, 10, 'Клавиатура Logitech G613', 'беспроводная, механическая Romer-g, клавиш - 120, USB, Bluetooth, черная', 4950, 8399, 4),
(25, 6, 'Мышь проводная DEXP Notos черный', '2400 dpi, светодиодный, USB, кнопки - 6', 280, 499, 12),
(25, 10, 'Мышь проводная Logitech G102 Prodigy черный', '8000 dpi, светодиодный, USB, кнопки - 6', 1150, 1799, NULL),
(25, 7, 'Мышь проводная Sven RX-112 белый', '800 dpi, светодиодный, USB, кнопки - 3', 100, 270, 18),
(25, 7, 'Мышь проводная Genius NetScroll DX-165 красный', '1000 dpi, светодиодный, USB, кнопки - 3', 125, 399, 14),
(25, 6, 'Мышь проводная Qumo Office M43 Serenity белый', '1000 dpi, светодиодный, USB, кнопки - 3', 237, 399, 10),
(25, 7, 'Мышь проводная SVEN RX-G950 Gaming черный', '4000 dpi, светодиодный, USB, кнопки - 5', 560, 999, NULL),
(25, 7, 'Мышь беспроводная Sven RX-300 черный', '1000 dpi, светодиодный, USB, кнопки - 3', 230, 420, 8),
(25, 6, 'Мышь проводная DEXP Eris белый', '2400 dpi, светодиодный, USB, кнопки - 6', 210, 430, 9);

INSERT INTO sales (product_id, quantity,client_id, employee_id, implementation_date) VALUES
(20, 2, 3, 4, '2020-04-06'),
(13, 1, 7, 10, '2020-05-22'),
(30, 3, 8, 9, '2020-05-30'),
(26, 1, 2, 8, '2020-06-04'),
(25, 2, 1, 8, '2020-05-08'),
(30, 1, 7, 10, '2020-05-23'),
(32, 1, 5, 4, '2020-05-25'),
(23, 3, 10, 5, '2020-05-20'),
(4, 1, 9, 10, '2020-06-05'),
(33, 4, 2, 8, '2020-06-03'),
(12, 1, 2, 9, '2020-06-19'),
(38, 2, 4, 8, '2020-05-29'),
(11, 1, 6, 8, '2020-06-07'),
(18, 2, 9, 4, '2020-05-16'),
(38, 1, 10, 5, '2020-07-08');



