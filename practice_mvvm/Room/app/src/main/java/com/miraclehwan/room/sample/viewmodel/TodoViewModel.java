package com.miraclehwan.room.sample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.miraclehwan.room.sample.MyApplication;
import com.miraclehwan.room.sample.repository.TodoRepository;
import com.miraclehwan.room.sample.repository.model.Todo;

import java.util.List;

public class TodoViewModel extends ViewModel {

    private TodoRepository todoRepository;
    private LiveData<List<Todo>> liveTodoList;

    public TodoViewModel() {
        super();
        todoRepository = new TodoRepository();
        liveTodoList = todoRepository.getLiveTodoList();
    }

    public LiveData<List<Todo>> getLiveTodoList() {
        return liveTodoList;
    }

    public void insert(Todo todo){
        todoRepository.insertTodo(todo);
    }
}
