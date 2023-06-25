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
  
1. Form Authentication: 
   * Provides a default login page
   * Provides a /logout url
   * As you can see below picture we have to fill the form. 
     * Username: user
     * Password: When you start the server the security password will appear in console 👇👇
      ![Console](https://github.com/mrtkrkrt/Spring-Security/assets/55550212/8da50eb5-eed8-4f9c-8f5c-520e7a9806b6)
     * Default Form 👇👇

        ![image](https://github.com/mrtkrkrt/Spring-Security/assets/55550212/ebe78f08-5bc2-4fd8-83a7-724f34cc8054)
 
2. Basic Authentication:
    * This is the most basic authentication. Base 64 encoded username and password is sent as request headers
    * But there is a disadvantages such as easy decoding, header does not contain authorization information, header does not have expire date
    * Because of this basic authentication not recommend for production use
    * You can configure auth username and password using [application.properties](src/main/resources/application.properties) file. The configuration is:
      *   ```
          spring.security.user.name=murat
          spring.security.user.password=karakurt
          ```
3. Cross-Site Request Forgery (CSRF):
    * Example: You are logged-in to your bank website. You go to a malicious website without logging out. Malicious website executes a bank transfer without your knowledge using cookie.
    * We have to specify CSRF token when we are using a Post or Put request. You can try this on a simple basic authentication.
    * How can we avoid this?:
        1. Synchronizer token pattern: A token created for each request. To make an update, you need a CSRF token from previous request
        2. SameSite cookie: You can enable same site cookie adding ``` server.servlet.session.cookie.same-site=strict ``` to the [application.properties](src/main/resources/application.properties) file.
    * To configure this authentications we can use simple line of code. After the create configuration file for security like [BasicSecurityConfiguration](src/main/java/com/springsecurity/demo/configuration/BasicSecurityConfiguration.java)
      all that's left is to add a few lines of code.
      * To disable CSRF ```http.csrf().disable()```
      * To disable form auth  ```http.formLogin()``` 
      * You can check more on [Spring Security](https://docs.spring.io/spring-security/reference/features/exploits/csrf.html) page