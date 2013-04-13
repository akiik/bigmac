##########
INSTALL
##########
J‰rgnev installeerimisjuhend on mıeldud OS W7'le, millel on eelnevalt installeeritud
Java Standard Edition Runtime Environment (JRE) versioon 6 vıi hilisem ning MinGW.

##########
STEP 1
##########
Klooni repositoorium enda arvutisse:
Selleks tuleb git bashis sisestada k‰sk:
git clone https://github.com/akiik/bigmac.git

##########
STEP 2
##########

Ava lokaalse repositooriumi kaust. 
Mine intall kataloogi.
K‰ivita "installer.bat" fail.
NB!
Installiskripti staatilisuse tıttu on v‰ga oluline, 
et Tomcat Server installeeritakse vaikekataloogi "C:\Program Files\Apache Software Foundation\Tomcat 7.0\"",
mysql installeeritakse kataloogi "C:\Program Files\MySQL\MySQL Server 5.5\",
ja et tomcati HTTP/1.1 Connector port 8888;
Muud parameetrid peaksid j‰‰ma vaikimisi.
Installsrcipt installeerib Tomcati ja Mysqli ning seadistab andmebaasi.

##########
STEP 3
##########
Mine aadressile http://localhost:8888/