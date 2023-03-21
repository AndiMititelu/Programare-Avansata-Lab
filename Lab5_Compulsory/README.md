1) Clasa Document am creat-o in felul urmator: ca atribute am String-uri pentru id, nume, location of the file si un Map pentru taguri. Am 2 constructori, unul 
   unde specific id-ul, numele si locatia si un constructor default pentru load-ul unui catalog(catalogul contine o lista de documente) dintr-un fisier json.
   Am creat settere si gettere pentru toate variabilele si am dat override la metoda toString() pentru a ma ajuta sa afizec mai bine obiectele de tip Document.
2) In clasa Catalog am un nume si o lista de documente. Ca mai sus am 2 constructori, unul specific si unul default care ma va ajuta la metoda load(), plus 
   settere si gettere pentru cele 2 atribute si metoda add() unde adaug documente la lista. Am dat override la toString() si cu ajutorul override-ului aceleasi metode din Document pot afisa mai clar
   catalogul cu documentele sale.
3) Metodele save() si load() le-am implementat intr-o clasa separata CatalogUtil. Ca atribut am un obiect ObjectMapper (din libraria Jackson) de tipul static final 
   (am folosit static pentru a nu trebui sa declar o instanta a clasei CatalogUtil si final pentru ca variabila sa nu-si modifice valoarea). 
4) In main am exemplificat cum functioneaza problema. Am adaugat 2 obiecte Document intr-un catalog dupa care i-am dat save ca format json, i-am dat load si am comparat
   afisarile before and after.
