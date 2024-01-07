#!/bin/bash

# Stop the services that can use the data partition
systemctl stop docker
systemctl stop docker.socket
systemctl stop usr-local-nvme.automount
systemctl stop usr-local-nvme.mount

# Resize data partiton to maximal size
umount /dev/mmcblk1p4
parted -s /dev/mmcblk1 resizepart 4 100%
resize2fs -f /dev/mmcblk1p4
mount /dev/mmcblk1p4 /usr/local

# Signal that first boot has been done
touch /boot/first_boot_done

# Reboot
reboot