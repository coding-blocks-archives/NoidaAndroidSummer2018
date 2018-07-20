package garg.ayush.noteappusingsqlite;

public class Notes {

    int id;
    String title,des;
    int status;

    public Notes(int id, String title, String des, int status) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.status = status;
    }
}
