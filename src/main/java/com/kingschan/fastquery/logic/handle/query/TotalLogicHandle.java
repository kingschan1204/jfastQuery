package com.kingschan.fastquery.logic.handle.query;

import java.sql.Connection;
import java.util.Map;

import com.kingschan.fastquery.sql.jsqlparser.DbType;
import com.kingschan.fastquery.sql.jsqlparser.DefaultSqlParser;
import com.kingschan.fastquery.util.JdbcTemplete;
import org.apache.log4j.Logger;

import com.kingschan.fastquery.WebArgs;
import com.kingschan.fastquery.logic.LogicHandle;
import com.kingschan.fastquery.vo.DataTransfer;

/**
 * <pre>
 * 纺计总计录条数
 * @author fedora
 *date:2013-8-19
 *</pre>
 */
public class TotalLogicHandle implements LogicHandle {
	private static Logger log = Logger.getLogger(TotalLogicHandle.class);

    public DataTransfer doLogic(Map<String, Object> args, DataTransfer sqb, Connection con,
            DbType type) throws Exception {
        /**
         * 判断是否为分页模式
         */
        if (args.containsKey(WebArgs.Pageindex)&&args.containsKey(WebArgs.pageSize)) {
            DefaultSqlParser sp = new DefaultSqlParser(sqb.getSql(),type);
            //构建where条件
            sp.appendCondition(sqb.getWhere());
            sp.count();
            Object total = JdbcTemplete.UniqueQuery(con, sp.toString());
            if (null!=total) {
                sqb.setTotal(Long.valueOf(total.toString())); 
            }
        }else{
            log.error("page and rows not found... ...so abort execute total query");
        }
        return sqb;
    }
	

	
}
