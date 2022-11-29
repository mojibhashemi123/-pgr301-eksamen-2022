
## Del 1 DevOps-prinsipper

Beskriv med egne ord;

* Hva er utfordringene med dagens systemutviklingsprosess - og hvordan vil innføring av DevOps kunne være med på å løse
  disse? Hvilke DevOps prinsipper blir brutt?
* En vanlig respons på mange feil under release av ny funksjonalitet er å gjøre det mindre hyppig, og samtidig forsøke å legge på mer kontroll og QA. Hva er problemet med dette ut ifra et DevOps perspektiv, og hva kan være en bedre tilnærming?
* Teamet overleverer kode til en annen avdelng som har ansvar for drift - hva er utfordringen med dette ut ifra et DevOps perspektiv, og hvilke gevinster kan man få ved at team han ansvar for både drift- og utvikling? 
* Å release kode ofte kan også by på utfordringer. Beskriv hvilke- og hvordan vi kan bruke DevOps prinsipper til å redusere
  eller fjerne risiko ved hyppige leveraner.

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
Beskriv hva du må gjøre for å få workflow til å fungere med din DockerHub konto? Hvorfor feiler workflowen?
  Workflowen feiler fordi den mangler token fra dockerhub, for at den skal fungere må man sette DOCKER_HUB_TOKEN og 
  DOCKER_HUB_USERNAME i ```Action secrets```. DOCKER_HUB_TOKEN kan skaffes fra dockerhub settings. 

### Oppave 3
* Beskriv deretter med egne ord hva sensor må gjøre for å få sin fork til å laste opp container image til sitt eget ECR repo.
* Docker workflow skal pushe et container image med en tag som er lik GitHub commit hash (id); for eksempel ```244530008913.dkr.ecr.eu-west-1.amazonaws.com/glenn_exam_practice:8234efc```


## Del 5 - Terraform og CloudWatch Dashboards

### Oppgave 1
* Forklar med egne ord. Hva er årsaken til dette problemet? Hvorfor forsøker Terraform å opprette en bucket, når den allerede eksisterer? 



