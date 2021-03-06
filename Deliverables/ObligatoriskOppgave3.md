##Obligatorisk oppgave 3
### Deloppgave 1: team og prosjekt 
- Team roller som har blitt tildelt forsetter å fungere stort sett veldig bra.
  De individuelle medlemmene i teamet fyller rollene sine uten store problemer,
  vi ser ingen logisk grunn til å legge til flere roller. Det som har blitt veldig tydelig 
  med bruken av roller er at det viser seg vanskelig og lite effektivt å gi enkelte roller som koder og tester til en person.
  Dette er hovedsakelig grunnet arbeidsmengde som de enkelte rollene må gjennomføre. Roller som teamleader og designer 
  fungerer mye bedre som roller enkelt personer kan ta ansvar for. Så selv om vi har satt opp en rolle for hvert
  medlem av teamet, så blir det mer riktig å se på dette som at medlemmet er hoved-ansvarlig for tildelt rolle.
  Rolle-systemet for oss blir dermed veldig flytende, vi kunne skrevet opp de fleste i gruppen på nesten alle rollene. 
  Vi bestemte oss for å beholde fordelingen av roller slik den er hovedsakelig for å holde struktur, men som nevnt tidligere blir roller sett mer som
  hovedansvaret til medlemmene. Arbeidsmengde, tid individuelle medlemmer har og krav for oppfylling av de forskjellige obligatorsike oppgavene er noe som 
  er i konstant forandring. Å holde rollene felksibel er dermed noe vi ser som essensielt for suksess i dette studentprosjektet. 

  
- Prosjektmetodikkene vi har valgt å fokusere er det vi kanskje er mest fornøyd med. 
  Vårt oppsett av scrum med mindre ukentlige sprints med tre faste møter hver sprint fører til at alle medlem 
  konstant holdes oppdatert på progresjon av prosjektet. Bruken av CodeWithMe og generell sammarbeid med nesten alle 
  oppgavene fører til få feil, god oversikt av alle medlem og konstruktive resultater. Bruk av project-borad har forbedret
  seg men er fortsatt minimalt noe som fungerer bra på grunn av god kommunikastion og konstant tilbakemeldinger. 
  Om prosjektet ville involvert flere personer og/eller vert mer kompleks ville vår bruk av project-board
  ikke vert tilstrekkelig. Bruk av project-board er kanskje den eneste tingen vi mener vi kan forbedre i vår bruk av valgte
  prosjektmetidikker.
  
- Gruppedynamikken har så langt fungert veldig bra. Det er mye kommunikasjon og tilbakemeldinger av de
    individuelle medlemmene. Vi føler at vi har satt opp et godt arbeidsmiljø der alle blir hørt og der ingen er redd for å gi sin mening.
    Arbeidsfordelingen er relativt balansert men må ofte finjusteres basert på tiden til medlemmene og at
    visse oppgaver blir mer langvarig / komplisert en andre. Noe som kan være vanskelig å presist forutse
    ved arbeidsfordeling.

- Kommunikasjon tar vi hovedsakelig gjennom discord der vi har en felles SMED gruppechat. Vi samles i en
  voice call sammen under møtene/arbeidstimer. Utenfor møter/arbeidstimer sender vi meldinger på discord
  i gruppechatten om spørsmål, oppfølging eller generell diskusjon.
  
- Prioritering av oppgaver fremover:
  - Implementasjon av flere objekter på brettet som vegger og rotasjonsrute.
  - Implementere en power-down funksjon.
  - Finpusse brukergrensesnitt.
  - Refaktorere kode.

- Oppfølging av sist retrospektiv forbedringspunkt:
  - Utdyping av rollebeskrivelser, som nevnet tidligere har vi bestemt oss for å holde 
  de tildelte rollene for struktur slev om disse er veldig felksibel.
  - Forbedre commits, vi har vert veldig fornøyd med commits med tanken på commit meldinger og å ungå merge-conflict.
  Fordelig av commits er fremdeles relativt ujevnt grunnet bruk av CodeWithMe og generell sammarbeid som fører til at en commit kan inneholde arbeid av flere medlem.
  Dette er vanskelig å ungå og vi foretrekker å holde godt sammarbeid over balanserte commits. 
  Vi kan gi credit for arbeid på andre måter og balansen av commits kan lett forklares.
  - Bruk av project board, vi har blitt bedre med bruken av project board i forhold til arbeidsfordeling, men vi kan 
  bli berde på å holde det oppdatert utover sprinten.
    
