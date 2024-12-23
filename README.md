
# Monitoring Temperature with Yocto as a Build System

This project is about monitoring temperature using a Raspberry Pi 3B+ with a DHT11 sensor. I'm using the Yocto Project as a build system to customize the development environment.

## BSP (Board Support Package)
You will need a BSP layer to support the Raspberry Pi boards. 
So Yocto Project is providing a meta-raspberrypi layer that contains information related to raspberry pi boards that are required during the build.
so you need to download meta-raspberrypi layer from the poky directory using the flowing command :


    ```
    $ git clone https://git.yoctoproject.org/meta-raspberrypi -b dunfell
    ```

## About Recipe: virtual/kernel
### Issue: Fetching Kernel Sources Fails in Yocto Recipe

### Problem Description:
When attempting to fetch kernel sources for the virtual/kernel recipe in a Yocto build environment, the do_fetch task fails. 
The following error is observed:

<img src="linux-kernal.png" alt="error about virtaul/kernel" width="900" height="400" >

### Solution:
To address the issue and ensure the successful fetching of the kernel sources, follow these steps:


1. **Increase the buffer size used by Git for HTTP transfers**:

    ```bash
    git config --global http.postBuffer 157286400
    ```

    This allows Git to send or receive larger files in one go (up to 150 MB).

2. **Reduce the compression window size**:

    ```bash
   
    git config --global pack.window 1
   
    ```

    This reduces the memory usage during compression, potentially improving performance on some systems.

4. **Disable file compression in Git**:

    ```bash
    git config --global core.compression 0
    ```

    This disables file compression, speeding up Git operations but using more disk space.

5. **Fetch kernel sources using Bitbake**:

    ```bash
    bitbake virtual/kernel -c do_fetch
    ```

    This command downloads the necessary files to build the Linux kernel in a Yocto project.
   

## Copy the Image to the SD Card

First, identify the SD card device by running:

```bash
lsblk
```

umount the partitions :

```bash
sudo umount /dev/sdX
```

Next, use \`dd\` to write the image to the SD card:

```bash
sudo dd if=core-image-minimal-raspberrypi3.wic.bz2 of=/dev/sdb bs=4M status=progress conv=fsync
```

This will copy the Yocto image to the SD card.
