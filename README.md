# **Application de Traitement de Données en Temps Réel avec Kafka et Spring**

    Cette application démontre le traitement de données en temps réel en utilisant Apache Kafka et Spring. Elle est divisée en deux parties principales : Kafka avec Docker et Kafka avec Spring Cloud.

## Partie 1 : Kafka avec Docker

### Introduction à Kafka

Apache Kafka est une plateforme de streaming d'événements distribuée conçue pour le traitement de données en temps réel à haut débit et tolérant aux pannes. Elle est couramment utilisée pour construire des pipelines de données en streaming et des applications en temps réel.

### Configuration de Kafka avec Docker

Pour exécuter Kafka localement, nous utilisons Docker, ce qui nous permet de configurer Kafka et Zookeeper rapidement.
    1. Installer Docker : Téléchargez et installez Docker depuis le site officiel.
    2. Fichier Docker-Compose : Créez un fichier docker-compose.yml avec le contenu suivant :
    
    ``` version: '2'
        services:
            zookeeper:
                image: wurstmeister/zookeeper:3.4.6
                ports: "2181:2181"
            kafka:
                image: wurstmeister/kafka:2.11-2.3.0
                ports:"9092:9092"
        expose: "9093"
        environment:
            KAFKA_ADVERTISED_LISTENERS: INSIDE://kafka:9093,OUTSIDE://localhost:9092
            KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INSIDE:PLAINTEXT,OUTSIDE:PLAINTEXT
            KAFKA_LISTENERS: INSIDE://0.0.0.0:9093,OUTSIDE://0.0.0.0:9092
            KAFKA_INTER_BROKER_LISTENER_NAME: INSIDE
            KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
        volumes: /var/run/docker.sock:/var/run/docker.sock

3. Démarrer Kafka : Dans le terminal, naviguez vers le répertoire contenant le fichier docker-compose.yml et exécutez :

        ``` docker-compose up -d

Cela lancera les services Kafka et Zookeeper dans des conteneurs Docker.

## Partie 2 : Kafka avec Spring Cloud
### Intégration de Kafka avec Spring

Spring Cloud Stream est un framework qui simplifie le développement d'applications qui consomment et produisent des messages. Il fournit une abstraction pratique sur les courtiers de messages sous-jacents, y compris Kafka.
Structure de l'Application

### L'application Spring est structurée comme suit :

- Producteur Kafka : Contient un point de terminaison API REST pour envoyer des messages à Kafka.
- Consommateur Kafka : Écoute le sujet Kafka et traite les messages entrants.
- Traitement en Temps Réel avec Kafka Streams (optionnel) : Effectue un traitement en temps réel sur les données.


