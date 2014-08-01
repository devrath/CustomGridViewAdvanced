package com.example.gridview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.example.CustomGridViewAdvanced.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter{

	Context context;
	ArrayList<LinkedHashMap<String, CharSequence>> mListLayoutData;
	int imageWidth,imageHeight,outerPaddingAdjust;

	public GridAdapter(Context _context,ArrayList<LinkedHashMap<String, CharSequence>> _mListLayoutData,int _outerPadding) {
		context=_context;
		mListLayoutData=_mListLayoutData;
		outerPaddingAdjust=_outerPadding;
	}

	@Override
	public int getCount() {
		return mListLayoutData.size();
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		TableLayout table_layout = null;
		ImageView imageView = null;
		TableRow table_row = null;
		LinearLayout linearLayoutOne=null;
		LinearLayout linearLayoutTwo=null;
		LinearLayout linearLayoutThree=null;
		LinearLayout linearLayoutFour=null;
		String key;
		CharSequence value = null;
		int countSize=0;
		int colCnt=1;

		if (view == null) {
			//Create the tableLayout and add params to it
			table_layout=new TableLayout(context);
			table_layout.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

		} else {
			table_layout=(TableLayout) view;
		}

		final LinkedHashMap<String, CharSequence> objMap= mListLayoutData.get(position);

		//Create the tableRow and add params to it
		table_row = new TableRow(context);
		table_row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT));

		// inner for loop
		for (Entry<String, CharSequence> entry : objMap.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();

			if(value=="HEADER"){
				countSize=objMap.size();
				TextView textView = new TextView(context);
				textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
				textView.setText(key);
				textView.setTextSize(20);
				textView.setTextColor(context.getResources().getColor(R.color.redColor));
				table_row.addView(textView);

			}else{				
				linearLayoutOne=new LinearLayout(context);
				linearLayoutOne.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT));
				linearLayoutOne.setOrientation(LinearLayout.VERTICAL);

				linearLayoutOne.setPadding(5+outerPaddingAdjust, 5, 0, 5);

				linearLayoutTwo=new LinearLayout(context);
				linearLayoutTwo.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
				linearLayoutTwo.setOrientation(LinearLayout.VERTICAL);
				linearLayoutTwo.setBackgroundColor(context.getResources().getColor(R.color.whiteColor));

				linearLayoutThree=new LinearLayout(context);
				linearLayoutThree.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
				linearLayoutThree.setOrientation(LinearLayout.VERTICAL);
				linearLayoutThree.setBackgroundColor(context.getResources().getColor(R.color.silverColor));

				linearLayoutFour=new LinearLayout(context);
				linearLayoutFour.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
				linearLayoutFour.setOrientation(LinearLayout.VERTICAL);
				linearLayoutFour.setBackgroundColor(context.getResources().getColor(R.color.whiteColor));

				//Create the ImageView and add params to it
				imageView = new ImageView(context);
				imageView.setLayoutParams(new LinearLayout.LayoutParams(110,80));
				imageView.setImageResource(R.drawable.eleven);
				imageView.setPadding(5,5,5,5);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);

				//Create the TextView and add params to it
				final TextView textView = new TextView(context);
				textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
				textView.setText(key);
				textView.setPadding(5,5,5,5);
				textView.setTextSize(12);
				textView.setTextColor(context.getResources().getColor(R.color.blackColor));

				linearLayoutOne.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(context, ""+textView.getText()+"", Toast.LENGTH_LONG).show();
					}
				});

				table_row.addView(linearLayoutOne);
				linearLayoutOne.addView(linearLayoutTwo);
				linearLayoutTwo.addView(linearLayoutThree);
				linearLayoutThree.addView(imageView);
				linearLayoutTwo.addView(linearLayoutFour);
				linearLayoutFour.addView(textView);

				colCnt++;
			}
		}
		table_layout.addView(table_row);
		return table_layout;
	}
}
