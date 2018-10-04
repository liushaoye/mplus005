package com.baidu.www.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 删除
 * @author liuyangos8888
 */
public class DeleteAll extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql;
        MySqlMethod mySqlMethod = MySqlMethod.DELETE_ALL;
        if (tableInfo.isLogicDelete()) {
            sql = String.format(mySqlMethod.getSql(), tableInfo.getTableName(),  tableInfo,
                    sqlWhereEntityWrapper(tableInfo));
        } else {
            mySqlMethod = MySqlMethod.DELETE_ALL;
            sql = String.format(mySqlMethod.getSql(), tableInfo.getTableName(),
                    sqlWhereEntityWrapper(tableInfo));
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, mySqlMethod.getMethod(), sqlSource);
    }
}
