package com.sliit.paf.payment.service.custom;



import com.sliit.paf.payment.dto.ItemDTO;
import com.sliit.paf.payment.service.SuperService;

import java.util.List;

public interface ManageItemsService extends SuperService {

    List<ItemDTO> getItems();

    void createItem(ItemDTO dto);

    void updateItem(ItemDTO dto);

    void deleteItem(String code);

    ItemDTO findItem(String code);


}
