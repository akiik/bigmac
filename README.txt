##########
INSTALL
##########


##########
STEP 1
##########
Klooni repositoorium enda arvutisse:
Selleks tuleb git bashis sisestada käsk:
git clone https://github.com/akiik/bigmac.git

##########
STEP 2
##########
Lae alla ja seadista ANT:
http://mirror.cc.columbia.edu/pub/software/apache//ant/binaries/apache-ant-1.9.0-bin.zip
Paki lahti.
Seadista keskkonnamuutujad:
JAVA_HOME=kaust/kus/asub/java/JDK ja ANT_HOME=kaust/kus/asub/ANT ning
lisa PATH muutujale ;kaust/kus/asub/ANT/bin

Testi käsureal: ant
kui not found build.xml siis OK

##########
STEP 3
##########

Lae alla tomcat: http://servingzone.com/mirrors/apache/tomcat/tomcat-7/v7.0.39/bin/apache-tomcat-7.0.39.zip
Paki lahti.
Mine repositooriumi kausta ja ava fail build.xml.
Neljandal real asenda 
	<property name="tomcat" value="D:\Programmid\apache-tomcat-7.0.39" />
value väärtus lahti pakitud tomcati kasuta asukohaga.
Sulge build.xml
Seadista kesskonnamuutuja CATALINA_HOME = tomcati/kaust

##########
STEP 4
##########
Lae alla ja installeeri MYSQL:http://www.mysql.com/downloads/

MYSQL installeerimisjuhised:
vali Typical install
next .. next .. (vaikimisi valikud)
Lõpus märgista kindlasti Launch the Mysql Instance configuration Wizard -> Finish
vali "Detailed Configuration" -> Next
vali "Developer machine" -> Next
 .. next .. next.. 
vali "Manual Selected Default Character Set" -> UTF8 -> NEXT
vali "Install as Windows Service" -> Next
võta linnuke "Modify Security settings" eest ära -> Next
vali EXECUTE
vali Finish

Käivita Mysql (kui juba ei käi)
impordi andmebaas, fail on repos install/elections.sql
selleks liigu käsureal mysql bin kausta, ja käivita käsk
mysql -u root mysql < täielik\tee\sinu\repo\kaustani\install\elections.sql

##########
STEP 5
##########
Jooksuta ANT build script (build.xml repo kaustas)
Ava käsurida, mine repo kausta ja sisesta käsk "ant".

##########
STEP 6 
##########
Mine aadressile http://localhost:8080/bigmac

##########
STEP 7 
##########

Testimiseks jooksuta käsk "ant runTest".

Testitulemuste vaatamiseks mine repo kausta ja sealt kausta testng_output ning ava index.html browseris.


