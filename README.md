# Gestao-Estetica-API  - Backend
## Configurações:<br/><br/>
`Open-JDK-11` <br>
`Maven Version 3.6.3` (Wrapper incluído no projeto)<br>
`Spring - 2.5.5` <br>
`Lombok` (Necessário o plugin, de acordo com sua IDE).

##Banco de dados
`application.properties`<br>
Em: `spring.profiles.active` existe duas variáveis: `prod` e `dev`.
Se escolher a "prod" o banco usado pela aplicação será um postgresql,
já está configurado para criar as tabelas automaticamente.
Caso prefirá subir um container com a database configurada de acordo
 com o properties do postgresql:
<br>
<br>
`docker run --name bd-postgre -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123 -e POSTGRES_DB=projeto-pi -p 5432:5432 -d postgres`

O profile "dev" utiliza um um banco H2 em memoria, tudo será apagado caso 
a aplicação sejá encerrada. Caso queira manipular dados em sql no H2, basta
acessar a seguinte url no navegador:<br> 

`localhost:8080/h2-console` senha 123.

Para editar as configurações de cada banco basta acessar os arquivos (pasta resources): <br>
`application-prod.properties` para postgresql. <br>
`aplication-dev-properties` para h2. <br>



