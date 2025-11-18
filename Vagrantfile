# Vagrantfile
Vagrant.configure("2") do |config|
  # Use Ubuntu 22.04
  config.vm.box = "ubuntu/jammy64"

  # Forward ports to host machine
  config.vm.network "forwarded_port", guest: 4200, host: 4200   # Angular
  config.vm.network "forwarded_port", guest: 8080, host: 8080   # Spring Boot
  config.vm.network "forwarded_port", guest: 3306, host: 3306   # MySQL

  # Optional: increase VM memory
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "4096"
    vb.cpus = 2
  end

  # Provision VM
  config.vm.provision "shell", inline: <<-SHELL
    # Update and install Docker
    sudo apt-get update
    sudo apt-get install -y apt-transport-https ca-certificates curl software-properties-common git

    # Install Docker
    curl -fsSL https://get.docker.com -o get-docker.sh
    sudo sh get-docker.sh

    # Install docker-compose
    sudo curl -L "https://github.com/docker/compose/releases/download/v2.20.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    sudo chmod +x /usr/local/bin/docker-compose

    # Add vagrant user to docker group
    sudo usermod -aG docker vagrant

    # Install Java (for Maven)
    sudo apt-get install -y openjdk-17-jdk maven nodejs npm
  SHELL

  # Sync project folder
  config.vm.synced_folder ".", "/home/vagrant/app"
end
