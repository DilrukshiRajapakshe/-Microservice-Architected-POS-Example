package com.sliit.paf.payment.service.custom.impl;


import com.sliit.paf.payment.dto.ItemDTO;
import com.sliit.paf.payment.repository.custom.ItemRepository;
import com.sliit.paf.payment.service.Converter;
import com.sliit.paf.payment.service.custom.ManageItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Service
@Transactional
public class ManageItemsServiceImpl implements ManageItemsService {

    private ItemRepository itemDAO;

    @Autowired
    public ManageItemsServiceImpl(ItemRepository itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Transactional(readOnly = true)
    public List<ItemDTO> getItems() {
        return itemDAO.findAll().map(Converter::<ItemDTO>getDTOList).get();
    }

    public void createItem(ItemDTO dto) {
            itemDAO.save(Converter.getEntity(dto));
    }


    public void updateItem(ItemDTO dto) {
            itemDAO.update(Converter.getEntity(dto));
    }


    public void deleteItem(String code) {
            itemDAO.delete(code);
    }


    public ItemDTO findItem(String code) {
        return itemDAO.find(code).map(Converter::<ItemDTO>getDTO).orElse(null);

    }


//    private ItemDAO itemDAO;
//
//    public ManageItemsBOImpl() {
//        itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
//    }
//
//    public List<ItemDTO> getItems() throws Exception {
//        return itemDAO.findAll().map(Converter::<ItemDTO>getDTOList).get();
//    }
//
//    public boolean createItem(ItemDTO dto) throws Exception {
//        return itemDAO.save(Converter.getEntity(dto));
//    }
//
//    public boolean updateItem(ItemDTO dto) throws Exception {
//        return itemDAO.update(Converter.getEntity(dto));
//    }
//
//    public boolean deleteItem(String code) throws Exception {
//        return itemDAO.delete(code);
//
//    }
//
//    public ItemDTO findItem(String itemCode) throws Exception {
//        return itemDAO.find(itemCode).map(Converter::<ItemDTO>getDTO).orElse(null);
//    }
}
