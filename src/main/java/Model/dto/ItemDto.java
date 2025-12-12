package Model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "items")
public class ItemDto {
    @Id
    @Column(name = "itemCode")
    private String itemCode;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "qtyOnHand")
    private int qtyOnHand;

    @Column(name = "unitPrice")
    private double unitPrice;
}
