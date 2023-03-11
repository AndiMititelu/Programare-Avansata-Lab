1) Din clasa Person am extins clasele Programmer si Designer la care am adaugat cate un atribut specific fiecareia ('language' si 'speciality'). In plus am facut
   override si la metoda 'toString' pentru a avea o afisare mai intuitiva.
2) Pentru clasa Person am adaugat un map care va avea valoare un string care specifica tipul relatiei: 'friend' si 'employee' si un key de tip Node
3) In clasa Network am ca atribute o lista de noduri si un map care contine relatiile.
   - pentru a obtine importanta unui nod (nr de conexiuni) primit ca parametru, parcurg lista de noduri si verific sa vad de ce tip sunt nodurile comparate
     pentru a cauta in map-ul din Person/Company daca exista acea conexiune
   - pentru a sorta nodurile dupa nr de conexiuni ma folosesc de functia 'sort' si un lambda expression convenabil
4) La final in 'main' adaug scenarii si pentru afisare parcurg nodurile din network sortate dupa importanta
