    android_packages_apps_Browser
    =============================
    
    Mod of CM browser (in turn fork of AOSP browser), to be used on i9100/CM11 (menu button, DPI, ...)
    all the work done on cm-11.0 branch

    Added functionality:
    + ability to filter browsing history by url and page title,
     enabled by options menu command in history activity
    + menu with opened tabs on long menu button click
     (unassign global menu button long press action in CM Setting/Buttons) 
    
    Privacy/convenience details:
    added option to clear cookies on startup
    removed adding RLZ param to google search URLs
     (doesn't work anyway on CM11 without "Play Services")
    added search icon to navbar to enable search suggestions, search suggestions disabled by default
    changed hardcoded "quick-search" provider to duckduckgo
    changed configurable user agents
    
    Renamed package, name and made appicon red, now able to use alongside system browser
    uses system browser providers for bookmarks and history (and more?)
     (TODO use internal, cloned providers?)
    removed "more" button from navbar, since there is a menu button on i9100
    
    Is it good for privacy now?
    No. Besides missing features:
     unable (TODO?) to clean HTML5 session storage without restart
     reported resolution is quite selective
     user agent contains detailed android/chrome/... version numbers (also selective)
    
    Compilable with framework[2].jar converted with dex2jar, set as "provided" lib,
    also needs guava and android-suppoer-v13
