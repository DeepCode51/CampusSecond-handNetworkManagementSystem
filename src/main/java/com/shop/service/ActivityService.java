package com.shop.service;


import com.shop.entity.Activity;
import com.shop.entity.ActivityExample;

import java.util.List;

public interface ActivityService {
    List<Activity> getAllActivity(ActivityExample activityExample);

    void insertActivitySelective(Activity activity);

    Activity selectByKey(Integer activityid);

    void deleteByActivityId(Integer activityid);

//    void updateGoodsActSelective(Goods goods);
}
