# Aspose for Spring Java

Aspose for Spring.Java provides usage samples / sourcecodes for the demonstration of Aspose API for Java by extending famous Spring Java PetClinic Sample Web Application.

This extension of "Spring Java PetClinic Sample Web Application" also shows the Integration of Aspose APIs with Spring MVC, JSP and Maven Project.

This extension helps you to explore Aspose Java components within Spring Framework / Spring MVC /Maven environments

# Aspose Extension for Spring PetClinic Sample Web Application

## What does it look like?
-spring-petclinic has been deployed here on cloudfoundry: http://demo-spring-petclinic.cfapps.io/


## Recommended Links

1.  [Youtube Video Demo of the project](https://www.youtube.com/watch?v=GLujBd6gq_Y&feature=youtu.be)
2.  [Aspose Java APIs](http://www.aspose.com/java/total-component.aspx)
    

## This Extension of Spring PetClinic Sample Application for Aspose API includes the following new features and webpages updates:

1.   On Veterinarians Page, Availability Days and Email Addresses are added, by Clicking on Email Address of any one will open Email Form where you can write email to the Veterinarian and send it through your Outlook Client by using Aspose APIs (Aspose.Email)
2.   On Veterinarians Page, You can export Veterinarians List to PDF, MS-Word and MS-Excel Formats using Aspose APIs (Aspose.PDF, Aspose.Words, Aspose.Cells)
3.   On Owners List Page, You can export Veterinarians List to PDF, MS-Word and MS-Excel Formats using Aspose APIs (Aspose.PDF, Aspose.Words, Aspose.Cells)
4.   On Add Visit Page, You can now also Feed Bill Amount in $ which will later display along with generated Barcode image on the Add Visit Page and Owners Information Page by using Aspose APIs (Aspose.Barcode)
5.   Export to PDF, MS-Word and MS-Excel documents (On Veterinarians Page & Owners List Page) also shows the sample usages of Aspose APIs for inserting Images, Formattings and Tables to the generated documents using Aspose.Words, Aspose.PDF and Aspose.Cells
6.   For creating / displaying Barcode Image using Aspose APIs (Aspose.Barcode) on JSP or any MVC Framework using JSP as Views, Tag Library <aspose:getBarcodeUrl> is created through which a Barcode Image can be very easily generated and embeded on the page providing CodeText / Amount and Symbology (Type of Barcode i.e Code128, QR) through tag attributes.
7.  Source code of usage of above features of Aspose API (Aspose.PDF,Aspose.Words, Aspose.Cells, Aspose.Email, Aspose.Barcode) are included in this project repository (Integrated with ready to run PetClinic Spring Sample Web Application).
8.  Source Codes of Tag Library for Aspose.Barcode usage for JSPs also included with the project sources code and demonstrated on Add/Edit Visit Page and Owners Information Page
9.  This Spring PetClinic Web Application extension for Aspose API also shows the Aspose APIs integration with Maven

## Comming Soon: 

Export webpages of Spring PetClinic Web Application to PDF and MS-WORD documents using Aspose APIs (Aspose.PDF, Aspose.Words), that will be for showing the sample sourcecodes for the usage of HTML to PDF and MS-WORD documents export features of Aspose APIs

## Understanding the Spring Petclinic application with a few diagrams
<a href="https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application">See the presentation here</a>

## Running petclinic locally
```
	git clone https://github.com/asposemarketplace/Aspose_for_Spring.Java.git
	mvn tomcat7:run
```

You can then access petclinic here: http://localhost:9966/petclinic/

**Note**: In case of any PermGen related JVM error, adjust PermGen memory space by setting the appropriate values to MAVEN_OPTS environment variable.

For Example:

    export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=128m"

(or on Windows:)

    set MAVEN_OPTS=-Xmx512m -XX:MaxPermSize=128m


## Working with Petclinic in JetBrains

The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* IntelliJ IDEA

## Working with Petclinic in Eclipse/STS

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line
```
git clone https://github.com/asposemarketplace/Aspose_for_Spring.Java.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```
2) Inside IntelliJ
```
File--> Open -> select spring-petclinic Project
```
## Looking for something in particular?

<table>
  <tr>
    <th width="300px">Inside the 'Web' layer</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Spring MVC- Atom integration</td>
    <td>
      <a href="/src/main/java/org/springframework/samples/petclinic/web/VetsAtomView.java">VetsAtomView.java</a>
      <a href="/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a>
    </td>
  </tr>
  <tr>
    <td>Spring MVC - XML integration</td>
    <td><a href="/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a></td>
  </tr>
  <tr>
    <td>Spring MVC - ContentNegotiatingViewResolver</td>
    <td><a href="/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a></td>
  </tr>
  <tr>
    <td>Spring MVC Test Framework</td>
    <td><a href="/src/test/java/org/springframework/samples/petclinic/web/VisitsViewTests.java">VisitsViewTest.java</a></td>
  </tr>
  <tr>
    <td>JSP custom tags</td>
    <td>
      <a href="/src/main/webapp/WEB-INF/tags">WEB-INF/tags</a>
      <a href="/src/main/webapp/WEB-INF/jsp/owners/createOrUpdateOwnerForm.jsp">createOrUpdateOwnerForm.jsp</a></td>
  </tr>
  <tr>
    <td>webjars</td>
    <td>
      <a href="/pom.xml">webjars declaration inside pom.xml</a> <br />
      <a href="/src/main/resources/spring/mvc-core-config.xml#L24">Resource mapping in Spring configuration</a> <br />
      <a href="/src/main/webapp/WEB-INF/jsp/fragments/headTag.jsp#L12">sample usage in JSP</a></td>
    </td>
  </tr>
  <tr>
    <td>Dandelion-datatables</td>
    <td>
      <a href="/src/main/webapp/WEB-INF/jsp/owners/ownersList.jsp">ownersList.jsp</a> 
      <a href="/src/main/webapp/WEB-INF/jsp/vets/vetList.jsp">vetList.jsp</a> 
      <a href="/src/main/webapp/WEB-INF/web.xml">web.xml</a> 
   </td>
  </tr>

  <tr>
    <td>Branch using GemFire and Spring Data GemFire instead of ehcache (thanks Bijoy Choudhury)</td>
    <td>
      <a href="https://github.com/bijoych/spring-petclinic-gemfire">See here</a></td>
  </tr>
</table>

<table>
  <tr>
    <th width="300px">'Service' and 'Repository' layers</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Transactions</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>
       <a href="/src/main/java/org/springframework/samples/petclinic/service/ClinicServiceImpl.java">ClinicServiceImpl.java</a>
    </td>
  </tr>
  <tr>
    <td>Cache</td>
      <td>
      <a href="/src/main/resources/spring/tools-config.xml">tools-config.xml</a>
       <a href="/src/main/java/org/springframework/samples/petclinic/service/ClinicServiceImpl.java">ClinicServiceImpl.java</a>
    </td>
  </tr>
  <tr>
    <td>Bean Profiles</td>
      <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>
       <a href="/src/test/java/org/springframework/samples/petclinic/service/ClinicServiceJdbcTests.java">ClinicServiceJdbcTests.java</a>
       <a href="/src/main/webapp/WEB-INF/web.xml">web.xml</a>
    </td>
  </tr>
  <tr>
    <td>JdbcTemplate</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>
      <a href="/src/main/java/org/springframework/samples/petclinic/repository/jdbc">jdbc folder</a></td>
  </tr>
  <tr>
    <td>JPA</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>
      <a href="/src/main/java/org/springframework/samples/petclinic/repository/jpa">jpa folder</a></td>
  </tr>
  <tr>
    <td>Spring Data JPA</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>
      <a href="/src/main/java/org/springframework/samples/petclinic/repository/springdatajpa">springdatajpa folder</a></td>
  </tr>
</table>

<table>
  <tr>
    <th width="300px">Others</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Gradle branch</td>
    <td>
      <a href="https://github.com/whimet/spring-petclinic">See here</a></td>
  </tr>
</table>


## Interaction with other open source projects

One of the best parts about working on the Spring Petclinic application is that we have the opportunity to work in direct contact with many Open Source projects. We found some bugs/suggested improvements on various topics such as Spring, Spring Data, Bean Validation and even Eclipse! In many cases, they've been fixed/implemented in just a few days.
Here is a list of them:

<table>
  <tr>
    <th width="300px">Name</th>
    <th width="300px"> Issue </th>
  </tr>

  <tr>
    <td>Spring JDBC: simplify usage of NamedParameterJdbcTemplate</td>
    <td> <a href="https://jira.springsource.org/browse/SPR-10256"> SPR-10256</a> and <a href="https://jira.springsource.org/browse/SPR-10257"> SPR-10257</a> </td>
  </tr>
  <tr>
    <td>Bean Validation / Hibernate Validator: simplify Maven dependencies and backward compatibility</td>
    <td>
      <a href="https://hibernate.atlassian.net/browse/HV-790"> HV-790</a> and <a href="https://hibernate.atlassian.net/browse/HV-792"> HV-792</a>
      </td>
  </tr>
  <tr>
    <td>Spring Data: provide more flexibility when working with JPQL queries</td>
    <td>
      <a href="https://jira.springsource.org/browse/DATAJPA-292"> DATAJPA-292</a>
      </td>
  </tr>  
  <tr>
    <td>Eclipse: validation bug when working with .tag/.tagx files (has only been fixed for Eclipse 4.3 (Kepler)). <a href="https://github.com/spring-projects/spring-petclinic/issues/14">See here for more details.</a></td>
    <td>
      <a href="https://issuetracker.springsource.com/browse/STS-3294"> STS-3294</a>
    </td>
  </tr>    
</table>




