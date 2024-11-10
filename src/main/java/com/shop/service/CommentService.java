package com.shop.service;


import com.shop.entity.Comment;
import com.shop.entity.CommentExample;

import java.util.List;

public interface CommentService {
    public void insertSelective(Comment comment);

    public List<Comment> selectByExample(CommentExample commentExample);
}
