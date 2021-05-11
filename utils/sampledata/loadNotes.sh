while IFS= read -r line; do
   USERNAME="`echo $line | cut -d , -f1`"
   echo "USERNAME=${USERNAME}"
   NOTEBOOKNAME="`echo $line | cut -d , -f2`"
   echo "NOTEBOOKNAME=${NOTEBOOKNAME}"
   NOTENAME="`echo $line | cut -d , -f3`"
   echo "NOTENAME=${NOTENAME}"
   NOTETITLE="`echo $line | cut -d , -f4`"
   echo "NOTETITLE=${NOTETITLE}"
   NOTECONTENT="`echo $line | cut -d , -f5-`"
   echo "NOTECONTENT=${NOTECONTENT}"
   
   echo "-----------------------------"
  if [ $USERNAME != "" ]; then
	firefox "http://localhost:8080/note/add?userName=${USERNAME}&noteBookName=${NOTEBOOKNAME}&noteName=${NOTENAME}&noteTitle=${NOTETITLE}&noteContent=${NOTECONTENT}"
  fi
  
done < linux-notes.list
#done < java-notes.list