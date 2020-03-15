package com.openclassrooms.netapp.Controllers.Fragments;


import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.netapp.Controllers.Model.NetworkAsyncTask;
import com.openclassrooms.netapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener, NetworkAsyncTask.Listener {

    @BindView(R.id.fragment_main_textview) TextView textView;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        view.findViewById(R.id.fragment_main_button).setOnClickListener(this);
        return view;
    }

    // -----------------
    // ACTIONS
    // -----------------


    @Override
    public void onClick(View v) {
        this.startHttpRequest();
    }

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    public void onPreExecute() {
        this.updateUIOnStartingHttpRequest();
    }

    @Override
    public void onPostExecute(String result) {
        this.updateUIOnEndingHttpRequest(result);
    }

    @Override
    public String doInBackground() {
        return null;
    }


    // -----------------
    //METHODES
    // -----------------

    private void updateUIOnStartingHttpRequest()
    {
        this.textView.setText("Downloading...");
    }

    private void updateUIOnEndingHttpRequest(String result)
    {
        this.textView.setText(result);
    }

    public void startHttpRequest()
    {
        new NetworkAsyncTask(this).execute("https://api.github.com/users/JakeWharton/following");
    }

}
