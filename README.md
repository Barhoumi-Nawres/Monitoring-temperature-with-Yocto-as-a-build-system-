# Monitoring-temperature-with-Yocto-as-a-build-system-
this project is about monitoring temperature  using raspberryPI3B+ with DHT11 sensor  ,i'am using Yocto project as abuild system to customize the development environment .
# BSP (board support package ) 
we need to add a layer to support raspberry(meta-raspberry)

## About recipe virtual/kernel



git config --global http.postBuffer 157286400
(/ 1.   But : Augmenter la taille du tampon utilisé par Git lors des transferts HTTP.
    Effet : Permet de télécharger ou envoyer de plus gros fichiers en une seule fois (ici, 150 Mo).

2. git config --global pack.window 1

    But : Réduire la taille de la fenêtre de compression des fichiers dans Git.
    Effet : Git va utiliser moins de mémoire pour compresser les fichiers, ce qui peut améliorer les performances sur certains systèmes.

3. git config --global core.compression 0

    But : Désactiver la compression des fichiers dans Git.
    Effet : Accélère les opérations Git en réduisant l'utilisation du processeur, mais utilise plus d'espace disque.

4. bitbake virtual/kernel -c do_fetch

    But : Télécharger les sources nécessaires pour le noyau Linux dans un projet Yocto.
    Effet : Télécharge les fichiers nécessaires pour construire le noyau.
)


# Copy the iamge in SD card 
First, you need to identify the SD card device using the following command in Linux:


```bash
lsblk



