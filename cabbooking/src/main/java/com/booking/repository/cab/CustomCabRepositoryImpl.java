package com.booking.repository.cab;

import com.booking.model.Booking;
import com.booking.model.Cab;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sam on 13/6/19.
 */
public class CustomCabRepositoryImpl implements CustomCabRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cab> findAllByDuration(final Date startDate, final Date endDate) {

        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Cab> cabQuery = criteriaBuilder.createQuery(Cab.class);
        final CriteriaQuery<Booking> bookingQuery = criteriaBuilder.createQuery(Booking.class);
        final Root<Booking> root = bookingQuery.from(Booking.class);
        final Root<Cab> cabRoot = cabQuery.from(Cab.class);
        final Join<Booking, Cab> cabJoin = root.join("cab");

        final Predicate tripStartPredicate = criteriaBuilder.between(criteriaBuilder.literal(startDate), root.get("tripStartDate"), root.get("tripEndDate"));
        final Predicate tripEndPredicate = criteriaBuilder.between(criteriaBuilder.literal(endDate), root.get("tripStartDate"), root.get("tripEndDate"));
        final Predicate finalPredicate = criteriaBuilder.or(tripStartPredicate, tripEndPredicate);
        bookingQuery.select(cabJoin.get("id")).where(finalPredicate);

        cabQuery.select(cabRoot).where(cabRoot.in(entityManager.createQuery(bookingQuery).getResultList()).not());

        return entityManager.createQuery(cabQuery).getResultList();
    }

}
