package com.shop.service;


import com.shop.entity.*;
import com.shop.entity.*;

import java.util.List;

public interface GoodsService {
    public Integer addGoods(Goods goods);

    public void addImagePath(ImagePath imagePath);

    public List<Goods> selectByExample(GoodsExample example);

    public void deleteGoodsById(Integer goodsid);

    public void updateGoodsById(Goods goods);

    public List<ImagePath> findImagePath(Integer goodsid);

    public Goods selectById(Integer goodsid);


    List<Goods> selectWithBLOBsLimit( List<Integer> list);

    public List<Goods> selectByExampleLimit(GoodsExample digGoodsExample);

    public void addFavorite(Favorite favorite);

    public Favorite selectFavByKey(FavoriteKey favoriteKey);

    public void deleteFavByKey(FavoriteKey favoriteKey);

    public List<Favorite> selectFavByExample(FavoriteExample favoriteExample);

    List<Goods> selectGoodsListByCateId(Integer category);

    List<Goods> selectGoodsListByGoodsName(String goodsName);
}
