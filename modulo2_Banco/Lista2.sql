-- 1
 Select idEmpregado, nomeEmpregado
 from empregado
 order by DataAdmissao

 ;
 -- 2
 Select nomeEmpregado 
 from empregado
 where comissao is null
 order by salario

 -- 3 
 Select idempregado,
		nomeEmpregado, 
        (salario*13) as SalarioAnual,
		(Comissao*12) as Comissao,
		(Salario*13 + Comissao*12) as RendaAnual		
	From Empregado

-- 4 
 Select idempregado,
		nomeempregado,
		Cargo,
		Salario
	from empregado
	where salario*12 < 18500.00 or cargo = 'Atendente'
		 