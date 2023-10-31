<h3 align="center">Gestiunea unui magazin</h3>
<p align="center">Proiectul reprezinta gestiunea unui magazincare are doua tipuri de produse, jocuri si carti.</p>

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
//aici vine diagrama UML
[![Product Name Screen Shot][product-screenshot]](https://example.com)

La inceperea programului, va aparea fereastra Start, de unde utilizatorul va alege ce doreste sa vizioneze, Inventarul sau Gestiune Comenzi. Dand click pe butoane, se va afisa fereastra de Inventar respectiv Gestiune. 
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- DESCRIERE DETALIATA-->
## Desciere deliata
### Pachet gestiune
<h4 align="center">Pachet gestiune</h4>
<h5 align="left">Comanda</h5>
Aceasta clasa abstracta serveste ca si schelet pentru obiectele de tip comanda si face posibila adugarea si eliminarea produselor din comanda, calculul preturilor, obtinerea informatiilor despre comanda.
<h5 align="left">ComandaIesita</h5>
Clasa ComandaIesita extinde clasa Comanda, implementeaza metodele din clasa Comanda. Clasa este utilizata pentru a gestiona comenzile care ies din sistem si furnizeaza informatii despre acestea.
<h5 align="left">ComandaIntrata</h5>
Clasa ComandaIntrata extinde clasa Comanda, implementeaza metodele din clasa Comanda. Reprezinta comenzile care intra in sistem de la clienti.
<h5 align="left">ItemComanda</h5>
Aceasta clasa reprezinta un produs din comanda. Contine informatii despre produs: cantitate, pret.
<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Pachet inventar
<h4 align="center">Pachet inventar</h4>

<h5 align="left">IProdus</h5>
Clasa IProdus este interfata, care defineste un set de metoda care vor fi implementate de tipurile de produse din sistemul de gestiune. 
<h5 align="left">Carte</h5>
Aceasta clasa care reprezinta un tip de produs, implementeaza inferfata IProdus. Contine informatii despre acest tip de produs, cum ar fi numele, stoc, SKU, pretul.
<h5 align="left">Joc</h5>
Clasa Joc reprezinta un tip de produs, iar aceata clasa implementeaza interfata IProdus. Contine informatii despre acest tip de produs, cum ar fi numele, stoc, SKU, pretul.
<h5 align="left">PretProdus</h5>
Clasa PretProdus gestioneaza informatiile legate de preturile produselor, de exemplu: calculeaza pretul de raft al produselor pe baza pretului de intrare si a TVA-ului tipului de produs(5% carte, 19% joc).

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Pachet exceptii
<h4 align="center">Pachet exceptii</h4>

<h5 align="left">DepozitException</h5>
Clasa DepozitException extinde clasa RuntimeException care este o clasa de exceptii verificate in Java.
<h5 align="left">ComandaException</h5>
clasa ComandaException extinde o alta clasa de exceptii numita DepozitException care gestioneaza operatiile sau erorile legate de comenzi.
<h5 align="left">ProdusDuplicatException</h5>
Clasa ProdusDuplicatException este o subclasa a clasei ComandaException care este o subclasa a DepozitException care extinde clasa RuntimeException. ProdusDuplicateException este utilizat in cazul in care se incearca adaugarea unui produs existent.
<h5 align="left">ProdusInexistentException</h5>
Clasa ProdusInexistentException este o subclasa a clasei ComandaException care este o subclasa a DepozitException care extinde clasa RuntimeException. ProdusInexistentException este utilizat in cazul in care un produs nu exista.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Pachet GUI
<h4 align="center">Pachet GUI</h4>

<h5 align="left">Main</h5>
Main-ul proiectului.
<h5 align="left">DepozitMagazin</h5>
DepozitMagazin este o clasa folosita pentru gestionarea depozitului. Contine doua liste, care returneaza produse, respectiv comenzi.
<h5 align="left">DepozitUtils</h5>
Clasa DepozitUtils contine doua liste, una cu comenzi intrate si celalalta cu comenzi iesite.Contine furnizori/clienti cu comenzi generate random care sunt adaugate la listele aferente.
<h5 align="left">Logger</h5>
Clasa Logger este o clasa de tip Singleton folosita pentru logarea erorilor intr-un fisier.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
