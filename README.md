Java EE 7 project example.

Application server:
  - Weblogic Server 12.1.3
  - Payara 4.1

It contains a simple example with CRUD customer entity.
  - BCE design pattern.
  - Presentation: JSF 2.1 + facelets
  - Business Logic: CDI 1.0 + EJB 3.1
  - Integration: JAX-WS + JAX-RS
  - Data Access: JPA 2.1
  - Arquillian integration tests:
      - Business logic
      - JPA entity
      - Unit test
      - JAX-WS with Soapui
      - JAX-RS
