package com.sliit.paf.payment.repository;

import org.hibernate.Session;

public interface SuperRepository {

    Session getSession();

}
