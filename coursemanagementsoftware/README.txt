COURSE MANAGEMENT SOFTWARE

The classes are organised as Model classes(Course, Participant,Faculty) and a central View cum Controller(Main.java) . MyFileIOManager class helps in writing to the text file data.txt.

The model classes are written as per requirement and in the Main.java , apart from storing the Courses , I have also stored the Faculty and Participants to extend features if needed(there was an ambiguity related to uniqueness of participants, so if I need to switch to a case where a participant can be part of multiple courses , I can extend it)


To make the file reading and writing simpler , I have used a DataBundle class which contains the courses and related data in it. So only one object is read and written.

NOTE:
The dates to be entered must be in dd/mm/yyyy format i.e 12/2/96 would pass as 12th Feb 96 AD while 12-12-2015 wouldn't pass


