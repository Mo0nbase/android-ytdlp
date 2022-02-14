<!-- MANPAGE: BEGIN EXCLUDED SECTION -->
<div align="center">

[![YT-DLP](https://raw.githubusercontent.com/mo0nbase/android-ytdlp/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png)](#readme)

[![License: Unlicense](https://img.shields.io/badge/-Unlicense-brightgreen.svg?style=for-the-badge)](LICENSE "License")

</div>
<!-- MANPAGE: END EXCLUDED SECTION -->

 Android-ytdlp is a [youtube-dlp](https://github.com/yt-dlp/yt-dlp) android port based on the [chaquopy-console-app](https://github.com/chaquo/chaquopy-console). It's very rudimentary and not all features of youtube-dlp have been tested however the core feature set appears to be functioning. I use this app for downloading videos to my downloads quickly on my phone to either edit them or share them simply and quickly on other applications. One of my favorite features is that i can directly share videos from the share diolouge on the YouTube app making the experience very streamlined and convienent. This is merely a passion project and any bugs or feature requests are welcome ill try to keep up with the latest releases of yt-dlp or if anything breaks however if you have a unique feature or just some things to refine the code base (one of my first android projects) then just open a pull request. Many thanks to both Chaquopy and YouTube-DLP becuase otheriswise this would note have been possible.
 
# Features 
 * Directly share videos from the YouTube app share context (including shorts!)
* Run any compatible YouTube-DLP command from the interface (untested).
  Find usage information at the [YouTube-DLP project](https://github.com/yt-dlp/yt-dlp#usage-and-options)
* Download in multiple formats (.mp4, .mkv, .webm atm) and have them immediately copied to system accessible download folder
 
# Broken Items/Optional Improvments
 * Presently the clipboard option adds list elements and the list can be cleared but the start button does not yet start a loop to download all the videos in the list.
 * Tab to customize the format and build in all youtube-dlp formats instead of the initial three
 * Tab to customize the youtube-dlp download options
 * Way to specify download folder
 * Log of videos downloaded
 * Notification to report progress of downloads inlcuding playlists
 
# Projects
 * [Chaquopy](https://chaquo.com/chaquopy/) -> [Github](https://github.com/chaquo/chaquopy)
 * [YouTube-DLP](https://github.com/yt-dlp/yt-dlp#usage-and-options)
 
 NOTE: I will make a apk binary once the the app has a chaquopy liscence. To build the project at the moment you'll need a sample local.properties file in the root directory of the project pointing to the android sdk i.e. `sdk.dir=/home/<user>/Android/Sdk` depending on your os. 
