package com.bank.agencies.infra;

import com.bank.agencies.usecase.FindAllAgenciesUseCase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner{
    
    private final FindAllAgenciesUseCase findAllAgenciesUseCase;

    public ApplicationRunner(FindAllAgenciesUseCase findAllAgenciesUseCase) {
        this.findAllAgenciesUseCase = findAllAgenciesUseCase;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading agencies...");
        
        findAllAgenciesUseCase.execute();
        System.out.println("Agencies loaded successfully");
    }
}
