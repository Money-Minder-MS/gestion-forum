package com.example.forum.Service;

import com.example.forum.Model.Post;
import com.example.forum.NotificationPublisher;
import com.example.forum.RabbitMQConfig;
import com.example.forum.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    private NotificationPublisher notificationPublisher;
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post non trouv avec l'id: " + id));
    }

    public Post createPost(Post post) {
        Post saved = postRepository.save(post);

        Map<String, Object> data = new HashMap<>();
        data.put("titre",  saved.getTitre());
        data.put("auteur", saved.getAuteur());

        notificationPublisher.publier(
                RabbitMQConfig.KEY_POST,
                saved.getUserId(),
                "Nouveau post publié : " + saved.getTitre(),
                data
        );

        return saved;
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = getPostById(id);
        post.setTitre(postDetails.getTitre());
        post.setContenu(postDetails.getContenu());
        post.setAuteur(postDetails.getAuteur());
        post.setUserId(postDetails.getUserId());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        Post post = getPostById(id);
        postRepository.delete(post);
    }
}
