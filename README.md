For å kjøre, åpne filen Application.kt og kjør fra IDE,
eller kjør `mvn spring-boot:run` fra en terminal.

Applikasjonen kjøres opp på port 5000, og med path /api.
Dette vil si at man kan aksessere endepunktene på f.eks. http://localhost:5000/api/hello.
Når man kjører applikasjonen kan man åpne frontend på http://localhost:5000/api/index.html.

For å kjøre tester, åpne prosjektet i IntelliJ, høyreklikk på testklassen i project view, 
og velg "Run 'klassenavn'". Eventuelt kan man høyreklikke på mappen `kotlin` under `test` og velge "Run 'All tests".