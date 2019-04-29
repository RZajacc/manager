# Force plate app

Application is designed to mimic simple volleyball manager agency website where player can create account with their 
personal data and log in into their account, and for other people - clubs for example to see full players list
and search by position on court.

## Getting Started

You will need MySql database to run this app. Provide all necessary data in application.properties and for the first use
set dev profile to active (just uncomment the line). It will create all entities in your schema, and populate it with 
sample data. If you want to check login and password for check bootstrap package and DataBaseLoader class where it is stored.
Data base store only encoded version of passwords (BCrypt). 

### Prerequisites

MySql database, and active dev profile

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Rafal Zajac** - *Initial work* - (https://github.com/RZajacc)

## Acknowledgments

* Its not a project meant to be deployed, only to learn spring boot by doing something 
more or less practical that won't be library app which is often used as an example on java 
courses as far as I know:)
