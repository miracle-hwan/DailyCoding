package com.miraclehwan.room.sample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.miraclehwan.room.R;


import com.miraclehwan.room.databinding.ActivityTodoListBinding;
import com.miraclehwan.room.sample.adapter.TodoAdapter;
import com.miraclehwan.room.sample.repository.model.Todo;
import com.miraclehwan.room.sample.viewmodel.TodoViewModel;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    ActivityTodoListBinding binding;

    TodoViewModel todoViewModel;
    TodoAdapter todoAdapter;
    List<Todo> todoList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list);

        todoAdapter = new TodoAdapter(this, todoList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(todoAdapter);

        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        todoViewModel.getLiveTodoList().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(@Nullable List<Todo> todos) {
            todoAdapter.setTodoList(todos);
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etContent.getText().length() > 0){
                    todoViewModel.insert(new Todo(binding.etContent.getText().toString()));
                    binding.etContent.setText("");
                }
            }
        });
    }
}
