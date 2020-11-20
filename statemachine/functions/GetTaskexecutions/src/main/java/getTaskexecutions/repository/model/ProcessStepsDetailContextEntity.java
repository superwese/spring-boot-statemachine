package getTaskexecutions.repository.model;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "process_steps_detail_context")
@Generated(value = "JPAGenerator")
public class ProcessStepsDetailContextEntity extends ImmutableEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
    private UUID uuid;

    @Column(name = "equipment_uuid")
    private UUID equipmentUuid;

    @Column(name = "equipment_part_uuid")
    private UUID equipmentPartUuid;

    @Column(name = "equipment_title")
    private String equipmentTitle;

    @Column(name = "equipment_part_title")
    private String equipmentPartTitle;

    @Column(name = "equipment_part_title_key")
    private String equipmentPartTitleKey;

    @Column(name = "product_uuid")
    private UUID productUuid;

    @Column(name = "product_title")
    private String productTitle;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getEquipmentUuid() {
        return equipmentUuid;
    }

    public void setEquipmentUuid(UUID equipmentUuid) {
        this.equipmentUuid = equipmentUuid;
    }

    public UUID getEquipmentPartUuid() {
        return equipmentPartUuid;
    }

    public void setEquipmentPartUuid(UUID equipmentPartUuid) {
        this.equipmentPartUuid = equipmentPartUuid;
    }

    public String getEquipmentTitle() {
        return equipmentTitle;
    }

    public void setEquipmentTitle(String equipmentTitle) {
        this.equipmentTitle = equipmentTitle;
    }

    public String getEquipmentPartTitle() {
        return equipmentPartTitle;
    }

    public void setEquipmentPartTitle(String equipmentPartTitle) {
        this.equipmentPartTitle = equipmentPartTitle;
    }

    public String getEquipmentPartTitleKey() {
        return equipmentPartTitleKey;
    }

    public void setEquipmentPartTitleKey(String equipmentPartTitleKey) {
        this.equipmentPartTitleKey = equipmentPartTitleKey;
    }

    public UUID getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(UUID productUuid) {
        this.productUuid = productUuid;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
