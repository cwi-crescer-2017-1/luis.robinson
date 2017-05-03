-- Lista 6
-- 1
select top(1) LEFT([Nome],CHARINDEX(' ',[Nome] + ' ')-1)  as PrimeiroNome,
  Sum(1) as totalOcorrencias
  from cliente cl
  inner join pedido ped on ped.IDCliente = cl.IDCliente
  group by (LEFT([Nome],CHARINDEX(' ',[Nome] + ' ')-1));
  --order by Count(1)DESC;

-- 2
Select count(ped.IDPedido) as totalPedido,
	   sum(ped.ValorPedido) as valorPedido
from pedido ped
where datepart(Month, ped.Datapedido) = 4 
  AND datepart(Year, ped.DataPedido) = 2017;

-- 3
Select * from(
Select Top(1) Count(cli.IDCidade) as Quantidade,
	   cid.UF
  from cidade cid
 inner join cliente cli on cli.IDCidade = cid.IDCidade   
  group by cid.UF
  order by Quantidade desc ) as tabDesc
  union
  Select * from(
Select Top(1) Count(cli.IDCidade) as Quantidade,
	   cid.UF
  from cidade cid
 inner join cliente cli on cli.IDCidade = cid.IDCidade   
  group by cid.UF
  order by Quantidade asc ) as tabDesc

  -- 4  
  insert into produto (nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao)
   values ('Galocha Maragato',GETDATE(),35.67,77.95,'A')

  -- 5
  Select Distinct(prod.Nome) as prodNome 
	from produto prod
   where not exists (Select 1
					  from pedido ped
					  inner join pedidoitem pedi on pedi.IDPedido = ped.IDPedido					  
					  where pedi.IDProduto = prod.IDProduto )

 -- 6
 
Select top(30) pedi.Quantidade * (prod.PrecoVenda  - prod.PrecoCusto) as lucro, prod.nome
from pedido ped
inner join PedidoItem pedi on pedi.IDPedido = ped.IDPedido
inner join Produto prod on prod.IDProduto = pedi.IDProduto
where datepart(year, ped.Datapedido) = 2016 
order by lucro desc
  
  


