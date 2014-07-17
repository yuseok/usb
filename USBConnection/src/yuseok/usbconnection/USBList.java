package yuseok.usbconnection;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.widget.ListView;

public class USBList extends Activity {
	ListView mDeviceList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.list);
		mDeviceList = (ListView) findViewById(R.id.deviceList);
		mDeviceList.setAdapter(new PrivateListAdapter());
		showUSBDrivers();

		super.onCreate(savedInstanceState);
	}

	void showUSBDrivers() {

		UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
		HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
		System.out.println(deviceList);
	}

}
