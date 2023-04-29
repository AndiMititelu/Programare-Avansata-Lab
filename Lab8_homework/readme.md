1) In plus fata de compulsory am terminat clasele pentru Artist si Genre impreuna cu clasele DAO respective
2) Am adaugat o clasa DatabaseConnectionPool unde am folosti c3p0 ca tool pentru a avea un connection pool
3) In clasa AlbumImporter, cu ajutorul CSVReader am citit fisierul .csv de pe haggle pentru albume. Fisierul se poate gasi in folderul resources alaturi de fisierul .properties pentru a configura conexiunea cu c3p0.
   Am citit fiecare linie din fisierul .csv, apoi am salvat datele importante pentru album in variabile si am construit un nou album pe care ulterior l-am adaugat in baza de date
