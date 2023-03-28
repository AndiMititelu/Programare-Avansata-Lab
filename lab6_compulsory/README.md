1) Clasa MainFrame contine ca atribute un ConfigPanel, un ControlPanel si un DrawingPanel. Ca metoda principala am un initializer care: seteaza operatia de inchidere
   a ferestrei grafice atunci cand dam exit, initializeaza config panelul si il adauga in partea de sus a ecranului, initializeaza drawing panelul si il adauga in centru
   si la fel adauga un control panel in partea de jos a ecranului.
2) Clasa ConfigPanel contine frame-ul, 2 labeluri pentru numarul de puncte si probabilitatea liniilor, un obiect JSpinner care ne va ajuta sa selectam line probability-ul,
   un obiect JComboBox<Double> care va da o lista de tip drop-down cu valori double pentru line probability si un JButton care va permite utilizatorului sa lanseze aplicatia.
   In metoda principala init() am instantiat obiectele de mai sus, iar pentru obiectul JButton am adaugat si un actionListener unde voi crea un canvas si voi seta
   numarul de puncte si probabilitatea muchiilor.
3) Clasa DrawingPanel contine frame-ul, rezolutia, nr de puncte si probabilitatea muchiilor. Initializam canvas-ul prin setarea rezolutiei si a marginii. Ca metode 
   mai am settere pentru nr de puncte si probabilitatea muchiilor. Pentru a desena corespunzator am dat override la paintComponent unde am creat punctele si muchiile pe ecran
   cu ajutorul functiilor gasite pe "Slides".
4) In clasa ControlPanel am adaugat butoanele de Load, Save, Exit si Reset care inca nu sunt functionale
