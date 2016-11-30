package com.mycompany.myapp;
import android.widget.*;
import android.content.*;
import android.util.*;
import android.os.*;

public class TextTimer extends TextView
{
	Handler mHandler;
	TextView mText = this;
	int i = 0;
	int colors[] = {0xffaa66cc,0xff00ddff};

	Runnable mRunnable = new Runnable()
	{
		@Override
		public void run()
		{
			// TODO: Implement this method
			mText.setTextColor(colors[i]);
			i++;
			if(i==2)
			{
				i=0;
			}
		}
	};
	
	public TextTimer(Context c,AttributeSet a)
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
