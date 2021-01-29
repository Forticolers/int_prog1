[Back to README](../../README.md)
## Projet Maven

### Installation
(Sur windows) Télécharger le fichier .zip présent à [cette adresse](https://maven.apache.org/download.cgi) et exporter le dossier de l'archive dans _C:\Program Files (x86)\_.

Une fois cela fait, ajoutez le dossier (par exemple :_C:\Program Files (x86)\apache-maven-3.6.3_) dans votre variable d'environnement PATH.

Si vous n'en avez pas d'installer, télécharger et installer java JDK puis vérifier qu'une variable d'environnement JAVA_HOME se créer, crée là si elle ne se créer pas automatiquement 
### Création d'un projet
 Déplacer vous dans le dossier où vous souhaitez créer votre projet maven puis ouvrez y un promt cdm pour y entrer la commande suivant :

```
 mvn "archetype:generate" "-DgroupId=<PACKAGE NAME>(Exemple: ch.jeanbourquj.cifom)" "-DartifactI
d=<PROJECT NAME>(Exemple: maven-project)" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.4" "-DinteractiveMode=false"
```

Le nom de projet va aussi servir de nom pour le dossier de projet que maven va créer.