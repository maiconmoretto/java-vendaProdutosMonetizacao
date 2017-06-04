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



  
CREATE TABLE cliente_conta
(
id_conta serial NOT NULL,
  idcliente integer,
  saldo integer,
  numero text,
  data_cadastro timestamp without time zone default now(),
  CONSTRAINT id_conta PRIMARY KEY (id_conta)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE  cliente_conta
  OWNER TO postgres;



  SELECT * FROM cliente_conta  WHERE numero =  '123'

