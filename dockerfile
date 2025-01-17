# Étape 1 : Construire l'application avec Maven
FROM maven:3.8.5-openjdk-11 AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier uniquement les fichiers nécessaires pour Maven
COPY pom.xml .

# Résoudre les dépendances Maven (optimisation du cache)
RUN mvn dependency:resolve

# Copier le code source
COPY src ./src

# Construire le projet (générer le fichier JAR)
RUN mvn package -DskipTests

# Étape 2 : Exécuter l'application Java avec OpenJDK
FROM openjdk:11-jre-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape de construction
COPY --from=build /app/target/OE_Bank-0.0.1-SNAPSHOT.jar /app/OE_Bank.jar

# Copier les fichiers JSON/XML dans l'image Docker
COPY src/main/resources/flows.json /app/resources/flows.json
COPY src/main/resources/accounts.xml /app/resources/accounts.xml

# Commande pour exécuter l'application
CMD ["java", "-jar", "/app/OE_Bank.jar"]
