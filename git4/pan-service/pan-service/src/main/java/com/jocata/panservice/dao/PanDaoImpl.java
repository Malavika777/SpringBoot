package com.jocata.panservice.dao;

import com.jocata.panservice.entity.PanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PanDaoImpl implements PanDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PanEntity getPanDetails(String panNumber){
        String sql = "select * from panDetails where panNumber = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{panNumber},
                new BeanPropertyRowMapper<>(PanEntity.class)
        );
    }

    public List<PanEntity> getAllPanDetails(){

        String sql = "select * from panDetails";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PanEntity.class));
    }
}
