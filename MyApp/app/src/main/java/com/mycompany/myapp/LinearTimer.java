package com.mycompany.myapp;
import android.widget.*;
import android.content.*;
import android.util.*;
import android.os.*;
import java.util.concurrent.*;

public class LinearTimer extends LinearLayout
{
	Handler mHandler;
	LinearLayout mLinear = this;
	int i = 0;
	int colors[] = {0xff00ddff,0xff669900,0xffaa66cc};
	
	Runnable mRunnable = new Runnable()
	{
		@Override
		public void run()
		{
			// TODO: Implement this method
			mLinear.setBackgroundColor(colors[i]);
			i++;
			if(i==3)
			{
				i=0;
			}
		}
	};
	
	public LinearTimer(Context c,AttributeSet a)
	{
		super(c,a);
		mHandler = new Handler();
		Thread mThread = new Thread()
		{
			public void run()
			{
				try
				{
					while(true)
					{
						sleep(3000);
						mHandler.post(mRunnable);
					}
				}
				catch(InterruptedException e)
				{}
			}
		};
		mThread.start();
	}
}
