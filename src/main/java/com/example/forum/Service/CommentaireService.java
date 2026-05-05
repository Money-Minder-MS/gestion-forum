package com.example.forum.Service;

import com.example.forum.Model.Commentaire;
import com.example.forum.Model.Post;
import com.example.forum.Repository.CommentaireRepository;
import com.example.forum.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    public Commentaire getCommentaireById(Long id) {
        return commentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouv avec l'id: " + id));
    }

    public List<Commentaire> getCommentairesByPostId(Long postId) {
        return commentaireRepository.findByPostId(postId);
    }

    public Commentaire createCommentaire(Commentaire commentaire) {
        Post post = postRepository.findById(commentaire.getPost().getId())
                .orElseThrow(() -> new RuntimeException("Post non trouv avec l'id: " + commentaire.getPost().getId()));
        commentaire.setPost(post);
        return commentaireRepository.save(commentaire);
    }

    public Commentaire updateCommentaire(Long id, Commentaire commentaireDetails) {
        Commentaire commentaire = getCommentaireById(id);
        commentaire.setContenu(commentaireDetails.getContenu());
        commentaire.setAuteur(commentaireDetails.getAuteur());
        commentaire.setUserId(commentaireDetails.getUserId());
        return commentaireRepository.save(commentaire);
    }

    public void deleteCommentaire(Long id) {
        Commentaire commentaire = getCommentaireById(id);
        commentaireRepository.delete(commentaire);
    }
}
