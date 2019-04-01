Spring Web Security with H2 data base.

Configuring H2 DataBase
------------------------

1) make directory of any name <drive:\H2Database>
2) Copy h2 inside the directory.
3) create one more directory to store database files <drive:\H2Database\databases>
4) run command:- java -cp h2.jar org.h2.tools.Server -web -webPort 2000 -webAllowOthers -tcp -tcpAllowOthers -tcpPort 3000
   this will start h2 database in server mode
 