- Retrospektiv: 
  - Fortsatt fornøyd med rollefordeling, metodikk og kommunikasjon.
  - Gruppedynamikken har god flyt og fungerer bra.
- Forbedringspunkter
  - Regelmessig oppdatering av progresjon på project board.
  - Sette opp flere tester av god kvalitet før programmering av arbeidsoppgaven begynner(Test-driven development)



### Deloppgave 2: Krav 
- Alle viste brukerhistorier har blitt implementert og fungerer som ønsket.
- Prioritering av krav:
  - Første prioritet var å lage ferdig en debug modus som lar oss teste spillet og kommende funksjoner
    mer effektivt.
  - Deretter prioriterte vi å få implementert et HP/liv -system ettersom det må være på plass for
    å kunne teste lasere.
  - De resterende kravene ble gjennomført uten en spesifikk prioritering.


#### Brukerhistorier
Transportbånd
- Brukerhistorie:
  - Som spiller skal brikken min bevege seg i retningen pilen på transportbåndet peker. Bevegelsen skal skje etter brikken har gjort en handling.
- Arbeidsoppgave:
  - Legge inn en funksjon i «Board» klassen som sjekker om spilleren står på et transportbånd, hvilken retning transportbåndet peker og flytter spilleren i retningen til transportbåndet.
- Akseptansekriterier:
  - Gitt at spilleren står på et transportbånd så skal:
    - Spilleren bli flyttet en rute i retningen til transportbåndet.

Health Points
- Brukerhistorie:
  - Som spiller skal roboten min ha HP.
- Arbeidsoppgave:
  - Legge inn variabler i «Player» klassen som lagrer nåværende HP og maksimum HP.
- Akseptansekriterier:
  - Gitt at spilleren starter et spill:
    - Spilleren skal ha maks HP
  - Gitt at spilleren mister et liv:
    - Spilleren skal starte med maks HP

Liv 
- Brukerhistorie:
  - Som spiller skal roboten min ha liv.
- Arbeidsoppgave:
  - Legge inn variable i «Player» klassen som lagrer nåværende mengde liv.
- Akseptansekriterier:
  - Gitt at spilleren starter et spill:
    i. Spilleren skal ha n liv
  - Gitt at spilleren har null HP:
    - Spilleren skal miste ett liv
    - Spilleren skal bli flyttet til sitt check point


Fikser rute
- Brukerhistorie:
  - Som spiller skal roboten min få sine livspoeng satt til det den originalt starter med (maks liv), når den beveger seg på en rute med en fikser.
- Arbeidsoppgave:
  - Legge inn en funksjon i «Board» klassen som sjekker om spilleren står på en fikser og setter livet til spilleren til den originalt startet med.
- Akseptansekriterier:
  - Gitt at spilleren står på en fikser så skal:
    - Spilleren få satt sine livspoeng til det den starter med.

Laser
- Brukerhistorie:
  - Som spiller skal roboten min miste et liv når den avslutter en fase på rute med en laser.
- Arbeidsoppgave:
  - Legge inn en funksjon i «Board» klassen som sjekker om spilleren står på en laser rute og redusere livspoenget til spilleren med 1 poeng.
- Akseptansekriterier:
  - Gitt at spilleren avslutter en fase på står på en laser rute så skal:
    - Spilleren miste et livspoeng

Flag
- Brukerhistorie:
  - Som spiller skal roboten min få et checkpoint når den har besøkt et flagg i riktig rekkefølge. I tillegg, hvis roboten min er først til å besøke alle flagg i riktig rekkefølge skal roboten min vinne spillet.
- Arbeidsoppgave:
  - Legge inn en funksjon i «Board» klassen som sjekker om spilleren står på et flagg, og hvor i rekkefølgen dette flagget ligger, og deretter setter nytt checkpoint til spilleren og lar spilleren vinne hvis den har besøkt alle flaggene.
