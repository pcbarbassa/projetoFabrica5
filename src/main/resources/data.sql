INSERT INTO "cliente" (id, nome, cpf_cnpj, dt_nascimento, email, endereco, identidade) VALUES
  (99999, 'Paulo3 Barbassa', '111.111.111-11', '1980-11-14', 'pcbarbassa@gmail.com', 'Rua das Uvas, 1234, Setor do Mar', '55555555-8'),
  (99998, 'Diogo2 Leal', '222.222.222-22', '1990-11-14', 'email2@gmail.com', 'Rua das Peras, 1234, Setor da Praia', '444444-8'),
  (99997, 'Antonio1 Abelardo', '333.333.333-33', '1970-11-14', 'email3@gmail.com', 'Rua das Laranjas, 1234, Setor dos Rios', '6666666-8');
  
INSERT INTO "tipo_prestador" (id, desativado, descricao) VALUES 
(99991, false, 'Pintor'),
(99992, false, 'Eletricista'),
(99993, false, 'Encanador'),
(99994, false, 'Pedreiro'),
(99995, false, 'Jardineiro'); 
  
INSERT INTO "prestador" (id, agencia, cod_banco, conta, cpf_cnpj, dt_nascimento, email, endereco, identidade, nome, tipo_prestador_id) VALUES
(99991, '0001', '0001', '0001', '111.111.111-11', '1925-11-14', 'email1@email.com','Rua das Mangas', '111111-11', 'Prestador Fulano 1',99991),
(99992, '0002', '0002', '0001', '222.111.111-11', '1926-11-14', 'email2@email.com','Rua das Uvas', '222222-11', 'Prestador Ciclano 2',99992),
(99993, '0003', '0003', '0003', '333.111.111-11', '1927-11-14', 'email3@email.com','Rua das Laranjas', '3333333-11', 'Prestador Beltrano 3',99991),
(99994, '0004', '0004', '0004', '444.111.111-11', '1928-11-14', 'email4@email.com','Rua das Caixas', '444444-11', 'Prestador Zutano 4',99993),
(99995, '0005', '0005', '0005', '555.111.111-11', '1929-11-14', 'email5@email.com','Rua dos Cubos', '5555555-11', 'Prestador Alano 5',99993);
