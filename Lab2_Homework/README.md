1) Am inceput prin a sterge enum-urile pentru tipurile de Location si am creat clase care extind clasa Location pentru: City, Airport si Gas Station.
2) Am dat override pentru metoda 'equals' in fiecare dintre subclasele clasei Location si pentru clasa Road astfel: daca obiectul pe care il dam ca argument are 
   toate atributele cu valori identice ca atributele obiectului curent => sunt egale.
3) In clasa 'Problem' am 1 array de Location si 1 array de Roads. Pentru fiecare am facut un setter care primeste un numar variabil de argumente. (de tip Location/Road)
   Parcurg array-urile primite ca argumente si ma asigur sa nu aiba duplicate. Dupa, salvez elementele(!= null) intr-un array auxiliar. Apoi mai creez un array final 
   de size potrivit unde voi avea elementele din array-ul dat ca argument dupa toate check-urile si prelucrarile facute. Acesta va fi atribuit array-ului de Location
   din clasa Problem. Similar implementez si 'setAllRoads'.
4) Mai am 2 metode de addLocation si addRoad, care verifica daca obiectul de tip Location/Road exista deja si il adauga la array-ul potrivit din Problem
5) Am adaugat si gettere pentru array-urile de Location si Road.
6) Metoda isValid() cauta in ambele array-uri din Problem duplicate.
7) Am adaugat si doc comments si am generat documentarea folosind javadoc: "javadoc -d docs src/*.java"
