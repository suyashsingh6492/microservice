package com.example.accounts.audit;

import jakarta.persistence.EntityListeners;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
 
@Component("auditAwareImpl") //So this is a bean name that I want to consider. This name can be anything.
public class AuditAwareImpl implements AuditorAware<String> {
//this will update created by , updated by
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
    }

}
