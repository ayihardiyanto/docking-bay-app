Docking System App
------------------
Contributors : Ayi Hardiyanto


This program is made in order to fulfill the Dkatalist recruitment program.

Instruction :
to run this program, there are steps to do.

Initial setup :
1. Open terminal (bash/powershell/cmd)
2. Point directory to the program directory.
   example (bash) : cd /c/docking-system-app
3. Install dependencies using 'mvn clean install' command

Running option :
1. To run the code using file (.txt) : java -jar docking-system-app-1.0-SNAPSHOT.jar #FILE_PATH#
2. To run the code using command inputs : java -jar docking-system-app-1.0-SNAPSHOT.jar #COMMAND#

Commands that can be used on this program :
1. CREATE_BOATING_DOCK #NUMBER > will generate piers based on #NUMBER inserted
2. RESERVE #REGISTRATION_NUMBER > will reserve pier by boat #REGISTRATION_NUMBER
3. DOCK #REGISTRATION_NUMBER > will dock the boat with specified #REGISTRATION_NUMBER 
4. LEAVE #NUMBER > will undock the boat from pier #NUMBER
5. STATUS > will provide current status of active piers (RESERVED/DOCKED)
6. EXIT > will terminate the program



