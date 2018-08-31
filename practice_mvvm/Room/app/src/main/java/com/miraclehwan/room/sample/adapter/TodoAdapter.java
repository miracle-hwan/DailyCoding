package com.miraclehwan.room.sample.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.miraclehwan.room.databinding.ItemTodoBinding;
import com.miraclehwan.room.sample.repository.model.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoHolder>{

    private Context context;
    private List<Todo> todoList;

    public TodoAdapter(Context context, List<Todo> todoList) {
        this.context = context;
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public TodoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoHolder(ItemTodoBinding.inflate(LayoutInflater.from(context), parent, false).getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull TodoHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void setTodoList(List<Todo> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public class TodoHolder extends RecyclerView.ViewHolder {

        ItemTodoBinding binding;

        public TodoHolder(View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.bind(itemView);
        }

        public void bind(int position){
            binding.title.setText(todoList.get(position).getTodo());
        }
    }
}
