package com.dream.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

@SuppressWarnings("unused")
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    protected MultiItemTypeSupport<T> mMultiItemTypeSupport;

    public MultiItemCommonAdapter(Context context, List<T> list,
                                  MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, list, -1);
        mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getViewTypeCount() {
        if (mMultiItemTypeSupport != null) {
            return mMultiItemTypeSupport.getViewTypeCount();
        }
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultiItemTypeSupport != null) {
            return mMultiItemTypeSupport.getItemViewType(position, mList.get(position));
        }
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mMultiItemTypeSupport == null) {
            return super.getView(position, convertView, parent);
        }
        int layoutId = mMultiItemTypeSupport.getLayoutId(position, getItem(position));
        CommonAdapterHelper helper = CommonAdapterHelper.get(mContext,
            convertView, parent, layoutId, position);
        convert(helper, getItem(position));
        return helper.getConvertView();
    }

}
