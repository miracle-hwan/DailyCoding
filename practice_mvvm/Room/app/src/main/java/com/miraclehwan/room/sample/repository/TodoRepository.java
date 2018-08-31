package com.miraclehwan.room.sample.repository;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.miraclehwan.room.sample.MyRoomDataBase;
import com.miraclehwan.room.sample.repository.model.Todo;
import com.miraclehwan.room.sample.repository.model.TodoDao;

import java.util.List;

public class TodoRepository {

    private TodoDao todoDao;
    private LiveData<List<Todo>> liveTodoList;

    public TodoRepository() {
        MyRoomDataBase db = MyRoomDataBase.getsInstance();
        todoDao =  db.todoDao();
        liveTodoList = todoDao.getTodoList();
    }

    public LiveData<List<Todo>> getLiveTodoList(){
        return liveTodoList;
    }

    public void insertTodo (Todo todo){
        new TodoInsertAsyncTask(todoDao).execute(todo);
    }

    private class TodoInsertAsyncTask extends AsyncTask<Todo, Void, Void> {

        private TodoDao todoDao;

        public TodoInsertAsyncTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.insert(todos[0]);
            return null;
        }
    }
}
