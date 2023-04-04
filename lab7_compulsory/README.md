1) Am creat o clasa Token care are un constructor unde este initializat cu un integer, un getter si un override la toString() pentru o afisare mai eficienta.
2) Clasa Cell contine 2 atribute: o lista de tokensi si un boolean pe care il vom folosi sa marcam celula ca vizitata sau nu.
3) Clasa ExplorationMap are ca atribut o matrice de celule. In constructor initializez matricea si creez o lista de tokeni cu n^3 integeri la care ii dau shuffle si
   adaug tokensii in celule. Pentru metoda visit dau ca parametrii linia, coloana si robotul cu care voi vizita celula respectiva si voi verifica daca este sau nu vizitata. daca nu este vizitata extrag tokenii, o marchez ca vizitata si returnez true.
4) Clasa Robot contine un nume, un flag ca sa vedem daca robotul mai are de explorat, si un atribut de tip Random cu care vom alege ce celula urmeaza sa viziteze robotul.
5) Clasa Exploration are o harta si o lista de roboti. De asemenea creeaza cate un thread pentru fiecare robot.
