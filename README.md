 # Description #
eMovie is an app that connects to The Movie Database API 

## Clean Architecture ##
The feature modules are divided internally in clean architecture. Inside the feature modules exists:

- a domain package for business logic,
- data package for data retrieving,
- app package for everything UI related, inside this module we have the framework, where we will want all of the implementation related to the external or  - internal conections and Dependency Injection.

![alt text](https://erikjhordan-rey.github.io/images/2016/1/clean_archi.png)

##Dependency injection##
This is a must-have architecture implementation to be able to have re-usability of code and make testing easier. Im using Dagger Hilt

##Testing##
For testing I am using Junit4, Mockk and the support test libraries for coroutines, android arch, koin and Junit Koin. In this project you can see UseCases, Repository and ApiClient Testing

##Kotlin serialization##
Instead of GSON I started to use Kotlin serialization in order to be ready for KMP.

##Save in Cache##
For save info in cache I am using Protofub. Protocol buffers are Google's language-neutral, platform-neutral, extensible mechanism for serializing structured data – think XML, but smaller, faster, and simpler. 

# //TODO´S #

Pagination
I would like to implement as update, Paging 3 to have a cleanear and more controlled pagination and also integrate the loader and the retry in the recyclerview

Search tab
Also want to add a search screen, this api have an endpoint to bring searched result
