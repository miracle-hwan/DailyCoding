package com.miraclehwan.room;

import android.arch.persistence.room.Room;
import android.support.test.runner.AndroidJUnit4;
import android.test.mock.MockContext;

import com.miraclehwan.room.sample.MyRoomDataBase;
import com.miraclehwan.room.sample.repository.model.Todo;
import com.miraclehwan.room.sample.repository.model.TodoDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TodoDaoTest extends TestWatcher{

//    private MyRoomDataBase db;
//    private TodoDao todoDao;
//
//    @Before
//    public void createDB(){
//        db = Room.inMemoryDatabaseBuilder(new MockContext(), MyRoomDataBase.class).build();
//        todoDao = db.todoDao();
//    }
//
//    @After
//    public void closeDB(){
//        db.close();
//    }
//
//    @Test
//    public void insertAndGetWord() throws InterruptedException {
//        Todo todo = new Todo("daehwan");
//        todoDao.insert(todo);
//        List<Todo> todoList = LiveDataTestUtil.getValue(todoDao.getTodoList());
//        assertEquals(todo.getTodo(), todoList.get(0).getTodo());
//    }

}
