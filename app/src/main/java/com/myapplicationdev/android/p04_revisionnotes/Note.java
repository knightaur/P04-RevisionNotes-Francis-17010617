package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

    private int _id;
    private String noteContent;
    private int stars;

    public Note(int _id, String noteContent, int stars) {
        this._id = _id;
        this.noteContent = noteContent;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
