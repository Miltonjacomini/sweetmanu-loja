#Loja de encomendas - Sweetmanu :)
**Projeto de uma loja online para encomendas**
**(utilize a vontade, se tiver sugestões de melhoras envie para mim por favor, valeu!)**



##Estrutura do projeto
- Java 1.8 SDK
- J2EE
- Servlets, JSP e JSTL
- JPA e Hibernate
- Heroku Cloud
- SendGrid p/ envio de e-mails pelo Heroku
- Amazon S3 Cloud (Armazenamento dos arquivos)

##Contratante do serviço
Empresa de gastronomia gourmet e saudável **SweetManu**

##Foco do projeto
Este sistema foi desenvolvido com o intuito de sanar os problemas enfrentados pelo cliente sendo eles:
- Falta de um cardápio dinâmico
- União dos contatos de encomendas em um só lugar
- Lista organizada dos clientes
- Melhorar interação com o cliente e a entrega do produto


##Informações para o setup

**Banco de dados - ** [JPAConfiguration.java](https://github.com/Miltonjacomini/sweetmanu-loja/blob/master/src/main/java/br/com/sweetmanu/config/JPAConfiguration.java)
```
Os dados para configuração devem ser alterados: 
- linhas 57 à 52, metodo: dataSource()
// Lá encontrará configuração do Heroku e para ambiente de testes
```

**AppWebConfiguration - ** [AppWebConfiguration.java](https://github.com/Miltonjacomini/sweetmanu-loja/blob/master/src/main/java/br/com/sweetmanu/config/AppWebConfiguration.java)
```
Os dados para configuração devem ser alterados:   

- linhas 82 à 85, metodo: credentials() 
// Configuração das variaveis de ambiente com usurio e senha do Amazon, 
lembrete importante!! Não deixem o usuário e senha expostos nessa classe pois você pode
commitar por engano... não sei quem fez isso mas só uma dica... rs //

- linhas 93 à 108, metodo: javaMailSenderImpl()
// Aqui a configuração somente mudará se você for utilziar algo foda do SendGrid e Heroku senão 
está okay..//
```

