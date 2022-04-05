#!/bin/bash
CHECKSUM_FIRST=$(md5sum /etc/syslog-ng/conf.d/*.conf | awk {'print $1'})
LOGGER_STATUS=$(systemctl status syslog-ng | grep Active:| awk {'print $2'})
#echo $LOGGER_STATUS
#echo $CHECKSUM_FIRST
if [ "$LOGGER_STATUS" == "active" ];
then
	echo Syslog is active
	vim /etc/syslog-ng/conf.d/*.conf
	CHECKSUM_SECOND=$(md5sum /etc/syslog-ng/conf.d/*.conf | awk {'print $1'})
	#echo $CHECKSUM_SECOND
	if [ "$CHECKSUM_FIRST" == "$CHECKSUM_SECOND" ];
	then
		echo Done. Syslog restarting not requied
	else
		echo Syslog needs restarting
		systemctl restart syslog-ng
		if [ "$LOGGER_STATUS" == "active" ];
		then
			echo Syslog successfully restarting and now $LOGGER_STATUS
			fi	
		fi
	
	else
	echo Syslog not started! Starting...
	systemctl start syslog-ng
	echo Syslog successgully started... Run that script again
	fi	
