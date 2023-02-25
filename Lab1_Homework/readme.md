1) Pentru validarea argumentului mai intai am verificat sa fi trimis DOAR un singur argument. Apoi cu try si catch am verificat daca argumentul este integer.
2) Pentru Latin Square am urmatorii pasi:
  - pentru primul rand din matrice, am pus pe pozitia A[0][j] = j+1
  - apoi am continuat cu randurile urmatoare astfel, pentru fiecare pozitie am pus valoarea celulei de pe randul anterior, dar shiftata cu o pozitie: A[i][j] = A[i-1][(j+1)%n]
3) Pentru concatenarea simbolurilor de pe fiecare coloana/linie:
  - pt fiecare linie am un string (pe care il golesc la fiecare iteratie a randului) la care concatenez fiecare celula de pe randul respectiv, iar la finalul liniei afisez
  - similar pt coloane
4) Pentru cazurile in care am un n>=30000 declar o variabila la inceputul programului "startTime" care memoreaza timpul la care ne aflam in milisecunde. 
   Apoi, inainte de afisare pe fiecare linie/coloana verific valoarea n-ului; daca este >=30000 atunci adaug o variabila "endTime" care memoreaza timpul curent dupa executia
   codului si fac diferenta dintre cele 2 pentru a afla runtime-ul final.
