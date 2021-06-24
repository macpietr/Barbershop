package com.macpietr.barbershop.service;

import com.macpietr.barbershop.model.Barber;
import com.macpietr.barbershop.repository.BarberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarberServiceImpl implements BarberService{

    private BarberRepository barberRepository;

    @Override
    public Barber findBarberById(Long id) {
        return barberRepository.findById(id).get();
    }

    @Override
    public Barber findBarberByEmail(String email) {
        return barberRepository.findByEmail(email);
    }

    @Override
    public List<Barber> findAllBarbers() {
        return (List<Barber>) barberRepository.findAll();
    }

    @Override
    public void saveBarber(Barber barber) {
        barberRepository.save(barber);
    }
}
