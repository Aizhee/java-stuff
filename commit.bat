@echo off

:: Navigate to the parent directory of the batch file
cd /d .
set parentDirectory=%CD%

:: Define the batch file name
set batchFileName=%~nx0

:: Check if .gitignore already exists
if exist "%parentDirectory%\.gitignore" (
    echo .gitignore file already exists in the parent directory.
) else (
    :: Create a .gitignore file to ignore the batch file itself
    echo %batchFileName% > "%parentDirectory%\.gitignore"
    echo .gitignore file created in the parent directory to ignore the batch file.
)

:: Prompt user for the repository link if remote 'origin' does not exist
git remote get-url origin >nul 2>&1
if errorlevel 1 (
    set /p repoLink="Enter the repository link: "
    :: Add a remote repository named 'origin'
    git remote add origin "%repoLink%"
    if errorlevel 1 (
        echo Failed to add remote repository 'origin'.
        pause
        exit /b 1
    )
)

:: Add all changes to the staging area
git add -A
if errorlevel 1 (
    echo git add failed
    pause
    exit /b 1
)

:: Prompt for commit message
set /p commitMessage="Enter the commit message: "

:: Commit changes
git commit -m "%commitMessage%"
if errorlevel 1 (
    echo git commit failed
    pause
    exit /b 1
)

:: Rename the branch to 'main'
git branch -M main
if errorlevel 1 (
    echo git branch rename failed
    pause
    exit /b 1
)

:: Push changes to the 'main' branch on the remote repository
git push -u origin main
if errorlevel 1 (
    echo git push failed
    pause
    exit /b 1
)

pause
