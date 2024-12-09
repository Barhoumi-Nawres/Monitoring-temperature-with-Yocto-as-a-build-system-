
# Monitoring Temperature with Yocto as a Build System

This project is about monitoring temperature using a Raspberry Pi 3B+ with a DHT11 sensor. I'm using the Yocto Project as a build system to customize the development environment.

## BSP (Board Support Package)

We need to add a layer to support the Raspberry Pi (\`meta-raspberry\`).

## About Recipe: virtual/kernel

### Git Configuration for Large File Transfers

To enhance Git's performance with large file transfers, use the following commands:

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

Next, use \`dd\` to write the image to the SD card:

```bash
sudo dd if=core-image-minimal-raspberrypi3.rpi-sdimg of=/dev/sdb bs=4M status=progress conv=fsync
```

This will copy the Yocto image to the SD card.
