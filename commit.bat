@echo off
setlocal

git add .   :: Add all changes to the staging area

:: Prompt for commit message
set /p commitMessage="Enter the commit message: "

:: Git commands

git commit -m "%commitMessage%"
git branch -M main
git remote add origin https://github.com/Aizhee/java-stuff.git
git push -u origin main

endlocal
pause
