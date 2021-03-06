package com.example.foodcart;
 
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class NavDrawerListAdapter extends BaseAdapter {
     
    private Context context;
    String[] navMenuTitles;
    TypedArray navMenuIcons;
 
    public NavDrawerListAdapter(Context applicationContext,
			String[] navMenuTitles, TypedArray navMenuIcons) {
    	context = applicationContext;
    	this.navMenuTitles = navMenuTitles;
    	this.navMenuIcons = navMenuIcons;
	}

	@Override
    public int getCount() {
        return navMenuTitles.length;
    }
 
    @Override
    public Object getItem(int position) {       
        return navMenuTitles[position];
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }
          
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        //TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
          
        imgIcon.setImageResource(navMenuIcons.getResourceId(position, -1));        
        txtTitle.setText(navMenuTitles[position]);
         
        // displaying count
        // check whether it set visible or not
/*        if(navDrawerItems.get(position).getCounterVisibility()){
            txtCount.setText(navDrawerItems.get(position).getCount());
        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }*/
         
        return convertView;
    }
 
}