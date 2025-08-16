package com.diptech.portfolio.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class SessionFactoryProvider {

    // Make it private, final, and thread-safe
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    // Private constructor to prevent instantiation
    private SessionFactoryProvider() {}

    // Build SessionFactory only once
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Exception e) {
            System.err.println("❌ Failed to create SessionFactory: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    // Public getter
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    // Gracefully close SessionFactory
    public static void shutdown() {
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }
}
