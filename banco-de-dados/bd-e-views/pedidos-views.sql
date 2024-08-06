CREATE DATABASE IF NOT EXISTS CLIENTE;
USE CLIENTE;

CREATE TABLE IF NOT EXISTS CLIENTE (
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

-- Inserção de dados nas tabelas
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

# 1) View que mostra o código do pedido e a data em que foram realizados
CREATE VIEW PedidoData AS
SELECT codpedido, datapedido
FROM PEDIDO;

# 2) View que apresenta o código do pedido, o nome do cliente e o valor total do pedido
CREATE VIEW PedidoClienteValor AS
SELECT p.codpedido, c.nome AS nome_cliente, p.valortotal
FROM PEDIDO p
INNER JOIN CLIENTE c ON p.codcliente = c.codcliente;

# 3) View que mostra o código do pedido, a descrição do produto, a quantidade vendida e o valor unitário
CREATE VIEW PedidoDescricaoQuantidadeValor AS
SELECT ip.codpedido, pr.descricao, ip.quantidade, ip.valorunitario
FROM ITEMPEDIDO ip
INNER JOIN PRODUTO pr ON ip.codproduto = pr.codproduto;

# 4) View que exibe o código do cliente, o nome, a idade e o CPF formatado
CREATE VIEW ClienteDetalhes AS
SELECT codcliente, nome, TIMESTAMPDIFF(YEAR, datanascimento, CURDATE()) AS idade, CONCAT(SUBSTRING(cpf, 1, 3), '.', SUBSTRING(cpf, 4, 3), '.', SUBSTRING(cpf, 7, 3), '-', SUBSTRING(cpf, 10, 2)) AS cpf_formatado
FROM CLIENTE;

# 5) View que apresenta o código do pedido, a data, a descrição do produto, a quantidade e o valor total do item
CREATE VIEW PedidoItemDetalhes AS
SELECT ip.codpedido, p.datapedido, pr.descricao, ip.quantidade, ip.quantidade * ip.valorunitario AS valor_total_item
FROM ITEMPEDIDO ip
INNER JOIN PEDIDO p ON ip.codpedido = p.codpedido
INNER JOIN PRODUTO pr ON ip.codproduto = pr.codproduto;

# 6) View que apresenta o código do pedido, a data, a descrição do produto, a quantidade e o valor total do item, ordenados pelo valor total do item de forma decrescente
CREATE VIEW PedidoItemDetalhesOrdenado AS
SELECT ip.codpedido, p.datapedido, pr.descricao, ip.quantidade, ip.quantidade * ip.valorunitario AS valor_total_item
FROM ITEMPEDIDO ip
INNER JOIN PEDIDO p ON ip.codpedido = p.codpedido
INNER JOIN PRODUTO pr ON ip.codproduto = pr.codproduto
ORDER BY valor_total_item DESC;

# 7) View que mostra o código do cliente, o nome, a idade e a quantidade total de pedidos feitos por cada cliente
CREATE VIEW ClientePedidos AS
SELECT c.codcliente, c.nome, TIMESTAMPDIFF(YEAR, c.datanascimento, CURDATE()) AS idade, COUNT(p.codpedido) AS quantidade_pedidos
FROM CLIENTE c
LEFT JOIN PEDIDO p ON c.codcliente = p.codcliente
GROUP BY c.codcliente;

# 8) View que exibe o código do produto, a descrição, a quantidade total vendida e o valor total das vendas de cada produto
CREATE VIEW ProdutoVendas AS
SELECT ip.codproduto, pr.descricao, SUM(ip.quantidade) AS quantidade_total_vendida, SUM(ip.quantidade * ip.valorunitario) AS valor_total_vendas
FROM ITEMPEDIDO ip
INNER JOIN PRODUTO pr ON ip.codproduto = pr.codproduto
GROUP BY ip.codproduto;

# 9) View que exibe o código do cliente, o nome, a data do primeiro pedido realizado e a data do último pedido realizado
CREATE VIEW ClientePrimeiroUltimoPedido AS
SELECT c.codcliente, c.nome, MIN(p.datapedido) AS data_primeiro_pedido, MAX(p.datapedido) AS data_ultimo_pedido
FROM CLIENTE
