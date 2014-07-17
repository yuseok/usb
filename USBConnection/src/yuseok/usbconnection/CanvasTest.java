package yuseok.usbconnection;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class CanvasTest extends Activity {

	int cnt = 0;
	double sinCnt = 0;
	Button mStartOrStopBtn;
	LinearLayout layout;
	myView mv;
	myView mv2; 
	
	
	
	// HeartBeat View class
	
	protected class heartView extends View {

		Paint pnt;
		public heartView(Context context) {
			super(context);
			pnt = new Paint();

		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			
			super.onDraw(canvas);
			
			canvas.drawColor(Color.WHITE);
			pnt.setColor(Color.rgb(100, 100, 100));
			canvas.drawCircle(120, 120, cnt, pnt);
			
		}
		
		
		
		
	}

	class myView extends View {

		Paint pnt;
		RectF rect;
		
		
		public myView(Context context) {
			super(context);
			pnt = new Paint();
			rect = new RectF();

			
			
			/*
			 * 
			 * 
			 * 
			 * 일단은 여기 하드코딩;;
			 * 
			 * 
			 */
			this.setLayoutParams(new LayoutParams(200, 200));

		}

		@Override
		protected void onDraw(Canvas canvas) {
			
			super.onDraw(canvas);
		
			canvas.drawColor(Color.YELLOW);

			
			pnt.setStyle(Style.STROKE);
			pnt.setStrokeWidth(3);
			pnt.setColor(Color.BLACK);
			pnt.setAntiAlias(true);

			canvas.drawCircle((float)sinCnt, (float)sinCnt, 90, pnt);

			canvas.drawCircle(93, 93, 9, pnt);
			canvas.drawCircle(147, 93, 9, pnt);

			
			rect.set(57, 57, 183, 183);
			canvas.drawArc(rect, 30, 120, false, pnt);

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.canvastest);
		layout = (LinearLayout)findViewById(R.id.linear);
		layout.setOrientation(LinearLayout.VERTICAL);
		mv = new myView(this);
//		mv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		mv2 = new myView(this);
//		mv2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		
		
		layout.addView(mv);
		layout.addView(mv2);
		
		mStartOrStopBtn = (Button) findViewById(R.id.startOrStop);
		

		mStartOrStopBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {

						while (true) {
							cnt++;
							sinCnt = Math.abs(150*Math.sin(cnt*0.1));
							

							if (cnt  > 10000) {
								break;
							}
							
							

							runOnUiThread(new Runnable() {

								@Override
								public void run() {

									mStartOrStopBtn.setText(String.valueOf(cnt));
									mv.invalidate();
									mv2.invalidate();

								}
							});

							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
						}

					}
				});

				t.start();

			}
		});

		super.onCreate(savedInstanceState);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		return super.onKeyDown(keyCode, event);
	}

}

//
//
// Thread t = new Thread(new Runnable() {
//
// @Override
// public void run() {
// runOnUiThread(new Runnable() {
//
// @Override
// public void run() {
// while (isStart) {
//
// mStartOrStopBtn.setText(String.valueOf(cnt));
// cnt++;
//
// if (cnt == 1000) {
// break;
// }
//
// try {
// Thread.sleep(100);
// } catch (InterruptedException e) {
//
// e.printStackTrace();
// }
//
// }
//
// }
// });
//
// }
// });
//
// t.start();

