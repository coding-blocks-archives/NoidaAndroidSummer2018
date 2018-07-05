package garg.ayush.whatsapp_ui_copy;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<Contact> contactArrayList = new ArrayList<>();
    String singleTick="https://www.clker.com/cliparts/0/f/W/A/E/5/whatsapp-reborn-tick-md.png";
    String doubleGreyTick = "http://www.clker.com/cliparts/2/U/S/h/P/E/whatsapp-plus-ticks-cool-md.png";
    String doubleBlueTick = "http://s01.s3c.es/imag/_v0/375x200/7/4/a/whatsapp-doble-tick-azul-3.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.RV);


        contactArrayList.add(new Contact("Alice","Hi Alice","12:43 AM","https://randomuser.me/api/portraits/women/63.jpg",singleTick,0));
        contactArrayList.add(new Contact("Jack","Hi Jack","11:21 PM","https://randomuser.me/api/portraits/men/78.jpg",singleTick,0));
        contactArrayList.add(new Contact("Candice","Hi Candice","1:03 AM","https://randomuser.me/api/portraits/women/19.jpg",singleTick,0));
        contactArrayList.add(new Contact("Henry","Hi Henry","5:12 AM","https://randomuser.me/api/portraits/men/37.jpg",singleTick,0));
        contactArrayList.add(new Contact("Jim","Hi Jim","8:00 PM","https://randomuser.me/api/portraits/men/20.jpg",singleTick,0));
        contactArrayList.add(new Contact("Peter","Hi Peter","10:40 PM","https://randomuser.me/api/portraits/men/51.jpg",singleTick,0));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        final MyCustomAdapter myCustomAdapter = new MyCustomAdapter();
        recyclerView.setAdapter(myCustomAdapter);

    }

    class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder>{
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
            Contact contact = contactArrayList.get(position);

            holder.tvName.setText(contact.name);
            holder.tvName.setTypeface(null, Typeface.BOLD);
            holder.tvMessage.setText(contact.message);
            holder.tvTime.setText(contact.time);
            Picasso.get().load(contact.imageURL).into(holder.ivImageView);
            Picasso.get().load(contact.tickURL).into(holder.tickview);

            final Contact finalContact = contact;
            final ViewHolder vh=holder;
            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int tickCount=finalContact.getCount();
                    finalContact.setCount(tickCount+1);
                    tickCount=tickCount+1;
                    if(tickCount%3==0){
                        Picasso.get().load(singleTick).into(vh.tickview);
                    }else if(tickCount%3==1){
                        Picasso.get().load(doubleGreyTick).into(vh.tickview);
                    }else{
                        Picasso.get().load(doubleBlueTick).into(vh.tickview);
                    }
                }
            });



        }

        @Override
        public int getItemCount() {
            return contactArrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public TextView tvName,tvMessage,tvTime;
            public ImageView ivImageView,tickview;

            public ViewHolder(View itemView) {
                super(itemView);
                tvName=itemView.findViewById(R.id.name);
                tvMessage=itemView.findViewById(R.id.message);
                tvTime=itemView.findViewById(R.id.time);
                ivImageView=itemView.findViewById(R.id.image);
                tickview=itemView.findViewById(R.id.tick);
            }
        }
    }

    public class Contact{
        public Contact(String name, String message, String time, String imageURL, String tickURL,int count) {
            this.name = name;
            this.message = message;
            this.time = time;
            this.imageURL = imageURL;
            this.tickURL = tickURL;
            this.count=count;
        }

        private String name;
        private String message;
        private String time;
        private String imageURL;
        private String tickURL;
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }

        public String getTickURL() {
            return tickURL;
        }

        public void setTickURL(String tickURL) {
            this.tickURL = tickURL;
        }
    }
}
