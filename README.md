# SHAZAM TEST SUITE (JAVA + SERENITY + CUCUMBER + SCREENPLAY)

Este proyecto contiene la automatizacion de pruebas a la API shazam

## ESTRUCTURA DE DIRECCTORIOS 🗂️

```bash
.
├── pom.xml
├── README.md
├── serenity.properties
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── shazam
    │               └── app
    │                   ├── helpers
    │                   │   ├── api
    │                   │   │   ├── RequestDataHelper.java
    │                   │   │   └── ResponseDataHelper.java
    │                   │   └── ui
    │                   ├── interactions
    │                   │   ├── api
    │                   │   │   ├── GetRequest.java
    │                   │   │   └── PostRequest.java
    │                   │   └── ui
    │                   ├── models
    │                   │   ├── api
    │                   │   │   ├── RequestData.java
    │                   │   │   └── ResponseData.java
    │                   │   └── ui
    │                   ├── pageobjects
    │                   ├── questions
    │                   │   ├── api
    │                   │   │   ├── CheckResponseBody.java
    │                   │   │   ├── CheckResponseHeaders.java
    │                   │   │   ├── CheckResponseStatusCode.java
    │                   │   │   └── CheckResponseStatusLine.java
    │                   │   └── ui
    │                   ├── tasks
    │                   │   ├── api
    │                   │   │   ├── DetailSong.java
    │                   │   │   ├── DetectSong.java
    │                   │   │   └── ValidateResponse.java
    │                   │   └── ui
    │                   └── utils
    │                       └── APIConstants.java
    └── test
        ├── java
        │   └── com
        │       └── shazam
        │           └── app
        │               ├── CucumberTestSuite.java
        │               ├── runners
        │               │   ├── BackendRunner.java
        │               │   └── FrontendRunner.java
        │               └── stepdefinitions
        │                   ├── api
        │                   │   ├── CommonStepDefinitions.java
        │                   │   └── SongsStepDefinitions.java
        │                   ├── ParameterDefinitions.java
        │                   └── ui
        └── resources
            ├── features
            │   ├── api
            │   │   ├── SongsDetect.feature
            │   │   └── SongsGetDetails.feature
            │   └── ui
            ├── logback-test.xml
            ├── serenity.conf
            └── webdriver
                ├── linux
                ├── mac
                └── windows
```

## EJECUCION DEL PROYECTO ⌨️

⚠️ La compilacion y posterior ejecucion del proyecto se debe hacer desde la raiz del proyecto ⚠️

⚠️ La salida del programa se almacena en ⚠️

```bash
target/site/serenity/
```

Para verificar el resultado de las pruebas se debe abrir el archivo index.html

- Compilacion y ejecucion

```bash
mvn clean verify
```
