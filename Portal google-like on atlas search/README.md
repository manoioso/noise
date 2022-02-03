 ![image](https://user-images.githubusercontent.com/92857777/152309544-6dafee62-c4ed-437c-afbb-a2cef17b6563.png)



**About**


"Portal google-like on Atlas search" is a small js project based on Node.

The idea is to use it during TFWs or TDDs to show to the Customer how is simple create a portal search based on Atlas search.
The atlas search is connected to my "trinity cluster" on Atlas. I create an text search autocomplete on title of "Theologic books databased".
I downloaded it form British Library Catalogue Datasets:

https://www.bl.uk/collection-metadata

very usufull for any search test and poc.
I developed a simple node app with a couple of microservice :-) for search and get from Atlas


**Installation**

![image](https://user-images.githubusercontent.com/92857777/152310941-c7feea0b-55ce-4290-b286-4f4255d8111e.png)

- install node on you mac, you can use brew

https://www.npmjs.com/package/homebrew

- download the fiels in the same directory

**Run the app**

- run --> node search.js

![image](https://user-images.githubusercontent.com/92857777/152311275-216659c2-0200-4147-9a3b-cb5a3c67b556.png)

run --> node app.js

![image](https://user-images.githubusercontent.com/92857777/152311452-f05c299b-56d0-4ed4-954e-7401e15baf7c.png)

- go to chrome 

http://localhost:4000/

![image](https://user-images.githubusercontent.com/92857777/152311580-6e26a576-82be-4ebe-961d-2cf4eb05678e.png)


**Steps for demo:**

navigate to http://localhost:4000/

start a search google-like with a small word, the search will auto-complete based on the title of the book:

![image](https://user-images.githubusercontent.com/92857777/152311902-c6f3d1e6-c08e-4d1d-ac2b-574fe70d44d2.png)

when you choose a particular book from results you will see other fields of document:

![image](https://user-images.githubusercontent.com/92857777/152312049-2a4150cf-4000-4a4a-aa78-9fc8f3838af5.png)


here a document

![image](https://user-images.githubusercontent.com/92857777/152311776-279e98e3-27d4-4a67-a5b7-303b41d5a84b.png)

**Next steps:**

Feel free to extend the search with highlights, facets and so on

enjoy :-)
