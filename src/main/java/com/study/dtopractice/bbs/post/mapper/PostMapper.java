package com.study.dtopractice.bbs.post.mapper;

import com.study.dtopractice.bbs.post.domain.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    int createPost(Post post);
}
