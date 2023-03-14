1) Clasa Student implementata are ca atribute un String pentru nume si o lista de obiecte Project pe care le prefera. Ca metode am settere si gettere pentru 
   nume si proiecte. Am dat override si la metoda compareTo() unde studentii sunt comparati dupa nume.
2) Clasa Project are doar ca atribut numele proiectului si o implementare similara ca la Student.
3) In main m-am folosit stream-uri pentru a crea obiecte de tip Student si Project mai eficient. Intr-o lista de studenti am salvat obiectele Student create ca apoi 
   sa le sortez alfabetic cu metoda sort() si o functie lambda in care folosesc metoda suprascrisa compareTo(). Pentru obiectele Project am folosit un TreeSet care imi 
   asigura ordinea proiectelor.
