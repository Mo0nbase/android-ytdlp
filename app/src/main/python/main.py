import os
from six.moves import input
from yt_dlp import init
from os.path import dirname, join

def main(instance):
    print("Paste your YouTube url/urls separated by spaces...")
    while True:
        try:
            urls = input()
        except EOFError:
            break
        if not urls:
            break

        try:
            arguments = ["youtube-dlp", *urls.split()]
            init.main(arguments)
            for file in getFiles():
                instance.addFile(join(dirname(__file__), "yt_dlp/downloader/", file))
            print("Moving to downloads...")
            instance.copyAllFiles()
            instance.deleteAllFiles()
            print("Done!")
        except SystemExit:
            pass

def getFiles():
    files = []
    for file in os.listdir(join(dirname(__file__), "yt_dlp/downloader/")):
        if file.endswith(".mp4") or file.endswith(".mkv") or file.endswith(".webm"):
            files.append(file)
    return files

# Get reference to the start button
# set the onclick listener to get the list of urls
# then download each of the urls with the init.main