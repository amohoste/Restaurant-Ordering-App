package com.example.aggoetey.myapplication.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aggoetey.myapplication.R;
import com.example.aggoetey.myapplication.model.Menu;
import com.example.aggoetey.myapplication.model.MenuItem;

import java.util.List;

/**
 * Created by Dries on 26/03/2018.
 */

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuItemHolder>{

    private List<MenuItem> items;

    public MenuListAdapter(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public MenuItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_menu_list_item, parent, false);
        return new MenuItemHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuItemHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MenuItemHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private Button mOrderButton;

        public MenuItemHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.menu_recycler_title_view);
            mOrderButton = (Button) itemView.findViewById(R.id.menu_recycler_price_order_button);
        }

        public void bind(MenuItem menuItem) {
            mTitleTextView.setText(menuItem.title);
            mOrderButton.setText("€ " + Integer.toString(menuItem.price));
        }
    }
}
