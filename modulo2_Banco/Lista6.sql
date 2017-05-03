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




