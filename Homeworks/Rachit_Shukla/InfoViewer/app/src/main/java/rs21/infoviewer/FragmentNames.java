package rs21.infoviewer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class FragmentNames extends Fragment {

    public static FragmentNames newInstance() {
        
        Bundle args = new Bundle();
        FragmentNames fragment = new FragmentNames();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.names_fragment, container, false);
        Communicator communicator = (Communicator) getActivity();
        ListAdapter l = new ListAdapter(getContext(), abc.getPersons(), communicator);

        RecyclerView rvList = view.findViewById(R.id.list);
        rvList.setAdapter(l);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
