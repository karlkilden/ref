ref
===

Java EE modular project template


Run instructions:

clone
in the root: mvn clean install -Pfast
cd web
mvn tomee:run

In your browser: localhost:8080

Login with "root2"



This project is based on Java EE 6 awaiting Java EE 7 support from TomEE. Everything will be portable unless explicitly mentioned here.


Best practice third party libraries will be used to cut down the boilerplate to the bare minimum. Omnifaces and Deltaspike being the best examples.


The made up customer specification it implements reads like this:

###Customer specification

The system is your typical "Did you know?" random facts app.

Full CRUD for facts (done)
Faul language controls
upvote and downvote system


Typical fact:


Did you know?

TomEE 1.6 works with any JPA vendor

