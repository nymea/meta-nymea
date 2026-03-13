# Build `yocto-nymea-image` with Poky and run it in QEMU

This tutorial shows how to build the nymea image from this layer with the normal Poky workflow and then boot it in QEMU, similar to the Yocto Project Scarthgap quick start.

The BitBake target in this repository is `yocto-nymea-image`.

## 1. Host prerequisites

Use a supported Linux build host and install the packages required by the Yocto Project for your distribution.

For Ubuntu or Debian, the Scarthgap documentation currently lists:

```bash
sudo apt-get install build-essential chrpath cpio debianutils diffstat file \
    gawk gcc git iputils-ping libacl1 liblz4-tool locales python3 python3-git \
    python3-jinja2 python3-pexpect python3-pip python3-subunit socat \
    texinfo unzip wget xz-utils zstd
sudo dpkg-reconfigure locales
```

If you use another distribution, follow the matching package list from the Yocto Project system requirements page.

## 2. Get the required layers

Create a workspace and clone the layers next to each other:

```bash
mkdir -p ~/yocto/nymea-scarthgap
cd ~/yocto/nymea-scarthgap

git clone -b scarthgap https://git.yoctoproject.org/poky
git clone -b scarthgap https://git.openembedded.org/meta-openembedded
git clone -b 6.10.3 https://code.qt.io/yocto/meta-qt6.git
git clone https://github.com/nymea/meta-nymea.git
```

Notes:

- `meta-nymea` declares compatibility with `kirkstone` and `scarthgap`.
- `meta-qt6` is required because nymea depends on Qt 6 recipes.
- `meta-openembedded/meta-oe` is needed for packages such as `influxdb`, `libgpiod`, `hidapi`, `libsodium`, and `owfs`.
- `meta-openembedded/meta-python` is required by `meta-qt6`.

If you are working from an existing checkout of this repository, use that checkout instead of cloning `meta-nymea` again.

## 3. Initialize a standard Poky build directory

This uses the usual Poky setup script and creates a separate build directory named `build-nymea`:

```bash
cd ~/yocto/nymea-scarthgap
source poky/oe-init-build-env build-nymea
```

After this command, your shell is inside `~/yocto/nymea-scarthgap/build-nymea`.

## 4. Add the layers

From inside the build directory:

```bash
bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-qt6
bitbake-layers add-layer ../meta-nymea
```

You can verify the result with:

```bash
bitbake-layers show-layers
```

## 5. Set the target machine

For a QEMU bootable x86-64 image, set the machine in `conf/local.conf`:

```conf
MACHINE ?= "qemux86-64"
```

That is enough for a first build.

Optional settings that are useful for local QEMU testing:

```conf
EXTRA_IMAGE_FEATURES += "debug-tweaks"
```

`debug-tweaks` makes test booting easier by relaxing some default image restrictions. Leave it out if you want a stricter image.

## 6. Build the nymea image

Build the image from inside the initialized build environment:

```bash
bitbake yocto-nymea-image
```

This image recipe lives in this layer at `recipes-image/images/yocto-nymea-image.bb` and installs `packagegroup-nymea`.

The first build will take a while because it needs to build Poky, Qt 6, nymea, the nymea plugin sets, and the image itself.

## 7. Boot the image in QEMU

When the build finishes, start QEMU from the same shell:

```bash
runqemu qemux86-64 yocto-nymea-image nographic
```

If you want a graphical QEMU window, omit `nographic`:

```bash
runqemu qemux86-64 yocto-nymea-image
```

`runqemu` will automatically pick the most recent matching kernel and root filesystem from `tmp/deploy/images/qemux86-64/`.

## 8. Verify that nymea is present

Inside the booted guest, check that the daemon and its service files are installed:

```bash
which nymead
ps | grep nymead
```

If your image is using `systemd`, you can also check:

```bash
systemctl status nymead
```

## 9. Common rebuild workflow

After the first setup, the normal workflow is:

```bash
cd ~/yocto/nymea-scarthgap
source poky/oe-init-build-env build-nymea
bitbake yocto-nymea-image
runqemu qemux86-64 yocto-nymea-image nographic
```

## 10. Common problems

### `Nothing PROVIDES ...`

Usually this means one of the required layers is missing from `bblayers.conf`. Check that these are present:

- `poky/meta`
- `poky/meta-poky`
- `poky/meta-yocto-bsp`
- `meta-openembedded/meta-oe`
- `meta-openembedded/meta-python`
- `meta-qt6`
- `meta-nymea`

### Fetch failures from GitHub or Qt

This is usually a network or proxy issue. The Yocto Project quick start notes that fetch problems are common behind firewalls or missing proxy configuration.

### QEMU starts but you want faster booting

If your host supports KVM, try:

```bash
runqemu qemux86-64 yocto-nymea-image kvm nographic
```

## Summary

The shortest possible Poky-style flow is:

```bash
git clone -b scarthgap https://git.yoctoproject.org/poky
git clone -b scarthgap https://git.openembedded.org/meta-openembedded
git clone -b 6.10.3 https://code.qt.io/yocto/meta-qt6.git
git clone https://github.com/nymea/meta-nymea.git

cd poky
source oe-init-build-env ../build-nymea
bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-qt6
bitbake-layers add-layer ../meta-nymea
echo 'MACHINE ?= "qemux86-64"' >> conf/local.conf
bitbake yocto-nymea-image
runqemu qemux86-64 yocto-nymea-image nographic
```
