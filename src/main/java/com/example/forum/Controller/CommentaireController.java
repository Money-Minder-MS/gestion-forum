package com.example.forum.Controller;

import com.example.forum.Model.Commentaire;
import com.example.forum.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        return ResponseEntity.ok(commentaireService.getAllCommentaires());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        return ResponseEntity.ok(commentaireService.getCommentaireById(id));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Commentaire>> getCommentairesByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(commentaireService.getCommentairesByPostId(postId));
    }

    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentaireService.createCommentaire(commentaire));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        return ResponseEntity.ok(commentaireService.updateCommentaire(id, commentaire));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.noContent().build();
    }
}
