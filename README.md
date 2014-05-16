android_packages_apps_Browser
=============================

Mod of CM browser (clone of AOSP browser?), tested on i9100/CM11

Renamed package, name and made appicon red
removed adding RLZ param to google search URLs
 (doesn't work anyway on CM11 without "Play Services")
removed "more" button from navbar, since there is a menu button on i9100
added search icon to navbar to enable search suggestions, search suggestions disabled by default
changed configurable user agents
added option to clear cookies on startup

Is it good for privacy now?
No. Besides missing features:
Unable (?) to clean HTML5 session storage without restart,
Reported resolution is quite unique
User agent contains minor version numbers (also unique)
