package com.codingblocks.roomdb.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.codingblocks.roomdb.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM task WHERE id = :id")
    Task taskWithID(int id);

    @Insert
    void insertTaskList(List<Task> tasks);

    @Insert
    void insertTask(Task... task);

    @Insert
    void insertTwoTasks(Task task1, Task task2);

    @Update
    void updateTask(Task task);

    @Delete
    void deleteTask(Task task);
}
