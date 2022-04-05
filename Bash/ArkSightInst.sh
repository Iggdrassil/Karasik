#!/bin/bash
systemctl stop firewalld
systemctl disable firewalld
yum -y install unzip
iptables-save
chmod u+x ArcSight-logger-6.3.0.7861.0.bin 
#ls /etc/security/limits.d/*-nproc.conf
echo "*	soft	nproc	10240" > /etc/security/limits.d/*-nproc.conf
echo "*	hard	nproc	10240" >> /etc/security/limits.d/*-nproc.conf
echo "*	soft	nofile	65536" >> /etc/security/limits.d/*-nproc.conf
echo "*	hard	nofile	65536" >> /etc/security/limits.d/*-nproc.conf
echo "System will be rebooting. Press Enter"
read Enter
reboot
ulimit -a | grep "open files" # =65536
ulimit -a | grep "max user procesess" #=10240
./ArcSight-logger-6.3.0.7861.0.bin -i console
#systemctl status arcsight_logger.service