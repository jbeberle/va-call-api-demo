# va-call-api-demo

This application consists of a REST API which will allow a vet to call on their
mobile device and have the call center recieve the meta-data associated with the call.

The API provides the ability to post a call which will insert the data into an H2 database.
From the Call Center, an application can call the /calls endpoint and receive all the calls
currently in the database.

## Data Sources

The data is stored in a single H2.  Noramlly the data in H2 is memory-resident and will not be persisted. 
However, in our case, it is  persisted.

| **Schema** | **Description**                                                                                          |
|------------|----------------------------------------------------------------------------------------------------------|
|   | Contains data related to calls placed by veteran's to the call center |
|  VET_CALL  | Contains the metadata for each Veteran's call |

## Architecture

This app provides a REST API for storing Veteran call information.   The API uses JPA to persist and retrieve call data.
Specifically, there are two endpoints: 
   **/vetcall** to post a request to persist data from a new call.
   **/calls** to retrieve all the data from currently active calls.
These endpoints call a service to use the corresponding repository using the DTO and entities to transfer the data.

## Running the application locally

### React FrontEnd

The UI for the mobile device has been built using React Native + Typescript. To run the UI locally from the root directly, execute the following command:

```
yarn bundle:android
yarn android
```

The above should start the frontend application on port **3000** locally.

### Spring Boot Rest-Based Backend

To run a Dockerized version of the application, execute the following to build and run:
```
java -cp h2*.jar org.h2.tools.RunScript -url jdbc:h2:/app/vacall -script ./src/main/resources/create.sql -user sa -password password
docker build --build-arg JAR_FILE=target/va-call-api-demo-0.0.1-SNAPSHOT.jar -t va/va-call-api-demo .
docker run -p 8088:8088 va/va-call-api-demo 
docker run --network host va/va-call-api-demo 
```
To login into Docker container
```
docker run -it --entrypoint /bin/bash va/va-call-api-demo
```

To run a query on the database:
```
java -cp ./h2-*.jar org.h2.tools.Shell
show tables;
```

If you want to run it locally without a docker container, remove the **spring-boot-docker-compose** dependency from pom.xml
and execute the following to build and run:
```
mvn spring-boot:run
```

By default, the application starts on port **8088**. 

Swagger documentation can be accessed at:

```
[BASE_PATH]/swagger-ui/index.html
```

## Deployment to Azure
### 1st:  Set the cloud and login
```
az cloud set --name AzureUSGovernment
az login.  (Takes you to GovCloud to login.   Use the “0” account name and password  from CyberArk)
```
### Check that web app exists:
```
 az webapp list | grep va-veis-vamobile-dev 
```

### Set these environment variables
```
   export ADAL_PYTHON_SSL_NO_VERIFY=1
   export AZURE_CLI_DISABLE_CONNECTION_VERIFICATION=1
```
### Deploy to Azure
```
 az webapp deploy --resource-group EIS-DEVTEST-INT-SOUTHWEST-VEIS-RG --name va-veis-vamobile-dev --src-path target/va-call-server-0.0.1-SNAPSHOT.jar
```

