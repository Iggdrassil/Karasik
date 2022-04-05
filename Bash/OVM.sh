#!/bin/bash
systemctl stop firewalld
systemctl disable firewalld
yum -y install unzip libaio
yum -y install iptables-services
yum -y install zip
yum -y install perl perl-Data-Dumper
yum -y install net-tools
mount -o loop Oracle\ VM\ Manager\ 3.4.6.2105\ \(V980621-01\).iso /mnt
cd /mnt/
./createOracle.sh 
./runInstaller.sh 