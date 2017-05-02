-- inner join -- join de informação obrigatória
-- left join, tabelas a esquerda mostram informações, mesmo que seja null ao fazer o join.
-- cidade c left join cidade c
-- union união de tabelas
-- union all união de tabelas, com os registros duplicados.

-- Lista 5
-- 1
Select emp.NomeEmpregado,
	   ger.NomeEmpregado as nomegerente,
		dep.nomedepartamento
  from empregado emp
  inner join empregado ger on emp.IDGerente = ger.IDEmpregado 
  inner join departamento dep on emp.iddepartamento = dep.iddepartamento; 

  -- 2
  Select top(1) dep.iddepartamento,
		 dep.nomeDepartamento,
		 max (emp.salario) as salario
	from departamento dep
	inner join empregado emp on emp.iddepartamento = dep.iddepartamento
	group by dep.iddepartamento,
			 dep.nomeDepartamento
	order by salario desc;

  -- 3
  select emp.nomeEmpregado
  from departamento dep
  inner join empregado emp on emp.iddepartamento = dep.iddepartamento
  where dep.localizacao = 'SAO PAULO'

  select * 
    into empregado_backup
	from empregado

  update emp
    set emp.salario = salario * 1.173
	from empregado emp	
  where  exists (select 1
				 from departamento dep
                where emp.iddepartamento = dep.iddepartamento
                  and dep.localizacao = 'SAO PAULO')

	-- 4
	Select cid.* 
	 from cidade Cid
	 inner join cidade uf on uf.idCidade != cid.idCidade
	 and uf.nome = cid.nome
	 and uf.uf = cid.uf
	order by cid.nome

	-- 5
	Select cid.* ,
			max(cid.idcidade)
	 from cidade Cid
	 inner join cidade uf on uf.idCidade != cid.idCidade
	 and uf.nome = cid.nome
	 and uf.uf = cid.uf
	 group by cid.idcidade
	order by cid.nome

	begin transaction
	update cid
	set cid.nome = cid.nome + '*'
	from cidade cid
	inner join cidade uf on uf.idCidade != cid.idCidade
	 and uf.nome = cid.nome
	 and uf.uf = cid.uf
	 where cid.idcidade > uf.idcidade

	 