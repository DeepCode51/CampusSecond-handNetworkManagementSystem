package com.shop.controller.front;


import com.shop.entity.*;
import com.shop.entity.*;
import com.shop.service.CateService;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CateService cateService;

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/")
    public String showAdmin(Model model, HttpSession session) {
        Integer userid;
        User user = (User) session.getAttribute("user");
        if (user == null) {
            userid = null;
        } else {
            userid = user.getUserid();
        }

        List<Category> categoryList =  cateService.selectByExample(null);
        model.addAttribute("categoryList",categoryList);

        List<Goods> goodsList = goodsService.selectByExample(null);
        for (Goods goods:goodsList) {
            List<ImagePath> imagePaths = goodsService.findImagePath(goods.getGoodsid());
             if(!CollectionUtils.isEmpty(imagePaths)){
                 goods.setImagePath(imagePaths.get(0));
             }
        }
        model.addAttribute("goodsList",goodsList);
        return "main";
    }

    @RequestMapping("/main")
    public String showAllGoods(Model model, HttpSession session) {
        Integer userid;
        User user = (User) session.getAttribute("user");
        if (user == null) {
            userid = null;
        } else {
            userid = user.getUserid();
        }
        List<Category> categoryList =  cateService.selectByExample(null);
        model.addAttribute("categoryList",categoryList);

        List<Goods> goodsList = goodsService.selectByExample(null);
        for (Goods goods:goodsList) {
            List<ImagePath> imagePaths = goodsService.findImagePath(goods.getGoodsid());
            if(!CollectionUtils.isEmpty(imagePaths)){
                goods.setImagePath(imagePaths.get(0));
            }
        }
        model.addAttribute("goodsList",goodsList);

        return "main";
    }

    public List<Goods> getCateGoods(String cate, Integer userid) {
        //查询分类
        CategoryExample digCategoryExample = new CategoryExample();
        digCategoryExample.or().andCatenameLike(cate);
        List<Category> digCategoryList = cateService.selectByExample(digCategoryExample);

        if (digCategoryList.size() == 0) {
            return null;
        }

        //查询属于刚查到的分类的商品
        GoodsExample digGoodsExample = new GoodsExample();
        List<Integer> digCateId = new ArrayList<Integer>();
        for (Category tmp:digCategoryList) {
            digCateId.add(tmp.getCateid());
        }
        digGoodsExample.or().andCategoryIn(digCateId);

        List<Goods> goodsList = goodsService.selectByExampleLimit(digGoodsExample);

        List<Goods> goodsAndImage = new ArrayList<>();
        //获取每个商品的图片
        for (Goods goods:goodsList) {
            //判断是否为登录状态
            if (userid == null) {
                goods.setFav(false);
            } else {
                Favorite favorite = goodsService.selectFavByKey(new FavoriteKey(userid, goods.getGoodsid()));
                if (favorite == null) {
                    goods.setFav(false);
                } else {
                    goods.setFav(true);
                }
            }

            List<ImagePath> imagePathList = goodsService.findImagePath(goods.getGoodsid());
            goods.setImagePaths(imagePathList);
            goodsAndImage.add(goods);
        }
        //cookie QQ 211811 9173
        return goodsAndImage;
    }
}

