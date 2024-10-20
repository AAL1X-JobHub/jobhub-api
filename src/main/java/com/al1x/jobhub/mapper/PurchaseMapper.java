package com.al1x.jobhub.mapper;

import com.al1x.jobhub.domain.entity.Job;
import com.al1x.jobhub.domain.entity.Purchase;
import com.al1x.jobhub.domain.entity.PurchaseItem;
import com.al1x.jobhub.domain.entity.User;
import com.al1x.jobhub.dto.PurchaseCreateUpdateDTO;
import com.al1x.jobhub.dto.PurchaseDTO;
import com.al1x.jobhub.dto.PurchaseItemCreateUpdateDTO;
import com.al1x.jobhub.dto.PurchaseItemDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    private final ModelMapper modelMapper;

    public PurchaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //Convertir PurchaseCreateUpdateDTO a Purchase (Crear una compra)
    public Purchase toPurchaseEntity(PurchaseCreateUpdateDTO purchaseDTO) {
        Purchase purchase = modelMapper.map(purchaseDTO, Purchase.class);

        User user = new User();
        user.setId(purchaseDTO.getCustomerId());
        purchase.setUser(user);

        //Mapear manualmente los items de la compra
        purchase.setItems(purchaseDTO.getItems().stream()
                .map(this::toPurchaseItemEntity)
                .toList());

        return purchase;
    }

    //Convertir Purchase a PurchaseDTO (Mostrar una compra)
    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        PurchaseDTO purchaseDTO = modelMapper.map(purchase, PurchaseDTO.class);

        purchaseDTO.setItems(purchase.getItems().stream()
                .map(this::toPurchaseItemDTO)
                .toList());
        return purchaseDTO;
    }

    private PurchaseItem toPurchaseItemEntity(PurchaseItemCreateUpdateDTO itemDTO) {
        PurchaseItem item = modelMapper.map(itemDTO, PurchaseItem.class);
        Job job = new Job();
        job.setId(itemDTO.getJobId());
        item.setJob(job);
        return item;
    }

    private PurchaseItemDTO toPurchaseItemDTO(PurchaseItem item) {
        PurchaseItemDTO itemDTO = modelMapper.map(item, PurchaseItemDTO.class);
        itemDTO.setBookTitle(item.getJob().getTitle());
        return itemDTO;
    }

}