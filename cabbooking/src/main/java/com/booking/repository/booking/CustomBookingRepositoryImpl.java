package com.booking.repository.booking;

import com.booking.model.Booking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sam on 14/6/19.
 */
public class CustomBookingRepositoryImpl implements CustomBookingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Booking> findBookingByUser(final Long userId) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Booking> query = criteriaBuilder.createQuery(Booking.class);
        final Root<Booking> from = query.from(Booking.class);
        final Predicate predicate = criteriaBuilder.equal(from.get("customer").get("id"), userId);
        query.select(from).where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Booking> findBookingByCabId(Long cabId) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Booking> query = criteriaBuilder.createQuery(Booking.class);
        final Root<Booking> from = query.from(Booking.class);

        final Predicate predicate = criteriaBuilder.equal(from.get("cab").get("id"), cabId);
        query.select(from).where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void cancelBooking(Long bookingId) {

    }
}
