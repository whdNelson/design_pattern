package com.wanghaodong.design_pattern.mapper;

import com.wanghaodong.design_pattern.model.AgeLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AgeLogMapper extends Mapper<AgeLog> {
}