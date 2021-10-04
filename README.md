# retail-discount-store
A retail store offering different types of discounts to users

# retail-discount-store
A retail store offering different types of discounts to users

#Restful api

#Technology =>  
SpringBoot
Java 8

#IDE
Eclipse EE Version: 2021-03 (4.19.0)

#End Point =>
POST: localhost:8080/api/calculateBill

#Input type => 
JSON

#Api Testing In eclipse => 
  RUN ApiApplicationTests.java as a JUnit Test
 
#Run app in eclipse
1. navigate into project folder using cmd
2. run (mvn clean)
3. run (mvn install)
4. or run (mvn install -DskipTests=true) : to skip tests 
5. import project into eclipse as an Existing Maven Project
6. Navigate to src/main/java/com/retail/store/api
7. Run ApiApplication.java as a java project

#Api testing app =>
POSTMAN 7.36

![Ca](https://user-images.githubusercontent.com/43088501/135939033-eef130c0-aa28-47dc-bfc5-122d322c8644.PNG)


#Example Input => 
  {
    "user":{
        "firstName":"Mark",
        "lastName":"Wilson",
        "type":"customer",
        "joinDate":"2019-09-08"
    },
    "products":[
        {
            "productName":"Juice",
            "productPrice": 100.00,
            "productType": "grocery",
            "quantity": 2
        },
        {
            "productName":"Hammer",
            "productPrice": 100,
            "productType": "hardware",
            "quantity": 1
        }
    ]   
}

#Example Output =>
{
    "response": "Bill [user=User [firstName=Mark, lastName=Wilson, type=customer, joinDate=Sun Sep 08 02:00:00 SAST 2019], products=[Products [productName=Juice,   productPrice=100.0, productType=grocery, quantity=2], Products [productName=Hammer, productPrice=100.0, productType=hardware, quantity=1]], netTotal=285.0]"
}

#Coverage Reports =>
Generated with Jacoco
on cmd run : mvn clean then mvn install to generate the report. 
The report will be in target/my-reports. Right click on the index.html and opne in browser to view the coverage.  
![Ca](https://user-images.githubusercontent.com/43088501/133018107-116979cd-b6bc-4c98-b922-cd7ea345ab2d.PNG)


#Uml

![Retail Store UML](https://user-images.githubusercontent.com/43088501/133040042-4cc67445-fb45-464d-9a33-a664bf4fd615.png)

