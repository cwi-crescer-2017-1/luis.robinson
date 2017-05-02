-- Lista 3
-- 1
select  IDEmpregado,
		NomeEmpregado,
	    DATEDIFF(YEAR,DataNascimento,DataAdmissao) AS Idade
  from empregado 
 where YEAR (DataAdmissao) = 1980


-- 2
Select TOP 1 cargo
  From empregado

-- 3
Select UF,
       count(1)
  from cidade
 group by UF

 -- 4
 insert into departamento (IDDepartamento,NomeDepartamento,Localizacao)
    values (80,'Inovação','São Leopoldo');

Update empregado 
   set IDDepartamento = 80
  where Month(DataAdmissao) = 12
   and Cargo != 'Atendente';