- Akseptansekriterier:
  - Gitt at spilleren besøker neste flagg i rekkefølgen:
    - Få et nytt checkpoint
    - La spilleren få besøke neste flagg
  - Gitt at spilleren besøker et flagg som ikke er neste i rekkefølgen:
    - Ingen ting skal skje
  - Gitt at spilleren besøker det siste flagget i rekkefølgen etter å besøkt de før i riktig rekkefølge:
    - Spilleren skal vinne

Spill meny
- Brukerhistorie:
  - Som spiller vil jeg ha en intuitiv måte å kjøre spillet på og kunne lett navigere gjennom de forskjellige valgmuligheter som påvirker hvilken modus spillet kjører i. Dette skal bli representert grafisk som en spillmeny.
- Arbeidsoppgave:
  - Lage en klasse for hver skjerm og en som samler de og implementere grafikk i hver klasse for så å koble sammen koden fra Main og kunne kjøre spillet kun gjennom menyen.
- Akseptansekriterier:
  - Gitt at brukeren trykker på “Play as client” skal:
    - Brukeren tas videre til en ny skjerm hvor de kan skrive inn ip-adresse og så starte spillet.
    - Brukeren kunne starte spillet i debug mode.
    - Brukeren kunne trykke på “Back” og tas tilbake til hovedmenyen.
  - Gitt at brukeren trykker på ”Play as server” skal:
    - Brukeren kunne starte spillet gjennom “Start”-knappen og vente på at den på klient-siden skal koble seg på.
    - Brukeren kunne starte spillet i debug mode.
    - Brukeren kunne trykke på “Back” og tas tilbake til hovedmenyen.
  - Gitt at brukeren trykker på “Test game” skal:
    - Brukeren kunne starte og teste spillet gjennom å trykke på “Single-step” metoden.
    - Brukeren kunne starte og teste spillet gjennom å trykke på “Round-based” metoden.
    - Brukeren kunne trykke på “Back” og tas tilbake til hovedmenyen.
  - Gitt at brukeren trykker på “Exit” skal:
    - Spillet avsluttes.

Debug mode client/server
- Brukerhistorie:
  - Som tester vil jeg ha en effektiv og enkel måte å teste spillfunksjoner manuelt på.
- Arbeidsoppgaver:
  - Lage en funksjon i klassen “GameLogic”som lar spilleren velge kort uten rng. Deretter, erstatt den vanlige kort velge funksjonen med denne.
- Akseptansekrav:
- Gitt at debug mode er valgt skal:
  - Man kunne bevege seg fritt for å kunne teste mer effektivt.
  
Single step
- Brukerhistorie:
  - Som tester vil jeg kunne bevege meg steg-for-steg for mer effektiv testing av programmet.
- Arbeidsoppgaver:
  - Lag ny funksjoner i GameLogic som lar spilleren bevege seg en handling av gangen. Lage en ny klasse “RenderTesting” som arver fra “RenderServer” og lag nye funksjoner for simulateRound() og keyUp() som kaller på de nye funksjonene i GameLogic.
- Akseptansekrav:
  - Gitt at bruker starter single-step modus skal:
    - Bruker kunne bevege seg med piltastene steg-for-steg for å teste funksjoner i spillet.  
    - Bruker kunne bevege seg med ett og ett kort for å teste funksjoner i spillet.

Round-based
- Brukerhistorie:
  - Som tester vil jeg kunne bevege meg og gjennomføre handlingene i en rundebasert modus.
- Arbeidsoppgaver:
  - Lag ny funksjoner i GameLogic som lar spilleren velge n handlinger før den starter runden. Lage en ny klasse “RenderTesting” som arver fra “RenderServer” og lag nye funksjoner for simulateRound() og keyUp() som kaller på de nye funksjonen i GameLogic.
- Akseptansekrav:
  - Gitt at bruker starter round-based modus skal:
  - Bruker kunne gjøre fem handlinger før de gjennomføres for å teste funksjoner i spillet mens ett runde-system er aktivt.
  
