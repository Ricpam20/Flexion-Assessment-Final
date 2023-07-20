#!/bin/bash

# Function to check if a command is installed
command_exists() {
  command -v "$1" >/dev/null 2>&1
}

# Check and install Java 11
if ! command_exists java; then
  echo "Java 11 not found. Installing OpenJDK 11..."
  sudo curl -O https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz
  sudo tar zxvf openjdk-11.0.1_linux-x64_bin.tar.gz
  sudo mv jdk-11.0.1 /usr/local/
else
  echo "Java 11 is already installed."
fi

sudo echo "export JAVA_HOME=/usr/local/jdk-11.0.1\n export PATH=$PATH:$JAVA_HOME/bin" > /etc/profile.d/jdk11.sh
sudo source /etc/profile.d/jdk11.sh

sudo yum install -y httpd 

# Show installed versions
echo "Installed Versions:"
java --version

sudo systemctl stop httpd

#boot applications
sudo cp -r frontend/* /var/www/html/
sudo systemctl start httpd

cd ~/backend/
nohup java -jar assessment-0.0.1-SNAPSHOT.jar >> logs.log


