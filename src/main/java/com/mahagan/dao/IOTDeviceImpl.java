package com.mahagan.dao;

import com.mahagan.model.IOTDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@Component
public class IOTDeviceImpl implements IOTDevice {

      JdbcTemplate jdbcTemplate;
    private final String SQL_Find_Device = "select * from iotdevice where id= ?";
    private final String SQL_Delete_Device = "Delete from iotdevice where id= ?";
    private final String SQL_Update_Device = "Update iotdevice set deviceName= ?,deviceLocation= ?,deviceFunction= ? where id= ?";
    private final String SQL_Get_All_Device = "select * from iotdevice";
    private final String SQL_Insert_Device = "insert into iotdevice(id,deviceName,deviceLocation,deviceFunction) value(?,?,?,?)";
    @Autowired

    public IOTDeviceImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }



    /**
     * This is to execute logic of by Id in database, and it will get the respective id records for user
     * @param id
     * @return
     */

/**/
    @Override
    public com.mahagan.model.IOTDevice getDeviceById(int id) {
        return (com.mahagan.model.IOTDevice) jdbcTemplate.queryForObject(SQL_Find_Device, new Object[]{id}, new IOTDeviceMapper());
    }



    /**
     *this method is use to get all devices from db
     * @return
     */

    public List<com.mahagan.model.IOTDevice> getAllDevice() {
        return jdbcTemplate.query(SQL_Get_All_Device, new IOTDeviceMapper());
    }

    /**
     * Delete record from db for respective id
     *
     * @param iotDevice iotDevice
     * @return jdbcTemplete
     */
    public int deleteDevice(com.mahagan.model.IOTDevice iotDevice) {
        return jdbcTemplate.update(SQL_Delete_Device,iotDevice.getId()) ;
    }

    /**
     * update the records in existing fields
     *
     * @param iotDevice
     * @return
     */
    public int updateDevice(com.mahagan.model.IOTDevice iotDevice) {
        return jdbcTemplate.update(SQL_Update_Device, iotDevice.getDeviceName(), iotDevice.getDeviceLocation(),
                iotDevice.getDeviceFunction(),iotDevice.getId());
    }

    /**
     * Creating IOT device
     *
     * @param iotDevice
     * @return
     */
    public int createIotDevice(com.mahagan.model.IOTDevice iotDevice) {
        return jdbcTemplate.update(SQL_Insert_Device,iotDevice.getId(), iotDevice.getDeviceName(),
                iotDevice.getDeviceLocation(), iotDevice.getDeviceFunction());
    }

}
