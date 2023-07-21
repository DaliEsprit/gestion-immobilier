package tn.esprit.immobilier.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.immobilier.entities.Payement;
import tn.esprit.immobilier.entities.Room;
import tn.esprit.immobilier.entities.enums.PaymentStatus;
import tn.esprit.immobilier.repositories.IPayementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PayementService implements IPayementService{

    IPayementRepository payRepository;


    @Override
    public List<Payement> retrieveAllPayement() {
        List<Payement> listPayement= payRepository.findAll();
        return listPayement;
    }

    @Override
    public Payement ajouterPayement(Payement p, PaymentStatus paymentStatus) {
        p.setPaymentStatus(paymentStatus);
        payRepository.save(p);
        return p;
    }

    @Override
    public void deletePayement(Long id) {
        payRepository.deleteById(id);

    }
    public Payement updatePayement(Payement p) {
       payRepository.save(p);
    return p;
    }

    @Override
    public Payement getPaymentById(long idPay) {
        Payement payement=payRepository.findById(idPay).get();
        return payement;
    }

}
