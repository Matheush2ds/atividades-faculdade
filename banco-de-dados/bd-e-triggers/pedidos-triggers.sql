CREATE DATABASE CLIENTE;
USE CLIENTE;
CREATE TABLE CLIENTE (
    codcliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    datanascimento DATE,
    cpf VARCHAR(11)
);

CREATE TABLE IF NOT EXISTS PRODUTO (
    codproduto INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100),
    quantidade INT
);

CREATE TABLE IF NOT EXISTS PEDIDO (
    codpedido INT AUTO_INCREMENT PRIMARY KEY,
    codcliente INT,
    datapedido DATE,
    nf VARCHAR(20),
    valortotal DECIMAL(10,2),
    FOREIGN KEY (codcliente) REFERENCES CLIENTE(codcliente)
);

CREATE TABLE IF NOT EXISTS ITEMPEDIDO (
    codpedido INT,
    numeroitem INT,
    valorunitario DECIMAL(10,2),
    quantidade INT,
    codproduto INT,
    PRIMARY KEY (codpedido, numeroitem),
    FOREIGN KEY (codpedido) REFERENCES PEDIDO(codpedido),
    FOREIGN KEY (codproduto) REFERENCES PRODUTO(codproduto)
);

CREATE TABLE IF NOT EXISTS LOG (
    codlog INT AUTO_INCREMENT PRIMARY KEY,
    data DATETIME,
    descricao VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS REQUISICAO_COMPRA (
    codrequisicaocompra INT AUTO_INCREMENT PRIMARY KEY,
    codproduto INT,
    data DATE,
    quantidade INT,
    status VARCHAR(20)
);

INSERT INTO CLIENTE (nome, datanascimento, cpf) VALUES
('Matheus', '2002-12-29', '11111111111'),
('Tatiane', '2003-02-22', '22222222222'),
('Luane', '1999-05-11', '33333333333'),
('Ana', '2000-12-09', '44444444444'),
('Carlos', '1993-07-06', '55555555555');

INSERT INTO PRODUTO (descricao, quantidade) VALUES
('Produto 1', 95),
('Produto 2', 60),
('Produto 3', 200),
('Produto 4', 75),
('Produto 5', 155);

INSERT INTO PEDIDO (codcliente, datapedido, nf, valortotal) VALUES
(1, '2024-04-01', 'NF111', 500.00),
(2, '2024-04-02', 'NF222', 750.00),
(3, '2024-04-03', 'NF333', 300.00),
(4, '2024-04-04', 'NF444', 900.00),
(5, '2024-04-05', 'NF555', 1200.00);

INSERT INTO ITEMPEDIDO (codpedido, numeroitem, valorunitario, quantidade, codproduto) VALUES
(1, 1, 50.00, 5, 1),
(1, 2, 25.00, 10, 2),
(2, 1, 30.00, 8, 3),
(3, 1, 20.00, 15, 4),
(4, 1, 100.00, 6, 5);

# 1. Trigger para baixar o estoque de um PRODUTO quando vendido
DELIMITER //
CREATE TRIGGER baixar_estoque AFTER INSERT ON ITEMPEDIDO
FOR EACH ROW
BEGIN
    UPDATE PRODUTO
    SET quantidade = quantidade - NEW.quantidade
    WHERE codproduto = NEW.codproduto;
END;
//
DELIMITER ;

# 2. Trigger para criar um log dos CLIENTES modificados
DELIMITER //
CREATE TRIGGER log_clientes AFTER INSERT ON CLIENTE
FOR EACH ROW
BEGIN
    INSERT INTO LOG (data, descricao) VALUES (NOW(), CONCAT('Inserindo novo cliente - ', NEW.cpf));
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER log_clientes_delete AFTER DELETE ON CLIENTE
FOR EACH ROW
BEGIN
    INSERT INTO LOG (data, descricao) VALUES (NOW(), CONCAT('Excluindo cliente - ', OLD.cpf));
END;
//
DELIMITER ;

# 3. Trigger para criar um log dos PRODUTOS atualizados
DELIMITER //
CREATE TRIGGER log_produtos AFTER UPDATE ON PRODUTO
FOR EACH ROW
BEGIN
    INSERT INTO LOG (data, descricao) VALUES (NOW(), CONCAT('Produto atualizado - ', OLD.descricao));
END;
//
DELIMITER ;

# 4. Trigger para criar um log quando não existir a quantidade do ITEMPEDIDO em estoque
DELIMITER //
CREATE TRIGGER log_sem_estoque BEFORE INSERT ON ITEMPEDIDO
FOR EACH ROW
BEGIN
    DECLARE qtd_disponivel INT;
    SELECT quantidade INTO qtd_disponivel FROM PRODUTO WHERE codproduto = NEW.codproduto;
    IF qtd_disponivel < NEW.quantidade THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantidade insuficiente em estoque!';
    END IF;
END;
//
DELIMITER ;

# 5. Trigger para criar uma requisição de REQUISICAO_COMPRA quando o estoque atingir 50% da venda mensal
DELIMITER //
CREATE TRIGGER requisicao_compra AFTER INSERT ON ITEMPEDIDO
FOR EACH ROW
BEGIN
    DECLARE venda_mensal DECIMAL(10,2);
    DECLARE estoque_atual INT;
    SELECT SUM(quantidade) INTO venda_mensal FROM ITEMPEDIDO WHERE MONTH(datapedido) = MONTH(NOW());
    SELECT quantidade INTO estoque_atual FROM PRODUTO WHERE codproduto = NEW.codproduto;
    IF estoque_atual < venda_mensal * 0.5 THEN
        INSERT INTO REQUISICAO_COMPRA (codproduto, data, quantidade, status) VALUES (NEW.codproduto, NOW(), ROUND(venda_mensal * 0.5) - estoque_atual, 'Pendente');
    END IF;
END;
//
DELIMITER ;

# 6. Trigger para criar um log quando um ITEMPEDIDO for removido
DELIMITER //
CREATE TRIGGER log_itempedido_delete AFTER DELETE ON ITEMPEDIDO
FOR EACH ROW
BEGIN
    INSERT INTO LOG (data, descricao) VALUES (NOW(), 'Item removido');
END;
//
DELIMITER ;

# 7. Trigger para criar um LOG quando o valor total do pedido for maior que R$ 1.000,00
DELIMITER //
CREATE TRIGGER log_valor_pedido AFTER INSERT ON PEDIDO
FOR EACH ROW
BEGIN
    IF NEW.valortotal > 1000.00 THEN
        INSERT INTO LOG (data, descricao) VALUES (NOW(), CONCAT('Valor total do pedido superior a R$ 1.000,00 - NF: ', NEW.nf));
    END IF;
END;
//
DELIMITER ;

# 8. Trigger que não permite que uma pessoa com data de nascimento posterior à data de hoje seja inserida ou atualizada
DELIMITER //
CREATE TRIGGER verificar_data_nascimento BEFORE INSERT ON CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.datanascimento > CURDATE() THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Data de nascimento inválida!';
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER verificar_data_nascimento_update BEFORE UPDATE ON CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.datanascimento > CURDATE() THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Data de nascimento inválida!';
    END IF;
END;
//
DELIMITER ;

# 9. Trigger para acrescentar a palavra "Sr(a)" ao nome das PESSOAS que nasceram há mais de 30 anos
DELIMITER //
CREATE TRIGGER adicionar_tratamento_nome BEFORE INSERT ON CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.datanascimento <= DATE_SUB(NOW(), INTERVAL 30 YEAR) THEN
        SET NEW.nome = CONCAT('Sr(a). ', NEW.nome);
    END IF;
END;
//
DELIMITER ;

# 10. Trigger que ajusta os pedidos de compra para que não existam itens repetidos
DELIMITER //
CREATE TRIGGER verificar_item_repetido BEFORE INSERT ON ITEMPEDIDO
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT * FROM ITEMPEDIDO WHERE codpedido = NEW.codpedido AND codproduto = NEW.codproduto) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Item de pedido já existente!';
    END IF;
