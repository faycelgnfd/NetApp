package com.openclassrooms.netapp.Controllers.Model;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class NetworkAsyncTask extends AsyncTask<String,Void,String>
{

    public interface Listener
    {
        public void onPreExecute();
        public void onPostExecute(String result);
        public String doInBackground();
    }

    private final WeakReference<Listener> callback;

    public NetworkAsyncTask(Listener callback)
    {
        this.callback = new WeakReference<>(callback);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.callback.get().onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        this.callback.get().onPostExecute(result);
    }

    @Override
    protected String doInBackground(String... url) {
        this.callback.get().doInBackground();
        return MyHttpURLConnection.startHttpRequest(url[0]);
    }

}
