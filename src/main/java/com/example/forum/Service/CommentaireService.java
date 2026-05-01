package com.example.forum.Service;

import com.example.forum.Model.Commentaire;
import java.util.List;

public interface CommentaireService {
    List<Commentaire> getAllCommentaires();
    Commentaire getCommentaireById(Long id);
    List<Commentaire> getCommentairesByPostId(Long postId);
    Commentaire createCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Long id, Commentaire commentaire);
    void deleteCommentaire(Long id);
}
