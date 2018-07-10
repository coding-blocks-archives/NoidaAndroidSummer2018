package garg.ayush.app_whtsappweb_usingfragments;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String FaceBookImage = "http://pngimg.com/uploads/facebook_logos/facebook_logos_PNG19759.png";
    String InstagramImage = "https://image.freepik.com/free-vector/instagram-icon_1057-2227.jpg";
    ArrayList<Contact> arrayList = new ArrayList<>();

    class Contact {
        String name,photo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public Contact(String name, String photo) {
            this.name = name;
            this.photo = photo;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList.add(new Contact("Zachary Simmons","https://randomuser.me/api/portraits/men/70.jpg"));
        arrayList.add(new Contact("Ivan Brown","https://randomuser.me/api/portraits/men/10.jpg"));
        arrayList.add(new Contact("Susan Barnett","https://randomuser.me/api/portraits/women/70.jpg"));
        arrayList.add(new Contact("Kristen Henry","https://randomuser.me/api/portraits/women/50.jpg"));
        arrayList.add(new Contact("Melinda Brooks","https://randomuser.me/api/portraits/women/70.jpg"));
        arrayList.add(new Contact("Mattie Shaw","https://randomuser.me/api/portraits/women/83.jpg"));
        arrayList.add(new Contact("Marcus Knight","https://randomuser.me/api/portraits/women/83.jpg"));
        arrayList.add(new Contact("Elizabeth Powell","https://randomuser.me/api/portraits/women/46.jpg"));
        arrayList.add(new Contact("Matthew Ferguson","https://randomuser.me/api/portraits/men/3.jpg"));
        arrayList.add(new Contact("Floyd Hughes","https://randomuser.me/api/portraits/men/90.jpg"));


        RecyclerView recyclerView = findViewById(R.id.IDrecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),
                DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(new MyCustomAdapter());


    }

    class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder>{


        class ViewHolder extends RecyclerView.ViewHolder{
            TextView name_recyclerView;

            public ViewHolder(View itemView) {
                super(itemView);
                name_recyclerView=itemView.findViewById(R.id.name);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView = li.inflate(R.layout.item_row, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            return  viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Contact contact = arrayList.get(position);
            holder.name_recyclerView.setText(contact.getName());
            holder.name_recyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addFragment(new Fragment(FaceBookImage,InstagramImage,contact.getPhoto(), contact.getName(),"Hi "+contact.getName()));
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }

    void addFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.IDframeLayoutID,fragment)
                .commit();
    }
}
