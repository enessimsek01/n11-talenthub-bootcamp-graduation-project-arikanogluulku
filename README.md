# Loan Application n11 TalentHub Java Bootcamp

<p>This project is the graduation project of n11 TalentHub Java bootcamp. It performs operations such as credit application and credit inquiry of users.It is a Restful spring boot project that returns the loan result to the customer according to the relevant criteria by receiving loan application requests.</p>

<img src="https://user-images.githubusercontent.com/44470054/151704577-1df85850-c698-403a-adaf-d02a1d743ea2.png" alt="loan_app" height="400"/>
<h4> 
  
  <h2>Content</h2>
  
1. [ Description ](#desc)
2. [ Technologies ](#usage)
3. [ Usage ](#usage)
 
      3.1. [ User Endpoint ](#user)
  
      3.2. [ Credit Endpoint ](#credit)
4. [ Loan Application UI ](#loanapp)
5. [ Installation ](#install)
6. [ Contact ](#contact)
</h4> 


<a name="desc"></a>
## 1. Description
<p>Loan application from the user to the system name , surname, date of birth, ID number, telephone number , monthly income, the cost of coverage (optional) by taking parameters such as the user's credit score, income, and collateral of credit according to the price calculated according to criteria related to the result(red check) and credit the result of the application is transmitted as a message to the user revolving credit limit.</p>


<a name="tech"></a>
## 2. Technologies
<ul>
  <li> OpenJDK 11 </li>
<li>Maven</li>
<li>Spring</li>
<li>Spring Data JPA</li>
<li>Postgresql</li>
<li>Validation</li>
<li>Mapstruct</li>
<li>Lombok</li>
<li>Junit , Mockito</li>
<li>Logging slf4j </li>

<li>Swagger</li>
<li>Twilio(SMS)</li>
<li>React</li>

</ul>


<a name="usage"></a>
## 3. Usage 
<a name="user"></a>
   ## 3.1 User Endpoint
   
   <p>It hosts basic operations such as registering new users, updating user information, deleting and listing. </p>
   
   
|   Endpoint  	| Method 	|     Params     	|                    Description                    	|
|:-----------:	|:------:	|:--------------:	|:-------------------------------------------------:	|
| getAllUsers 	|   GET  	|      null      	|                It lists all users.                	|
| getOneUsers 	|   GET  	|     userId     	| Fetches the user according to the id information. 	|   	
|  createUser 	|  POST  	| UserRequestDto 	|               Registers a new user.               	|   	
|  deleteUser 	| DELETE 	|     userId     	|             Deletes user based on id.             	|   	

   
<a name="credit"></a>
   ## 3.2 Credit Endpoint
According to the information received from the user for applying for a loan, the credit score is first calculated(fake service).

The credit score was calculated by adding 100 to the last three digits of the user's identification number in the project.

There are different credit level alternatives according to the user's credit score and salary status. Different calculations are performed at each level. And if the user has collateral information, the credit result is calculated by adding it to the credit limit according to the credit level.

The credit result is sent to the user as a REJECTION, APPROVE and limit information.As a result of the loan, sms is sent to the user's phone number.

A user who has applied for a loan can request a loan by date of birth and ID number.As a result of this query, user information and credit result information are returned.


|            Endpoint            	| Method 	|                Params                	|                        Description                        	|
|:------------------------------:	|:------:	|:------------------------------------:	|:---------------------------------------------------------:	|
| createUserAndCreditApplication 	|  POST  	|            UserRequestDto            	|                 credit application process                	|
|    inquiryCreditApplication    	|   GET  	| dateOfBirthday, identificationNumber 	| credit inquiry by identification number and date of birth 	|


<a name="loanapp"></a>
## 4.Loan Application UI

### Credit Inquiry Page | Home Page

The page where the user queries the loan application by entering the date of birth and identification number.


![home-inquiry](https://user-images.githubusercontent.com/44470054/151715179-7cf6ba1f-20e7-4f01-9b3f-dcfa5bf98b04.JPG)


Sample Inquiry:

The result of the user whose credit result is approve:
![inquiry-a](https://user-images.githubusercontent.com/44470054/151715211-3f24c1ab-ea42-463c-b4ea-6040bf2782f8.JPG)


The result of the user whose credit result is rejection:
![inquiry-r](https://user-images.githubusercontent.com/44470054/151715217-b26b2d72-8749-4387-8f28-0316fe4e33f1.JPG)


If the user does not have a loan application:
![inquiry-no](https://user-images.githubusercontent.com/44470054/151715372-6282b000-9ccd-4cd5-b22c-5ec6efdcfed4.JPG)



### Credit Application Page

![credit-app](https://user-images.githubusercontent.com/44470054/151715424-b588cb63-78d7-4618-8101-dc7c2c56c950.JPG)

Sample Application

![credit-app-result](https://user-images.githubusercontent.com/44470054/151715428-41300a42-ff3c-4cca-8df9-71387276a802.JPG)


SMS :

!! Since the trial version of the Twilio api provides a security warning for public repos, the sms discard function has been translated into the comment line.For this reason, the sms feature has been added with images as an example.

<img src="https://user-images.githubusercontent.com/44470054/152054730-304b315b-d533-4ba6-9acb-acc127975dd6.jpeg" height="450px"/>

<img src="https://user-images.githubusercontent.com/44470054/152054798-29a5ee04-1155-459a-a292-0df18c40a47a.jpeg" height="450px"/>

### User Operations 
This page lists users whose user information is updated or deleted.

![users](https://user-images.githubusercontent.com/44470054/151715249-047fa6d2-fab8-41ac-8db1-cafc5b05fbe6.JPG)


User Save : 

![user-save](https://user-images.githubusercontent.com/44470054/151715252-99901dcb-e9c1-40dd-bd5c-0bb6f9ec2d58.JPG)


User Updated Model:

![update-model](https://user-images.githubusercontent.com/44470054/151715952-0772509e-214a-4f4c-bff0-d60febc6a45f.png)


Form Valid:

The validations for the quality of the data received in the forms are limited in the same way as the backend.

![valid](https://user-images.githubusercontent.com/44470054/151715959-286bd71a-4ca9-4551-b42a-962ba1358007.JPG)



<a name="install"></a>
## 5.Installation

<pre>
<code>
git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-arikanogluulku.git

Import the project to your IDE

Configure application.properties files for PostgreSQL connection.

Send request to endpoints. (The project is running on the 8080 port by default.)

</code>
</pre>

<bold> Swagger UI :  </bold>

Link : <a hreff="http://localhost:8080/swagger-ui/index.html#/"> http://localhost:8080/swagger-ui/index.html#/ </a>


<a name="contact"></a>
## 6.Contact

arikanogluulku@gmail.com

Linkedin: https://www.linkedin.com/in/arikanogluulku/




