package com.timbuchalka;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    private SongList songList;
//    moved to SongList innerclass
//    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
//        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        return this.songList.addSong(new Song(title, duration));
    }

    //moved findSong method to SongList class

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songList.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            System.out.println(title + " has been added.");
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean addSong(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
            }

        private Song findSong(String title) {
            for(Song checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }
        
    }

}
