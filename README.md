<code>
android_packages_apps_Browser
=============================

<br>Mod of CM browser (clone of AOSP browser?), to be used on i9100/CM11 (menu button, DPI, ...)
all the work done on cm-11.0 branch

<br>Renamed package, name and made appicon red
<br>removed adding RLZ param to google search URLs
<br>&nbsp;(doesn't work anyway on CM11 without "Play Services")
<br>removed "more" button from navbar, since there is a menu button on i9100
<br>added search icon to navbar to enable search suggestions, search suggestions disabled by default
<br>changed configurable user agents
<br>added option to clear cookies on startup
<br>added ability to filter browsing history by url and page title,
<br>&nbsp;enabled by options menu command in history activity

<br>Is it good for privacy now?
<br>No. Besides missing features:
<br>&nbsp;Unable (?) to clean HTML5 session storage without restart,
<br>&nbsp;Reported resolution is quite unique
<br>&nbsp;User agent contains minor version numbers (also unique)
</code>
