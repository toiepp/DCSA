package me.mikholsky.practice6.entity.dto;

import me.mikholsky.practice6.entity.AbstractEntity;
import me.mikholsky.practice6.service.CommonService;

public interface CommonDto<E extends AbstractEntity> {
     from(E e);
}
