package com.amande.infrastructure.repository.paint;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaintRepositoryMapper {
  List<PaintEventRecord> selectEvents(@Param("aggregateID") String aggregateID);

  int insertEvent(@Param("eventRecords") List<PaintEventRecord> eventRecords);

  int upsertAggregate(
    @Param("aggregateID") String aggregateID,
    @Param("lastVersion") Integer lastVersion
  );
}
