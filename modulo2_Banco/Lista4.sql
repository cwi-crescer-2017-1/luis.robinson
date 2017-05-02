-- Lista 4
-- 1
select	projeto as [Projetos atrasados],
		datediff(month, data_inicio_prev, data_fim_prev) as previsao, 
		datediff(month, data_inicio_real, data_fim_real) as realizado
from licitacao
where data_inicio_real > data_inicio_prev;

-- 2
select  top 10	empresa_licitante,
						sum(valor_realizado) as TotalFaturamento,
						sum(valor_realizado)/sum(profissionais) as valorMedio
						
from licitacao
group by empresa_licitante
order by totalFaturamento desc;

-- 3
select top 10 municipio,
		   sum(imposto_municipal) as imposto
from licitacao
group by municipio
order by imposto desc;

-- 4
select projeto
from licitacao
-- sábado e domingo (1,7)
where DATEPART(DW, data_inicio_real) in (1,7);

-- 5
select empresa_licitante
from licitacao 
group by empresa_licitante, faturamento_1ano_anterior
having faturamento_1ano_anterior * 0.5 < sum(valor_previsto) 
order by empresa_licitante asc;

-- 6
select projeto, 
      custoreal  = case esfera 
        		  when 'Federal'   then valor_realizado - imposto_federal
				  when 'Estadual'  then valor_realizado - imposto_estadual
				  when 'Municipal' then valor_realizado - imposto_municipal
				  end 
from licitacao;

-- 7
select	empresa_licitante, 
		convert(numeric(10,2), faturamento_1ano_anterior - faturamento_2ano_anterior) as diferencaFaturamento, 
		faturamento_1ano_anterior as faturamento_1ano,
		faturamento_2ano_anterior as faturamento_2ano,
		valor_previsto 
from licitacao 
where identificador='17255';
-- Explicação :
-- O faturamento do 2º ano foi muito superior ao do primeiro ano
-- Ambos os faturamentos são muito maiores que o valor previsto

select * from licitacao

