package yuseok.usbconnection;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PrivateListAdapter extends BaseAdapter {
	private Context context = null;
	private ArrayList<String> data = null;
	
	public PrivateListAdapter(Context context) {
		super();
		this.context = context;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TOsDO Auto-generated method stub
		return data.get(position);
		}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(android.R.layout.simple_list_item_1, null);
		
		
		return convertView;
	}

}