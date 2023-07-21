package tn.esprit.immobilier.services;

import tn.esprit.immobilier.entities.Payement;
import tn.esprit.immobilier.entities.enums.PaymentStatus;

import java.util.List;

public interface IPayementService {
    List<Payement> retrieveAllPayement();

    Payement ajouterPayement(Payement p, PaymentStatus paymentStatus);

    void deletePayement(Long id);

    Payement updatePayement(Payement p);
    Payement getPaymentById(long idPay);

}
