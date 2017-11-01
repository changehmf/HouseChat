package cn.pcbc.www.housechat;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Name: ServicesSectionEntity
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/11/01
 */

public class ServicesSectionEntity extends SectionEntity<ServicesEntity> {

    public ServicesSectionEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public ServicesSectionEntity(ServicesEntity servicesEntity) {
        super(servicesEntity);
    }
}
