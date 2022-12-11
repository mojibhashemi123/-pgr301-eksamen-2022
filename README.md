Kandidatnr:1047.

## Del 1 DevOps-prinsipper

Beskriv med egne ord;

* Hva er utfordringene med dagens systemutviklingsprosess - og hvordan vil innføring av DevOps kunne være med på å løse
  disse? Hvilke DevOps prinsipper blir brutt?

  Lang ventetid for å deploye løsningen fører til ussiker og ustabilitet prosesser. Å bruke for mye tid i utvikling miljø 
  og bygge opp store leveranser uten å gå gradvis i produksjon fører til ustabilitet og uforventet feil.

  En av utfordringene er å akselerere tiden til markedet. Når utviklingsteamet bygger applikasjonen, må de vente flere 
  uker før arbeidet settes i produksjon. Denne forsinkelsen øker presset for å holde seg konkurransedyktig

  De opplevde ustabilitet med oftere deployment, sikkert fordi de ikke hadde bedre prosess og kontroll implementert. 
  F.eks. å redusere størrelsen av endringer og bryte ned prosesser til mer håndterbart størrelsen gir bedre kontroll.
  Ansette flere folk vil ikke løse problemet heller hvis det er prosessen som er feil! De kunne ha automatisert test 
  og QA steg for å få bedre innsikt over kvaliteten av produktet.
  Utviklingsledere ble «bottle-neck» for prosessen siden alt måtte gå gjennom han. De kunne automatisere en del kontroll 
  checks og tillegg dele-opp ansvar mellom teamet for å få mer ut av ressursene sine.
  Å redusere frekvensen av leveranser er ikke en bra løsning, som nevnet før, å brytte ned tasks i mindre størrelesen kunne hjelpe bedre
  bør samarbeide med Developer Team og Operations team som et hvor alle har innsikt og ansvar på alt som går ut. 
  Et team, et DevOps team istdenfor å være to forskjellige Dev og Ops teams.

  * prinsipper blir brutt:

    Følgende er hoved prinsipper som ble brøt her:
    De ventet for mye for releaser og det skapte waste av tiden og ressurs.
    Begrensing av oppgave størrelse: Når de deployer kun 4 gang i året da er sikkert størrelsen av leveranser blitt større og er ikke alltid håndterbart
    manuell tester førte til mer tid og mer ressurs
    En person som godkjenner for alle arbeid, var flaskehals som de ikke fjernet

* En vanlig respons på mange feil under release av ny funksjonalitet er å gjøre det mindre hyppig, og samtidig forsøke å legge på mer kontroll og QA. Hva er problemet med dette ut ifra et DevOps perspektiv, og hva kan være en bedre tilnærming?

  Problemer med tidskrav og høye kostnader, teste systemet eller programvaren tar veldig lang tid når man selv har ikke 
  kodet den. QA og utviklere må kommunisere, samarbeide og optimere innsatsen for å finne defekter raskt og fikse dem før 
  lansering. Det er mye mer fornuftig for dem å gjøre dette automatisk og gjennom de anbefalte verktøyene for testing. 
  
  I DevOps er testing en kontinuerlig prosess og støtter prosessen med å inkludere kontinuerlig tilbakemelding for å 
  muliggjøre bedre kvalitet. Andre viktig faktor til suksess til QA integrering i DevOps er å ha metrics som gir feedback. 
  vellykket DevOps-implementering må team ha DevOps prinsippet, gjøre arbeid synlig i hverandres arbeid. Viktig å ha 
  Kontinuerlig testing der en programvare automatisere tester gjennom hele livssyklusen til utviklingsprosessen, 
  det hjelper teamet og analysere kvaliteten til produktet på alle trinn i prosessen.

* Teamet overleverer kode til en annen avdelng som har ansvar for drift - hva er utfordringen med dette ut ifra et DevOps perspektiv, og hvilke gevinster kan man få ved at team han ansvar for både drift- og utvikling? 

  Drift-teamet føler iblant at utviklere kaster jobbene sine over veggen til dem. Samme føler utviklere når de får 
  noen tilbakemeldinger om dårlig ytelse av systemet i produksjon.

  Hvis utviklere og fra operasjons utviklere jobber sammen, tenke mer likt, brøt ned siloer og dele ansvar. 
  integrerer utviklere og operasjonsteam for å forbedre samarbeid og produktivitet, ved å automatisere infrastruktur, 
  automatisere arbeidsflyter(workflow) og kontinuerlig måle applikasjons ytelse.  Å skrive små biter av programvare vil 
  tillate dem å øke frekvensen av lansering og forbedre tiden for å lansere ny kode.

  Å skrive små biter av programvare vil tillate dem å øke frekvensen av lansering og forbedre tiden for å lansere ny kode. 
  Det gjør det også mulig for dem å ta i bruk en interaktiv prosess for å overvåke, måle og forbedre koden. Forbedre deres 
  evne til å svare på markedsbehov, eller andre ting som påvirker programvare.

