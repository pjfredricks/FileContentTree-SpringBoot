# FileContentTree-SpringBoot
The FileContentTree project migrated into Spring Boot

Use the included File_Tree_Input.txt for testing purposes.
Refer the TreeCollections project in my repo for what the project does.


### The aim of this project is to override the Comparator method in treecollections.Tree Object, so that the objects inserted into the treecollections.Tree can be sorted in a User defined order.

>> #### A set of values are read from a text file, they contain (name,designation) pairs.
>> #### These values are stored in a hashmap as (key,value) pairs.
>> #### The custom sorting order is stored in another hasmap as (rank,designation) pairs.
>> #### The values are sorted based on their ranking.
>> #### They are inserted into a treecollections.Tree Object in sorted order.
>> #### treecollections.Tree objects contain a comparator method which automatically sorts inserted objects in ascending order.
>> #### We need to override this comparator object to preserve our insertion order.
>> #### In order to do so we implement to comparator method and set it to return true always.
