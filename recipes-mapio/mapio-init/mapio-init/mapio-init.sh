#!/bin/bash

# Resize data partiton to maximal size
resize2fs /dev/mmcblk1p4

# Create volume directories for containers
mkdir -p /usr/local/domoticz
mkdir -p /usr/local/homebridge
mkdir -p /usr/local/homeassistant
mkdir -p /usr/local/zigbee2mqtt
mkdir -p /usr/local/samba
mkdir -p /usr/local/avahi
mkdir -p /usr/local/nvme

# Signal that first boot has been done
touch /boot/first_boot_done