package me.kimxu.gitclient.listener;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.kimxu.gitclient.adapter.ListAdapter;
import me.kimxu.gitclient.model.GitSearchResult;
import me.kimxu.gitclient.net.GithubApi;
import me.kimxu.gitclient.utils.SimpleObserver;
import okio.Timeout;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 事件监听
 * Created by kimxu on 2017/1/23.
 */

@BindingMethods({
        @BindingMethod(type = android.support.v7.widget.SearchView.class,
                attribute = "app:onQueryText",
                method = "setOnQueryTextListener"),
})
public class Callbacks {
    private Subscription mSubscription;
    private ListAdapter mListAdapter;

    public Callbacks(ListAdapter listAdapter){
        mListAdapter=listAdapter;
    }
    public OnQueryTextListener mOnQueryTextListener = new OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            Log.e("onQueryTextSubmit", query);
            return false;
        }
        @Override
        public boolean onQueryTextChange(String newText) {
            if(mHandler.hasMessages(MSG_SEARCH)){
                mHandler.removeMessages(MSG_SEARCH);
                if (mSubscription!=null)
                    mSubscription.unsubscribe();
            }
            Message message =mHandler.obtainMessage(MSG_SEARCH,newText);
            mHandler.sendMessageDelayed(message,1000);


            return false;
        }
    };
    private static final int MSG_SEARCH = 1;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.e("handleMessage",msg.obj.toString());
            mSubscription =GithubApi.API()
                    .apiManager
                    .search(msg.obj.toString(), "stars", "asc")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SimpleObserver<GitSearchResult>() {
                        @Override
                        public void onNext(GitSearchResult searchResult) {
                            mListAdapter.addContact(searchResult.getItems());
                            Log.e("", searchResult.toString());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("", e.toString());
                        }
                    });
        }
    };

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
