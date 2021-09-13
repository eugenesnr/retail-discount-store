# retail-discount-store
A retail store offering different types of discounts to users

# retail-discount-store
A retail store offering different types of discounts to users

#Restful api

#Technology =>  
SpringBoot
Java 8

#End Point =>
POST: localhost:8080/api/calculateBill

#Input type => 
JSON

#Api Testing In eclipse => 
  RUN ApiApplicationTests.java as a JUnit Test

#Api testing app =>
POSTMAN 7.36

![Capture](https://user-images.githubusercontent.com/43088501/133017928-a232ab7c-c0d9-4a64-b870-6e38b1cee24d.PNG)

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
    "response": "Bill [user=User [firstName=Mark, lastName=Wilson, type=customer, joinDate=Sun Sep 08 02:00:00 SAST 2019], products=[Products [productName=Juice,   productPrice=100.0, productType=grocery, quantity=2], Products [productName=Hammer, productPrice=100.0, productType=hardware, quantity=1]], netTotal=280.25]"
}

#Coverage Reports =>
Generated with Jacoco
on cmd run : mvn clean then mvn install to generate the report. 
The report will be in target/my-reports
![Ca](https://user-images.githubusercontent.com/43088501/133018107-116979cd-b6bc-4c98-b922-cd7ea345ab2d.PNG)
