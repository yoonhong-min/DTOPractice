package com.study.dtopractice.bbs.post.mapper;

import com.study.dtopractice.bbs.post.domain.Post;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    int createPost(Post post);
    List<Post> getAllPosts(Long boardId);
    Post getPost(Long postId);
    int increaseViewCnt(Long postId);
}
