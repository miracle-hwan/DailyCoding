package com.miraclehwan.searchhistorywithroom.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Toast;

import com.miraclehwan.searchhistorywithroom.databinding.ItemSearchHistoryBinding;
import com.miraclehwan.searchhistorywithroom.repos.model.History;

import java.util.List;

public class SearchHistoryAdapter extends ArrayAdapter<History> {

    private ItemSearchHistoryBinding binding;
    private List<History> historyList;

    public SearchHistoryAdapter(@NonNull Context context, List<History> historyList) {
        super(context, 0, historyList);
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return historyFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            binding = ItemSearchHistoryBinding.inflate(LayoutInflater.from(getContext()), parent, false);
            convertView = binding.getRoot();
        }

        History history = getItem(position);
        if (history != null) {
            binding.tvHistory.setText(history.getContent());
            binding.ivClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "삭제!!!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
        notifyDataSetChanged();
    }

    private Filter historyFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            results.values = historyList;
            results.count = historyList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((History) resultValue).getContent();
        }
    };
}
