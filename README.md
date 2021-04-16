Fizz-Buzz Service
======


This is a simple microservice that will provide the [Fizz Buzz](https://en.wikipedia.org/wiki/Fizz_buzz) list for a given integer. 




<br>

To run the project:
1. Go to the base directory /FizzBuzz.
2. Run the following command to build the docker container.
```
docker build -t fizzbuzz-app .
```
3. Run the following command to start. This command will use the port 8080.
```
docker run -p 8080:8080 fizzbuzz-app
```
4. On your browser, hit http://localhost:8080

This will give you the welcome page and will give you the link to start FizzBuzz with initiall limit of 1

```
http://localhost:8080/fizzBuzz/1
```

<br>

This microservice is written with the following:
- `Java 8`
- `Springboot 2.4.2`
- `Maven`
- `Docker`

<br>

### Tests
I have included tests for the following use cases:
- `Test for null`
- `Test for non-positive`
- `Test for factorial of 3`
- `Test for factorial of 5`
- `Test for factorial of both 3 & 5`
- `Test for non-factorial of 3 nor 5`

<br>

### Authentication 
This microservice doesn't handle authentication. However, there are number of ways  we can handle authentication,
depending on how/where we deploy this, in my opinion.

<br>

If we're gonna deploy this in AWS, my first option is to  create a separate [lambda authorizer](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-use-lambda-authorizer.html) 
and add it to API Gateway. I prefer this because of the following reasons:
* `Separation of responsibility with the microservice`
* `Reuse of authorizer with another microservice`
* `Leverage the API Gateway security`
* `Easy to change authentication implementation, without affecting the underlying microservices`

<br>

However, if we will deploy this locally/on-premise, I will prefer to use oauth2 provider (such as Okta), and 
use [spring-security SAML](https://www.baeldung.com/spring-security-saml)

Alternatively, we can use [oauth2 using github](https://spring.io/guides/tutorials/spring-boot-oauth2/).
This microservice have initial implementation of it, using my personal github oauth authorization. Please see the following files:
* application.yml
* pom.xml

### Update
* Fix for issue #1 - BUG: Multiples of both 3 and 5 are not returning the correct value
* Added simple login using oauth2 of github. 
* Added surefire plugin to run unit test

