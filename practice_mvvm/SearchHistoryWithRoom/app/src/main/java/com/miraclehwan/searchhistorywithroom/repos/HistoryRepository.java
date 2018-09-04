package com.miraclehwan.searchhistorywithroom.repos;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.miraclehwan.searchhistorywithroom.MyRoomDataBase;
import com.miraclehwan.searchhistorywithroom.repos.model.History;
import com.miraclehwan.searchhistorywithroom.repos.model.HistoryDao;

import java.util.List;

public class HistoryRepository {

    private HistoryDao historyDao;
    private LiveData<List<History>> liveHistoryList;

    public HistoryRepository() {
        historyDao = MyRoomDataBase.getsInstance().historyDao();
        liveHistoryList = historyDao.getHistoryList();
    }

    public LiveData<List<History>> getLiveHistoryList() {
        return liveHistoryList;
    }

    public void insertHistory(History history){
        new HistoryInsertAsyncTask(historyDao).execute(history);
    }

    public void deleteHistory(History history){
        new HistoryDeleteAsyncTask(historyDao).execute(history);
    }

    public void deleteHistoryAll(){
        new HistoryDeleteAsyncTask(historyDao).execute();
    }

    private class HistoryInsertAsyncTask extends AsyncTask<History, Void, Void> {

        private HistoryDao historyDao;

        public HistoryInsertAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... historys) {
            historyDao.insert(historys[0]);
            return null;
        }
    }

    private class HistoryDeleteAsyncTask extends AsyncTask<History, Void, Void> {

        private HistoryDao historyDao;

        public HistoryDeleteAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... historys) {
            if (historys[0] != null){
                historyDao.deleteItem(historys[0].getContent());
            }else{
                historyDao.deleteAll();
            }
            return null;
        }
    }
}
