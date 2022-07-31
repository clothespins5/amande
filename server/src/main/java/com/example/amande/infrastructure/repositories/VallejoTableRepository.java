package com.example.amande.infrastructure.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.amande.domain.models.Paint;
import com.example.amande.domain.models.PaintColorCode;
import com.example.amande.domain.models.PaintId;
import com.example.amande.domain.models.PaintName;
import com.example.amande.domain.models.Paints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VallejoTableRepository implements IVallejoTableRepository {

    @Autowired
    private PostgreSql postgreSql;
    
    public Paints findAll() {

        List<Paint> paints = new ArrayList<Paint>();

        try {

            ResultSet resultSet = postgreSql.executeQuery("SELECT * FROM vallejocolors");
            
            while(resultSet.next()) {
                
                Paint paint = new Paint(
                    new PaintId(resultSet.getInt("id")),
                    new PaintName(resultSet.getString("colorname")),
                    new PaintColorCode.Builder()
                            .specifiedColor(resultSet.getString("colorcode"))
                            .buildOrElseThrow(builder -> new IllegalArgumentException())

                );
                paints.add(paint);
    
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Paints vallejoTable = new Paints(paints);

        return vallejoTable;
    }
}
