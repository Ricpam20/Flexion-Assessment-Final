#!/bin/bash

# Function to check if a command is installed
command_exists() {
  command -v "$1" >/dev/null 2>&1
}

# Check and install Java 11
if ! command_exists java; then
  echo "Java 11 not found. Installing OpenJDK 11..."
  sudo yum update
  sudo yum install -y java-11-openjdk
else
  echo "Java 11 is already installed."
fi

sudo yum install -y httpd 

# Show installed versions
echo "Installed Versions:"
java --version


#kill running processes
sudo fuser -k 3000/tcp
sudo fuser -k 8080/tcp

#boot applications
cd ~/backend/
cp ~/frontend/* /var/www/html
nohup java -jar assessment 0.0.1-SNAPSHOT.jar 


