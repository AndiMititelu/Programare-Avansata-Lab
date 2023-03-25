1) Pentru a reprezenta comenzile implementate la partea de compulsory ca si clase, am creat 2 interfete Command1 si Command2, fiecare cu o metoda execute()
   care ia un parametru sau doi.
2) Pentru comanda list am creat o clasa ListCommand care implemeneteaza interfata Command1 facand override la execute() astfel: printeaza pe ecran documentele din
   obiectul tip Catalog primit ca parametru
3) Pentru comanda view am creat o clasa ViewCommand care implementeaza interfata Command1 facand override astfel: se creeaza un new File cu locatia obtinuta
   de la documentul primit ca parametru, apoi folosesc metoda getDesktop() pentru a deschide documentul cu adresa file-ului respectiv
4) Pentru comanda add am o clasa AddCommand care implementeaza interfata Command2 facand override astfel: salvez documentele deja existente in catalogul primit ca
   parametru intr-o variabila, la care adaug documentul primit ca al parametru; la final setez documentele din catalog ca fiind variabila prelucrata local.
5) Pentru comanda save am dat override la functia din Command2, unde cu un obiect ObjectMapper dau write catalogului primit ca parametru, iar path-ul este un String
   primit ca al doilea parametru. 
