package com.code.mvvm.core.data;

import com.code.mvvm.network.ApiService;
import com.mvvm.base.AbsRepository;
import com.mvvm.event.LiveBus;
import com.mvvm.http.HttpHelper;


/**
 * @author：tqzhang on 18/7/26 16:15
 */
public class BaseRepository extends AbsRepository {

    protected ApiService apiService;

    public BaseRepository() {
        if (null == apiService) {
            apiService = HttpHelper.getInstance().create(ApiService.class);
        }
    }


    protected void sendData(Object eventKey, Object t) {
        sendData(eventKey, null, t);
    }

    protected void sendData(Object eventKey, String tag, Object t) {
        LiveBus.getDefault().postEvent(eventKey, tag, t);
    }

    protected void showPageState(Object eventKey, String state) {
        sendData(eventKey, state);
    }

    protected void showPageState(Object eventKey, String tag, String state) {
        sendData(eventKey, tag, state);
    }


}
