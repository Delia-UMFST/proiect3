<h3 align="center">Gestiunea unui magazin</h3>
<p align="center">Proiectul reprezinta gestiunea unui magazin care are doua tipuri de produse, jocuri si carti.</p>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Continut</summary>
  <ol>
    <li><a href="#about-the-project">Despre proiect</a>
    <li><a href="#descriere-detaliata">Descriere detaliata</a>
      <ol>
    <li><a href="#pachet-gestiune">Pachet gestiune</a>
    <li><a href="#pachet-inventar">Pachet inventar</a>
    <li><a href="#pachet-exceptii">Pachet exceptii</a>
    <li><a href="#pachet-inventar">Pachet GUI</a>
      </ol>
    </li>
  </ol>
</details>

<!-- DESPRE PROIECT -->
## Despre proiect

La inceperea programului, va aparea fereastra Start, de unde utilizatorul va alege ce doreste sa afiseze, Inventarul sau Gestiunea Comenzilor. Dand click pe butoane, se va afisa fereastra de Inventar respectiv Gestiune. 
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- DESCRIERE DETALIATA-->
## Desciere deliata

### Pachet proiect3
<h4 align="centre">Pachet proiect3</h4>

<img src="Diagrama GUI 2.png" alt="Diagrama GUI 2" title="Diagrama GUI 2">

<h5 align="left">Main</h5>
Main-ul proiectului.
<h5 align="left">DepozitMagazin</h5>
DepozitMagazin este o clasa folosita pentru gestionarea depozitului. Contine doua liste, care contin produse, respectiv comenzi.
<h5 align="left">DepozitUtils</h5>
Clasa DepozitUtils contine doua metode pentru demonstrarea functionalitatii aplicatiei, una care initializeaza o lista de comenzi intrate si celalalta care initializeaza o lista de comenzi iesite, cu cantitati aleatorii ale produselor din comenzi.
<h5 align="left">Logger</h5>
Clasa Logger este o clasa de tip Singleton folosita pentru logarea evenimentelor intr-un fisier.

### Pachet gestiune
<h4 align="center">Pachet gestiune</h4>

<img src="Diagrama Gestiune.png" alt="Diagrama Gestiune" title="Diagrama Gestiune">

<h5 align="left">Comanda</h5>
Aceasta clasa abstracta serveste ca si schelet pentru obiectele de tip comanda si face posibila adugarea si eliminarea produselor din comanda, calculul preturilor, obtinerea informatiilor despre comanda.
<h5 align="left">ComandaIesita</h5>
Clasa ComandaIesita extinde clasa Comanda, implementeaza metodele abstracte din clasa Comanda. Clasa este utilizata pentru a gestiona comenzile care ies din sistem si furnizeaza informatii despre acestea.
<h5 align="left">ComandaIntrata</h5>
Clasa ComandaIntrata extinde clasa Comanda, implementeaza metodele abstracte din clasa Comanda. Reprezinta comenzile care intra in sistem de la clienti.
<h5 align="left">ItemComanda</h5>
Aceasta clasa reprezinta un item din comanda. Contine informatii despre produsul comandat, cantitatea comnadata, si pret.
<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Pachet inventar
<h4 align="center">Pachet inventar</h4>

<img src="Diagrama Inventar.png" alt="Diagrama Inventar" title="Diagrama Inventar">


<h5 align="left">IProdus</h5>
IProdus este interfata, care defineste un set de metoda care vor fi implementate de tipurile de produse din sistemul de gestiune. 
<h5 align="left">Carte</h5>
Aceasta clasa care reprezinta un tip de produs, implementeaza inferfata IProdus. Contine informatii despre acest tip de produs, cum ar fi numele, stoc, SKU, pretul.
<h5 align="left">Joc</h5>
Clasa Joc reprezinta un tip de produs, iar aceata clasa implementeaza interfata IProdus. Contine informatii despre acest tip de produs, cum ar fi numele, stoc, SKU, pretul.
<h5 align="left">PretProdus</h5>
Clasa PretProdus gestioneaza informatiile legate de preturile produselor, de exemplu: calculeaza pretul de raft al produselor pe baza pretului de intrare si a TVA-ului tipului de produs(5% carte, 19% joc).

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Pachet exceptii
<h4 align="center">Pachet exceptii</h4>

<img src="Diagrama Exceptii.jpg" alt="Diagrama Exceptii" title="Diagrama Exceptii">

<h5 align="left">DepozitException</h5>
Clasa DepozitException extinde clasa RuntimeException care este o clasa de exceptii verificate in Java.
<h5 align="left">ComandaException</h5>
clasa ComandaException extinde clasa de exceptii DepozitException care este aruncata in cazul erorilor legate de comenzi.
<h5 align="left">ProdusDuplicatException</h5>
Clasa ProdusDuplicatException este o subclasa a clasei ComandaException care este o subclasa a DepozitException care extinde clasa RuntimeException. ProdusDuplicateException este utilizat in cazul in care se incearca adaugarea unui produs deja existent.
<h5 align="left">ProdusInexistentException</h5>
Clasa ProdusInexistentException este o subclasa a clasei ComandaException care este o subclasa a DepozitException care extinde clasa RuntimeException. ProdusInexistentException este utilizat in cazul in care un produs nu exista.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Pachet GUI
<h4 align="center">Pachet GUI</h4>

<img src="Diagrama GUI.png" alt="Diagrama GUI" title="Diagrama GUI">

<h5 align="left">AddProduseWindow</h5>
Fereastra modala pentru adaugarea de produse la o comanda.
<h5 align="left">GestiuneComenzi</h5>
Clasa GestiuneComenzi este fereastra principala care se va ocupa de gestionarea comenzilor intrate si iesite.
<h5 align="left">Inventar</h5>
Clasa Inventar se ocupa cu inventarul produselor, aici se pot adauga produse noi pe inventar, modifica stocul produselor, pretul lor, adaugare discount. 
<h5 align="left">Start</h5>
Clasa Start este pentru afisarea ferestrei de start, din care utilizatorul va putea alege ce fereastra doreste sa vada in continuare: inventar sau gestiune.
<h5 align="left">StergereProduseWindow</h5>
Clasa este folosita pentru a afisa o noua fereastra in care se poate alege ce produs dorim sa stergem dintr-o comanda selectata.




<p align="right">(<a href="#readme-top">back to top</a>)</p>
