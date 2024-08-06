CREATE DATABASE clinica;
USE clinica;

CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    data_nascimento DATE,
    endereco VARCHAR(255),
    telefone VARCHAR(15)
);

CREATE TABLE consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    data_consulta DATE,
    descricao TEXT,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

INSERT INTO paciente (nome, data_nascimento, endereco, telefone) VALUES
('Marco Silva', '1990-05-15', 'Rua A, 123', '123456789'),
('Mariane Oliveira', '1985-03-20', 'Rua B, 456', '987654321'),
('Carla Lima', '1978-11-30', 'Rua C, 789', '564738291');

INSERT INTO consulta (paciente_id, data_consulta, descricao) VALUES
(1, '2024-01-15', 'Consulta de rotina'),
(2, '2024-02-20', 'Revisão anual'),
(3, '2024-03-05', 'Exame de sangue'),
(1, '2024-04-10', 'Consulta de acompanhamento'),
(2, '2024-05-25', 'Consulta dermatológica');

CREATE VIEW vw_paciente_consulta AS
SELECT
    p.nome AS nome_paciente,
    p.data_nascimento,
    c.data_consulta,
    c.descricao
FROM
    paciente p
JOIN
    consulta c ON p.id = c.paciente_id;
    
    CREATE TABLE mt_paciente_consulta AS
SELECT
    p.nome AS nome_paciente,
    p.data_nascimento,
    c.data_consulta,
    c.descricao
FROM
    paciente p
JOIN
    consulta c ON p.id = c.paciente_id;
    
    DELIMITER //

CREATE EVENT atualiza_mt_paciente_consulta
ON SCHEDULE EVERY 1 HOUR
DO
BEGIN
    DELETE FROM mt_paciente_consulta;
    INSERT INTO mt_paciente_consulta
    SELECT
        p.nome AS nome_paciente,
        p.data_nascimento,
        c.data_consulta,
        c.descricao
    FROM
        paciente p
    JOIN
        consulta c ON p.id = c.paciente_id;
END//

DELIMITER ;



