1) In clasa singleton Database am 3 metode pentru conexiunea la o baza de date postgres: create, get si close. De asemenea am ales sa am si o metoda createtables unde 
am scris scripturile pentru crearea tabelelor.
2) In clasa AlbumDAO, in metoda create adaug entry-uri in tabelul albums, ulterior mai am metode de findBy unde caut in tabela albume in functie de release_year, titlu, gen, etc
si returnez lista de entryuri gasite.
3) Am facut si o clasa Album ca sa pot returna obiecte de tip album in findBy-urile de la clasa DAO
4) Pentru a testa am folosit JUnit si am creat o clasa separata AlbumDAOTest.
