package xyz.vinayak.notesrecyclerview;

public class Note {
    String note,dateTime;

    public Note(String note, String dateTime) {
        this.note = note;
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public String getDateTime() {
        return dateTime;
    }
}
