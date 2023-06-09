Pentru realizarea bot-ului am folosit JDA (Java Discord API).

Am creat un server de discord si de pe Discord Developer Portal am configurat bot-ul pentru serverul respectiv. Comenzile lui principale sunt crearea 
de evenimente. 
Comanda principala "/event" trimisa de user va deschide o conversatie in DM cu bot-ul unde acesta va colecta informatii precum subiectul, locatia, data, 
un thumbnail si alte informatii care vor fi stocate intr-o baza de date Postgres, folosind JPA. La finalul conversatiei cu bot-ul se va crea un eveniment pe 
server-ul de discord unde membrii vor fi notificati si vor putea vota daca pot participa sau nu.
Comanda "/edit" ne permite sa editam/updatam un event deja creat.
