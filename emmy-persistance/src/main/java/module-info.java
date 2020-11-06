module emmy.persistance {
    requires emmy.common;
    requires transitive emmy.domain;

    requires java.persistence;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires com.fasterxml.jackson.annotation;
    requires spring.tx;
    requires org.slf4j;
    requires spring.context;
    requires java.sql;

    exports org.tpokora.persistance.entity.users;
    exports org.tpokora.persistance.entity.weather;

    // Temporary repositories export
    exports org.tpokora.persistance.repositories.weather;
    exports org.tpokora.persistance.repositories.users;

    exports org.tpokora.persistance.services.rates;
    exports org.tpokora.persistance.services.weather;
}