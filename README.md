# Spring Security
* What is Spring Security: Protect your web applications such as REST API or microservices etc. Although Spring Security can be difficult to understand, it is very flexible for securing.
* There is a various type of Spring Security.
  * Logout Filter
  * CsrfFilter
  * BasicAuthenticationFilter
  * AuthorizationFilter
  * DefaultLoginPageGeneratingFilter
  * ...

* How Does Spring Security Work?
  * Normally in Spring MVC Dispatcher Servlet intercepts all request and routes to the right controller.
  * With Spring Security, Spring Security acts as a layer between request and Dispatcher Servlet. Before Dispatcher Servlet Spring Security intercepts all requests and only after Spring Security checks, authentication and authorization the request sent to Dispatcher Servlet and for further processing to the controllers.
  * As the mentioned above, Spring Security intercepts all request but what it does handle with this requests? Spring Security execute series of filters also called Spring Security Filter Chain.
  * You can figure out more with the looking at the diagrams I left below
  ![Spring Security](https://github.com/mrtkrkrt/Spring-Security/assets/55550212/66f7353f-a8a2-453b-9129-67c5f87d75a9)

* Spring Security Filters:
  * Authentication: Question -> Is it a valid user?
  * Authorization: Question -> Does the user have right access?
  * Cross-Origin Resource Sharing (CORS): With SOP, browsers are prevented from malicious xyz․com stealing information from other sites that the user opens with the same browser, via session cookies. This is where CORS was introduced to relax the limitations imposed by the SOP.
  * Cross Site Request Forgery (CSRF): CSRF, that is, cross-site request forgery, is a user who is logged into a web application by taking advantage of the vulnerability of that website, and the attacker gains access and acts as if he were that user, without the user's request. These vulnerabilities on websites are mostly vulnerabilities that occur in cases such as GET requests and SESSION operations cannot be properly controlled. This vulnerability, which occurs in systems that do not control how and from which source the requests to the application are sent, is also known as "Session Riding".
  * Login Page, Logout Page: Spring Security provide simple login form and lgout request

* Default Spring Security Configuration:
  * Everything is authenticated
  * Form authentication is enabled
  * Basic Authentication is enabled
  * Test user is created
  * CSRF protection is enabled
  * CORS requests are denied
  * X-Frame-Options is set to 0 
  * ...

