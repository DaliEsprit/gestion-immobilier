package tn.esprit.immobilier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Feedback;
import tn.esprit.immobilier.repositories.IFeedbackRepository;

import java.util.List;

@Service

public class FeedbackService implements IFeedbackService{
    @Autowired
    IFeedbackRepository FeedRepository;


    @Override
    public List<Feedback> retrieveAllFeedback() {
        List<Feedback> listFeedback= FeedRepository.findAll();
        return listFeedback;
    }

    @Override
    public Feedback ajouterFeedback(Feedback f) {
        FeedRepository.save(f);
        return f;
    }

    @Override
    public void deleteFeedback(Long id) {
        FeedRepository.deleteById(id);

    }

    @Override
    public Feedback updateFeedback(Feedback f) {
        FeedRepository.save(f);
        return f;
    }
}
