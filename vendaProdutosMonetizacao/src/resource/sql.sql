-- Table: clientes

-- DROP TABLE clientes;

CREATE TABLE clientes
(
  idcliente serial NOT NULL,
  nome text,
  email text,
  cpf text,
  data_cadastro timestamp without time zone default now(),
  CONSTRAINT idcliente PRIMARY KEY (idcliente)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE clientes
  OWNER TO postgres;


-- Table: produtos

-- DROP TABLE produtos;

-- Table: produtos

-- DROP TABLE produtos;

CREATE TABLE produtos
(
  idproduto serial NOT NULL,
  nome text,
  valor integer,
  data_cadastro timestamp without time zone DEFAULT now(),
  quantidade integer,
  CONSTRAINT idproduto PRIMARY KEY (idproduto)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE produtos
  OWNER TO postgres;


  
-- Table: cliente_conta

-- DROP TABLE cliente_conta;

CREATE TABLE cliente_conta
(
  id_conta serial NOT NULL,
  idcliente integer,
  saldo integer,
  numero text,
  data_cadastro timestamp without time zone DEFAULT now(),
  CONSTRAINT id_conta PRIMARY KEY (id_conta),
  CONSTRAINT idcliente FOREIGN KEY (idcliente)
      REFERENCES clientes (idcliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cliente_conta
  OWNER TO postgres;



-- Table: historico_venda

--DROP TABLE historico_venda;

CREATE TABLE historico_venda
(
  id_venda serial NOT NULL,
  nome_cliente text,
  produto text,
  data_cadastro timestamp without time zone DEFAULT now(),
  CONSTRAINT id_venda PRIMARY KEY (id_venda)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE historico_venda
  OWNER TO postgres;



SELECT * FROM historico_venda


DELETE FROM historico_venda WHERE  id_venda = 1


SELECT c.nome, cc.saldo FROM  cliente_conta  cc INNER JOIN clientes c ON c.idcliente = cc.idcliente WHERE numero = '123'


SELECT * FROM produtos WHERE  idproduto  =  2