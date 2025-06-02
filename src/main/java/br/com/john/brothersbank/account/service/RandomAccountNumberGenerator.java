package br.com.john.brothersbank.account.service;

import br.com.john.brothersbank.account.service.impl.IAccountNumberGenerator;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class RandomAccountNumberGenerator implements IAccountNumberGenerator {

    private final Set<Long> generated = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Long generate() {
        long number;
        do {
            long fiveDigits = 1000 + random.nextInt(90000);
            int extraDigit = random.nextInt(10);
            number = Long.parseLong(fiveDigits + "" + extraDigit);
        } while (generated.contains(number));

        generated.add(number);
        return number;
    }
}
