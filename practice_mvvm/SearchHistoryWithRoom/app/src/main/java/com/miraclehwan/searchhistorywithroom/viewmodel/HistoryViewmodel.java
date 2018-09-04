package com.miraclehwan.searchhistorywithroom.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.miraclehwan.searchhistorywithroom.repos.HistoryRepository;
import com.miraclehwan.searchhistorywithroom.repos.model.History;

import java.util.List;

public class HistoryViewmodel extends ViewModel {

    private HistoryRepository historyRepository;
    private LiveData<List<History>> liveHistoryList;

    public HistoryViewmodel() {
        super();
        historyRepository = new HistoryRepository();
        liveHistoryList = historyRepository.getLiveHistoryList();
    }

    public LiveData<List<History>> getLiveHistoryList() {
        return liveHistoryList;
    }

    public void insert(History history){
        historyRepository.insertHistory(history);
    }

    public void delete(History history){
        historyRepository.deleteHistory(history);
    }

    public void deleteAll(){
        historyRepository.deleteHistoryAll();
    }
}
