echo "HOME"
curl  -s http://localhost:8080
echo ""
echo "----- USER TEST -----"
echo -n "USER Add: TESTUSER1 : "
curl -s http://localhost:8080/user/add?userName=TESTUSER1\&firstName=Test\&lastName=User
 
curl -s http://localhost:8080/user/list | grep TESTUSER1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "USER Add: TESTUSER2 : "
curl -s http://localhost:8080/user/add?userName=TESTUSER2\&firstName=FNAME\&lastName=mylastname\&email=EMAIL\&address=GHAZIABAD

curl -s http://localhost:8080/user/list | grep TESTUSER2 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "USER Update: TESTUSER1 LASTNAME: "
curl -s http://localhost:8080/user/update?userName=TESTUSER1\&firstName=Test\&lastName=TESTLASTNAME

curl  -s http://localhost:8080/user/list | grep TESTUSER1 | grep TESTLASTNAME | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'

echo -n "USER Delete: TESTUSER1 : "
curl -s http://localhost:8080/user/delete?userName=TESTUSER1

curl -s http://localhost:8080/user/list | grep TESTUSER1 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'
echo -n "USER Delete: TESTUSER2 : "
curl -s http://localhost:8080/user/delete?userName=TESTUSER2
curl -s http://localhost:8080/user/list | grep TESTUSER2 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'
echo -n "User List: "
curl -s http://localhost:8080/user/list | grep TESTUSER2 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'

echo "----- NOTEBOOK TEST -----"
echo -n "NOTEBOOK Add: TESTUSER1 , NOTEBOOK1 : "
curl -s http://localhost:8080/notebook/add?userName=TESTUSER1\&noteBookName=NOTEBOOK1
curl -s http://localhost:8080/notebook/list | grep TESTUSER1 | grep NOTEBOOK1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTEBOOK Add: TESTUSER2 , NOTEBOOK1 : "
curl -s http://localhost:8080/notebook/add?userName=TESTUSER2\&noteBookName=NOTEBOOK1
curl -s http://localhost:8080/notebook/list | grep TESTUSER2 | grep NOTEBOOK1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTEBOOK List: "
curl -s http://localhost:8080/notebook/list | grep TESTUSER1 | grep NOTEBOOK1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTEBOOK List: TESTUSER1 : "
curl -s http://localhost:8080/notebook/list?userName=TESTUSER1 | grep TESTUSER1 | grep NOTEBOOK1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTEBOOK Delete: TESTUSER1 , NOTEBOOK1 : "
curl -s http://localhost:8080/notebook/delete?userName=TESTUSER1\&noteBookName=NOTEBOOK1
curl -s http://localhost:8080/notebook/list | grep TESTUSER1 | grep NOTEBOOK1 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'
echo -n "NOTEBOOK Delete: TESTUSER2 , NOTEBOOK1 : "
curl -s http://localhost:8080/notebook/delete?userName=TESTUSER2\&noteBookName=NOTEBOOK1
curl -s http://localhost:8080/notebook/list | grep TESTUSER2 | grep NOTEBOOK1 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'

#curl -s http://localhost:8080/note/list
#curl -s http://localhost:8080/note/list?userName=User4
#curl -s http://localhost:8080/note/list?userName=User4\&noteBookName=notebook3

echo "----- NOTE TEST -----"
echo -n "NOTE Add: TESTUSER1, NOTEBOOK1, NOTE1 : "
curl -s http://localhost:8080/note/add?userName=TESTUSER1\&noteBookName=NOTEBOOK1\&noteName=NOTE1\&noteTitle=NOTETITLE\&noteContent=NOTECONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK1 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTE Add: TESTUSER1, NOTEBOOK1, NOTE2 : "
curl -s http://localhost:8080/note/add?userName=TESTUSER1\&noteBookName=NOTEBOOK1\&noteName=NOTE2\&noteTitle=NOTETITLE\&noteContent=NOTECONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK1 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE2 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTE Add: TESTUSER1, NOTEBOOK2, NOTE1 : "
curl -s http://localhost:8080/note/add?userName=TESTUSER1\&noteBookName=NOTEBOOK2\&noteName=NOTE1\&noteTitle=NOTETITLE\&noteContent=NOTECONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK2 | grep TESTUSER1 | grep NOTEBOOK2 | grep NOTE1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'
echo -n "NOTE Update: TESTUSER1, NOTEBOOK2, NOTE1 : "
curl -s http://localhost:8080/note/add?userName=TESTUSER1\&noteBookName=NOTEBOOK2\&noteName=NOTE1\&noteTitle=NOTETITLE\&noteContent=UPDATEDCONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK2 | grep TESTUSER1 | grep NOTEBOOK2 | grep NOTE1| grep UPDATEDCONTENT | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/'

echo -n "NOTE List: "
#curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK1 
curl -s http://localhost:8080/note/list | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/' 
echo -n "NOTE List: TESTUSER1"
curl -s http://localhost:8080/note/list?userName=TESTUSER1 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/' 
echo -n "NOTE List: TESTUSER1, NOTEBOOK1 : "
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK1 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE1 | wc -l | sed 's/1/PASS/' | sed 's/0/FAIL/' 

echo -n "NOTE Delete: TESTUSER1, NOTEBOOK1, NOTE1 : "
curl -s http://localhost:8080/note/delete?userName=TESTUSER1\&noteBookName=NOTEBOOK1\&noteName=NOTE1\&noteTitle=NOTETITLE\&noteContent=NOTECONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK1 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE1 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'
echo -n "NOTE Delete: TESTUSER1, NOTEBOOK1, NOTE2 : "
curl -s http://localhost:8080/note/delete?userName=TESTUSER1\&noteBookName=NOTEBOOK1\&noteName=NOTE2\&noteTitle=NOTETITLE\&noteContent=NOTECONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK1 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE2 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'
echo -n "NOTE Delete: TESTUSER1, NOTEBOOK2, NOTE1 : "
curl -s http://localhost:8080/note/delete?userName=TESTUSER1\&noteBookName=NOTEBOOK2\&noteName=NOTE1\&noteTitle=NOTETITLE\&noteContent=NOTECONTENT
curl -s http://localhost:8080/note/list?userName=TESTUSER1\&noteBookName=NOTEBOOK2 | grep TESTUSER1 | grep NOTEBOOK1 | grep NOTE1 | wc -l | sed 's/0/PASS/' | sed 's/1/FAIL/'

