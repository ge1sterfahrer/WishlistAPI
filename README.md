# WishlistAPI
 This Web API returns the contents of Amazon Wishlists in JSON.
 
## Usage
 To use this API clone the repository or download the newest release from GitHub.
 The port used in this application is 8081, please see the application.properties if you need to run with a different port.
 
 If run locally the API will listen on localhost:8081/wishlist_api and needs two parameters:
 - The Top-Level-Domain of your wishlist ("de", "com", "co.uk")
 - The Wishlist ID found in the Wishlist URL

 API call example: http://localhost:8081/wishlist_api?tld=de&id=2L8FP7DFBFEC7
 
 ## Return
 If called correctly the API will return valid JSON containing the following attributes of every item on the wishlist:
 - Link to preview image
 - Name of item
 - Comment of wishlist creator
 - Price
 - Amount needed
 - Amount received

## wHy DoNt U iNcLuDe ThE iTeM lInK???
For simplicity I gather all the data from the printview version of the Amazon Wishlist which does not include links to the items.


 ## Technical Details
 This is a Spring Boot application using Jsoup for HTML parsing and GSON for generating valid JSON from objects.
 
