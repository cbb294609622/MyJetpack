package com.example.mypaging.pkds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypaging.R;
import com.example.mypaging.model.Person;
import com.squareup.picasso.Picasso;

public class PersonPagedListAdapter extends PagedListAdapter<Person, PersonPagedListAdapter.PersonViewHodler> {

    //查分更新  只更新需要更新的元素，而不是整个刷新数据源
    private static final DiffUtil.ItemCallback<Person> DIFF_CALLBACK = new DiffUtil.ItemCallback<Person>() {
        @Override
        public boolean areItemsTheSame(Person oldItem, Person newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(Person oldItem, Person newItem) {
            return oldItem.equals(newItem);
        }
    };
    private Context mContext;

    public PersonPagedListAdapter(Context mContext) {
        super(DIFF_CALLBACK);
        this.mContext = mContext;
    }

    @Override
    public PersonViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new PersonViewHodler(root);
    }

    @Override
    public void onBindViewHolder(PersonPagedListAdapter.PersonViewHodler holder, int position) {
        Person item = getItem(position);
        if (item != null){
            Picasso.get()
                    .load(item.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imageView);
            holder.title.setText(item.name);
            holder.age.setText(String.valueOf(item.age));
        }
    }

    public class PersonViewHodler extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView age;

        public PersonViewHodler(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.textViewTitle);
            age = itemView.findViewById(R.id.textViewAge);
        }
    }
}
