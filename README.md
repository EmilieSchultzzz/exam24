Step 1.
Extract the files from the compressed zip file. I have extracted my files to my onedrive desktop, and it is therefore here I will access the files from.

Step 2.
In the command prompt, go to the folder that contains the exam24-main folder:
    cd OneDrive\Skrivebord\exam24-main

Step 3.
Since the program uses packages, compile the program as:
    javac -d out exam24-main/models/*.java exam24-main/interfaces/*.java

Step 4.
Execute the generated file as:
    java -cp out models.ActivityOrganizer