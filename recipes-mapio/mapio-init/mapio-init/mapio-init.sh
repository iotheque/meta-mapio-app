#!/bin/bash

# Resize data partiton to maximal size
resize2fs /dev/mmcblk1p4

# Signal that first boot has been done
touch /boot/first_boot_done