package com.example.gridview;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.CustomGridViewAdvanced.R;
import com.example.gridview.customcontrols.HFGridView;

public class MainActivity extends Activity {
		
	private TableLayout table_layout = null;
	private ArrayList<LinkedHashMap<String,CharSequence>> mListLayoutData;
	private LinkedHashMap<String, CharSequence> objMap;
	private HFGridView gridView;
	private int numOfColumns=0;
	private int imageWidth=100;
	private int outerPadding=10;
	private int imagePadding=10;
	private int outerPaddingAdjust=0;
	private int minPadding=5;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mListLayoutData=new ArrayList<LinkedHashMap<String,CharSequence>>();
		objMap = new LinkedHashMap<String, CharSequence>();
		
		gridView = (HFGridView) findViewById(R.id.gridView);
		table_layout = (TableLayout)findViewById(R.id.tableLayout);
		
		//Always set the number of columns to one
		gridView.setNumColumns(1);
		
		//Get the Width and the height of the screeen
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		
		Configuration config = getResources().getConfiguration();
		if (config.orientation == Configuration.ORIENTATION_PORTRAIT)
		{
			//Portrait Mode
			numOfColumns=(int) Math.floor((metrics.widthPixels-outerPadding)/(imageWidth+imagePadding));
			outerPaddingAdjust=(int) Math.floor(((metrics.widthPixels-(minPadding*(numOfColumns+1))-(numOfColumns*(imageWidth+imagePadding)))/(numOfColumns+1)));
			gridView.setColumnWidth(metrics.widthPixels);
		}
		else if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
			//Landscape Mode
			numOfColumns=(int) Math.floor((metrics.widthPixels-outerPadding)/(imageWidth+imagePadding));
			outerPaddingAdjust=(int) Math.floor(((metrics.widthPixels-(minPadding*(numOfColumns+1))-(numOfColumns*(imageWidth+imagePadding)))/(numOfColumns+1)));
			gridView.setColumnWidth(metrics.widthPixels);
		}
		
		View gridViewHeader = getHeader("Header");
		View gridViewFooter = getFooter("Footer");

		gridView.addHeaderView(gridViewHeader);
		gridView.addFooterView(gridViewFooter);
		
		//Add the data for the gridview
		AddDataToGridView();
		
		GridAdapter gridAdapter=new GridAdapter(MainActivity.this,mListLayoutData,outerPaddingAdjust);	
		
		gridView.setAdapter(gridAdapter);
		
	}
	
	private void AddDataToGridView() {
		mListLayoutData.add(objMap);
		if(numOfColumns==4){
			objMap.put("Sub-Header1","HEADER");
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-1","starter");
			objMap.put("ANDROID-2","starter");
			objMap.put("ANDROID-3","starter");
			objMap.put("ANDROID-4","starter");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-5","starter");
			objMap.put("ANDROID-6","starter");
			objMap.put("ANDROID-7","starter");
			objMap.put("ANDROID-8","starter");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-9","starter");
			objMap.put("ANDROID-10","starter");
			objMap.put("ANDROID-11","starter");
			objMap.put("ANDROID-12","starter");
			mListLayoutData.add(objMap);
			
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("Sub-Header2","HEADER");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-1","salad");
			objMap.put("ANDROID-2","salad");
			objMap.put("ANDROID-3","salad");
			objMap.put("ANDROID-4","salad");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-5","salad");
			objMap.put("ANDROID-6","salad");
			objMap.put("ANDROID-7","salad");
			objMap.put("ANDROID-8","salad");
			mListLayoutData.add(objMap);
			
		}else{
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("Sub-Header1","HEADER");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-1","starter");
			objMap.put("ANDROID-2","starter");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-3","starter");
			objMap.put("ANDROID-4","starter");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-5","starter");
			objMap.put("ANDROID-6","starter");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-7","starter");
			objMap.put("ANDROID-8","starter");
			mListLayoutData.add(objMap);
			
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("Sub-Header2","HEADER");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-1","salad");
			objMap.put("ANDROID-2","salad");
			mListLayoutData.add(objMap);
			objMap = new LinkedHashMap<String, CharSequence>();
			objMap.put("ANDROID-3","salad");
			objMap.put("ANDROID-4","salad");
			mListLayoutData.add(objMap);
		}
	}

	private View getHeader(String text) {
		View header = getLayoutInflater().inflate(R.layout.header, null);
		TextView textView = (TextView) header.findViewById(R.id.headerTextView);
		textView.setText(text);
		return header;
	}

	private View getFooter(String text) {
		View footer = getLayoutInflater().inflate(R.layout.footer, null);
		TextView textView = (TextView) footer.findViewById(R.id.footerTextView);
		textView.setText(text);
		return footer;
	}
}