END;
//
DELIMITER ;

# 11. Trigger que ajusta os pedidos de compra para que não existam itens repetidos
DELIMITER //
CREATE TRIGGER verificar_item_repetido_update BEFORE UPDATE ON ITEMPEDIDO
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT * FROM ITEMPEDIDO WHERE codpedido = NEW.codpedido AND codproduto = NEW.codproduto) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Item de pedido já existente!';
    END IF;
END;
//
DELIMITER ;

# 12. Trigger que exibe uma mensagem informando que o valor do pedido excedeu R$ 100.000,00
DELIMITER //
CREATE TRIGGER verificar_valor_maximo_pedido BEFORE INSERT ON PEDIDO
FOR EACH ROW
BEGIN
    IF NEW.valortotal > 100000.00 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'O valor do pedido excedeu R$ 100.000,00!';
    END IF;
END;
//
DELIMITER ;

# 13. Trigger que é executada quando o status de uma requisição for alterado para “Concluída” e exibe uma mensagem
DELIMITER //
CREATE TRIGGER verificar_requisicao_concluida AFTER UPDATE ON REQUISICAO_COMPRA
FOR EACH ROW
BEGIN
    IF NEW.status = 'Concluída' THEN
        DECLARE estoque_atual INT;
        SELECT quantidade INTO estoque_atual FROM PRODUTO WHERE codproduto = NEW.codproduto;
        IF estoque_atual < 0.5 * (SELECT SUM(quantidade) FROM ITEMPEDIDO WHERE MONTH(datapedido) = MONTH(NOW())) THEN
            INSERT INTO LOG (data, descricao) VALUES (NOW(), 'Estoque baixo, precisando reabastecer');
        END IF;
    END IF;
END;
//
DELIMITER ;
