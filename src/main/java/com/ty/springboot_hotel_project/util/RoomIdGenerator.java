package com.ty.springboot_hotel_project.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RoomIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="IBMR";
		String suffix="";
		Connection connection=session.connection();
		
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select count(room_id) from Customer");
			if(resultSet.next()) {
				int id=resultSet.getInt(1);
				suffix=String.valueOf(id);
				}
			return prefix+suffix;
		}catch (Exception e) {
			System.out.println("some problem occured");
		}
		return null;
	}

}
