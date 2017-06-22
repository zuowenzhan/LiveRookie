package com.projectdemo.zwz.liverookie.adapter;


import android.content.Context;
import android.widget.TextView;

import com.projectdemo.zwz.liverookie.R;
import com.projectdemo.zwz.liverookie.base.BaseAdapter;
import com.projectdemo.zwz.liverookie.model.ChatMsg;

import java.util.List;


/**
 * @Description: 消息列表的Adapter
 * @author: Andruby
 * @date: 2016年7月9日
 */
public class ChatMsgListAdapter extends BaseAdapter<ChatMsg> {


	public ChatMsgListAdapter(Context context, List<ChatMsg> dataList) {
		super(context, dataList);
	}

	@Override
	protected int getViewLayoutId() {
		return R.layout.listview_msg_item;
	}


	@Override
	protected void initData(ViewHolder viewHolder, ChatMsg data, int position) {
		TextView tvMsg = viewHolder.getView(R.id.tv_msg);
		//谁发给谁的消息是
		tvMsg.setText(String.format("%s发给%的消息是%s",data.sendName,data.receiveName,data.msg));

	}
}
