package io.renren.entity;

import java.io.Serializable;
import java.util.List;

import io.renren.modules.sys.entity.NideshopCategoryEntity;
import lombok.Data;
@Data
public class CategoryResp extends NideshopCategoryEntity implements Serializable{
   private List<NideshopCategoryEntity> subCategoryList;
}