###Bugs:
- Spillere kan bevege seg over hull/flagg uten å avslutte spillet midt i en runde hvis spilleren beveger seg 2 eller 3 felt fremover på en turn.
- Applikasjonsvinduet «fryser» mens den andre spilleren velger kort. Ikke noe problem egentlig.
- Hvis en trykker på et tall på tastaturet høyere enn det er tilgjengelige kort krasjer programmet. For eksempel, det er 8 kort å velge mellom og brukeren trykker på 9.
- Godtar feil input men setter verdi til null. (Et valg utenfor 1-9)
- Knapper i GUI mister posisjon avhenging av operativsystem.
- I runde baserte moduser (Klient/Server, Test game: Round-based) vil kort velge systemet tulle hvis det blir valgt kort for fort.
- Noen ganger oppdateres ikke teksten på skjermen før første fase i neste runde.

### Deloppgave 3: Produktleveranse og kodekvalitet

### Credits
- Ressurser for utseendet av menyen er ikke laget selv. 
- GlassyUI:
  - Created by Raymond "Raeleus" Buckley 
  - Visit ray3k.wordpress.com for games, tutorials, and much more!

## Meetingminutes

### Mandag 08.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Sprint-planlegging møte på Discord 12-13
- Fordeling av arbeidsoppgaver:
  - Skrive brukerhistorier for det vi vil implementere iløpet av sprint.
  

### Onsdag 10.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord Møte - oppfølging av utdelte arbeidsopppgaver 12-12:15
- Konklusjon:
  - Brukerhistorie for testmodus
  - Brukerhistorie for hp
- Gjenstående:
  - Implementasjon av brukerhistoriene

### Discord gruppetime fellesarbeid - med tilgang til TA. 12:15-14
- Konklusjon:
  - Fullført testmodus

### Fredag 12.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Scrum review konklusjon:
  - Ferdig med implementasjon av testmodus
  - Ferdig med brukerhistorie
  - Ferdig med implementasjon med hp
- Scrum review retrospektiv konklusjon:
  - Sette opp flere oppgpaver for medlemmene for neste uke

### Mandag 15.03.2021
### Deltakere: Eivind, Sigurd, Malte(Daan manglet grunnet annet obligatorisk oppmøte)
### Discord møte - Sprint-planlegging 12-13
- Sprint planning: 
  - Brukerhistorie for liv
  - Brukerhistorie for fikser rute
  - Brukerhistorie for laser
  - Implementasjona av brukerhistoriene
- Fordeling av arbeidsoppgaver:
  - Liv: Eivind
  - fikser rute : Daan
  - Brukerhistorie for laser: Malte, Sigurd
  - Implementasjon av brukerhistoriene: (alle)

### Onsdag 17.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Oppfølging av utdelte arbeidsoppgaver 12-12:15
- Konklusjon:
  - Ferdig med brukerhistorier
  - Implementert HP
- Gjenstående:
  - Implementere resterende brukerhistorier

### Discord gruppetime fellesarbeid - med tilgang til TA 12:15-14
### Deltakere: Daan, Eivind, Sigurd, Malte
- Konklusjon:
  - Mangler å lage tester for laser, transportbånd og flagg.

### Fredag 19.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Sprint review konklusjon:
  - Ferdig med tester for laser, transportbånd og flagg.
  - Oppdatere project board
-Sprint retrospektiv konklusjon:
  - Sette opp arbeidsoppgaver på mandagen
  - God arbeidsmengde hittil.

### Mandag 22.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint-planlegging 12-13
- Sprint planlegging:
  - Implementere laser
  - Implementere transportbånd
  - Implementere flagg
  - Legge til GUI
  
- Arbeidsfordeling:
  - Laser - Eivind
  - Transportbånd - Malte
  - Flagg - Daan
  - GUI - Sigurd

### Onsdag 24.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - oppfølging av arbeid.
- Konklusjon:
  - Må fikse noen små bugs med transportbånd og flagg
  - Litt igjen på GUI
- Gjenstående:
  - Implementere ferdig laser
  - Fikse finpuss GUI

### Discord gruppetime fellesarbeid - med tilgang til TA 12:15-14
### Deltakere: Daan, Eivind, Sigurd, Malte
- Konklusjon:
  - Fant et problem med å kjøre programmet på ulike datamaskiner
  - Fikset problemet litt senere

### Fredag 26.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Sprint review konklusjon:
  - Sett gjennom ukens arbeid
-Sprint retrospektiv konklusjon:
    - Fikk gjort mye denne uken
    - Alt ser bra ut

### Project Board
![projectboard.png](projectboard.png)
