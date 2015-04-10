package com.example.gridviewsample;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
   
	private static final int NUM=36;
	private GridView grid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		grid=(GridView)findViewById(R.id.grid);
		
		//ע��Ҫ��this.getResources()������Resources().getSystem(),��Ȼ����?
        Drawable drawable=this.getResources().getDrawable(R.drawable.play);
 
		List<String>nameList=new ArrayList<String>();
		List<Drawable>drawableList=new ArrayList<Drawable>();
		for(int i=0;i<NUM;++i)
		{
			nameList.add("Hello"+(i+1));
			drawableList.add(drawable);
		}
		
		grid.setAdapter(new GridAdapter(this.getBaseContext(),nameList,drawableList));
		
	}

	private class GridAdapter extends BaseAdapter
	{
		private List<String>nameList=new ArrayList<String>();
		private List<Drawable>drawableList=new ArrayList<Drawable>();
		private LayoutInflater inflater;
		private Context mContext;
		LinearLayout.LayoutParams params;
		
		public GridAdapter(Context context,List<String>nameList,List<Drawable>drawableList)
		{
			this.nameList=nameList;
			this.drawableList=drawableList;
			mContext=context;
			inflater=LayoutInflater.from(context);
			
			params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		    params.gravity=Gravity.CENTER;
		}
		
		public int getCount()
		{
			return nameList.size();
		}
		
		public Object getItem(int position)
		{
			return nameList.get(position);
		}
		
		public long getItemId(int position)
		{
			return position;
		}
		
		public View getView(int position,View convertView,ViewGroup parent)
		{
			ViewHolder tag;
			if(convertView==null)
			{
				convertView=inflater.inflate(R.layout.item, null);
				ImageView imageView=(ImageView)convertView.findViewById(R.id.grid_icon);
				TextView textView=(TextView)convertView.findViewById(R.id.grid_name);
				tag=new ViewHolder(imageView,textView);
				convertView.setTag(tag);
			}
			else
			{
				tag=(ViewHolder)convertView.getTag();
			}
			
			tag.mName.setText(nameList.get(position));
			tag.mIcon.setImageDrawable(drawableList.get(position));
			//tag.mIcon.setBackgroundDrawable(drawableList.get(position));
			tag.mIcon.setLayoutParams(params);
			return convertView;
			
		}
		
		class ViewHolder
		{
			protected ImageView mIcon;
			protected TextView mName;
			public ViewHolder(ImageView icon,TextView name)
			{
				mIcon=icon;
				mName=name;
			}
		}
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
