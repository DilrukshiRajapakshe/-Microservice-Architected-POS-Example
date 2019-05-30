package com.sliit.paf.payment.repository.custom.impl;

import com.sliit.paf.payment.entity.Item;
import com.sliit.paf.payment.repository.CrudRepositoryImpl;
import com.sliit.paf.payment.repository.custom.ItemRepository;
import org.springframework.stereotype.Repository;


@Repository
public class ItemRepositoryImpl extends CrudRepositoryImpl<Item, String> implements ItemRepository {

}
