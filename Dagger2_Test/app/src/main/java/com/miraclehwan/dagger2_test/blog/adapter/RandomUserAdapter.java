package com.miraclehwan.dagger2_test.blog.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.miraclehwan.dagger2_test.R;
import com.miraclehwan.dagger2_test.blog.MainActivity;
import com.miraclehwan.dagger2_test.blog.model.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hari on 20/11/17.
 */

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder> {

    private final Picasso picasso;
    private final MainActivity mainActivity;
    private List<Result> resultList = new ArrayList<>();


    public RandomUserAdapter(MainActivity mainActivity, Picasso picasso) {
        this.mainActivity = mainActivity;
        this.picasso = picasso;
    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_random_user,
                parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        Result result = resultList.get(position);
        Log.e("daehwan", ""+position);
        holder.textView.setText(String.format("%s %s", result.getName().getFirst(),
                result.getName().getLast()));
        picasso.with(mainActivity)
                .load(result.getPicture().getLarge())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Result> results) {
        resultList = results;
    }

    public class RandomUserViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public RandomUserViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}