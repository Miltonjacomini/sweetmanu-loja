insert into role (nome) values ('ROLE_ADMIN');
insert into usuario (email,senha) values ('sweetmanu@sweetmanu.com.br' , '$2a$12$DaTmNCa.oa4VRzeJT8H90ephiBsLy9sktyE2NKOfTk4Jvi5F/vfJe'); -- Senha (123456)
insert into usuario_role (usuario_email,permissoes_nome) values ('sweetmanu@sweetmanu.com.br' , 'ROLE_ADMIN');

insert into role (nome) values ('ROLE_CLIENTE');
insert into usuario (email,senha) values ('cliente@sweetmanu.com.br' , '$2a$12$DaTmNCa.oa4VRzeJT8H90ephiBsLy9sktyE2NKOfTk4Jvi5F/vfJe'); -- Senha (123456)
insert into usuario_role (usuario_email,permissoes_nome) values ('cliente@sweetmanu.com.br' , 'ROLE_CLIENTE');