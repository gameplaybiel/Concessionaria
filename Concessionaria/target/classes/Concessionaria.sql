CREATE TABLE CONCESSIONARIA (
id INT AUTO_INCREMENT PRIMARY KEY,
cliente VARCHAR(100) NOT NULL,
modelo VARCHAR(100) NOT NULL,
placa VARCHAR(100) NOT NULL,
endereco VARCHAR(200) NOT NULL,
cidade VARCHAR(100) NOT NULL,
estado VARCHAR(25) DEFAULT NULL
);


INSERT INTO condominio (id, cliente, modelo, placa, endereco, cidade, estado) VALUES
(1, 'Henrique Gomes', 'Civic 10', 'ABC123', 'Av Pacifico Moneda', 'Jaguariuna', 'SP'),
(2,'Alexandre Moares', 'HB20', 'CDE345', 'Avenida Paulista', 'Sao Paulo', 'SP'),
(3, 'Luis Carlos', 'Corrola', 'FGH678', 'Rua Ipanema', 'Rio de Janeiro', 'RJ');