/* TABLE veiculo */
CREATE TABLE public.veiculo (
    id number(38,0) IDENTITY NOT NULL,
	dthrCriacao timestamp(6),
	codUserCriacao varchar(20),
	dthrUltimaAtualizacao timestamp(6),
	codUserUltimaAtualizacao varchar(20),
    version number(38,0) NOT NULL,
	codigo varchar(10) NOT NULL,
	descricao varchar(80) NOT NULL,
    fatorMultiplicador number(10,2) NOT NULL,
    limiteTonelada number(38,0) NOT NULL,
    custoKmViaPav number(10,2) NOT NULL,
    custoKmViaNaoPav number(10,2) NOT NULL,
    custoKmExcessoTon number(10,2) NOT NULL,
    CONSTRAINT pk_veiculo PRIMARY KEY (id)
);

INSERT INTO public.veiculo (dthrCriacao, codUserCriacao, dthrUltimaAtualizacao, codUserUltimaAtualizacao, version, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon)
VALUES (null, null, null, null, 0, '01', 'Veículo urbano de carga (VUC)', (1.00), (5), (0.63), (0.72), (0.03));

INSERT INTO public.veiculo (dthrCriacao, codUserCriacao, dthrUltimaAtualizacao, codUserUltimaAtualizacao, version, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon)
VALUES (null, null, null, null, 0, '02', 'Caminhão 3/4', (1.05), (5), (0.63), (0.72), (0.03));

INSERT INTO public.veiculo (dthrCriacao, codUserCriacao, dthrUltimaAtualizacao, codUserUltimaAtualizacao, version, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon)
VALUES (null, null, null, null, 0, '03', 'Caminhão toco', (1.08), (5), (0.63), (0.72), (0.03));

INSERT INTO public.veiculo (dthrCriacao, codUserCriacao, dthrUltimaAtualizacao, codUserUltimaAtualizacao, version, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon)
VALUES (null, null, null, null, 0, '04', 'Carreta simples', (1.13), (5), (0.63), (0.72), (0.03));

INSERT INTO public.veiculo (dthrCriacao, codUserCriacao, dthrUltimaAtualizacao, codUserUltimaAtualizacao, version, codigo, descricao, fatorMultiplicador, limiteTonelada, custoKmViaPav, custoKmViaNaoPav, custoKmExcessoTon)
VALUES (null, null, null, null, 0, '05', 'Carreta eixo estendido', (1.19), (5), (0.63), (0.72), (0.03));