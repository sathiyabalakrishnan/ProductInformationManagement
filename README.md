"# ProductInformationManagement" 

The following sample REST APIs could be used to push the data to the PIM: load the data to H2 database

POST /products/ → Creates a new products
PUT /products/ → Update the product with SKU =
GET /products/ → Get the details of product with SKU =


Steps to run :
---------------

1. Build the Jar using mvn clean install
2. Run the below cmd in cmd prompt.

java -jar pmi-1.0-SNAPSHOT.jar com.mercado.pmi.Application

3. Import the Curl collection in your postman and try the above end points with port 8000

Notes: Please find postman collection in zip
