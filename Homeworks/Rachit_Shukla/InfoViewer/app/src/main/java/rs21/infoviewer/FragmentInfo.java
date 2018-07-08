package rs21.infoviewer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FragmentInfo extends Fragment {
    abc data = new abc("", 0, "");

    //    public FragmentInfo(abc data) {
    //        this.data = data;
    //    }

    public static FragmentInfo newInstance(abc a) {

        Bundle args = new Bundle();
        args.putParcelable("STUDENT", a);
        FragmentInfo fragment = new FragmentInfo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment, container, false);
        Bundle bundle = getArguments();
        data = (abc) bundle.getParcelable("STUDENT");

        TextView t = view.findViewById(R.id.name);
        TextView t1 = view.findViewById(R.id.age);
        t.setText("Name: " + data.name);
        t1.setText("Age: " + String.valueOf(data.age));
        ImageView v = view.findViewById(R.id.img);
        Picasso.get().load(data.url).into(v);
        return view;
    }
}
