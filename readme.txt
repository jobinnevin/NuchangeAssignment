Hello. 
I have used the HashMap concept here to store the url and its corresponding count.
When a comand is entered, the url after the command is passesed as an argument to the corresponding functions:

storeurl()		:	This function checks if the entered url is already stored,
					if not, it intiantes a unique key to the url using generatekey() function and store the url and count = 0 into the hasmap.

get()			:	This function if the url entered is present in the table,
					if yes, it increments the count by1 and puts the same into the hashmap.

count()			:	This function if the url entered is present in the table,
					if yes, it shows the count of the given url.

list()			:	This function will list out the urls stored and also its corresponding count value


generatekey()	:	This function returns a 8 character unique string using random.
