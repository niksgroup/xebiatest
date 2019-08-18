# xebiatest
XEBIA TEST Code

This project is written in SpringBOOT.

To run this either import to eclipse and run as Spring Boot app or build using CMD and run the WAR.

Once you deploy the project to any server you can access the service endpoint 

Customers are categorized into 3 groups that need to be passed from input : 

CUST - Normal customer
EMP - Employee 
AFFL - Affiliate

Need to pass : customerRelationAgeInYrs 

Type of products : 
groceries/ELECTRONICS. etc 

Service Endpoint : 

http://localhost:8080/purchase/calculate

Header : 

Content-Type : application/json


<Sample Input> : 

{
	"customer" : {
		"customerName" : "Sudhir Mishra",
		"customerId" : "12345",
		"customerType" : "EMP",
		"customerRelationAgeInYrs" : 2
	},
	"itemList" : [
		{
			"itemName" : "Pen Drive",
			"itemCode" : "7764",
			"itemPrice" : 1000,
			"itemCategory" : "groceries"
		},
		{
			"itemName" : "LED TV",
			"itemCode" : "2245",
			"itemPrice" : 100,
			"itemCategory" : "ELECTRONICS"
		}
		]
}

Sample Output :

{
    "status": "SUCCESS",
    "message": "Please pay : $950.0. You got a discount of $80.0"
}
