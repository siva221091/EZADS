package com.ezads;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Search> searchList;

    //getting the context and product list with constructor
    public SearchAdapter(Context mCtx, List<Search> searchList) {
        this.mCtx = mCtx;
        this.searchList = searchList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.search_histories_cardview, null);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        //getting the product of the specified position
        Search search = searchList.get(position);

        //binding the data with the viewholder views
        holder.textViewSearch1.setText(search.getSearch1());





    }


    @Override
    public int getItemCount() {
        return searchList.size();
    }


    class SearchViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSearch1;


        public SearchViewHolder(View itemView) {
            super(itemView);

            textViewSearch1 = itemView.findViewById(R.id.search1);



        }
    }
}