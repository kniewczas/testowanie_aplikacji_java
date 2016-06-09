Czynności wymagane do uruchomienia projektu:

1. Uruchomić trzy okna terminala i w każdym z nich przejść do katalogu projektu i już go nie zmieniać (bardzo ważne)!

2. Terminal1: Uruchomienie serwera bazy danych
 > ./scripts/runHSQLDBServer.bat

3. Terminal2: Uruchomienie klienta bazy danych
 > ./scripts/runHSQLDBClient.bat

4. Terminal3: Uruchomienie serwera webowego z usługą RESTową
 >  mvn jetty:run

5. Uruchomić przeglądarkę (lub innego klienta http) i sprawdzić czy serwis działa:
http://localhost:8080/restservicedemo/api/person/test
Spodziewany rezultat: 
"REST Service is running"

6. W terminalu z klientem bazy danych po wykonaniu View->Refresh Tree powinna pojawić się tabela PUBLIC.PERSON
Dodać klienta poleceniem INSERT (prawy klik na tabeli daje szablon do INSERTa), zapamiętać jego ID

7. Z przeglądarki (lub innego klienta http) 
http://localhost:8080/restservicedemo/api/person/{ID}
powinniśmy otrzymać Osobę w formacie JSON, taką jak dodaliśmy do bazy

