package garg.ayush.noteappusingroomandlivedata;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Notes {

    @PrimaryKey(autoGenerate = true)
    int id;

    String title,des;


    int status;

    public Notes(int id, String title, String des, int status) {
        this.id = id;
        this.title = title;
        this.des = des;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
