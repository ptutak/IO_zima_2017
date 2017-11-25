# IO_zima_2017

## Instrukcja obsługi projektu
### Importowanie projektu
Aby zaimportować projekt użyjcie **InteliJ Idea -> File -> Open** oraz wybierzcie folder z projektem.
W lewym dolnym rogu powinno wyskoczyć okienko **Import Gradle project** naciśnijcie na nie, a następnie klikajcie OK do skutku.

### Struktura projektu
* Diagramy znajdują się w folderze **diagrams**
* Kod źródłowy implementacji **impl/src/main/java/\*** (odpowiednie foldery package)
* Testy implementacji **impl/src/test/java/\*** (odpowiednie foldery package)
* Kod źródłowy api **api/src/main/java/\*** (odpowiednie foldery package)

### Uruchamianie testów
Aby uruchomić testy użyjcie odpowiedniej configuracji w InteliJ (**runTests**) lub wpiszcie w konsoli

Linux/MacOS:
```
./gradlew test
```
Windows:
```
gradlew.bat test
```

### Tworzenie artefaktów
Aby utworzyć jar z implementacją oraz api użyjcie configuracji w InteliJ (**release**) lub wpiszcie w konsoli

Linux/MacOS:
```
./gradlew release
```
Windows:
```
gradlew.bat release
```
Pliki wylądują w folderze **release**
