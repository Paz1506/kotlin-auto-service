-- Создаем таблицу авто
CREATE TABLE IF NOT EXISTS AUTO
(
    ID   VARCHAR(36)  NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO AUTO (ID, NAME) VALUES ('45dd729c-723b-4f87-a952-8f6717725786', 'auto1'),
                                   ('124440e3-ab0e-4ede-b58b-3c9a95cc9934', 'auto2'),
                                   ('26c12460-7757-44b9-94cb-0dac5c22cb37', 'auto3'),
                                   ('4e4ee01c-8816-4cee-b376-06c1b3ab3f6c', 'auto4'),
                                   ('ba6b410b-0bf9-47cf-8434-38305568b9ad', 'auto5');