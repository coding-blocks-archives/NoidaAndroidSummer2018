package garg.ayush.listviewcustomadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>(); //arraylist is like vector in C++

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentArrayList.add(new Student("Ayush","Android App Dev","Noida"));
        studentArrayList.add(new Student("Veerain","Java","Dwarka"));
        studentArrayList.add(new Student("Charu","Web Dev","Gurgaon"));
        studentArrayList.add(new Student("Hiten","Android App Dev","Pitampura"));
        studentArrayList.add(new Student("Abhinav","Android App Dev","Noida"));
        studentArrayList.add(new Student("Akshay","Web Dev","Gurgaon"));
        studentArrayList.add(new Student("Varun","Java","Noida"));
        studentArrayList.add(new Student("Keshav","Java","Dwarka"));
        studentArrayList.add(new Student("Abhinav","Android App Dev","Pitampura"));
        studentArrayList.add(new Student("Anshuman","Web Dev","Noida"));
        studentArrayList.add(new Student("Shreyas","Web Dev","Pitampura"));
        studentArrayList.add(new Student("Rishab","Android App Dev","Pitampura"));
        studentArrayList.add(new Student("Jatin","Java","Gurgaon"));
        studentArrayList.add(new Student("Amit","Android App Dev","Noida"));

        ListView listView = findViewById(R.id.lvStudents);
        listView.setAdapter(new MyCustomAdapter());
    }

    class MyCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {//number of row items
            return studentArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) { //which view to display on for a particular id
            //Context context = MainActivity.this;

            LayoutInflater li =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);//have to typecast here
            View inflatedView;
            if(view==null){
                inflatedView = li.inflate(R.layout.customlist_view,viewGroup,false);//choose the option which has 3 arguments third one option for inflate
            }else{
                inflatedView=view;
            }

            final Student currentstudent = studentArrayList.get(i); // all are iterated

            TextView studentName = inflatedView.findViewById(R.id.name);
            studentName.setText(currentstudent.getName());

            TextView studentBatch = inflatedView.findViewById(R.id.batch);
            studentBatch.setText(currentstudent.getBatch());

            TextView studentLocation = inflatedView.findViewById(R.id.location);
            studentLocation.setText(currentstudent.getLocation());
            final int f=i;
            inflatedView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getBaseContext(),studentArrayList.get(f).getName(), Toast.LENGTH_SHORT).show();
                }
            });
            return inflatedView;
        }
    }
}
