1) Am creat o clasa Problem care contine o lista de obiecte Student si un set de obiecte Project. Pentru ambele colectii am facut settere si gettere. 
2) In Main m-am folosit de Java Stream pentru a gasi studentii cu un numar de preferinte mai mic decat media. Pentru inceput am calculat media numarului
   de preferinte, m-am folosit de metoda mapToInt() unde memorez size-ul proiectelor preferate pentru fiecare student, apoi de metoda average() pentru a face media.
   In urmatorul query am utilizat metoda filter() care filtra studetii cu nr mai mic de preferinte decat media, apoi am aplicat metoda map() cu care obtineam
   numele studentilor returnati de filter(), apoi pentru fiecare (forEach) am dat un println.
3) Cu ajutorul Java-Faker (am completat in fisierul pom.xml cu codul necesar pentru a ma folosi de biblioteca) am generat nume random pentru fiecare student si proiect.
4) In clasa Problem am adaugat o metoda care imi rezolva problema maximum cardinality matching folosind un approach greedy. Am parcurs fiecare student si lista de 
   proiecte admissible pentru el, am verificat daca studentul sau proiectul au mai fost atribuite, iar daca nu ii adaug intr-un map unde salvez toate matchingurile.
   Algoritmul calculeaza un optim local, dar nu garanteaza solutia optima la nivel global. 
