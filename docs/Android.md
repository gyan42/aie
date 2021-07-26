wget -O - https://skia.googlesource.com/skia/+archive/cd048d18e0b81338c1a04b9749a00444597df394/platform_tools/android/bin/linux.tar.gz | tar -zxvf - adb
sudo mv adb /usr/bin/adb
sudo chmod +x /usr/bin/adb
adb version