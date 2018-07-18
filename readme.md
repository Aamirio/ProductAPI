# Product Service API

The Product Service API provides product details

## Table of contents

1. [Prerequisites](#Prerequisites)
2. [Getting started](#Getting)
    1. [Download source code](#Download)
    2. [Running the tests](#tests)
    3. [Building the jar](#Building)
    4. [Running the API](#Running)
4. [Using the API](#Using)
5. [Feedback](#Feedback)

## Prerequisites

You will need...

* Git installed on your machine to clone the source code from this repository. To install Git please refer to the
[Git-scm instructions.](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

* Java 8 to run the application. To check which version please refer to the
[Oracle version manual.](https://www.java.com/en/download/help/version_manual.xml) If you do not have Java 8
installed, please refer to the
[Oracle Java installation instructions.](https://www.java.com/en/download/help/index_installing.xml)

## Getting started

The following sub-sections explain how to download the source code, run the existing tests, build the application
(as a jar,) and how to run the application.

### Download source code

* Download the source code locally so you can run the tests and build the jar to run the API

* *Tip:* In your terminal or command console, create a directory where you would like to dowload the source code and use
`git clone https://github.com/Aamirio/Product.git` or alternatively you can download it as a zip using the
github *Download ZIP* feature in the UI.

### Running the tests

* In your terminal or command console, navigate to the root directory where you have downloaded the source code and run
`./mvnw clean test` to verify all tests are passing. If for any reason this maven wrapper script does not work, then you
will need to install [maven 3.3.3](https://maven.apache.org/docs/3.3.3/release-notes.html) and run `mvn clean test`
instead.

* Unit and integration tests have been written for the `ProductService`. All tests can be found in the `test` source
folder.

### Building the jar

In your terminal or command console, navigate to the root directory where you have downloaded the source code and run
`./mvnw clean verify` to verify all tests are passing and build the jar. If for any reason this maven wrapper script
does not work, then you will need to install [maven 3.3.3](https://maven.apache.org/docs/3.3.3/release-notes.html) and
run `mvn clean test` instead. A `target` directory will be generated where the jar will reside.

### Running the jar

In your terminal or command console, after you have built the jar, navigate to the `target` directory and run
`java -jar aamiridrees-0.0.1-SNAPSHOT.jar` This will host the API at
[http://localhost:8080](http://localhost:8080/product)

## Using the API

* The API can be used by hitting the endpoint at
`http://localhost:8080/product/<productId>`

* For example, if the client wanted to find a product with id "abc123" they would hit the endpoint at
`http://localhost:8080/product/abc123`

* If a product id is passed which does not exist then the Controller returns a `404 Not Found Error` with a message
informing the client that the product could not be found.

## Feedback

* Thank you for taking your time to have a look. Any constructive feedback will be most appreciated. You can reach me at
my [email address](mailto:aamiridrees@hotmail.com)