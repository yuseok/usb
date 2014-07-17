package yuseok.usbconnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.app.ListActivity;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Toast;

public class USBList extends ListActivity {
	// ListView mDeviceList;
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {

			showUSBDrivers();

		} catch (Exception e) {

			finish();
			Log.e("yuseok", "error occur in USB Port");
		}

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list));
		getListView().setTextFilterEnabled(true);

		getListView().setOnItemClickListener(listener);

		super.onCreate(savedInstanceState);
	}

	OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			Toast.makeText(USBList.this, String.valueOf(id), Toast.LENGTH_SHORT)
					.show();
			;

		}
	};

	void showUSBDrivers() {

		UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
		HashMap<String, UsbDevice> deviceList = manager.getDeviceList();

		Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
		while (deviceIterator.hasNext()) {
			UsbDevice device = deviceIterator.next();

			StringBuilder str = new StringBuilder();
			str.append("***DeviceName:");
			str.append(device.getDeviceName() + "\n***Device id:");
			str.append(device.getDeviceId() + "\n***Vendor id:");
			str.append(device.getVendorId());
			list.add(str.toString());
			// list.add(device.getDeviceName());
			// list.add(String.valueOf(device.getDeviceId()));
			// list.add(String.valueOf(device.getVendorId()));
			//

		}

	}

	protected class TestAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
