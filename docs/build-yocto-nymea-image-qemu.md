# Build `yocto-nymea-image` for QEMU with Yocto Wrynose

This builds the `yocto-nymea-image` target from `meta-nymea` for `qemux86-64` and boots it with QEMU. The flow follows the Yocto Project 6.0 "wrynose" `bitbake-setup` workflow.

## 1. Install host packages

Use a supported Linux build host. For Ubuntu or Debian:

```bash
sudo apt-get install build-essential chrpath cpio debianutils diffstat file \
    gawk gcc git iputils-ping libacl1 libcrypt-dev locales python3 \
    python3-git python3-jinja2 python3-pexpect python3-pip \
    python3-subunit socat texinfo unzip wget xz-utils zstd
sudo dpkg-reconfigure locales
```

Yocto Wrynose expects a reasonably large build machine. Plan for at least 140 GB free disk space and 32 GB RAM.

## 2. Create the Wrynose setup

Create the working directory for your yocto setup.

```bash
mkdir -p yocto/nymea-wrynose
cd yocto/nymea-wrynose

git clone https://git.openembedded.org/bitbake
./bitbake/bin/bitbake-setup init --setup-dir-name nymea \
    --non-interactive poky-wrynose poky distro/poky machine/qemux86-64
```

If the non-interactive setup choices change in a newer BitBake, run this instead and select `poky-wrynose`, `poky`, `qemux86-64`, and `poky` when prompted:

```bash
./bitbake/bin/bitbake-setup init --setup-dir-name nymea
```

## 3. Add the nymea layers

Clone the extra layers into the setup:

```bash
git clone -b wrynose https://git.openembedded.org/meta-openembedded bitbake-builds/nymea/layers/meta-openembedded
git clone -b 6.11.1 https://code.qt.io/yocto/meta-qt6.git bitbake-builds/nymea/layers/meta-qt6
git clone -b wrynose https://github.com/nymea/meta-nymea.git bitbake-builds/nymea/layers/meta-nymea
```

`meta-nymea` requires `meta-qt6` 6.11.0 or newer. The example above uses the current default branch, `6.11.1`.

If you are already working from a local `meta-nymea` checkout, use that checkout path in the `bitbake-layers add-layer` command below instead of cloning it again.

Enter the build environment and add the layers:

```bash
source bitbake-builds/nymea/build/init-build-env

bitbake-layers add-layer ../layers/meta-openembedded/meta-oe
bitbake-layers add-layer ../layers/meta-openembedded/meta-python
bitbake-layers add-layer ../layers/meta-qt6
bitbake-layers add-layer ../layers/meta-nymea
```

For easier local QEMU testing, allow root login with an empty password:

```bash
bitbake-config-build enable-fragment core/yocto/root-login-with-empty-password
```

## 4. Build the image

```bash
bitbake yocto-nymea-image
```

The first build takes a while because it builds Yocto, Qt 6, nymea, the plugin sets, and the image.

## 5. Boot in QEMU

```bash
runqemu qemux86-64 yocto-nymea-image nographic
```

If your host supports KVM:

```bash
runqemu qemux86-64 yocto-nymea-image kvm nographic
```

## 6. Check nymea in the guest

Log in as `root` and check the daemon:

```bash
which nymead
ps | grep nymead
```

If the image uses systemd:

```bash
systemctl status nymead
```

## Rebuild later

```bash
cd yocto/nymea-wrynose
source bitbake-builds/nymea/build/init-build-env
bitbake yocto-nymea-image
runqemu qemux86-64 yocto-nymea-image nographic
```

## Common problems

If BitBake reports `Nothing PROVIDES ...`, check the layer list:

```bash
bitbake-layers show-layers
```

The build needs `meta-oe`, `meta-python`, `meta-qt6`, and `meta-nymea`.

## References

- Yocto Project 6.0 Quick Build: <https://docs.yoctoproject.org/6.0/brief-yoctoprojectqs/index.html>
- BitBake `bitbake-setup`: <https://docs.yoctoproject.org/bitbake/bitbake-user-manual/bitbake-user-manual-environment-setup.html>
- Qt `meta-qt6`: <https://doc.qt.io/Boot2Qt/b2qt-meta-qt6.html>
