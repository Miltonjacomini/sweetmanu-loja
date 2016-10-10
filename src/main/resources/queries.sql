insert into usuario (email,senha) values ('sweetmanu@sweetmanu.com.br' , '$2a$12$DaTmNCa.oa4VRzeJT8H90ephiBsLy9sktyE2NKOfTk4Jvi5F/vfJe'); -- Senha (123456)
insert into role (nome) values ('ROLE_ADMIN');
insert into usuario_role (usuario_email,permissoes_nome) values ('miltonjacomini@gmail.com' , 'ROLE_ADMIN');