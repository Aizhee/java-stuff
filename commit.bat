@echo off
cd /d C:\Users\aizhar\eclipse-workspace

:: Check if the directory change was successful
if not "%cd%"=="C:\Users\aizhar\eclipse-workspace" (
    echo Failed to change directory.
    pause
    exit /b 1
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

:: Check if remote 'origin' already exists
git remote get-url origin
if not errorlevel 1 (
    echo Remote 'origin' already exists, skipping 'git remote add'.
) else (
    :: Add a remote repository named 'origin'
    git remote add origin https://github.com/Aizhee/java-stuff.git
    if errorlevel 1 (
        echo git remote add failed
        pause
        exit /b 1
    )
)

:: Push changes to the 'main' branch on the remote repository
git push -u origin main
if errorlevel 1 (
    echo git push failed
    pause
    exit /b 1
)

pause
