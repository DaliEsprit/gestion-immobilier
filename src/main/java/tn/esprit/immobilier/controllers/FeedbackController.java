package tn.esprit.immobilier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.immobilier.entities.Immobilier;
import tn.esprit.immobilier.entities.Feedback;
import tn.esprit.immobilier.services.IFeedbackService;
import tn.esprit.immobilier.services.ImmoblierService;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    IFeedbackService feedbackService;
    // http://localhost:8089/api/immobilier/retrieve-all-immobilier
    @GetMapping("/retrieve-all-feedback")
    public List<Feedback> getFeedback() {
        List<Feedback> listFeedback = feedbackService.retrieveAllFeedback();
        return listFeedback;
    }
    @PostMapping("/add-feedback")
    public Feedback addFeedback(@RequestBody Feedback f) {
        return
                feedbackService.ajouterFeedback(f);
    }
    @DeleteMapping("/remove-feedback/{feedback-id}")
    public void removeFeedback(@PathVariable("feedback-id") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }
    @PutMapping("/modify-feedback")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }
    @PostMapping("/add-feedbackuser/{user-id}")
    public Feedback addFeedbackuser(@RequestBody Feedback f,@PathVariable("user-id") Long userID)
    {
        return feedbackService.affecterAchetuer(f,userID);
    }
}
