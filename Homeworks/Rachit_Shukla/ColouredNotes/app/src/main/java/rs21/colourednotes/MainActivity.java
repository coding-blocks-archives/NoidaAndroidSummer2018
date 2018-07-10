package rs21.colourednotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<row> data = new ArrayList<>();
    ListView listView;
    NotesAdaptor notesAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = findViewById(R.id.button);
        final EditText note = findViewById(R.id.editText);
        notesAdaptor = new NotesAdaptor(this, data);

        RecyclerView rvList = findViewById(R.id.rvList);
        rvList.setAdapter(notesAdaptor);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row temp = new row();
                temp.text = note.getText().toString();
                temp.colNo = 0;

                data.add(temp);
                notesAdaptor.notifyDataSetChanged();
            }
        });
    }
}