1) Clasa Road: avem nevoie de atribute pentru tipul drumului (care va fi un 'enum'), lungimea, limita de viteza si cele 2 locatii pe care le conecteaza
  - am un constructor care va initializa toate aceste atribute, cu 2 conditii: limita de viteza > 0 si lungimea drumului sa NU fie mai mica decat distanta
    euclidiana dintre coordonatele celor 2 locatii
  - am adaugat settere/gettere pt fiecare atribut
  - am dat override la metoda toString() pentru a avea o afisare mai intuitiva a obiectelor de tip Road

2) Clasa Location: avem nevoie de atribute pentru numele locatiei, tipul (tot de tip 'enum') si coordonatele x si y care ne indica pozitia
  - implementarea e similara ca la clasa Road, doar ca fara acele conditii pentru constructor

In main am creat 2 obiecte Location si 1 obiect Road care ar conecta cele 2 locatii si le-am afisat folosindu-ma de metoda toString() la care i-am dat override 
pt fiecare clasa.
