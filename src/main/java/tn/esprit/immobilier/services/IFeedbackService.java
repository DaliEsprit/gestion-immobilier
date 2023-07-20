package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> retrieveAllFeedback();

    Feedback ajouterFeedback(Feedback f);

    void deleteFeedback(Long id);

    Feedback updateFeedback(Feedback f);

    Feedback affecterAchetuer(Feedback f,Long userId);

}
