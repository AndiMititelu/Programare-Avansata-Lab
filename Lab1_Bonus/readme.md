1) Cycle graph:
  - pentru exercitiul asta am realizat doar matricea de adiacenta;
  - avand un cycle graph se contruieste in felul urmator: fiecare nod este adiacent cu nodul precedent si cu succesorul sau; pentru a ne asigura ca indecsii sunt
    in range-ul [1, n], facem un modulo n pentru succesor: "(i+1)%n", iar pentru nodul predecesor avem "(i+n-1)%n" pentru a include cazul cand suntem pe primul nod iar
    acesta este conectat cu nodul de pe ultima pozitie

2) Regular graph:
  - regular graph <=> graf unde fiecare nod are acelasi grad
  - mergem pe fiecare nod i in parte si marcam k(k=grad_nod) noduri ca fiind vecini astfel: marcam nodurile de pe pozitiile (i+j)%n, astfel ne asiguram ca
    marcam noduri de pe indecsi care sunt in range si pastram si simetria grafului (graful este neorientat)
  - la final, inainte de afisare, verificam ca suma de pe fiecare linie din matrice sa corespunda cu gradul nodului