* Å release kode ofte kan også by på utfordringer. Beskriv hvilke- og hvordan vi kan bruke DevOps prinsipper til å redusere
  eller fjerne risiko ved hyppige leveraner.

  Ved å ha god praksis med integrering av kode kan føre til en rimelig prosess. F.eks. 
  Trunk-based development med gode kommentarer i commit og branching strategi kan synliggjøre arbeidet mellom teamet.

  Det vil også tillate peer-review / enklere godkjenning / merge av koden til main(master).

  Legge in automatiserte unit tester vil også fikse en del problemer og minimisere risiko ved hyppigere releaser.

* Slutt på beskrivelse 

## Del 2 - CI

### Oppgave 3 

Branch protection og status sjekker - Beskriv hva sensor må gjøre for å konfigurere sin fork på en slik måte
at

* Ingen kan pushe kode direkte på main branch

  Trykk på ```settings``` -> ```branches``` -> ```add branch protection rule```. 
  Deretter skriv ```main``` i ```Branch name pattern``` feltet.  Velg ```«Require a pull request before merging»```
  betyr at man kan ikke pushe kode direkte på main branch men krever å lage pull request gjennom en annen branch.

* Kode kan merges til main branch ved å lage en Pull request med minst en godkjenning

  I ```«add branch protection rule»``` etter man har valgt ```«Require a pull request before merging»``` 
  kan man da velge ```«Require approvals»``` for å lage en pull request med minst en godkjenning ved å velge ```1```.

* Kode kan merges til main bare når feature branchen som pull requesten er basert på, er verifisert av GitHub Actions.

  I ```«add branch protection rule»``` velg ```«Require status checks to pass before merging»``` 
  også i søkefeltet skriver du ```build``` -> ```trykk enter``` og velg ```Github Action```.

## Del 3 - Docker

### Oppgave 1
* Beskriv hva du må gjøre for å få workflow til å fungere med din DockerHub konto? Hvorfor feiler workflowen?

  Workflowen feiler fordi den mangler token fra dockerhub, for at den skal fungere må man sette DOCKER_HUB_TOKEN og 
  DOCKER_HUB_USERNAME i ```Action secrets```. DOCKER_HUB_TOKEN kan skaffes fra dockerhub settings. 

### Oppave 3
* Beskriv deretter med egne ord hva sensor må gjøre for å få sin fork til å laste opp container image til sitt eget ECR repo.

  Sensor må først bytte kodene i github secrets. I github secrets ligger det mine nøkler. Slett mine AWS nøkler, 
  og legg en AWS_ACCESS_KEY_ID med access key. Så en AWS_SECRET_ACCESS_KEY med secret access key som kan skaffes fra IAM.

  I workflow docker.yml kan sensor endre følgende kommandoer for å kunne laste opp container image til sitt eget ECR repo:
```sh
  aws ecr get-login-password --region eu-west-1 | docker login --username AWS --password-stdin <Account ID>.dkr.ecr.<region&zone>.amazonaws.com
  rev=$(git rev-parse --short HEAD)  #<- henter siste commit hash (id)
  docker build . -t shopifly
  docker tag shopifly <Account ID>.dkr.ecr.<region&zone>.amazonaws.com/<ECR repo navn>:$rev
  docker push <Account ID>.dkr.ecr.<region&zone>.amazonaws.com/<ECR repo navn>:$rev
```
  Ved å bruke $rev legges den siste commit fra github som versjon i container image.

På oppgave 3, er jeg usikker om det er ment for workflow eller direkte fra terminal. 
Derfor tar jeg med en eksemepel fra terminal også, kjør følgende kommando for å bygge en container image i din maskin.
```sh
docker build -t shopifly:<velg versjon> .
```
Bruk først docker login til å autentisere docker mot AWS ECR, også push ønskende versjon, kjør følgende kommandoer:
```sh
aws ecr get-login-password --region eu-west-1 | docker login --username AWS --password-stdin <Account ID>.dkr.ecr.<region&zone>.amazonaws.com
docker tag shopifly:<versjon> <Account ID>.dkr.ecr.<region&zone>.amazonaws.com/<ECR repo navn>:<versjon>
docker push 244530008913.dkr.ecr.eu-west-1.amazonaws.com/<ECR repo navn>:<versjon>
```

## Del 5 - Terraform og CloudWatch Dashboards

### Oppgave 1
* Forklar med egne ord. Hva er årsaken til dette problemet? Hvorfor forsøker Terraform å opprette en bucket, når den allerede eksisterer? 
  
  Som vi vet at TF trenger .statefil for å huske/maintaine ressurser som ble opprettet av TF. Jeg lagde en backend block 
  i koden for å peke/lagre status av alle deployed ressurser sånn at TF kan huske/maintaine.
  GitHub action må ha tilgang til terraform-konfigurasjonene
  og koden slik at den bruker samme terraform-filene. Når Github ikke har tilgang til tilstandsfilen så vet den ikke om
  den allerede eksisterer derfor forsøker den å opprette bucket igjen.
