#!/bin/bash

# Function to check if a command is installed
command_exists() {
  command -v "$1" >/dev/null 2>&1
}

# Check and install Maven 3
if ! command_exists mvn; then
  echo "Maven not found. Installing Maven 3..."
  sudo yum update
  sudo yum install -y maven
else
  echo "Maven is already installed."
fi

# Check and install Java 11
if ! command_exists java; then
  echo "Java 11 not found. Installing OpenJDK 11..."
  sudo yum update
  sudo yum install -y openjdk-11-jdk
else
  echo "Java 11 is already installed."
fi

# Check and install Node.js 18 (only if Node.js 18 is available)
if ! command_exists node; then
  echo "Node.js not found. Installing Node.js 18..."

  # Add NodeSource repository for Node.js 18
  curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -

  # Install Node.js
  sudo yum install -y nodejs
else
  echo "Node.js is already installed."
fi

# Show installed versions
echo "Installed Versions:"
mvn -version
java -version
node -v
npm -v
ls
pwd

sudo fuser -k 3000/tcp
sudo fuser -k 8080/tcp

#boot applications
cd ~/backend/
nohup java -jar assessment 0.0.1-SNAPSHOT.jar 

cd ~/frontend/
npm install
npm start
