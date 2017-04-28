
-- 1
Create table CIDADEAUX(
	ID INT IDENTITY NOT NULL,
	NOME VARCHAR(30),
	UF VARCHAR(2),
	CONSTRAINT  PK_CIDADEAUX PRIMARY KEY (ID)
);

-- 2
TRUNCATE TABLE CIDADEAUX;

select * 
  into cidadeAux 
  from cidade c 
  where c.UF = 'RS';
-- 3

Create table Produto(
	id int identity not null,
	nome_curto varchar(20),
	nome_descricao varchar(50),
	data_descricao date,
	local_estoque varchar(20),
	quantidade decimal(14,4),
	preco decimal(16,2),
	constraint PK_IDPRODUTO primary key (id)
	)

	
-- 4
insert 
  into produto (nome_curto,nome_descricao,data_descricao,local_estoque,quantidade,preco) 
  values ('teste1','teste grande 1','28/04/2017','frente da loja',1.0000,15.90);

  -- getDate();
insert 
  into produto (nome_curto,nome_descricao,data_descricao,local_estoque,quantidade,preco) 
  values ('teste2','teste grande 2','30/04/2017','fundo da loja',3.0000,22.87);

  select * from produto
  -- select CONVERT (DATE,'27-05-1992',103)

  Select Nome as [Nome da Cidade],
         UF as UnidadeFederativa
		 from cidade